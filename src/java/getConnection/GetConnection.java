/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Crystal
 */
public class GetConnection {

    public static Connection getConnection() throws ClassNotFoundException {
        String connectionURL = "jdbc:derby://localhost:1527/FinalProject";
        Connection conn = null;
//ConnectionURL, username and password should be specified in getConnection()
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            try {
                conn = DriverManager.getConnection(connectionURL, "IS2560", "IS2560");
                System.out.println("Connect successfully ! ");
                //conn.close();
            } catch (SQLException ex) {
                System.out.println("Connect failed ! ");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("getconnection2 failed!");
        }
        return conn;
    }
}
