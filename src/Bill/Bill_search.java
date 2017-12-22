package Bill;

import Data_base_Conection.DataBase_connection;
import Customer.Account_bal;
import Bill.New_bill;
import Login.Main_page;
import Products.Product_bal;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shahyar
 */
public class Bill_search extends javax.swing.JInternalFrame {

    /**
     * Creates new form Bill_search
     */
     DefaultComboBoxModel product_list;
     DefaultComboBoxModel Customer_list;
     
    public Bill_search() throws SQLException {
        initComponents();
        jComboBox_date.setEnabled(false);
        jComboBox_month.setEnabled(false);
        jComboBox_year.setEnabled(false);
        jComboBox1_product_name.setEnabled(false);
        jComboBox_custome_name.setEnabled(false);
        jTextField1_bill_id.setEnabled(false);
        jComboBox_date_2.setEnabled(false);
        jComboBox_month_2.setEnabled(false);
        jComboBox_year_2.setEnabled(false);
        jCheckBox_range_date.setEnabled(false);
        
        product_list();
        Customer_list();
    
        PreparedStatement ps =null;
            ResultSet rs=null;
      //  String s = (String)jComboBox1_product_name.getSelectedItem();
       /// Vector <String> a = new Vector<>();
        String Query="select Bill_Amount.Bill_ID , Bill_Product.Date_ , Bill_Product.Time_ , Bill_Amount.customer_name ,  Bill_Product.Prodcut_name ,\n" +
" Bill_Product.Quantity , Bill_Product.Rate ,  Bill_Amount.Bill_Amount \n" +
" from \n" +
" Bill_Amount\n" +
" right join\n" +
" Bill_Product\n" +
" on \n" +
" Bill_Amount.Bill_ID = Bill_Product.Bill_ID\n" +
"\n" +
" order by \n" +
" Bill_ID";
             try {
                 ps=Main_page.con.prepareStatement(Query);
                // ps.setString(1, s);
             } catch (SQLException ex) {
                 Logger.getLogger(Bill_search.class.getName()).log(Level.SEVERE, null, ex);
             }
             try {
                 rs=ps.executeQuery();
             } catch (SQLException ex) {
                 Logger.getLogger(Bill_search.class.getName()).log(Level.SEVERE, null, ex);
             }
             ResultSetMetaData rsmetadata = rs.getMetaData();
        int columbs = rsmetadata.getColumnCount();
        DefaultTableModel dtm  = new DefaultTableModel();
       Vector colums_name = new Vector();
             
           
          for(int  i = 1 ; i <= columbs ; i++){
            colums_name.addElement(rsmetadata.getColumnName(i));
        }
        dtm.setColumnIdentifiers(colums_name);     
             
        jTable1.setModel(dtm);
       
    }
    
