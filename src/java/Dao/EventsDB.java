/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.Arandac;
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
public class EventsDB {

    private Connection conn;
    private PreparedStatement pstat, pstat1, pstat2;

    public List<Arandac> event(String type) throws SQLException, ClassNotFoundException {
        conn = GetConnection.getConnection();
        String sql = "select * from arandac where type=?";
        pstat = conn.prepareStatement(sql);
        pstat.setString(1, type);
        ResultSet rs = (ResultSet) pstat.executeQuery();
        List<Arandac> list = new ArrayList<Arandac>();
        try {
            while (rs.next()) {
                Arandac event = new Arandac();
                event.setArandacid(rs.getInt(1));
                event.setTitle(rs.getString(2));
                list.add(event);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block     
            System.out.println("event wrong");
        }
        return list;
    }

    public Arandac findevent(Arandac events) throws SQLException, ClassNotFoundException {

        conn = GetConnection.getConnection();
        System.out.println("findevent");
        String sql = "select * from arandac where arandacid=?";
        pstat = conn.prepareStatement(sql);
        pstat.setInt(1, events.getArandacid());
        ResultSet rs = (ResultSet) pstat.executeQuery();
        Arandac event = new Arandac();
        try {
            while (rs.next()) {
                event.setArandacid(rs.getInt(1));
                event.setTitle(rs.getString(2));
                event.setText(rs.getString(3));
                event.setPeoplemax(rs.getInt(4));
                event.setPeoplemin(rs.getInt(5));
                event.setDate(rs.getDate(6));
                event.setPlace(rs.getString(7));
                event.setK1(rs.getString(8));
                event.setK2(rs.getString(9));
                event.setK3(rs.getString(10));
                event.setPeoplenum(rs.getInt(12));
                event.setType(rs.getString(11));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block     
            System.out.println("findevent wrong");
        }
        return event;
    }

    public void Addclick(Arandac events) throws SQLException, ClassNotFoundException {

        conn = GetConnection.getConnection();
        System.out.println("addclick");
        String sql = "select click from ranking where arandacid=?";
        pstat = conn.prepareStatement(sql);
        pstat.setInt(1, events.getArandacid());
        ResultSet rs = (ResultSet) pstat.executeQuery();
        int count = 0;
        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block     
            System.out.println("addclick wrong");
        }
        count++;
        String sql1 = "update ranking set click=" + count + " where arandacid=" + events.getArandacid();
        pstat1 = conn.prepareStatement(sql1);
        pstat1.executeUpdate();
    }

    public List<Arandac> rank() throws SQLException, ClassNotFoundException {
        conn = GetConnection.getConnection();
        String sql = "select * from ranking ORDER BY click desc FETCH FIRST 10 ROWS ONLY ";
        String sql1 = "select * from arandac where arandacid=?";
        pstat = conn.prepareStatement(sql);
        pstat1 = conn.prepareStatement(sql1);
        ResultSet rs = (ResultSet) pstat.executeQuery();
        List<Arandac> list1 = new ArrayList<Arandac>();
        try {
            while (rs.next()) {
                pstat1.setInt(1, rs.getInt(2));
                ResultSet rs1 = (ResultSet) pstat1.executeQuery();
                try {
                    while (rs1.next()) {
                        Arandac event = new Arandac();
                        event.setArandacid(rs1.getInt(1));
                        event.setTitle(rs1.getString(2));
                        event.setText(rs1.getString(3));
                        list1.add(event);
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block     
                    System.out.println("findevent wrong");
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block     
            System.out.println("rank wrong");
        }
        return list1;
    }

    public void addActivity(Arandac activity) throws ClassNotFoundException, SQLException {
        conn = GetConnection.getConnection();
        String sql = "insert into arandac(title,text,peoplemax,peoplemin,date,place,k1,k2,k3,type,author) values(?,?,?,?,?,?,?,?,?,?,?)";
        String sql1 = "select max(arandacid) from arandac";
        try {
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, activity.getTitle());
            pstat.setString(2, activity.getText());
            pstat.setInt(3, activity.getPeoplemax());
            pstat.setInt(4, activity.getPeoplemin());
            pstat.setDate(5, activity.getDate());
            pstat.setString(6, activity.getPlace());
            pstat.setString(7, activity.getK1());
            pstat.setString(8, activity.getK2());
            pstat.setString(9, activity.getK3());
            pstat.setString(10, activity.getType());
            pstat.setString(11, activity.getAuthor());
            pstat.executeUpdate();
            pstat.close();
        } catch (SQLException e) {
            System.out.println("addActivity wrong");
        }
        pstat1 = conn.prepareStatement(sql1);
        ResultSet rs = (ResultSet) pstat1.executeQuery();
        while(rs.next()){
        String sql2 = "insert into ranking(arandacid) values ?";
        pstat2 = conn.prepareStatement(sql2);
        pstat2.setInt(1, rs.getInt(1));
        pstat2.executeUpdate();
        }
        pstat1.close();
        pstat2.close();
        conn.close();
    }

    public List<Arandac> customerevents(Customer loginUser) throws SQLException, ClassNotFoundException {
        conn = GetConnection.getConnection();
        String sql = "select * from arandac where type=? or type=? or type=? or type=? or type=? or type=?";
        pstat = conn.prepareStatement(sql);
        if (loginUser.getBasketball() == 1) {
            pstat.setString(1, "basketball");
        } else {
            pstat.setString(1, "null");
        }
        if (loginUser.getBaseball() == 1) {
            pstat.setString(2, "baseball");
        } else {
            pstat.setString(2, "null");
        }
        if (loginUser.getSwimming() == 1) {
            pstat.setString(3, "swimming");
        } else {
            pstat.setString(3, "null");
        }
        if (loginUser.getFootball() == 1) {
            pstat.setString(4, "football");
        } else {
            pstat.setString(4, "null");
        }
        if (loginUser.getJogging() == 1) {
            pstat.setString(5, "jogging");
        } else {
            pstat.setString(5, "null");
        }
        if (loginUser.getSoccer() == 1) {
            pstat.setString(6, "soccer");
        } else {
            pstat.setString(6, "null");
        }
        ResultSet rs = (ResultSet) pstat.executeQuery();
        List<Arandac> list = new ArrayList<Arandac>();
        try {
            while (rs.next()) {
                Arandac event = new Arandac();
                event.setArandacid(rs.getInt(1));
                event.setTitle(rs.getString(2));
                list.add(event);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block     
            System.out.println("customerevent wrong");
        }
        return list;
    }

    public List<Arandac> Searchevent(String input) throws SQLException, ClassNotFoundException {

        conn = GetConnection.getConnection();
        String sql = "SELECT * FROM arandac WHERE title LIKE '%" + input + "%' or K1 LIKE '%" + input + "%' or K2 LIKE '%" + input + "%' or K3 LIKE '%" + input + "%' or type LIKE '%" + input + "%'";
        pstat = conn.prepareStatement(sql);
        ResultSet rs = (ResultSet) pstat.executeQuery();
        List<Arandac> list = new ArrayList<Arandac>();
        try {
            while (rs.next()) {
                Arandac event = new Arandac();
                event.setArandacid(rs.getInt(1));
                event.setTitle(rs.getString(2));
                event.setText(rs.getString(3));
                event.setPeoplemax(rs.getInt(4));
                event.setPeoplemin(rs.getInt(5));
                event.setDate(rs.getDate(6));
                event.setPlace(rs.getString(7));
                event.setK1(rs.getString(8));
                event.setK2(rs.getString(9));
                event.setK3(rs.getString(10));
                event.setPeoplenum(rs.getInt(12));
                event.setType(rs.getString(11));
                event.setAuthor(rs.getString(13));
                list.add(event);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block     
            System.out.println("Searchevent wrong");
        }
        return list;
    }

    public List<Arandac> Joined(Customer loginUser) throws SQLException, ClassNotFoundException {
        conn = GetConnection.getConnection();
        String sql = "select * from \"" + loginUser.getUserid() + "\"";
        String sql1 = "select * from arandac where arandacid=?";
        pstat = conn.prepareStatement(sql);
        pstat1 = conn.prepareStatement(sql1);
        ResultSet rs = (ResultSet) pstat.executeQuery();
        List<Arandac> list1 = new ArrayList<Arandac>();
        try {
            while (rs.next()) {
                pstat1.setInt(1, rs.getInt(2));
                ResultSet rs1 = (ResultSet) pstat1.executeQuery();
                try {
                    while (rs1.next()) {
                        Arandac event = new Arandac();
                        event.setArandacid(rs1.getInt(1));
                        event.setTitle(rs1.getString(2));
                        event.setText(rs1.getString(3));
                        list1.add(event);
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block     
                    System.out.println("findevent wrong");
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block     
            System.out.println("joined wrong");
        }
        return list1;
    }
}
