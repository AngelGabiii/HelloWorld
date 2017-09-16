/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma;

import java.sql.*;
import java.sql.DriverManager;

/**
 *
 * @author Angelis
 */
public class TheConnection {
    
 public  static Connection  conn = null;
    
    
    public static Connection establishConnection() throws Exception{
        try{
            String url = "jdbc:mysql://localhost:3306/pharmadata";
            String user = "root";
            String password = "";
            
            conn = DriverManager.getConnection(url, user, password );
            System.out.println("Connected");
            
        }catch(Exception ex){
            System.out.println("Could not connect to db");
        }
         return conn;    
           
    }
    
}