    public void product_search() throws SQLException
    {
          PreparedStatement ps =null;
            ResultSet rs=null;
        String s = (String)jComboBox1_product_name.getSelectedItem();
       /// Vector <String> a = new Vector<>();
        String Query="select Bill_Amount.Bill_ID , Bill_Product.Date_ , Bill_Product.Time_ , Bill_Amount.customer_name ,  Bill_Product.Prodcut_name ,\n" +
" Bill_Product.Quantity , Bill_Product.Rate ,  Bill_Amount.Bill_Amount \n" +
" from \n" +
" Bill_Amount\n" +
" right join\n" +
" Bill_Product\n" +
" on \n" +
" Bill_Amount.Bill_ID = Bill_Product.Bill_ID\n" +
" where\n" +
" Bill_Product.Prodcut_name = ?\n" +
" order by \n" +
" Bill_ID";
             try {
                 ps=Main_page.con.prepareStatement(Query);
                 ps.setString(1, s);
             } catch (SQLException ex) {
                 Logger.getLogger(Bill_search.class.getName()).log(Level.SEVERE, null, ex);
             }
             try {
                 rs=ps.executeQuery();
             } catch (SQLException ex) {
                 Logger.getLogger(Bill_search.class.getName()).log(Level.SEVERE, null, ex);
             }
             ResultSetMetaData rsmetadata = rs.getMetaData();
        int columbs = rsmetadata.getColumnCount();
        DefaultTableModel dtm  = new DefaultTableModel();
       Vector colums_name = new Vector();
             
         Vector datarows = new Vector();    
          for(int  i = 1 ; i <= columbs ; i++){
            colums_name.addElement(rsmetadata.getColumnName(i));
        }
        dtm.setColumnIdentifiers(colums_name);     
             
             while(rs.next())
        {
           datarows = new Vector();
           for(int j = 1 ; j <=columbs ; j++)
           {
               datarows.addElement(rs.getString(j));
           }
           dtm.addRow(datarows);
           
        }
        jTable1.setModel(dtm);
    }
    
    
    
    
    public void customer_search() throws SQLException
    {
          PreparedStatement ps =null;
            ResultSet rs=null;
        String s = (String)jComboBox_custome_name.getSelectedItem();
       /// Vector <String> a = new Vector<>();
        String Query="select Bill_Amount.Bill_ID , Bill_Product.Date_ , Bill_Product.Time_ , Bill_Amount.customer_name ,  Bill_Product.Prodcut_name ,\n" +
" Bill_Product.Quantity , Bill_Product.Rate ,  Bill_Amount.Bill_Amount \n" +
" from \n" +
" Bill_Amount\n" +
" right join\n" +
" Bill_Product\n" +
" on \n" +
" Bill_Amount.Bill_ID = Bill_Product.Bill_ID\n" +
" where\n" +
" Bill_Amount.customer_name = ?\n" +
" order by \n" +
" Bill_ID";
             try {
                 ps=Main_page.con.prepareStatement(Query);
                 ps.setString(1, s);
             } catch (SQLException ex) {
                 Logger.getLogger(Bill_search.class.getName()).log(Level.SEVERE, null, ex);
             }
             try {
                 rs=ps.executeQuery();
             } catch (SQLException ex) {
                 Logger.getLogger(Bill_search.class.getName()).log(Level.SEVERE, null, ex);
             }
             ResultSetMetaData rsmetadata = rs.getMetaData();
        int columbs = rsmetadata.getColumnCount();
        DefaultTableModel dtm  = new DefaultTableModel();
       Vector colums_name = new Vector();
             
         Vector datarows = new Vector();    
          for(int  i = 1 ; i <= columbs ; i++){
            colums_name.addElement(rsmetadata.getColumnName(i));
        }
        dtm.setColumnIdentifiers(colums_name);     
             
             while(rs.next())
        {
           datarows = new Vector();
           for(int j = 1 ; j <=columbs ; j++)
           {
               datarows.addElement(rs.getString(j));
           }
           dtm.addRow(datarows);
           
        }
        jTable1.setModel(dtm);
        
    }
    

    
    
    public void date_search() throws SQLException
    {
    
        PreparedStatement ps =null;
            ResultSet rs=null;
        String date = (String)jComboBox_date.getSelectedItem();
        String mounth = (String)jComboBox_month.getSelectedItem();
        String year = (String)jComboBox_year.getSelectedItem();
        String a  =date+"-"+mounth+"-"+year;
       /// Vector <String> a = new Vector<>();
        String Query="select Bill_Amount.Bill_ID , Bill_Product.Date_ , Bill_Product.Time_ , Bill_Amount.customer_name ,  Bill_Product.Prodcut_name ,\n" +
        " Bill_Product.Quantity , Bill_Product.Rate ,  Bill_Amount.Bill_Amount \n" +
        " from \n" +
        " Bill_Amount\n" +
        " right join\n" +
        " Bill_Product\n" +
        " on \n" +
        " Bill_Amount.Bill_ID = Bill_Product.Bill_ID\n" +
        " where\n" +
        " Date_ = ?\n" +
        " order by \n" +
        " Bill_ID";
             try {
                 ps=Main_page.con.prepareStatement(Query);
                 ps.setString(1, a);
//                 ps.setString(2, "May");
//                 ps.setString(3, "2016");
                 
             } catch (SQLException ex) {
                 Logger.getLogger(Bill_search.class.getName()).log(Level.SEVERE, null, ex);
             }
             try {
                 rs=ps.executeQuery();
             } catch (SQLException ex) {
                 Logger.getLogger(Bill_search.class.getName()).log(Level.SEVERE, null, ex);
             }
             ResultSetMetaData rsmetadata = rs.getMetaData();
        int columbs = rsmetadata.getColumnCount();
        DefaultTableModel dtm  = new DefaultTableModel();
       Vector colums_name = new Vector();
             
         Vector datarows = new Vector();    
          for(int  i = 1 ; i <= columbs ; i++){
            colums_name.addElement(rsmetadata.getColumnName(i));
        }
        dtm.setColumnIdentifiers(colums_name);     
             
             while(rs.next())
        {
           datarows = new Vector();
           for(int j = 1 ; j <=columbs ; j++)
           {
               datarows.addElement(rs.getString(j));
           }
           dtm.addRow(datarows);
           
        }
        jTable1.setModel(dtm);   
        
    }
    
