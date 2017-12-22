package Customer;

import Data_base_Conection.DataBase_connection;
import Login.Main_page;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shahyar
 */
public class Account_bal {
    
    public int get_New_customer_id () throws SQLException
    {
        int ID = 0;
        String Query="Select top 1 account_id from account order by account_id desc"; 
        PreparedStatement ps =Main_page.con.prepareStatement(Query);
      // PreparedStatement ps =
       ResultSet rs=null;
      
       rs = ps.executeQuery();
       
         if(rs.next())
        {
            ID =rs.getInt("account_id");        
        }
       
       return ID;
    }
    
     public int AddAccount(String customer_name , int balnce) throws SQLException
    {
        int row = 0;
        PreparedStatement ps =null;
        ResultSet rs=null;
         
        String Query = "insert into account (customer_name , customer_balnce )  values (? , ?)";
        ps=Main_page.con.prepareStatement(Query);
        ps.setString(1, customer_name);
        ps.setInt(2, balnce);
        
        row =ps.executeUpdate();
        
        return row;
    
    }
     
      public  Vector <String> Customer_name() throws SQLException
              
    {
        PreparedStatement ps =null;
        ResultSet rs=null;
        Vector <String> All_names = new Vector<>();
        String Query="select customer_name from account ";
        ps=Main_page.con.prepareStatement(Query);
        rs=ps.executeQuery();
        String name;
        while(rs.next())
        {
            name =rs.getString("customer_name");
            All_names.add(name);
        }
        return All_names;
    }

  public void Delete_customer(String customer_name) throws SQLException
     {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String Query = "DELETE FROM account WHERE customer_name= ?";
        ps=Main_page.con.prepareStatement(Query);       
        ps.setString(1, customer_name); 
        ps.executeUpdate();                   
     }
     
    public void add_customer_blnce(String customer_name , int balance) throws SQLException
     {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String Query = "update account set customer_balnce  = customer_balnce + ? where customer_name = ?";
        ps=Main_page.con.prepareStatement(Query);       
        ps.setInt(1, balance);
        ps.setString(2, customer_name); 
        ps.executeUpdate();                   
     }
    
      public void update_customer_balnce(String customer_name , int balnce) throws SQLException
     {
        PreparedStatement ps =null;
        ResultSet rs=null;
        String Query = "update account set customer_balnce = ? where customer_name = ?";
        ps=Main_page.con.prepareStatement(Query);       
        ps.setInt(1, balnce);
        ps.setString(2, customer_name); 
        ps.executeUpdate();       
     }
      
        public void update_customer_Name(String New_customer_name , String Old_customer_name) throws SQLException
     {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String Query = "update account set customer_name = ? where customer_name = ?";
        ps=Main_page.con.prepareStatement(Query);       
        ps.setString(1, New_customer_name);
        ps.setString(2, Old_customer_name); 
        ps.executeUpdate();                   
     }
     
       public String get_single_customer_name(int  customer_id) throws SQLException
       {
            String customer_name = null;
       
        PreparedStatement ps = null;
        ResultSet rs = null;
        String Query = "select customer_name from account\n" +
" where \n" +
" account_id = ?";
        ps=Main_page.con.prepareStatement(Query); 
        ps.setInt(1, customer_id);  
        rs = ps.executeQuery();
        while (rs.next())
        {
            customer_name = rs.getString("customer_name");
        }
        return customer_name;
       }
     
}
