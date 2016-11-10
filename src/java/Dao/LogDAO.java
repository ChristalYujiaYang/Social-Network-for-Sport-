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
public class LogDAO {

    private int login;
    private PreparedStatement pstmt;
    private Connection conn;
        
    public int getLog(Customer customer){

        try {
            conn = GetConnection.getConnection();       
            String sql = "SELECT login FROM CUSTOMER where email = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, customer.getEmail());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                login = rs.getInt("login");                
            }
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return login;
    }
    public void setLogin(Customer customer){
        try {
            conn = GetConnection.getConnection();
            String sql = "UPDATE CUSTOMER SET login= 1 where email = ?";
            pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, customer.getEmail());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    public void setLogout(Customer customer){
        try {
            conn = GetConnection.getConnection();
            String sql = "UPDATE CUSTOMER SET login= 0 where email = ?";
            pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, customer.getEmail());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
        
    
}