    public void Date_range() throws SQLException
    {
        
        PreparedStatement ps =null;
            ResultSet rs=null;
            // first date
        String date = (String)jComboBox_date.getSelectedItem();
        String mounth = (String)jComboBox_month.getSelectedItem();
        String year = (String)jComboBox_year.getSelectedItem();
        String a  =date+"-"+mounth+"-"+year;
      //second date
        String date_2 = (String)jComboBox_date_2.getSelectedItem();
        String mounth_2 = (String)jComboBox_month_2.getSelectedItem();
        String year_2 = (String)jComboBox_year_2.getSelectedItem();
        String b  =date_2+"-"+mounth_2+"-"+year_2;
        String Query="select Bill_Amount.Bill_ID , Bill_Product.Date_ , Bill_Product.Time_ , Bill_Amount.customer_name ,  Bill_Product.Prodcut_name ,\n" +
" Bill_Product.Quantity , Bill_Product.Rate ,  Bill_Amount.Bill_Amount \n" +
" from \n" +
" Bill_Amount\n" +
" right join\n" +
" Bill_Product\n" +
" on \n" +
" Bill_Amount.Bill_ID = Bill_Product.Bill_ID\n" +
" where Date_ between ? and ?\n" +
" order by \n" +
" Bill_ID";
             try {
                 ps=Main_page.con.prepareStatement(Query);
                 ps.setString(1, a);
                 ps.setString(2, b);
                 
//                 ps.setString(2, "May");
//                 ps.setString(3, "2016");
                 
             } catch (SQLException ex) {
                 Logger.getLogger(Bill_search.class.getName()).log(Level.SEVERE, null, ex);
             }
             try {
                 rs=ps.executeQuery();
             } catch (SQLException ex) {
                 Logger.getLogger(Bill_search.class.getName()).log(Level.SEVERE, null, ex);
             }
             ResultSetMetaData rsmetadata = rs.getMetaData();
        int columbs = rsmetadata.getColumnCount();
        DefaultTableModel dtm  = new DefaultTableModel();
       Vector colums_name = new Vector();
             
         Vector datarows = new Vector();    
          for(int  i = 1 ; i <= columbs ; i++){
            colums_name.addElement(rsmetadata.getColumnName(i));
        }
        dtm.setColumnIdentifiers(colums_name);     
             
             while(rs.next())
        {
           datarows = new Vector();
           for(int j = 1 ; j <=columbs ; j++)
           {
               datarows.addElement(rs.getString(j));
           }
           dtm.addRow(datarows);
           
        }
        jTable1.setModel(dtm); 
    }
    
    
    
