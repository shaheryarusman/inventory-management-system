package Products;

import Data_base_Conection.DataBase_connection;
import Login.Main_page;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import sun.security.x509.AttributeNameEnumeration;


public class Product_bal {
  
    
    private String  product_name;
    private String  product_qnt;
    private String  product_rate;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_qnt() {
        return product_qnt;
    }

    public void setProduct_qnt(String product_qnt) {
        this.product_qnt = product_qnt;
    }

    public String getProduct_rate() {
        return product_rate;
    }

    public void setProduct_rate(String product_rate) {
        this.product_rate = product_rate;
    }
    
    
    
    
      public int get_New_product_id () throws SQLException
    {
        int ID = 0;
        String Query="Select top 1 product_id from Inventory order by product_id desc"; 
        PreparedStatement ps = Main_page.con.prepareStatement(Query);
      // PreparedStatement ps =
       ResultSet rs=null;
      
       rs = ps.executeQuery();
       
         if(rs.next())
        {
            ID = rs.getInt("product_id");        
        }
       
       return ID;
    }
    
      
      
    public   Vector <String> getAllProducts() throws SQLException
    {
        PreparedStatement ps =null;
        ResultSet rs=null;
        Vector <String> a = new Vector<>();
        String Query="select * from CustomerSample";
        ps=Main_page.con.prepareStatement(Query);
        rs=ps.executeQuery();
        
        ResultSetMetaData rsmetadata = rs.getMetaData();
        int columbs = rsmetadata.getColumnCount();
        DefaultTableModel dtm  = new DefaultTableModel();
        //Vector colums_name = new Vector();
        Vector datarows = new Vector();
//        for(int  i = 1 ; i < columbs ; i++){
//            colums_name.addElement(rsmetadata.getColumnName(i));
//        }
//        dtm.setColumnIdentifiers(colums_name);
//        
        while(rs.next())
        {
           datarows = new Vector();
           for(int j = 1 ; j <columbs ; j++)
           {
               datarows.addElement(rs.getString(j));
           }
           dtm.addRow(datarows);
           
        }
        
     return a;
    }
    
    public int AddProduct(String product_name , String Product_rate , String product_qnt) throws SQLException
    {
        int row = 0;
        PreparedStatement ps =null;
        ResultSet rs=null;
         
        String Query = "insert into Inventory (product_name , pruduct_rate , pruduct_quantity)  values (?,?,?)";
        ps=Main_page.con.prepareStatement(Query);
        
        ps.setString(1, product_name);
        ps.setString(2, Product_rate);
        ps.setString(3, product_qnt);
        
        row =ps.executeUpdate();
        
        return row;
    
    }
    
    public  Vector <String> Product_name() throws SQLException
    {
        PreparedStatement ps =null;
        ResultSet rs=null;
        
        Vector <String> All_names = new Vector<>();
        
        String Query="select product_name from Inventory";
        ps=Main_page.con.prepareStatement(Query);
        rs=ps.executeQuery();
        String name;
        while(rs.next())
        {
            name =rs.getString("product_name");
            All_names.add(name);
        }
        return All_names;
    }
    
    
    
       public void Delete_product(String product_name) throws SQLException
     {
         
        PreparedStatement ps = null;
        ResultSet rs = null;
        String Query = "DELETE FROM Inventory WHERE product_name= ?";
        ps=Main_page.con.prepareStatement(Query);       
        ps.setString(1, product_name); 
        ps.executeUpdate();   
        
     }
       
       
        public void add_product_quantity(String product_name , int quantity) throws SQLException
     {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String Query = "update Inventory set pruduct_quantity  = pruduct_quantity + ? where product_name = ?";
        ps=Main_page.con.prepareStatement(Query);       
        ps.setInt(1, quantity);
        ps.setString(2, product_name); 
        
        
        
        ps.executeUpdate();                   
     }
     
      public void update_product_quantity(String product_name , int quantity) throws SQLException
     {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String Query = "update Inventory set pruduct_quantity = ? where product_name = ?";
        ps=Main_page.con.prepareStatement(Query);       
        ps.setInt(1, quantity);
        ps.setString(2, product_name); 
        ps.executeUpdate();                   
     }
     
       public void update_product_rate(String product_name , int rate) throws SQLException
     {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String Query = "update Inventory set pruduct_rate = ? where product_name = ?";
        ps=Main_page.con.prepareStatement(Query);       
        ps.setInt(1, rate);
        ps.setString(2, product_name); 
        ps.executeUpdate();                   
     }
     
       public void update_product_Name(String New_product_name , String Old_product_name) throws SQLException
     {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String Query = "update Inventory set product_name = ? where product_name = ?";
        ps=Main_page.con.prepareStatement(Query);       
        ps.setString(1, New_product_name);
        ps.setString(2, Old_product_name); 
        ps.executeUpdate();                   
     }
     
       
       public boolean Search_existed_porduct_for_add_new(String product_name) throws SQLException
       {
        boolean status;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String Query = "select product_name from Inventory  where product_name = ?";
        ps=Main_page.con.prepareStatement(Query); 
        ps.setString(1, product_name);  
        rs = ps.executeQuery();
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
       
       
       public String get_single_product_name(int  prodct_id) throws SQLException
       {
            String product_name = null;
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        String Query = " select product_name from Inventory\n" + 
        " where\n" +
        " product_id = ?";
        ps=Main_page.con.prepareStatement(Query); 
        ps.setInt(1, prodct_id);  
        rs = ps.executeQuery();
        while (rs.next())
        {
            product_name = rs.getString("product_name");
        }
        return product_name;
       }
       
       
          public int get_single_product_id(String  prodct_name) throws SQLException
       {
            int product_id = 0;
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        String Query = " select product_id from Inventory\n" +
" where\n" +
" product_name = ?";
        ps=Main_page.con.prepareStatement(Query); 
        ps.setString(1, prodct_name);  
        rs = ps.executeQuery();
        while (rs.next())
        {
            product_id = rs.getInt("product_id");
        }
        return product_id;
       }
     
       
}
