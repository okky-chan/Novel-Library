/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lightNovel;

import java.sql.DriverManager;

/**
 *
 * @author newbi
 */
public class Connect {
    private static java.sql.Connection connect;
    
    public static java.sql.Connection getConnectionDB() {
        if (connect == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/crud";
                String user = "root";
                String pass = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connect = DriverManager.getConnection(url, user, pass);
                System.out.println("Connected");
            } catch (Exception e) {
                System.out.println("Error! Check the connection");
            }
        }
        return connect;
    }
    
    public static void main(String args[]) {
        getConnectionDB();
    }
    
}