    public void By_id () throws SQLException
    {
      PreparedStatement ps =null;
            ResultSet rs=null;
     String bill_id = (String)jTextField1_bill_id.getText();
       /// Vector <String> a = new Vector<>();
        String Query="select Bill_Amount.Bill_ID , Bill_Product.Date_ , Bill_Product.Time_ , Bill_Amount.customer_name ,  Bill_Product.Prodcut_name ,\n" +
        " Bill_Product.Quantity , Bill_Product.Rate ,  Bill_Amount.Bill_Amount \n" +
        " from \n" +
        " Bill_Amount\n" +
        " right join\n" +
        " Bill_Product\n" +
        " on \n" +
        " Bill_Amount.Bill_ID = Bill_Product.Bill_ID\n" +
        " where\n" +
        " Bill_Amount.Bill_ID = ?\n" +
        " order by \n" +
        " Bill_ID";
             try {
                 ps=Main_page.con.prepareStatement(Query);
                 ps.setString(1, bill_id);
//                 ps.setString(2, "May");
//                 ps.setString(3, "2016");
                 
             } catch (SQLException ex) {
                 Logger.getLogger(Bill_search.class.getName()).log(Level.SEVERE, null, ex);
             }
             try {
                 rs=ps.executeQuery();
             } catch (SQLException ex) {
                 Logger.getLogger(Bill_search.class.getName()).log(Level.SEVERE, null, ex);
             }
             ResultSetMetaData rsmetadata = rs.getMetaData();
        int columbs = rsmetadata.getColumnCount();
        DefaultTableModel dtm  = new DefaultTableModel();
       Vector colums_name = new Vector();
             
         Vector datarows = new Vector();    
          for(int  i = 1 ; i <= columbs ; i++){
            colums_name.addElement(rsmetadata.getColumnName(i));
        }
        dtm.setColumnIdentifiers(colums_name);     
             
             while(rs.next())
        {
           datarows = new Vector();
           for(int j = 1 ; j <=columbs ; j++)
           {
               datarows.addElement(rs.getString(j));
           }
           dtm.addRow(datarows);
           
        }
        jTable1.setModel(dtm);    
        
    }
    
    
      public void product_list()
    {
      Product_bal ob = new Product_bal();
        Vector <String> v;
       
        try {
            v = ob.Product_name();
             product_list= new DefaultComboBoxModel();
             for (String cb:v) {
               
                product_list.addElement(cb);
             //   JOptionPane.showMessageDialog(null,cb.getCustomer_name());
            }
           } catch (SQLException ex) {
            Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            jComboBox1_product_name.setModel(product_list);
           //  jLabel_product_name_show.setText((String) jComboBox_product.getSelectedItem());
    }
    
      
      
     public void Customer_list()
    {
       Account_bal ob = new Account_bal();
       Vector <String> v;
       
        try {
            v = ob.Customer_name();
             Customer_list= new DefaultComboBoxModel();
             for (String cb:v) {
               
                Customer_list.addElement(cb);
             //   JOptionPane.showMessageDialog(null,cb.getCustomer_name());
            }
           } catch (SQLException ex) {
            Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            jComboBox_custome_name.setModel(Customer_list);
           //  jLabel_customer_name_shpw.setText((String) jComboBox_customer.getSelectedItem()); 
    }



         
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton_product = new javax.swing.JRadioButton();
        jRadioButton_customer = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton_date = new javax.swing.JRadioButton();
        jComboBox_date = new javax.swing.JComboBox();
        jComboBox_month = new javax.swing.JComboBox();
        jComboBox_year = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1_product_name = new javax.swing.JComboBox();
        jComboBox_custome_name = new javax.swing.JComboBox();
        jButton1_search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jRadioButton1_bill_id = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField1_bill_id = new javax.swing.JTextField();
        jCheckBox_range_date = new javax.swing.JCheckBox();
        jComboBox_date_2 = new javax.swing.JComboBox();
        jComboBox_month_2 = new javax.swing.JComboBox();
        jComboBox_year_2 = new javax.swing.JComboBox();
        jLabel_status = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Bill Search");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("AR BONNIE", 1, 52)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Bill Search");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 240, 59));

        buttonGroup1.add(jRadioButton_product);
        jRadioButton_product.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButton_product.setForeground(new java.awt.Color(0, 51, 153));
        jRadioButton_product.setText("By Product Sale");
        jRadioButton_product.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton_productItemStateChanged(evt);
            }
        });
        jRadioButton_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_productActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 86, 133, -1));

        buttonGroup1.add(jRadioButton_customer);
        jRadioButton_customer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButton_customer.setForeground(new java.awt.Color(0, 51, 153));
        jRadioButton_customer.setText("By Customer Name");
        jRadioButton_customer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton_customerItemStateChanged(evt);
            }
        });
        jRadioButton_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_customerActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton_customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 112, -1, -1));

        jLabel2.setText("Search Catogory");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 93, -1));

        buttonGroup1.add(jRadioButton_date);
        jRadioButton_date.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButton_date.setForeground(new java.awt.Color(0, 51, 153));
        jRadioButton_date.setText("By Date");
        jRadioButton_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_dateActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 138, -1, -1));

        jComboBox_date.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        getContentPane().add(jComboBox_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 139, 61, -1));

        jComboBox_month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
        getContentPane().add(jComboBox_month, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 139, 78, -1));

        jComboBox_year.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2016", "2017", "2018" }));
        getContentPane().add(jComboBox_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 139, 83, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 153));
        jLabel3.setText("Enter Product Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 153));
        jLabel4.setText("Enter Customer Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 153));
        jLabel5.setText("Select Date ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, -1, -1));

        jComboBox1_product_name.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1_product_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 87, 234, -1));

        jComboBox_custome_name.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_custome_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 113, 234, -1));

        jButton1_search.setBackground(new java.awt.Color(255, 102, 0));
        jButton1_search.setText("Search");
        jButton1_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_searchActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 196, 126, 47));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 249, 1054, 243));

        buttonGroup1.add(jRadioButton1_bill_id);
        jRadioButton1_bill_id.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButton1_bill_id.setForeground(new java.awt.Color(0, 51, 153));
        jRadioButton1_bill_id.setText("By Bill ID");
        jRadioButton1_bill_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1_bill_idActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1_bill_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 161, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 153));
        jLabel6.setText("Enter Bill ID");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(813, 90, 91, -1));

        jTextField1_bill_id.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        jTextField1_bill_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1_bill_idFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1_bill_idFocusLost(evt);
            }
        });
        jTextField1_bill_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1_bill_idActionPerformed(evt);
            }
        });
        jTextField1_bill_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_bill_idKeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1_bill_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(922, 88, 122, -1));

        jCheckBox_range_date.setForeground(new java.awt.Color(0, 51, 153));
        jCheckBox_range_date.setText("To");
        jCheckBox_range_date.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox_range_dateItemStateChanged(evt);
            }
        });
        getContentPane().add(jCheckBox_range_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, -1, -1));

        jComboBox_date_2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        getContentPane().add(jComboBox_date_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 196, 61, -1));

        jComboBox_month_2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
        getContentPane().add(jComboBox_month_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 196, 78, -1));

        jComboBox_year_2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2016", "2017", "2018" }));
        getContentPane().add(jComboBox_year_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 196, 83, -1));
        getContentPane().add(jLabel_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(813, 129, 251, 16));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bill/blue.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_productActionPerformed
        // TODO add your handling code here:
        if(jRadioButton_product.isSelected())
        {           
             jComboBox1_product_name.setEnabled(true);
             jComboBox_date.setEnabled(false);
             jComboBox_month.setEnabled(false);
             jComboBox_year.setEnabled(false);
             jComboBox_custome_name.setEnabled(false);
             jTextField1_bill_id.setEnabled(false);
              jComboBox_date_2.setEnabled(false);
             jComboBox_month_2.setEnabled(false);
             jComboBox_year_2.setEnabled(false);
             jCheckBox_range_date.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton_productActionPerformed

    private void jRadioButton_productItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton_productItemStateChanged
        
    }//GEN-LAST:event_jRadioButton_productItemStateChanged

    private void jRadioButton_customerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton_customerItemStateChanged
         
    }//GEN-LAST:event_jRadioButton_customerItemStateChanged

    private void jRadioButton_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_customerActionPerformed
        // TODO add your handling code here:
        if(jRadioButton_customer.isSelected())
        {           
             jComboBox1_product_name.setEnabled(false);
             jComboBox_date.setEnabled(false);
             jComboBox_month.setEnabled(false);
             jComboBox_year.setEnabled(false);
             jComboBox_custome_name.setEnabled(true);
             jTextField1_bill_id.setEnabled(false);
              jComboBox_date_2.setEnabled(false);
             jComboBox_month_2.setEnabled(false);
             jComboBox_year_2.setEnabled(false);
             jCheckBox_range_date.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton_customerActionPerformed

    private void jRadioButton_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_dateActionPerformed
        // TODO add your handling code here:
        if(jRadioButton_date.isSelected())
        {           
             jComboBox1_product_name.setEnabled(false);
             jComboBox_date.setEnabled(true);
             jComboBox_month.setEnabled(true);
             jComboBox_year.setEnabled(true);
             jComboBox_custome_name.setEnabled(false);
             jTextField1_bill_id.setEnabled(false);
             jComboBox_date_2.setEnabled(false);
             jComboBox_month_2.setEnabled(false);
             jComboBox_year_2.setEnabled(false);
             jCheckBox_range_date.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButton_dateActionPerformed

    private void jButton1_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_searchActionPerformed
      
             if(jRadioButton_product.isSelected())
             {
                 try {
                     product_search();
                 } catch (SQLException ex) {
                     Logger.getLogger(Bill_search.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
              if(jRadioButton_customer.isSelected())
              {
                 try {
                     customer_search();
                 } catch (SQLException ex) {
                     Logger.getLogger(Bill_search.class.getName()).log(Level.SEVERE, null, ex);
                 }
              }
         
             if(jRadioButton_date.isSelected())
             {
                 jCheckBox_range_date.setEnabled(true);
                 if(jCheckBox_range_date.isSelected())
                 {
                        jComboBox_date_2.setEnabled(true);
                        jComboBox_month_2.setEnabled(true);
                        jComboBox_year_2.setEnabled(true);
                     try {
                         Date_range();
                     } catch (SQLException ex) {
                         Logger.getLogger(Bill_search.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
                 else
                 {
                 try {
                     date_search();
                 } catch (SQLException ex) {
                     Logger.getLogger(Bill_search.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 }
             }
             
             
             if(jRadioButton1_bill_id.isSelected())
             {
                String check = jTextField1_bill_id.getText();
                if(check.equalsIgnoreCase(""))
                {
                    jTextField1_bill_id.setBackground(Color.red);
                }
                else
                {
                 try {
                     By_id();
                 } catch (SQLException ex) {
                     Logger.getLogger(Bill_search.class.getName()).log(Level.SEVERE, null, ex);
                 }
                }
             }
             
    
    }//GEN-LAST:event_jButton1_searchActionPerformed

    private void jRadioButton1_bill_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1_bill_idActionPerformed
          if(jRadioButton1_bill_id.isSelected())
        {           
             jComboBox1_product_name.setEnabled(false);
             jComboBox_date.setEnabled(false);
             jComboBox_month.setEnabled(false);
             jComboBox_year.setEnabled(false);
             jComboBox_custome_name.setEnabled(false);
             jTextField1_bill_id.setEnabled(true);            
             jCheckBox_range_date.setEnabled(true);
               jComboBox_date_2.setEnabled(false);
             jComboBox_month_2.setEnabled(false);
             jComboBox_year_2.setEnabled(false);
             jCheckBox_range_date.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton1_bill_idActionPerformed

    private void jTextField1_bill_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1_bill_idFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_bill_idFocusLost

    private void jTextField1_bill_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1_bill_idFocusGained
        jTextField1_bill_id.setBackground(null);
    }//GEN-LAST:event_jTextField1_bill_idFocusGained

    private void jTextField1_bill_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_bill_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_bill_idActionPerformed

    private void jCheckBox_range_dateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox_range_dateItemStateChanged
        if(jCheckBox_range_date.isSelected())
        {
        jComboBox_date_2.setEnabled(true);
             jComboBox_month_2.setEnabled(true);
             jComboBox_year_2.setEnabled(true);
        }
        if(jCheckBox_range_date.isSelected() == false)
                {
              jComboBox_date_2.setEnabled(false);
             jComboBox_month_2.setEnabled(false);
             jComboBox_year_2.setEnabled(false); 
                }
    }//GEN-LAST:event_jCheckBox_range_dateItemStateChanged

    private void jTextField1_bill_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_bill_idKeyPressed
int key = evt.getKeyCode();
        if((key >= evt.VK_0&&key<=evt.VK_9) || (key>=evt.VK_NUMPAD0 && key<= evt.VK_NUMPAD9) || key==KeyEvent.VK_BACKSPACE)
        {
             jTextField1_bill_id.setEditable(true);
          jTextField1_bill_id.setBackground(Color.yellow);
            jLabel_status.setText("");
        }
        else
        {
           jTextField1_bill_id.setEditable(false);
             jTextField1_bill_id.setBackground(Color.RED);
             jLabel_status.setForeground(Color.red);
             jLabel_status.setText("Please Enter Only Numeric Value");
        }              // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_bill_idKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1_search;
    private javax.swing.JCheckBox jCheckBox_range_date;
    private javax.swing.JComboBox jComboBox1_product_name;
    private javax.swing.JComboBox jComboBox_custome_name;
    private javax.swing.JComboBox jComboBox_date;
    private javax.swing.JComboBox jComboBox_date_2;
    private javax.swing.JComboBox jComboBox_month;
    private javax.swing.JComboBox jComboBox_month_2;
    private javax.swing.JComboBox jComboBox_year;
    private javax.swing.JComboBox jComboBox_year_2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_status;
    private javax.swing.JRadioButton jRadioButton1_bill_id;
    public static javax.swing.JRadioButton jRadioButton_customer;
    public static javax.swing.JRadioButton jRadioButton_date;
    public static javax.swing.JRadioButton jRadioButton_product;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1_bill_id;
    // End of variables declaration//GEN-END:variables
}
