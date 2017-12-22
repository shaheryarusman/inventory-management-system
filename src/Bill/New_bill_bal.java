package Bill;

import Data_base_Conection.DataBase_connection;
import Login.Main_page;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class New_bill_bal {
    
    public int getProductRate(String Product_name) throws SQLException
    {
        PreparedStatement ps =null;
        ResultSet rs=null;        
        String Query="select pruduct_rate from Inventory where product_name = ?";      
        ps=Main_page.con.prepareStatement(Query);
        ps.setString(1, Product_name);       
        rs=ps.executeQuery();
        int product_rate = 0;
        while(rs.next())
        {
            product_rate =rs.getInt("pruduct_rate");
         
        }
        return product_rate;
        
    }
    
    public int getProductQuntity(String Product_name) throws SQLException
    {
      PreparedStatement ps =null;
      ResultSet rs=null;
        
        String Query="select pruduct_quantity from Inventory where product_name = ?";      
        ps=Main_page.con.prepareStatement(Query);
        ps.setString(1, Product_name);       
        rs=ps.executeQuery();
        int product_qnt = 0;
        while(rs.next())
        {
            product_qnt =rs.getInt("pruduct_quantity");
         
        }
        return product_qnt; 
        
    }
    
    public int getProductTotalAmt(String Product_name) throws SQLException
    {
      PreparedStatement ps =null;
      ResultSet rs=null;
        
        String Query="select total_amount from Inventory where product_name = ?";      
        ps=Main_page.con.prepareStatement(Query);
        ps.setString(1, Product_name);       
        rs=ps.executeQuery();
        int product_anmt = 0;
        while(rs.next())
        {
            product_anmt =rs.getInt("total_amount");
         
        }
        return product_anmt; 
    }
    
    
   public int getcustomer_balance(String customer_name) throws SQLException
    {
      PreparedStatement ps =null;
      ResultSet rs=null;
        
        String Query="select customer_balnce from account where customer_name =? ";      
        ps=Main_page.con.prepareStatement(Query);
        ps.setString(1, customer_name);       
        rs=ps.executeQuery();
        int customer_balance = 0;
        while(rs.next())
        {
            customer_balance =rs.getInt("customer_balnce");
         
        }
        return customer_balance; 
    }  
   
   public boolean check_bill_id(long Bill_ID) throws SQLException
   {
       boolean Status = false;
       PreparedStatement ps =null;
       ResultSet rs=null;
       String Query="select Bill_id from new_bill where Bill_id =? "; 
       ps.setLong(1, Bill_ID);
       rs = ps.executeQuery();
       if(rs.next())
       {
           Status = false;
       }
       else
       {
           Status = true;
       }
       
       return Status;
       
   }
   
   
   public int getNewBillId() throws SQLException
   {
       int ID = 0;
        String Query="Select top 1 Bill_ID from Bill_Amount order by Bill_ID desc"; 
        PreparedStatement ps =Main_page.con.prepareStatement(Query);
      // PreparedStatement ps =
       ResultSet rs=null;
      
       rs = ps.executeQuery();
       
         if(rs.next())
        {
            ID =rs.getInt("Bill_ID");        
        }
       
       return ID;
   }
   
   
   public void Sent_BillAmount_in_Amount_bill(int bill_id , String Customer_name , int Bill_amount) throws SQLException
   {
        ResultSet rs=null;
       String Query="insert into Bill_Amount values (? ,? ,?)"; 
        PreparedStatement ps =Main_page.con.prepareStatement(Query);
        ps.setInt(1, bill_id);
        ps.setString(2, Customer_name);
        ps.setInt(3, Bill_amount);
        ps.executeUpdate();
      // PreparedStatement ps =
     
   }
   
    public void Sent_Data_in_Product_bill(int bill_id , String date , String time , String Product_name , int qnt , int rate , int amount) throws SQLException
    {
        ResultSet rs=null;
        String Query="insert into Bill_Product values (? ,  ? , ? , ? , ? , ? ,?)"; 
        PreparedStatement ps =Main_page.con.prepareStatement(Query);
        ps.setInt(1, bill_id);
        ps.setString(2, date);
        ps.setString(3, time);        
        ps.setString(4, Product_name);
        ps.setInt(5, qnt);
        ps.setInt(6, rate);
        ps.setInt(7, amount);
        
        ps.executeUpdate();
    }
    
    
    public void update_product_qnt(String product_name , int qunatity) throws SQLException
    {
        ResultSet rs=null;
        String Query="update Inventory set pruduct_quantity = ? where product_name = ?"; 
        PreparedStatement ps =Main_page.con.prepareStatement(Query);
        ps.setInt(1, qunatity);
        ps.setString(2, product_name);
        ps.executeUpdate();
    }
    
    public void update_qnt_when_remove(String product_name , int qunatity) throws SQLException
    {
        ResultSet rs=null;
        String Query="update Inventory set pruduct_quantity = pruduct_quantity + ? where product_name = ?"; 
        PreparedStatement ps =Main_page.con.prepareStatement(Query);
        ps.setInt(1, qunatity);
        ps.setString(2, product_name);
        ps.executeUpdate(); 
    }
    
    
}

