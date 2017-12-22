package Login;


import Data_base_Conection.DataBase_connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class textfield_bal {
   
    
     public static boolean login_check_user(String user , String pass) throws SQLException
        {
        
            PreparedStatement ps1;
                        
            ps1 = Main_page.con.prepareStatement("select username,pass_word from login_form where username =? and pass_word =?");        
            ps1.setString(1,user);
            ps1.setString(2, pass);
            ResultSet rs;
            rs = ps1.executeQuery();
            
            if(rs.next())
            {             
               return true;
            }
            else
            {
                return false;
            }
            
        }
     
     
     
         public static boolean login_check_Admin(String user , String pass) throws SQLException
        {
          //  DataBase_connection ob = new DataBase_connection();
            PreparedStatement ps1;
                        
            ps1 = Main_page.con.prepareStatement("select usename ,pass_word from admin_login_form where usename = ? and pass_word = ? ");        
            ps1.setString(1,user);
            ps1.setString(2, pass);
            ResultSet rs;
            rs = ps1.executeQuery();
            
            if(rs.next())
            {             
               return true;
            }
            else
            {
                return false;
            }
        }
     
         public int change_pass_in_Admin (String name , String old_pass , String new_pass ) throws SQLException
         {
             int status  = 0;
             
            PreparedStatement ps1;                      
            ps1 = Main_page.con.prepareStatement("update admin_login_form set pass_word  = ? where usename = ? and pass_word = ?");        
            ps1.setString(1,new_pass);
            ps1.setString(2, name);
            ps1.setString(3, old_pass);
            ResultSet rs;
            status = ps1.executeUpdate();
           
             return status;
         }
         
         
         
         
       public int change_pass_in_User (String name , String old_pass , String new_pass ) throws SQLException
         {
           int status  = 0;
             
            PreparedStatement ps1;                      
            ps1 = Main_page.con.prepareStatement("update login_form set pass_word  = ? where username = ? and pass_word = ?");        
            ps1.setString(1,new_pass);
            ps1.setString(2, name);
            ps1.setString(3, old_pass);
            ResultSet rs;
            status = ps1.executeUpdate();
           
             return status;
         }
         
        
       public boolean check_account_in_admin (String name , String passwrod) throws SQLException
                              
               
         {
           boolean status ;
            PreparedStatement ps1;                      
            ps1 = Main_page.con.prepareStatement("select usename ,pass_word from admin_login_form where usename = ? and pass_word = ? ");        
            ps1.setString(1,name);
            ps1.setString(2, passwrod);
            ResultSet rs = ps1.executeQuery();
            if(rs.next())
            {
                status = true;
            }
            else
            {
                status = false;
            }
                            
             return status;
         }
       
       
       public int Add_account_admin (String name , String passwrod) throws SQLException
         {
           int status  = 0;
             
            PreparedStatement ps1;                      
            ps1 = Main_page.con.prepareStatement("insert into admin_login_form values (? ,?)");        
            ps1.setString(1,name);
            ps1.setString(2, passwrod);           
            status = ps1.executeUpdate();
            
                        
             return status;
         }
         
       
       
             public int Add_account_USER (String name , String passwrod) throws SQLException
         {
           int status  = 0;
             
            PreparedStatement ps1;                      
            ps1 = Main_page.con.prepareStatement("insert into login_form values (? ,?)");        
            ps1.setString(1,name);
            ps1.setString(2, passwrod);           
            status = ps1.executeUpdate();
            
                        
             return status;
         }
         
         
       
       
       
//    public int check_account_in_user (String name , String old_pass , String new_pass ) throws SQLException
//         {
//           int status  = 0;
//             
//            PreparedStatement ps1;                      
//            ps1 = Main_page.con.prepareStatement("update login_form set pass_word  = ? where username = ? and pass_word = ?");        
//            ps1.setString(1,new_pass);
//            ps1.setString(2, name);
//            ps1.setString(3, old_pass);
//            ResultSet rs;
//            status = ps1.executeUpdate();
//           
//             return status;
//         }
}
