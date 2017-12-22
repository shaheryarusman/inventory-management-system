package Bill;

import Data_base_Conection.DataBase_connection;
import Login.Main_page;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Conform_bill_bal {
  
    
     public int  save_Bill(int bill_id , String date , String time , String customer_name , String Product_name , int rate , int qnt , int total, int remainign_balance) throws SQLException
    {
        int row = 0;
        PreparedStatement ps =null;
        ResultSet rs=null;
        
        String Query = "insert into new_bill(Bill_id ,Date_  , Time_ , Customer_Name ,Product_Name , Rate , Quantity , Total_Amount , Customer_Remaining_Balance )  values (? , ? , ? , ?, ? ,?,?,?,?)";
        ps=Main_page.con.prepareStatement(Query);
        ps.setInt(1, bill_id);
        ps.setString(2, date);
        ps.setString(3, time);
        ps.setString(4, customer_name);
        ps.setString(5, Product_name);
        ps.setInt(6, rate);
        ps.setInt(7, qnt);
        ps.setInt(8, total);
        ps.setInt(9, remainign_balance);       
        row =ps.executeUpdate();
        
        return row;
    }
    
    
     // Minus quantity after any New bill
     public void minus_quantity_afterBill(String product_name , int new_quantity) throws SQLException
     {
        PreparedStatement ps =null;
        ResultSet rs=null;
        String Query = "update Inventory set pruduct_quantity  = pruduct_quantity - ? where product_name = ?";
        ps=Main_page.con.prepareStatement(Query);       
        ps.setInt(1, new_quantity);
        ps.setString(2, product_name); 
        ps.executeUpdate(); 
     }
     
   
  
   
      
   
     
     
     
     
}
