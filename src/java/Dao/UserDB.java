/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.Customer;
import Bean.Mail;
import getConnection.GetConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Crystal
 */
public class UserDB {

    private Connection conn;
    private PreparedStatement pstat, pstat1;
    private Statement stmt;

    public void usermodify(Customer user) throws SQLException, ClassNotFoundException {
        conn = GetConnection.getConnection();
        String sql = "update customer set name=?, email=?, password=?, age=?, phone=?, basketball=?, baseball=?, swimming=?, football=?, jogging=?, soccer=? where userid=" + user.getUserid();
        try {
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, user.getName());
            pstat.setString(2, user.getEmail());
            pstat.setString(3, user.getPassword());
            pstat.setString(4, user.getAge());
            pstat.setString(5, user.getPhone());
            pstat.setInt(6, user.getBasketball());
            pstat.setInt(7, user.getBaseball());
            pstat.setInt(8, user.getSwimming());
            pstat.setInt(9, user.getFootball());
            pstat.setInt(10, user.getJogging());
            pstat.setInt(11, user.getSoccer());
            pstat.executeUpdate();
            pstat.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("modify wrong");
        }
    }

    public void Logout(int userid) throws SQLException, ClassNotFoundException {
        conn = GetConnection.getConnection();
        String sql = "update customer set login=" + 0 + " where userid=" + userid;
        pstat = conn.prepareStatement(sql);
        pstat.executeUpdate();
        pstat.close();
        conn.close();
    }

    public int Getnum(int id) throws SQLException, ClassNotFoundException {
        conn = GetConnection.getConnection();
        String sql = "select peoplenum from arandac where arandacid=?";
        pstat = conn.prepareStatement(sql);
        pstat.setInt(1, id);
        ResultSet rs = (ResultSet) pstat.executeQuery();
        int count = 0;
        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block     
            System.out.println("Getnum wrong");
        }
        return count;
    }

    public int Getmax(int id) throws SQLException, ClassNotFoundException {
        conn = GetConnection.getConnection();
        String sql = "select peoplemax from arandac where arandacid=" + id;
        pstat = conn.prepareStatement(sql);
        ResultSet rs = (ResultSet) pstat.executeQuery();
        int peoplemax = 0;
        try {
            while (rs.next()) {
                peoplemax = rs.getInt(1);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block     
            System.out.println("Getmax wrong");
        }
        return peoplemax;
    }

    public int Getmin(int id) throws SQLException, ClassNotFoundException {
        conn = GetConnection.getConnection();
        String sql = "select peoplemin from arandac where arandacid=" + id;
        pstat = conn.prepareStatement(sql);
        ResultSet rs = (ResultSet) pstat.executeQuery();
        int peoplemin = 0;
        try {
            while (rs.next()) {
                peoplemin = rs.getInt(1);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block     
            System.out.println("Getmin wrong");
        }
        return peoplemin;
    }

    public void Changenum1(int id) throws SQLException, ClassNotFoundException {
        conn = GetConnection.getConnection();
        String sql = "select peoplenum from arandac where arandacid=" + id;
        pstat = conn.prepareStatement(sql);
        ResultSet rs = (ResultSet) pstat.executeQuery();
        int count = 0;
        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block     
            System.out.println("changenum1 wrong");
        }
        count++;
        String sql1 = "update arandac set peoplenum=" + count + " where arandacid=" + id;
        pstat1 = conn.prepareStatement(sql1);
        pstat1.executeUpdate();
    }

    public void JoinActivity(int userid, int id) throws ClassNotFoundException {
        conn = GetConnection.getConnection();
        String sql = "insert into\"" + userid + "\"(arandacid) values(?)";
        try {
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1, id);
            pstat.executeUpdate();
            Changenum1(id);
            pstat.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("JoinActivity wrong");
        }
    }

    public void Changenum2(int id) throws SQLException, ClassNotFoundException {
        conn = GetConnection.getConnection();
        String sql = "select peoplenum from arandac where arandacid=" + id;
        pstat = conn.prepareStatement(sql);
        ResultSet rs = (ResultSet) pstat.executeQuery();
        int count = 0;
        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block     
            System.out.println("changenum2 wrong");
        }
        count--;
        String sql1 = "update arandac set peoplenum=" + count + " where arandacid=" + id;
        pstat1 = conn.prepareStatement(sql1);
        pstat1.executeUpdate();
        pstat.close();
        pstat1.close();
        conn.close();
    }

    public void QuitActivity(int userid, int id) throws ClassNotFoundException {
        conn = GetConnection.getConnection();
        String sql = "delete from\"" + userid + "\"where arandacid=" + id;
        try {
            pstat = conn.prepareStatement(sql);
            pstat.executeUpdate();
            Changenum2(id);
            pstat.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("QuitActivity wrong");
        }
    }

    public boolean Getarandac(int userid, int id) throws SQLException, ClassNotFoundException {
        conn = GetConnection.getConnection();
        String sql = "select arandacid from \""+userid+"\"";
        pstat = conn.prepareStatement(sql);
        ResultSet rs = (ResultSet) pstat.executeQuery();
        while (rs.next()) {
            if (rs.getInt(1) == id) {
                return true;
            }
        }
        pstat.close();
        conn.close();
        return false;
    }

    public String Getauthor(int id) throws SQLException, ClassNotFoundException {
        conn = GetConnection.getConnection();
        String sql = "select author from arandac where arandacid=" + id;
        String sql1 = "select email from customer where name=?";
        pstat = conn.prepareStatement(sql);
        ResultSet rs = (ResultSet) pstat.executeQuery();
        pstat1 = conn.prepareStatement(sql1);
        String email = null;
        try {
            while (rs.next()) {
                String author = rs.getString(1);
                pstat1.setString(1, author);
                ResultSet rs1 = (ResultSet) pstat1.executeQuery();
                while (rs1.next()) {
                    System.out.println(rs.getString(1));
                    email = rs1.getString(1);
                    System.out.println(rs1.getString(1));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block     
            System.out.println("Getauthor wrong");
        }
        return email;
    }

    public void SendMail(int id) throws SQLException, ClassNotFoundException {
        String smtp = "smtp.163.com";
        String from = "crystal12345654321@163.com";
        String to = Getauthor(id);
        String subject = "Sport";
        String content = "The activity you start has got enough people";
        String username = "crystal12345654321@163.com";
        String password = "12345654321";
        Mail.send(smtp, from, to, subject, content, username, password);
    }
}
