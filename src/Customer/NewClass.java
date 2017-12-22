/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import Login.Main_page;
import static Login.Main_page.con;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewClass {
    
    public static Connection con;      
        static String connectionUrl = "jdbc:sqlserver://localhost;" 
        +"Database=Uni_Project";
        static String user="sa";
        static String passwd="123";
        static  String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        public static PreparedStatement ps =null;  
        static ResultSet rs = null;
        
    public static void main(String[] args) throws SQLException {
        
              
        System.out.println("Drivers Loaded");
     
        con=  DriverManager.getConnection(connectionUrl, user, passwd);
        System.out.println("Connection Successed");
        

    int id  = 5;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String Query = "select customer_name , customer_balnce from account where account_id ='3'";
         try {       
             ps=NewClass.con.prepareStatement(Query);
            // ps.setInt(1, id);
             rs = ps.executeQuery();
             while(rs.next())
             {
             String anem =(rs.getString("customer_name"));
             String chek = (rs.getString("customer_balnce"));
             System.out.println(""+anem+ ""+ chek);
             }
         } catch (SQLException ex) {
             Logger.getLogger(Update_account.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       
       
         
    }
}