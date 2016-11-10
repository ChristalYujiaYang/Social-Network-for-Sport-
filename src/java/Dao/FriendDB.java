/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.Customer;
import getConnection.GetConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Crystal
 */
public class FriendDB {

    private Connection conn;
    private PreparedStatement pstat, pstat1, pstat2;

    public List<Customer> friends(int userid) throws SQLException, ClassNotFoundException {
        conn = GetConnection.getConnection();
        String sql = "select friendid from friends where userid=?";
        String sql1 = "select * from customer where userid=?";
        pstat = conn.prepareStatement(sql);
        pstat.setInt(1, userid);
        pstat1 = conn.prepareStatement(sql1);
        ResultSet rs = (ResultSet) pstat.executeQuery();
        List<Customer> list = new ArrayList<Customer>();
        try {
            while (rs.next()) {
                pstat1.setInt(1, rs.getInt(1));
                ResultSet rs1 = (ResultSet) pstat1.executeQuery();
                while (rs1.next()) {
                    Customer friend = new Customer();
                    friend.setUserid(rs1.getInt(1));
                    friend.setName(rs1.getString(2));
                    friend.setEmail(rs1.getString(3));
                    friend.setAge(rs1.getString(5));
                    friend.setPhone(rs1.getString(6));
                    list.add(friend);
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block     
            System.out.println("friends wrong");
        }
        return list;
    }

    public List<Customer> Searchfriend(String input) throws SQLException, ClassNotFoundException {

        conn = GetConnection.getConnection();
        String sql = "SELECT * FROM customer WHERE name LIKE '%" + input + "%'";
        pstat = conn.prepareStatement(sql);
        ResultSet rs = (ResultSet) pstat.executeQuery();
        List<Customer> list = new ArrayList<Customer>();
        try {
            while (rs.next()) {
                Customer user = new Customer();
                user.setUserid(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setAge(rs.getString(4));
                user.setPhone(rs.getString(5));
                list.add(user);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block     
            System.out.println("Searchfriend wrong");
        }
        return list;
    }

    public boolean addFriend(int friendid, int userid) throws ClassNotFoundException, SQLException {
        conn = GetConnection.getConnection();
        String sql = "select friendid from friends where userid = " + userid;
        String sql1 = "insert into friends (userid,friendid) values(?,?)";
        pstat = conn.prepareStatement(sql);
        ResultSet rs = (ResultSet) pstat.executeQuery();
        List<Integer> list = new ArrayList<Integer>();
        boolean flag = true;
        try {
            if (rs != null) {
                while (rs.next()) {
                    list.add(rs.getInt(1));
                }
            } else {
                pstat1 = conn.prepareStatement(sql1);
                pstat1.setInt(1, userid);
                pstat1.setInt(2, friendid);
                pstat1.executeUpdate();
                pstat2 = conn.prepareStatement(sql1);
                pstat2.setInt(1, friendid);
                pstat2.setInt(2, userid);
                pstat2.executeUpdate();
                flag = true;
            }
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == friendid) {
                    flag = false;
                }
            }
            if (flag == true) {
                pstat1 = conn.prepareStatement(sql1);
                pstat1.setInt(1, userid);
                pstat1.setInt(2, friendid);
                pstat1.executeUpdate();
                pstat2 = conn.prepareStatement(sql1);
                pstat2.setInt(1, friendid);
                pstat2.setInt(2, userid);
                pstat2.executeUpdate();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block     
            System.out.println("Addfriend wrong");
        }
        return flag;
    }

}
