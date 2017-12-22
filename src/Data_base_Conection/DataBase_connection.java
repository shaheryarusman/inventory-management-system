package Data_base_Conection;


import Login.Main_page;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataBase_connection {
    
        public static Connection con;      
        static String connectionUrl = "jdbc:sqlserver://localhost;" 
        +"Database=Uni_Project";
        static String user="sa";
        static String passwd="123";
        static  String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        public static PreparedStatement ps =null;  
        static ResultSet rs = null;
        
        public void connection()
        {
            
        }
       
        
        public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {        
            
        Class.forName(driver);
        System.out.println("Drivers Loaded");
        try {
        con=  DriverManager.getConnection(connectionUrl, user, passwd);
        System.out.println("Connection Successed");
        
        // TODO code application logic here
    } catch (SQLException ex) {
        Logger.getLogger(DataBase_connection.class.getName()).log(Level.SEVERE, null, ex);
    }
//      
//        textfield  ob = new textfield();
//        ob.setVisible(true);
////        
         Main_page ob = new Main_page();
         ob.setVisible(true);
////         
//            View_product ob = new View_product();
//            ob.setVisible(true);
//    
}
}


