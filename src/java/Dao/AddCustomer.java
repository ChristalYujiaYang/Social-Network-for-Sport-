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


/**
 *
 * @author wyh1
 */
public class AddCustomer {

    private Connection conn;
    PreparedStatement pstmt, pstmt1;

    public String addC(Customer customer) {
        try {
            conn = GetConnection.getConnection();
            String sql = "INSERT INTO CUSTOMER (NAME,EMAIL,PASSWORD,AGE,PHONE,"
                    + "BASKETBALL,BASEBALL,SWIMMING,FOOTBALL,JOGGING,SOCCER)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, customer.getName());
                pstmt.setString(2, customer.getEmail());
                pstmt.setString(3, customer.getPassword());
                pstmt.setString(4, customer.getAge());
                pstmt.setString(5, customer.getPhone());
                pstmt.setInt(6, customer.getBasketball());
                pstmt.setInt(7, customer.getBaseball());
                pstmt.setInt(8, customer.getSwimming());
                pstmt.setInt(9, customer.getFootball());
                pstmt.setInt(10, customer.getJogging());
                pstmt.setInt(11, customer.getSoccer());
                pstmt.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
            String sql2 = "SELECT userid from CUSTOMER where email = ?";
            pstmt = conn.prepareStatement(sql2);
            pstmt.setString(1, customer.getEmail());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int userid = rs.getInt("userid");
                String id = String.valueOf(userid);
                String sql3 = "CREATE TABLE \""+id+"\"(joinactivityid integer generated always as identity, arandacid integer)";
                System.out.println(sql3);
                pstmt1 = conn.prepareStatement(sql3);
                pstmt1.execute();
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("addc wrong");
        }
        return "Successflly Register!";
    }

}
