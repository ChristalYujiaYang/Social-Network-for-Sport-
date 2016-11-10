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
public class CustomerDAOImpl implements ICustomerDAO{
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    @Override
    public boolean findLogin(Customer customer) throws Exception {
        boolean flag = false;
        conn = GetConnection.getConnection();
        try{           
            String sql1 = "SELECT userid from CUSTOMER where email = ? and password = ?";
            this.pstmt = this.conn.prepareStatement(sql1);
            this.pstmt.setString(1,customer.getEmail());
            this.pstmt.setString(2,customer.getPassword());
            this.pstmt.executeQuery();
            String sql2 = "SELECT * from CUSTOMER where email = ? and password = ?";
            this.pstmt = this.conn.prepareStatement(sql2);
            this.pstmt.setString(1,customer.getEmail());
            this.pstmt.setString(2,customer.getPassword());
            ResultSet rs = this.pstmt.executeQuery();
            if(rs.next()){
                customer.setUserid(rs.getInt("userid"));
                customer.setName(rs.getString("name"));
                customer.setAge(rs.getString("age"));
                customer.setPhone(rs.getString("phone"));
                customer.setLogin(rs.getInt("login"));
                customer.setBasketball(rs.getInt("basketball"));
                customer.setBaseball(rs.getInt("baseball"));
                customer.setSwimming(rs.getInt("swimming"));
                customer.setFootball(rs.getInt("football"));
                customer.setJogging(rs.getInt("jogging"));
                customer.setSoccer(rs.getInt("soccer"));
                flag = true;            
                LogDAO login = new LogDAO();
                login.setLogin(customer);
            }

        }catch(Exception e){
                System.out.println("findlogin wrong");
        }
        return flag;
    }

    @Override
    public boolean findCustomer(Customer customer) throws Exception {
        boolean flag = false;
        conn = GetConnection.getConnection();
        try{           
            String sql = "SELECT email from CUSTOMER where email = ?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,customer.getEmail());
            ResultSet rs = this.pstmt.executeQuery();
            if(rs.next()){
                flag = true;
            }
            this.pstmt.close();
            }catch(Exception e){
                System.out.println(e);
            }
        return flag;       
    }
    
}
