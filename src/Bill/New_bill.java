package Bill;

import Data_base_Conection.DataBase_connection;
import Customer.Account_bal;
import Customer.Update_account;
import Login.Main_page;
import static Login.Main_page.con;
import static Login.Main_page.jDesktopPane2;
import Products.Product_bal;
import com.sun.glass.events.KeyEvent;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyleConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shahyar
 */
public class New_bill extends javax.swing.JInternalFrame {

    /**
     * Creates new form New_bill
     */
     DefaultComboBoxModel product_list;
     DefaultComboBoxModel Customer_list;
      DefaultTableModel model;
    public New_bill() throws SQLException, PropertyVetoException {
       
        initComponents();
        
        product_list();
        show_produc_info_show();
        Customer_list();
        show_Customer_info_show();
        jTextFieldProduct_qnt_show.setEnabled(false);
        jTextField_customer_name_show.setEnabled(false);
        jTextField_total_product_amount.setEnabled(false);
        jTextField_product_name_show.setEnabled(false);
        jTextField1_product_rate_show.setEnabled(false);
        jTextField_customer_blnc_show.setEnabled(false);
        jButton_generate_bill.setEnabled(false);
        jButton_clear.setEnabled(false);
        jButton_remove_row.setEnabled(false);
        jButton1_print_and_save_bill.setEnabled(false);
        //jLabel_product_name_show.setText("");
        //jLabel_product_qnt_show.setText("0");
        //jLabel_product_rate_show.setText("0");
        //jLabel_total_show.setText("0");
        //jLabel_customer_name_shpw.setText("");
        //jLabel_customer_balance_show.setText("0");
        //jLabel_total_bill_amount_show.setText("0");
        //jTextField_puchase_quantity.setText("0");
       // jTextField_puchase_quantity.setEnabled(false);
        
        // date And Time
        Date date = new Date();
        SimpleDateFormat dateformat11 =new SimpleDateFormat("dd-MMM-yyyy");
        jLabel_date_show.setText(dateformat11.format(date));
        Date time = new Date(); 
        SimpleDateFormat timeformat11 =new SimpleDateFormat("hh:mm:ss");
        jLabel_time_show.setText(timeformat11.format(time));
        
        // bill id
//       long Bill_ID = gerate_bill_id();
//       
//       boolean status = false;
//       
//      New_bill_bal bill = new New_bill_bal();
//      
//      while(status = false)
//      {
//          Bill_ID = gerate_bill_id();
//      
//          //status = false;                                             
//       status = bill.check_bill_id(Bill_ID);        
//      }
        int Bill_ID;
        New_bill_bal ob = new New_bill_bal();
        Bill_ID = ob.getNewBillId();
      jLabel_bill_id_show.setText(String.valueOf(Bill_ID+1));
  }
    
    /**
     *
     * @return
     */
//      
//    public long gerate_bill_id()
//    {
//        long bill_id;      
//        Random rand = new Random(); 
//         bill_id= 2000000+ rand.nextInt(8000000);       
//        return bill_id;
//    }
    
    
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
            
            jComboBox_product.setModel(product_list);
             jTextField_product_name_show.setText((String) jComboBox_product.getSelectedItem());
    }
    
    
    
    
    
    public void show_produc_info_show()
    {
        New_bill_bal ob  = new New_bill_bal();
        String s; 
        int Product_rate= 0;
        int product_qnt = 0 ;
        int product_total_amnt =0 ;
        // name
        s = (String) jComboBox_product.getSelectedItem();
        jTextField_product_name_show.setText(s);
        
        // rate
        
         try {
            Product_rate = ob.getProductRate(s);
         } catch (SQLException ex) {
             Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
         }         
         jTextField1_product_rate_show.setText(String.valueOf(Product_rate));
        
        //for quantity
        try {
            product_qnt = ob.getProductQuntity(s);
         } catch (SQLException ex) {
             Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
         }    
        jTextFieldProduct_qnt_show.setText(String.valueOf(product_qnt));
         // for total
        try {
            product_total_amnt = ob.getProductTotalAmt(s);
         } catch (SQLException ex) {
             Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
         }    
        jTextField_total_product_amount.setText(String.valueOf(product_total_amnt));
        
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
            
            jComboBox_customer.setModel(Customer_list);
             jTextField_customer_name_show.setText((String) jComboBox_customer.getSelectedItem()); 
    }
    
    
    
    
    
     public void show_Customer_info_show()
    {
        New_bill_bal ob  = new New_bill_bal();
        String s; 
        int Customer_balance= 0;
       
        // name
        s = (String) jComboBox_customer.getSelectedItem();
        jTextField_customer_name_show.setText(s);
        
        // balance
        
         try {
            Customer_balance = ob.getcustomer_balance(s);
         } catch (SQLException ex) {
             Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
         }         
        jTextField_customer_blnc_show.setText(String.valueOf(Customer_balance));
        
    
    }
     
     
     
     
     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_1 = new javax.swing.JButton();
        jButton_2 = new javax.swing.JButton();
        jButton_3 = new javax.swing.JButton();
        jButton_6 = new javax.swing.JButton();
        jButton_5 = new javax.swing.JButton();
        jButton_4 = new javax.swing.JButton();
        jButton_7 = new javax.swing.JButton();
        jButton_8 = new javax.swing.JButton();
        jButton_9 = new javax.swing.JButton();
        jButton1_customer_search = new javax.swing.JButton();
        jLabel_purchase_qnt = new javax.swing.JLabel();
        jLabel1_customer_balance = new javax.swing.JLabel();
        jLabel_customer_name = new javax.swing.JLabel();
        jLabel_Select_customer = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1_customer_id = new javax.swing.JTextField();
        jComboBox_customer = new javax.swing.JComboBox();
        jTextField_customer_name_show = new javax.swing.JTextField();
        jTextField_customer_blnc_show = new javax.swing.JTextField();
        jTextField_puchase_quantity = new javax.swing.JTextField();
        jButton_remove_row = new javax.swing.JButton();
        jButton1_add_product = new javax.swing.JButton();
        jButton1_search_po_id = new javax.swing.JButton();
        jTextField_total_product_amount = new javax.swing.JTextField();
        jTextFieldProduct_qnt_show = new javax.swing.JTextField();
        jTextField1_product_rate_show = new javax.swing.JTextField();
        jTextField_product_name_show = new javax.swing.JTextField();
        jComboBox_product = new javax.swing.JComboBox();
        jTextField1_product_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel_select_product = new javax.swing.JLabel();
        jLabel_product_name = new javax.swing.JLabel();
        jLabel_product_rate2 = new javax.swing.JLabel();
        jLabel_product_qnt1 = new javax.swing.JLabel();
        jLabel_total = new javax.swing.JLabel();
        jLabel_time_show = new javax.swing.JLabel();
        jLabel_date_show = new javax.swing.JLabel();
        jLabel_time = new javax.swing.JLabel();
        jLabel_date = new javax.swing.JLabel();
        jLabel_bill_id_show = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1_close = new javax.swing.JButton();
        jButton_generate_bill = new javax.swing.JButton();
        jButton_clear = new javax.swing.JButton();
        jLabel_status = new javax.swing.JLabel();
        jLabel_total_bill_amount = new javax.swing.JLabel();
        jLabel_total_bill_amount_show = new javax.swing.JLabel();
        jLabel_massage_balance = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1_print_and_save_bill = new javax.swing.JButton();
        jLabel4_back_g = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setIconifiable(true);
        setTitle("New Bill");
        setToolTipText("Generate New Bill");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_1.setBackground(new java.awt.Color(153, 204, 255));
        jButton_1.setText("1");
        jButton_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, 65, 65));

        jButton_2.setBackground(new java.awt.Color(153, 204, 255));
        jButton_2.setText("2");
        jButton_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, 65, 65));

        jButton_3.setBackground(new java.awt.Color(153, 204, 255));
        jButton_3.setText("3");
        jButton_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 80, 65, 65));

        jButton_6.setBackground(new java.awt.Color(153, 204, 255));
        jButton_6.setText("6");
        jButton_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 150, 65, 65));

        jButton_5.setBackground(new java.awt.Color(153, 204, 255));
        jButton_5.setText("5");
        jButton_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 150, 65, 65));

        jButton_4.setBackground(new java.awt.Color(153, 204, 255));
        jButton_4.setText("4");
        jButton_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, 65, 65));

        jButton_7.setBackground(new java.awt.Color(153, 204, 255));
        jButton_7.setText("7");
        jButton_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 220, 65, 65));

        jButton_8.setBackground(new java.awt.Color(153, 204, 255));
        jButton_8.setText("8");
        jButton_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 220, 65, 65));

        jButton_9.setBackground(new java.awt.Color(153, 204, 255));
        jButton_9.setText("9");
        jButton_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 220, 65, 65));

        jButton1_customer_search.setBackground(new java.awt.Color(102, 153, 0));
        jButton1_customer_search.setText("Search Customer ");
        jButton1_customer_search.setAutoscrolls(true);
        jButton1_customer_search.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jButton1_customer_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_customer_searchActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_customer_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 273, 133, 37));

        jLabel_purchase_qnt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_purchase_qnt.setForeground(new java.awt.Color(0, 51, 153));
        jLabel_purchase_qnt.setText("Purchase Quantity");
        getContentPane().add(jLabel_purchase_qnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 236, 112, 13));

        jLabel1_customer_balance.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1_customer_balance.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1_customer_balance.setText("Customer Balance");
        getContentPane().add(jLabel1_customer_balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 133, -1));

        jLabel_customer_name.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_customer_name.setForeground(new java.awt.Color(0, 51, 153));
        jLabel_customer_name.setText("Customer Name");
        getContentPane().add(jLabel_customer_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 160, 133, -1));

        jLabel_Select_customer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_Select_customer.setForeground(new java.awt.Color(0, 51, 153));
        jLabel_Select_customer.setText("Select Customer");
        getContentPane().add(jLabel_Select_customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 114, 114, 21));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 153));
        jLabel3.setText("Enter Customer Id");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 80, -1, -1));

        jTextField1_customer_id.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        jTextField1_customer_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1_customer_idFocusGained(evt);
            }
        });
        jTextField1_customer_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_customer_idKeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1_customer_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 200, 26));

        jComboBox_customer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_customer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        jComboBox_customer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_customerItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox_customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 200, 26));

        jTextField_customer_name_show.setText("jTextField1");
        jTextField_customer_name_show.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        jTextField_customer_name_show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_customer_name_showActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_customer_name_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 200, 26));

        jTextField_customer_blnc_show.setText("jTextField1");
        jTextField_customer_blnc_show.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        getContentPane().add(jTextField_customer_blnc_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, 200, 26));

        jTextField_puchase_quantity.setText("0");
        jTextField_puchase_quantity.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        jTextField_puchase_quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_puchase_quantityFocusGained(evt);
            }
        });
        jTextField_puchase_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_puchase_quantityActionPerformed(evt);
            }
        });
        jTextField_puchase_quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_puchase_quantityKeyPressed(evt);
            }
        });
        getContentPane().add(jTextField_puchase_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 200, 26));

        jButton_remove_row.setBackground(new java.awt.Color(234, 9, 9));
        jButton_remove_row.setText("Remove Row");
        jButton_remove_row.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_remove_rowActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_remove_row, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 312, 110, 38));

        jButton1_add_product.setBackground(new java.awt.Color(51, 51, 255));
        jButton1_add_product.setText("ADD Products");
        jButton1_add_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_add_productActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_add_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 312, -1, 38));

        jButton1_search_po_id.setBackground(new java.awt.Color(102, 153, 0));
        jButton1_search_po_id.setText("Search By ID");
        jButton1_search_po_id.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1_search_po_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_search_po_idActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_search_po_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 90, 40));

        jTextField_total_product_amount.setText("jTextField1");
        jTextField_total_product_amount.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        jTextField_total_product_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_total_product_amountActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_total_product_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 200, 26));

        jTextFieldProduct_qnt_show.setText("jTextField1");
        jTextFieldProduct_qnt_show.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        getContentPane().add(jTextFieldProduct_qnt_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 200, 26));

        jTextField1_product_rate_show.setText("jTextField1");
        jTextField1_product_rate_show.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        getContentPane().add(jTextField1_product_rate_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 200, 26));

        jTextField_product_name_show.setText("jTextField1");
        jTextField_product_name_show.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        getContentPane().add(jTextField_product_name_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 200, 26));

        jComboBox_product.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        jComboBox_product.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_productItemStateChanged(evt);
            }
        });
        jComboBox_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_productActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 200, 26));

        jTextField1_product_id.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        jTextField1_product_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1_product_idFocusGained(evt);
            }
        });
        jTextField1_product_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1_product_idActionPerformed(evt);
            }
        });
        jTextField1_product_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_product_idKeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1_product_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 200, 26));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Enter Product ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 117, -1));

        jLabel_select_product.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_select_product.setForeground(new java.awt.Color(0, 51, 153));
        jLabel_select_product.setText("Select Product");
        getContentPane().add(jLabel_select_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 117, -1));

        jLabel_product_name.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_product_name.setForeground(new java.awt.Color(0, 51, 153));
        jLabel_product_name.setText("Product Name");
        jLabel_product_name.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jLabel_product_namePropertyChange(evt);
            }
        });
        getContentPane().add(jLabel_product_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 117, -1));

        jLabel_product_rate2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_product_rate2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel_product_rate2.setText("Product Rate");
        jLabel_product_rate2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jLabel_product_rate2PropertyChange(evt);
            }
        });
        getContentPane().add(jLabel_product_rate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 117, -1));

        jLabel_product_qnt1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_product_qnt1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel_product_qnt1.setText("Product Quantity");
        jLabel_product_qnt1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jLabel_product_qnt1PropertyChange(evt);
            }
        });
        getContentPane().add(jLabel_product_qnt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 98, -1));

        jLabel_total.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_total.setForeground(new java.awt.Color(0, 51, 153));
        jLabel_total.setText("Total Product Amont");
        getContentPane().add(jLabel_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jLabel_time_show.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_time_show.setText("jLabel2");
        getContentPane().add(jLabel_time_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 31, 105, -1));

        jLabel_date_show.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_date_show.setText("jLabel2");
        getContentPane().add(jLabel_date_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 11, 115, -1));

        jLabel_time.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_time.setText("Time");
        getContentPane().add(jLabel_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 31, 45, -1));

        jLabel_date.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_date.setText("Date");
        getContentPane().add(jLabel_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 11, 47, -1));

        jLabel_bill_id_show.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_bill_id_show.setText("jLabel2");
        getContentPane().add(jLabel_bill_id_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(884, 11, 146, -1));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel1.setText("Bill ID :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(778, 13, 88, -1));

        jButton1_close.setBackground(new java.awt.Color(234, 9, 9));
        jButton1_close.setText("Close");
        jButton1_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_closeActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 600, 90, -1));

        jButton_generate_bill.setBackground(new java.awt.Color(51, 51, 255));
        jButton_generate_bill.setText("Save & New Bill");
        jButton_generate_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_generate_billActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_generate_bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 210, 35));

        jButton_clear.setText("Clear");
        jButton_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_clearActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 105, -1));
        getContentPane().add(jLabel_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 623, 308, 16));

        jLabel_total_bill_amount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_total_bill_amount.setText("Total Bill Amount :");
        getContentPane().add(jLabel_total_bill_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 580, 176, 49));

        jLabel_total_bill_amount_show.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_total_bill_amount_show.setText("0");
        getContentPane().add(jLabel_total_bill_amount_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 580, 116, 49));
        getContentPane().add(jLabel_massage_balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 600, 123, 14));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Rate", "Quantity", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 368, 1000, 172));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 74, 20, 276));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 74, 20, 276));

        jButton1_print_and_save_bill.setBackground(new java.awt.Color(51, 51, 255));
        jButton1_print_and_save_bill.setText("Print And Save Bill");
        jButton1_print_and_save_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_print_and_save_billActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_print_and_save_bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 560, 150, 70));

        jLabel4_back_g.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bill/new_Bill.png"))); // NOI18N
        jLabel4_back_g.setText("jLabel4");
        jLabel4_back_g.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        getContentPane().add(jLabel4_back_g, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_generate_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_generate_billActionPerformed
     int Bill_id =Integer.parseInt(jLabel_bill_id_show.getText());
      String Date  = jLabel_date_show.getText();
      String Time = jLabel_time_show.getText();
      
       
       // jLabel_message_quantity.setText("");
        New_bill_bal ob = new New_bill_bal();
        String prodct_name = (String)jComboBox_product.getSelectedItem();
        String Customer_name = (String)jTextField_customer_name_show.getText();
        
        
      
                 
                int Bill_amount = Integer.parseInt(jLabel_total_bill_amount_show.getText());

 
                 
                 // store bill  informatipon  ni bill_amount databse table
                 New_bill_bal bill_amnt = new New_bill_bal();
         try {
             bill_amnt.Sent_BillAmount_in_Amount_bill(Bill_id, Customer_name, Bill_amount );
         } catch (SQLException ex) {
             Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
         }
                 

                 // update customer  balnce after bill
                 int remaining_cus_bln;
                 remaining_cus_bln = Integer.parseInt(jTextField_customer_blnc_show.getText());
                 Account_bal update_bln = new Account_bal();
         try {
             update_bln.update_customer_balnce(Customer_name, remaining_cus_bln);
         } catch (SQLException ex) {
             Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
         }

                 // store from table to database
                 for (int i =0 ; i < jTable2.getRowCount(); i++)
                 {
                 String  Table_product_name = (String)jTable2.getValueAt(i, 1);
                  int table_product_rate = (int)jTable2.getValueAt(i, 2);
                 int table_product_qnt = (int)jTable2.getValueAt(i, 3);
                
                 int table_product_amount1 = (int)jTable2.getValueAt(i, 4);               
         try {
             bill_amnt.Sent_Data_in_Product_bill(Bill_id, Date, Time, Table_product_name, table_product_qnt, table_product_rate, table_product_amount1);
         } catch (SQLException ex) {
             Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
         }
                 
                 }
                 
    
       this.setVisible(false);
       
         try {
             
            // open new bill
             New_bill  next_bill  = new New_bill();
             Main_page.jDesktopPane2.add(next_bill);
              Dimension pareentSize = jDesktopPane2.getSize();
             Dimension childSize = next_bill.getSize();
             next_bill.setLocation((pareentSize.width - childSize.width)/2, (pareentSize.height - childSize.height)/2);
             next_bill.setVisible(true);
         }   catch (SQLException ex) {
             Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
         } catch (PropertyVetoException ex) {
             Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
         }
       
       
    }//GEN-LAST:event_jButton_generate_billActionPerformed

    private void jLabel_product_namePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabel_product_namePropertyChange
        
          
    }//GEN-LAST:event_jLabel_product_namePropertyChange

    private void jComboBox_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_productActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_productActionPerformed

    private void jComboBox_productItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_productItemStateChanged
      //  product_list();
        show_produc_info_show();
       
        
        
    }//GEN-LAST:event_jComboBox_productItemStateChanged

    private void jLabel_product_rate2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabel_product_rate2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_product_rate2PropertyChange

    private void jLabel_product_qnt1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabel_product_qnt1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_product_qnt1PropertyChange

    private void jComboBox_customerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_customerItemStateChanged
        
       show_Customer_info_show();
       
       
    }//GEN-LAST:event_jComboBox_customerItemStateChanged

    private void jButton_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_clearActionPerformed
//        jTextField_product_name_show.setText("");
//        jTextFieldProduct_qnt_show.setText("0");
//        jTextField1_product_rate_show.setText("0");
//        jTextField_total_product_amount.setText("0");
//        jTextField_customer_name_show.setText("");
//        jTextField_customer_blnc_show.setText("0");
//        jLabel_total_bill_amount_show.setText("0");
//        jTextField_puchase_quantity.setText("0");
        DefaultTableModel model_2 =  (DefaultTableModel)jTable2.getModel() ;
        
        while(model_2.getRowCount() >0)
        {
//        if(jTable2.getRowCount() > 0)
//        {
            
            for(int i = 0 ; i < model_2.getRowCount(); i++ )
            {
                     // for customer bln update
        int customer_bln = Integer.parseInt(jTextField_customer_blnc_show.getText());
        String t = String.valueOf(jTable2.getValueAt(i, 4));
        int table_customer_bln = Integer.parseInt(t);
        int total_bln = customer_bln + table_customer_bln; 
        jTextField_customer_blnc_show.setText(String.valueOf(total_bln));
          
        // for qunatiy update 
        int qunatity_add = Integer.parseInt(String.valueOf(jTable2.getValueAt(i, 3)));
        String porduct_name = (String)jTable2.getValueAt(i, 1);
        
        New_bill_bal  update_qnt = new  New_bill_bal();
            try {
                update_qnt.update_qnt_when_remove(porduct_name, qunatity_add);
            } catch (SQLException ex) {
                Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
            }
        model.removeRow(i);                    
       show_produc_info_show();
     // String amount = String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 3));
      //int int_amnt = Integer.parseInt(amount);
      int total_bill =  Integer.parseInt(jLabel_total_bill_amount_show.getText());
      int final_amount_bill = total_bill - table_customer_bln;
      jLabel_total_bill_amount_show.setText(String.valueOf(final_amount_bill));
            }
            
             if(model.getRowCount() == 0)
        {
            jButton_remove_row.setEnabled(false);
            jButton_clear.setEnabled(false);
            jButton_generate_bill.setEnabled(false);
            jComboBox_customer.setEnabled(true);
            jTextField1_customer_id.setEnabled(true);
            jButton1_print_and_save_bill.setEnabled(false);
        }
      //  }
        }// while
        
        
    }//GEN-LAST:event_jButton_clearActionPerformed

    private void jTextField_puchase_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_puchase_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_puchase_quantityActionPerformed

    private void jTextField_puchase_quantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_puchase_quantityKeyPressed
jLabel_massage_balance.setText("");
//jLabel_message_quantity.setText("");
        int key = evt.getKeyCode();
        
        if((key >= evt.VK_0&&key<=evt.VK_9) || (key>=evt.VK_NUMPAD0 && key<= evt.VK_NUMPAD9) || key==KeyEvent.VK_BACKSPACE)
        {
            jTextField_puchase_quantity.setEditable(true);
            jTextField_puchase_quantity.setBackground(Color.yellow);
            jLabel_status.setText("");
        }
        else
        {
           jTextField_puchase_quantity.setEditable(false);
            jTextField_puchase_quantity.setBackground(Color.RED);
            jLabel_status.setForeground(Color.red);
        jLabel_status.setText("Please Enter Only Numeric Value");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_puchase_quantityKeyPressed

    private void jButton1_add_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_add_productActionPerformed
        
        // purchase feild id empty
        String a  = (String)jTextField_puchase_quantity.getText();
       if(a.equalsIgnoreCase("") || a.equalsIgnoreCase("0"))
       {
       jTextField_puchase_quantity.setBackground(Color.red);
      // jLabel_massage_balance.setText("Enter some Quantity");
       JOptionPane.showMessageDialog(this, "Please Enter Some Product Quantity First", "New Bill", 2);
            
       //jTextField_product_name_show.setText("0");
       }
       else
       {        
           
      model =(DefaultTableModel) jTable2.getModel();
      int count = 0;
      int qnt = Integer.parseInt(jTextField_puchase_quantity.getText());
      int rate = Integer.parseInt(jTextField1_product_rate_show.getText());
      int amnt =qnt *rate;
      int cus_bln = Integer.parseInt(jTextField_customer_blnc_show.getText());
      
       if(Integer.parseInt(jTextField_puchase_quantity.getText()) <= Integer.parseInt(jTextFieldProduct_qnt_show.getText()) && amnt <= cus_bln)
               {
       
       
       if(jTable2.getRowCount() > 0)
       {
             
        for(int j = 0 ; j < jTable2.getRowCount() ;j++)
        {
            //String  Table_product_name= (String)jTable2.getValueAt(j, 0);
            String Prpduct_name = (String)jTextField_product_name_show.getText();
           
            int table_product_id = (int)jTable2.getValueAt(j, 0);
            
            Product_bal ob = new Product_bal();
            int id =0;
            try {
                 id = ob.get_single_product_id(Prpduct_name);
            } catch (SQLException ex) {
                Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(id == table_product_id)
            {
              int Quantity = Integer.parseInt(jTextField_puchase_quantity.getText());
              int existance_Quantity = (Integer)jTable2.getValueAt(j, 3);
              int total_quantity =Quantity + existance_Quantity;              
              int amount =Integer.parseInt(jTextField_puchase_quantity.getText()) * Integer.parseInt(jTextField1_product_rate_show.getText());
              int existance_amount = (Integer)jTable2.getValueAt(j, 4);
              int total_Sum_amount = amount + existance_amount;       
                      
               model.setValueAt(total_quantity, j, 3);       
              model.setValueAt(total_Sum_amount, j, 4);
              
              count =1;
              
//              //// product qunatity change on bill when row added 
//              int whole_qnt = Integer.parseInt(jTextFieldProduct_qnt_show.getText());
//              int added_qnt = Integer.parseInt(jTextField_puchase_quantity.getText());
//              int remaining_qunatiyt = whole_qnt - added_qnt;
//              jTextFieldProduct_qnt_show.setText((String.valueOf(remaining_qunatiyt)));
              
              // product amount change on bill when row added
              int whole_qnt = Integer.parseInt(jTextFieldProduct_qnt_show.getText());
              int added_qnt = Integer.parseInt(jTextField_puchase_quantity.getText());
              int remaining_qunatiyt = whole_qnt - added_qnt;
              int po_rate = Integer.parseInt(jTextField1_product_rate_show.getText());
              int po_amnt = po_rate * remaining_qunatiyt;
              jTextField_total_product_amount.setText(String.valueOf(po_amnt));
              
               /// for customer blnc update show on bill when row added
              int whole_customer_balnce = Integer.parseInt(jTextField_customer_blnc_show.getText());
               int Rate_for_customer_bln_change = Integer.parseInt(jTextField1_product_rate_show.getText());
                    int quantity_for_customer_bln_change =Integer.parseInt(jTextField_puchase_quantity.getText());
                    int amount_for_customer_bln_change = Rate_for_customer_bln_change *quantity_for_customer_bln_change;
                    int remaini_bln = whole_customer_balnce - amount_for_customer_bln_change;
                     jTextField_customer_blnc_show.setText(String.valueOf(remaini_bln));
                     
                 //// update product qnt in database
                    String  po_name = (String)jTextField_product_name_show.getText();
                    int updated_qnt = Integer.parseInt(jTextFieldProduct_qnt_show.getText()) - Integer.parseInt(jTextField_puchase_quantity.getText());
                    New_bill_bal update_qnt = new New_bill_bal();
                try {
                    update_qnt.update_product_qnt(po_name, updated_qnt);
                    jTextFieldProduct_qnt_show.setText((String.valueOf(updated_qnt)));
                } catch (SQLException ex) {
                    Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
                    //jLabel_massage_balance.setText("Enter some Value");
                    
                }
                     
                  
              
            }// inner if
        }//forloop
       }//outer if
         else
         {
             Product_bal  for_id  = new Product_bal();
             int product_id =0;
           try {
             product_id =   for_id.get_single_product_id((String.valueOf(jTextField_product_name_show.getText())));
           } catch (SQLException ex) {
               Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
           }
                  int Rate = Integer.parseInt(jTextField1_product_rate_show.getText());
                  int quantity =Integer.parseInt(jTextField_puchase_quantity.getText());
                  int amount = Rate *quantity;     
                  model.addRow(new Object[] {product_id,jTextField_product_name_show.getText(), Rate ,quantity , amount}); 
                 jComboBox_customer.setEnabled(false);
                 jTextField1_customer_id.setEnabled(false);
                  jButton_generate_bill.setEnabled(true);
                  jButton_clear.setEnabled(true);
                jButton_remove_row.setEnabled(true);
                jButton1_print_and_save_bill.setEnabled(true);
                  //// product qunatity change on bill when row added 
   
               int whole_qnt = Integer.parseInt(jTextFieldProduct_qnt_show.getText());
               int added_qnt = Integer.parseInt(jTextField_puchase_quantity.getText());
               int remaining_qunatiyt = whole_qnt -added_qnt;
//              jTextFieldProduct_qnt_show.setText((String.valueOf(remaining_qunatiyt)));
              
              //// product Amunt change on bill when row added 
              int po_rate = Integer.parseInt(jTextField1_product_rate_show.getText());
              int po_amnt = po_rate * remaining_qunatiyt;
              jTextField_total_product_amount.setText(String.valueOf(po_amnt));
              
               /// for customer blnc update show on bill
                 int whole_customer_balnce = Integer.parseInt(jTextField_customer_blnc_show.getText());
                 int Rate_for_customer_bln_change = Integer.parseInt(jTextField1_product_rate_show.getText());
                 int quantity_for_customer_bln_change =Integer.parseInt(jTextField_puchase_quantity.getText());
                 int amount_for_customer_bln_change = Rate_for_customer_bln_change *quantity_for_customer_bln_change;
                    int remaini_bln = whole_customer_balnce - amount_for_customer_bln_change;
                    jTextField_customer_blnc_show.setText(String.valueOf(remaini_bln));
                    
                     //// update product qnt in database
                    String  po_name = (String)jTextField_product_name_show.getText();
                    int updated_qnt = Integer.parseInt(jTextFieldProduct_qnt_show.getText()) - Integer.parseInt(jTextField_puchase_quantity.getText());
                    New_bill_bal update_qnt = new New_bill_bal();
                try {
                    update_qnt.update_product_qnt(po_name, updated_qnt);
                    jTextFieldProduct_qnt_show.setText((String.valueOf(updated_qnt)));
                } catch (SQLException ex) {
                    Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
                }
                     
                                    
                  count =1;
         }
         
         // for first row
         if(count != 1)
            {
                Product_bal  for_id  = new Product_bal();
             int product_id =0;
           try {
             product_id =   for_id.get_single_product_id((String.valueOf(jTextField_product_name_show.getText())));
           } catch (SQLException ex) {
               Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
                 int Rate = Integer.parseInt(jTextField1_product_rate_show.getText());
                 int quantity =Integer.parseInt(jTextField_puchase_quantity.getText());
                 int amount = Rate *quantity;     
                 model.addRow(new Object[] {product_id,jTextField_product_name_show.getText(), Rate ,quantity , amount});
                 jComboBox_customer.setEnabled(false);
                 jButton_generate_bill.setEnabled(true);
                 jTextField1_customer_id.setEnabled(false);
                  jButton_clear.setEnabled(true);
                jButton_remove_row.setEnabled(true);
                jButton1_print_and_save_bill.setEnabled(true);
                  //// product Amunt change on bill when row added 
              int whole_qnt = Integer.parseInt(jTextFieldProduct_qnt_show.getText());
              int added_qnt = Integer.parseInt(jTextField_puchase_quantity.getText());
              int remaining_qunatiyt = whole_qnt -added_qnt;
           //   jTextFieldProduct_qnt_show.setText((String.valueOf(remaining_qunatiyt)));
              
               //// product Amunt change on bill when row added 
              
              int po_rate = Integer.parseInt(jTextField1_product_rate_show.getText());
              int po_amnt = po_rate * remaining_qunatiyt;
              jTextField_total_product_amount.setText(String.valueOf(po_amnt));
              
              
              /// for customer blnc update show on bill
              int whole_customer_balnce = Integer.parseInt(jTextField_customer_blnc_show.getText());
               int Rate_for_customer_bln_change = Integer.parseInt(jTextField1_product_rate_show.getText());
                 int quantity_for_customer_bln_change =Integer.parseInt(jTextField_puchase_quantity.getText());
       int amount_for_customer_bln_change = Rate_for_customer_bln_change *quantity_for_customer_bln_change;
       int remaini_bln = whole_customer_balnce - amount_for_customer_bln_change;
       jTextField_customer_blnc_show.setText(String.valueOf(remaini_bln));
       
        //// update product qnt in database
                    String  po_name = (String)jTextField_product_name_show.getText();
                    int updated_qnt = Integer.parseInt(jTextFieldProduct_qnt_show.getText()) - Integer.parseInt(jTextField_puchase_quantity.getText());
                    New_bill_bal update_qnt = new New_bill_bal();
                try {
                    update_qnt.update_product_qnt(po_name, updated_qnt);
                    jTextFieldProduct_qnt_show.setText((String.valueOf(updated_qnt)));
                } catch (SQLException ex) {
                    Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
                }
                     
                
              
                  count =1;
            }
                      
               }
       else{
           //jLabel_status.setText("Quanityt is unavalible");
           JOptionPane.showMessageDialog(this, "ERROR.!! Purchase Quantity OR Customer Balance is NOT Available.", "New Bill", 2);
            
       }
       
        int total_bill_amount = 0;
       for(int k = 0 ; k <  jTable2.getRowCount() ; k++)
       {
            
           total_bill_amount += (Integer)jTable2.getValueAt(k, 4);
       }
       // customer_balnce  add;
       jLabel_total_bill_amount_show.setText(String.valueOf(total_bill_amount));
       int whole_customer_balnce = Integer.parseInt(jTextField_customer_blnc_show.getText());
       }
       
      // }
    }//GEN-LAST:event_jButton1_add_productActionPerformed

    private void jTextField_customer_name_showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_customer_name_showActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_customer_name_showActionPerformed

    private void jButton_remove_rowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_remove_rowActionPerformed
        
        if(jTable2.getSelectedRow()>=0 ){
            
            // for customer bln update
        int customer_bln = Integer.parseInt(jTextField_customer_blnc_show.getText());
        String t = String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 4));
        int table_customer_bln = Integer.parseInt(t);
        int total_bln = customer_bln + table_customer_bln; 
        jTextField_customer_blnc_show.setText(String.valueOf(total_bln));
          
        // for qunatiy update 
        int qunatity_add = Integer.parseInt(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 3)));
        String porduct_name = (String)jTable2.getValueAt(jTable2.getSelectedRow(), 1);
        
        New_bill_bal  update_qnt = new  New_bill_bal();
            try {
                update_qnt.update_qnt_when_remove(porduct_name, qunatity_add);
            } catch (SQLException ex) {
                Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
            }
        model.removeRow(jTable2.getSelectedRow());                    
       show_produc_info_show();
     // String amount = String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 3));
      //int int_amnt = Integer.parseInt(amount);
      int total_bill =  Integer.parseInt(jLabel_total_bill_amount_show.getText());
      int final_amount_bill = total_bill - table_customer_bln;
      jLabel_total_bill_amount_show.setText(String.valueOf(final_amount_bill));
      
        }
        
        if(model.getRowCount() == 0)
        {
            jButton_remove_row.setEnabled(false);
            jButton_clear.setEnabled(false);
            jButton_generate_bill.setEnabled(false);
            jComboBox_customer.setEnabled(true);
            jTextField1_customer_id.setEnabled(true);
            jButton1_print_and_save_bill.setEnabled(false);
        }
        
    }//GEN-LAST:event_jButton_remove_rowActionPerformed

    private void jButton1_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_closeActionPerformed
       DefaultTableModel model_2 =  (DefaultTableModel)jTable2.getModel() ;
        
        while(model_2.getRowCount() >0)
        {
//        if(jTable2.getRowCount() > 0)
//        {
            
            for(int i = 0 ; i < model_2.getRowCount(); i++ )
            {
                     // for customer bln update
        int customer_bln = Integer.parseInt(jTextField_customer_blnc_show.getText());
        String t = String.valueOf(jTable2.getValueAt(i, 4));
        int table_customer_bln = Integer.parseInt(t);
        int total_bln = customer_bln + table_customer_bln; 
        jTextField_customer_blnc_show.setText(String.valueOf(total_bln));
          
        // for qunatiy update 
        int qunatity_add = Integer.parseInt(String.valueOf(jTable2.getValueAt(i, 3)));
        String porduct_name = (String)jTable2.getValueAt(i, 1);
        
        New_bill_bal  update_qnt = new  New_bill_bal();
            try {
                update_qnt.update_qnt_when_remove(porduct_name, qunatity_add);
            } catch (SQLException ex) {
                Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
            }
        model.removeRow(i);                    
       show_produc_info_show();
     // String amount = String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 3));
      //int int_amnt = Integer.parseInt(amount);
      int total_bill =  Integer.parseInt(jLabel_total_bill_amount_show.getText());
      int final_amount_bill = total_bill - table_customer_bln;
      jLabel_total_bill_amount_show.setText(String.valueOf(final_amount_bill));
            }
      //  }
        }// while
        this.setVisible(false);
    }//GEN-LAST:event_jButton1_closeActionPerformed

    private void jButton_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_6ActionPerformed
        jTextField_puchase_quantity.setBackground(Color.WHITE);
        String check =jTextField_puchase_quantity.getText();
      if(check.equalsIgnoreCase(""))
      {        
      jTextField_puchase_quantity.setText("0");
      int quntity_num = Integer.parseInt(jTextField_puchase_quantity.getText());
      quntity_num = quntity_num +6;            
      jTextField_puchase_quantity.setText(String.valueOf(quntity_num));
      } 
      else
      {
      int quntity_num = Integer.parseInt(jTextField_puchase_quantity.getText());
      quntity_num = quntity_num +6;            
      jTextField_puchase_quantity.setText(String.valueOf(quntity_num)); 
      }
    }//GEN-LAST:event_jButton_6ActionPerformed

    private void jButton_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_2ActionPerformed
      jTextField_puchase_quantity.setBackground(Color.WHITE);
        String check =jTextField_puchase_quantity.getText();
      if(check.equalsIgnoreCase(""))
      {        
      jTextField_puchase_quantity.setText("0");
      int quntity_num = Integer.parseInt(jTextField_puchase_quantity.getText());
      quntity_num = quntity_num +2;            
      jTextField_puchase_quantity.setText(String.valueOf(quntity_num));
      } 
      else
      {
      int quntity_num = Integer.parseInt(jTextField_puchase_quantity.getText());
      quntity_num = quntity_num +2;            
      jTextField_puchase_quantity.setText(String.valueOf(quntity_num)); 
      }
    }//GEN-LAST:event_jButton_2ActionPerformed

    private void jButton_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_5ActionPerformed
    jTextField_puchase_quantity.setBackground(Color.WHITE);
        String check =jTextField_puchase_quantity.getText();
      if(check.equalsIgnoreCase(""))
      {        
      jTextField_puchase_quantity.setText("0");
      int quntity_num = Integer.parseInt(jTextField_puchase_quantity.getText());
      quntity_num = quntity_num +5;            
      jTextField_puchase_quantity.setText(String.valueOf(quntity_num));
      } 
      else
      {
      int quntity_num = Integer.parseInt(jTextField_puchase_quantity.getText());
      quntity_num = quntity_num +5;            
      jTextField_puchase_quantity.setText(String.valueOf(quntity_num)); 
      }
    }//GEN-LAST:event_jButton_5ActionPerformed

    private void jButton_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_1ActionPerformed
   jTextField_puchase_quantity.setBackground(Color.WHITE);
        String check =jTextField_puchase_quantity.getText();
      if(check.equalsIgnoreCase(""))
      {        
      jTextField_puchase_quantity.setText("0");
      int quntity_num = Integer.parseInt(jTextField_puchase_quantity.getText());
      quntity_num = quntity_num +1;            
      jTextField_puchase_quantity.setText(String.valueOf(quntity_num));
      } 
      else
      {
      int quntity_num = Integer.parseInt(jTextField_puchase_quantity.getText());
      quntity_num = quntity_num +1;            
      jTextField_puchase_quantity.setText(String.valueOf(quntity_num)); 
      }
    }//GEN-LAST:event_jButton_1ActionPerformed

    private void jButton_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_3ActionPerformed
       jTextField_puchase_quantity.setBackground(Color.WHITE);
        String check =jTextField_puchase_quantity.getText();
      if(check.equalsIgnoreCase(""))
      {        
      jTextField_puchase_quantity.setText("0");
      int quntity_num = Integer.parseInt(jTextField_puchase_quantity.getText());
      quntity_num = quntity_num +3;            
      jTextField_puchase_quantity.setText(String.valueOf(quntity_num));
      } 
      else
      {
      int quntity_num = Integer.parseInt(jTextField_puchase_quantity.getText());
      quntity_num = quntity_num +3;            
      jTextField_puchase_quantity.setText(String.valueOf(quntity_num)); 
      }
    }//GEN-LAST:event_jButton_3ActionPerformed

    private void jButton_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_4ActionPerformed
jTextField_puchase_quantity.setBackground(Color.WHITE);
        String check =jTextField_puchase_quantity.getText();
      if(check.equalsIgnoreCase(""))
      {        
      jTextField_puchase_quantity.setText("0");
      int quntity_num = Integer.parseInt(jTextField_puchase_quantity.getText());
      quntity_num = quntity_num +4;            
      jTextField_puchase_quantity.setText(String.valueOf(quntity_num));
      } 
      else
      {
      int quntity_num = Integer.parseInt(jTextField_puchase_quantity.getText());
      quntity_num = quntity_num +4;            
      jTextField_puchase_quantity.setText(String.valueOf(quntity_num)); 
      }       // TODO add your handling code here:
    }//GEN-LAST:event_jButton_4ActionPerformed

    private void jButton_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_7ActionPerformed
jTextField_puchase_quantity.setBackground(Color.WHITE);
        String check =jTextField_puchase_quantity.getText();
      if(check.equalsIgnoreCase(""))
      {        
      jTextField_puchase_quantity.setText("0");
      int quntity_num = Integer.parseInt(jTextField_puchase_quantity.getText());
      quntity_num = quntity_num +7;            
      jTextField_puchase_quantity.setText(String.valueOf(quntity_num));
      } 
      else
      {
      int quntity_num = Integer.parseInt(jTextField_puchase_quantity.getText());
      quntity_num = quntity_num +7;            
      jTextField_puchase_quantity.setText(String.valueOf(quntity_num)); 
      }       // TODO add your handling code here:
    }//GEN-LAST:event_jButton_7ActionPerformed

    private void jButton_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_8ActionPerformed
jTextField_puchase_quantity.setBackground(Color.WHITE);
        String check =jTextField_puchase_quantity.getText();
      if(check.equalsIgnoreCase(""))
      {        
      jTextField_puchase_quantity.setText("0");
      int quntity_num = Integer.parseInt(jTextField_puchase_quantity.getText());
      quntity_num = quntity_num +8;            
      jTextField_puchase_quantity.setText(String.valueOf(quntity_num));
      } 
      else
      {
      int quntity_num = Integer.parseInt(jTextField_puchase_quantity.getText());
      quntity_num = quntity_num +8;            
      jTextField_puchase_quantity.setText(String.valueOf(quntity_num)); 
      }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_8ActionPerformed

    private void jButton_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_9ActionPerformed
jTextField_puchase_quantity.setBackground(Color.WHITE);
        String check =jTextField_puchase_quantity.getText();
      if(check.equalsIgnoreCase(""))
      {        
      jTextField_puchase_quantity.setText("0");
      int quntity_num = Integer.parseInt(jTextField_puchase_quantity.getText());
      quntity_num = quntity_num +9;            
      jTextField_puchase_quantity.setText(String.valueOf(quntity_num));
      } 
      else
      {
      int quntity_num = Integer.parseInt(jTextField_puchase_quantity.getText());
      quntity_num = quntity_num +9;            
      jTextField_puchase_quantity.setText(String.valueOf(quntity_num)); 
      
      }    }//GEN-LAST:event_jButton_9ActionPerformed

    private void jButton1_search_po_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_search_po_idActionPerformed
       Product_bal ob =new Product_bal();
        jLabel_status.setText("");
        
        if(String.valueOf(jTextField1_product_id.getText()).equalsIgnoreCase(""))
        {
            
            
            jTextField1_product_id.setBackground(Color.RED);
            jLabel_status.setForeground(Color.red);
           // jLabel_status.setText("Enter ID First");
            JOptionPane.showMessageDialog(this, "Please Enter Product ID First", "New Bill", 2);
      
            
        }
        else{
            {
        
        int id = Integer.parseInt(jTextField1_product_id.getText());
        PreparedStatement ps = null;
        ResultSet rs = null;
        String Query = "Select product_name , pruduct_quantity  , pruduct_rate  , total_amount from Inventory\n" +
"where\n" +
"product_id = ?";
         try {       
             ps=Main_page.con.prepareStatement(Query);
             ps.setInt(1, id); 
            rs = ps.executeQuery();
            int count = 0;
            while(rs.next())
            {
             jTextField_product_name_show.setText(rs.getString("product_name"));
             jTextFieldProduct_qnt_show.setText(rs.getString("pruduct_quantity"));
             jTextField1_product_rate_show.setText(rs.getString("pruduct_rate"));
             jTextField_total_product_amount.setText(rs.getString("total_amount"));
             
             
             count++;
            }
            String product_name;
            product_name = ob.get_single_product_name(id);
            jComboBox_product.setSelectedItem(product_name);
            
                if(count == 0)
                {
                    jLabel_status.setForeground(Color.red);
                    //jLabel_status.setText("ID NOT FOUND");
                    JOptionPane.showMessageDialog(this, "Please Enter Correct ID", "New Bill", 2);
            
                }
            
            
         } catch (SQLException ex) {
             Logger.getLogger(Update_account.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        }
        }
        
            
    }//GEN-LAST:event_jButton1_search_po_idActionPerformed

    private void jTextField1_product_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_product_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_product_idActionPerformed

    private void jTextField_puchase_quantityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_puchase_quantityFocusGained
       
        jTextField_puchase_quantity.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTextField_puchase_quantityFocusGained

    private void jButton1_customer_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_customer_searchActionPerformed
       
          jLabel_status.setText("");
        
        if(String.valueOf(jTextField1_customer_id.getText()).equalsIgnoreCase(""))
        {
            
            
            jTextField1_customer_id.setBackground(Color.RED);
            jLabel_status.setForeground(Color.red);
           // jLabel_status.setText("Enter ID First");
               JOptionPane.showMessageDialog(this, "Please Enter Customer ID First", "New Bill", 1);
        }
        else{
            {
        
        int id = Integer.parseInt(jTextField1_customer_id.getText());
        PreparedStatement ps = null;
        ResultSet rs = null;
        String Query = "select customer_name , customer_balnce from account \n" +
"where \n" +
"account_id = ?";
         try {       
             ps=Main_page.con.prepareStatement(Query);
             ps.setInt(1, id); 
            rs = ps.executeQuery();
            int count = 0;
            while(rs.next())
            {
             jTextField_customer_name_show.setText(rs.getString("customer_name"));
             jTextField_customer_blnc_show.setText(rs.getString("customer_balnce"));
             
             
             count++;
            }
            
            Account_bal ob = new Account_bal();
            String customer_name;
            customer_name = ob.get_single_customer_name(id);
            jComboBox_customer.setSelectedItem(customer_name);
                if(count == 0)
                {
                    jLabel_status.setForeground(Color.red);
                    //jLabel_status.setText("ID NOT FOUND");
                    JOptionPane.showMessageDialog(this, "Please Enter Correct ID", "New Bill", 2);
                    
                }
            
            
         } catch (SQLException ex) {
             Logger.getLogger(Update_account.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        }
        }
    }//GEN-LAST:event_jButton1_customer_searchActionPerformed

    private void jTextField1_product_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1_product_idFocusGained
        // TODO add your handling code here:
        jTextField1_product_id.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTextField1_product_idFocusGained

    private void jTextField1_customer_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1_customer_idFocusGained
        // TODO add your handling code here:
        jTextField1_customer_id.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTextField1_customer_idFocusGained

    private void jTextField1_product_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_product_idKeyPressed
 int key = evt.getKeyCode();
        if((key >= evt.VK_0&&key<=evt.VK_9) || (key>=evt.VK_NUMPAD0 && key<= evt.VK_NUMPAD9) || key==KeyEvent.VK_BACKSPACE)
        {
              jTextField1_product_id.setEditable(true);
           jTextField1_product_id.setBackground(Color.yellow);
            jLabel_status.setText("");
            
        }
        else
        {
            jTextField1_product_id.setEditable(false);
              jTextField1_product_id.setBackground(Color.RED);
           jLabel_status.setForeground(Color.red);
            jLabel_status.setText("Please Enter Only Numeric Value");
        }        // TODO add your handl        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_product_idKeyPressed

    private void jTextField1_customer_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_customer_idKeyPressed
 int key = evt.getKeyCode();
        if((key >= evt.VK_0&&key<=evt.VK_9) || (key>=evt.VK_NUMPAD0 && key<= evt.VK_NUMPAD9) || key==KeyEvent.VK_BACKSPACE)
        {
              jTextField1_customer_id.setEditable(true);
           jTextField1_customer_id.setBackground(Color.yellow);
            jLabel_status.setText("");
        }
        else
        {
            jTextField1_customer_id.setEditable(false);
              jTextField1_customer_id.setBackground(Color.RED);
           jLabel_status.setForeground(Color.red);
            jLabel_status.setText("Please Enter Only Numeric Value");
        }             
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_customer_idKeyPressed

    private void jTextField_total_product_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_total_product_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_total_product_amountActionPerformed

    private void jButton1_print_and_save_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_print_and_save_billActionPerformed
          int Bill_id =Integer.parseInt(jLabel_bill_id_show.getText());
      String Date  = jLabel_date_show.getText();
      String Time = jLabel_time_show.getText();
      
       
       // jLabel_message_quantity.setText("");
        New_bill_bal ob = new New_bill_bal();
        String prodct_name = (String)jComboBox_product.getSelectedItem();
        String Customer_name = (String)jTextField_customer_name_show.getText();
        
        
      
                 
                int Bill_amount = Integer.parseInt(jLabel_total_bill_amount_show.getText());

 
                 
                 // store bill  informatipon  ni bill_amount databse table
                 New_bill_bal bill_amnt = new New_bill_bal();
         try {
             bill_amnt.Sent_BillAmount_in_Amount_bill(Bill_id, Customer_name, Bill_amount );
         } catch (SQLException ex) {
             Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
         }
                 

                 // update customer  balnce after bill
                 int remaining_cus_bln;
                 remaining_cus_bln = Integer.parseInt(jTextField_customer_blnc_show.getText());
                 Account_bal update_bln = new Account_bal();
         try {
             update_bln.update_customer_balnce(Customer_name, remaining_cus_bln);
         } catch (SQLException ex) {
             Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
         }

                 // store from table to database
                 for (int i =0 ; i < jTable2.getRowCount(); i++)
                 {
                 String  Table_product_name = (String)jTable2.getValueAt(i, 1);
                  int table_product_rate = (int)jTable2.getValueAt(i, 2);
                 int table_product_qnt = (int)jTable2.getValueAt(i, 3);
                
                 int table_product_amount1 = (int)jTable2.getValueAt(i, 4);               
         try {
             bill_amnt.Sent_Data_in_Product_bill(Bill_id, Date, Time, Table_product_name, table_product_qnt, table_product_rate, table_product_amount1);
         } catch (SQLException ex) {
             Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
         }
                 
                 }


        
        /// jesper report
        
        try {
            
              JasperDesign jd  = JRXmlLoader.load("C:\\Users\\Shahyar\\Documents\\NetBeansProjects\\Inventory_managment\\Reports\\Bills\\invo - Copy.jrxml");
             String id  = jLabel_bill_id_show.getText();
                            String sql =  " select Bill_Amount.Bill_ID , Bill_Product.Date_ , Bill_Product.Time_ , Bill_Amount.customer_name ,  Bill_Product.Prodcut_name ,\n" +
               " Bill_Product.Quantity , Bill_Product.Rate ,  Bill_Amount.Bill_Amount \n" +
               " from \n" +
               " Bill_Amount\n" +
               " right join\n" +
               " Bill_Product\n" +
               " on \n" +
               " Bill_Amount.Bill_ID = Bill_Product.Bill_ID\n" +
               " where Bill_Product.Bill_ID = '"+id+"'\n" +
               " order by \n" +
               " Bill_ID";
            
            
            JRDesignQuery  newquer  = new JRDesignQuery();
             newquer.setText(sql);
            jd.setQuery(newquer);
            JasperReport jr =  JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null , con);
             JasperViewer.viewReport(jp,false);
        } catch (JRException ex) {
            Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // jesper report
        
        
         
         this.setVisible(false);       
         try {
             
            // open new bill
             New_bill  next_bill  = new New_bill();
             Main_page.jDesktopPane2.add(next_bill);
              Dimension pareentSize = jDesktopPane2.getSize();
             Dimension childSize = next_bill.getSize();
             next_bill.setLocation((pareentSize.width - childSize.width)/2, (pareentSize.height - childSize.height)/2);
             next_bill.setVisible(true);
         }   catch (SQLException ex) {
             Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
         } catch (PropertyVetoException ex) {
             Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
         }
       
    }//GEN-LAST:event_jButton1_print_and_save_billActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_add_product;
    private javax.swing.JButton jButton1_close;
    private javax.swing.JButton jButton1_customer_search;
    private javax.swing.JButton jButton1_print_and_save_bill;
    private javax.swing.JButton jButton1_search_po_id;
    private javax.swing.JButton jButton_1;
    private javax.swing.JButton jButton_2;
    private javax.swing.JButton jButton_3;
    private javax.swing.JButton jButton_4;
    private javax.swing.JButton jButton_5;
    private javax.swing.JButton jButton_6;
    private javax.swing.JButton jButton_7;
    private javax.swing.JButton jButton_8;
    private javax.swing.JButton jButton_9;
    private javax.swing.JButton jButton_clear;
    private javax.swing.JButton jButton_generate_bill;
    private javax.swing.JButton jButton_remove_row;
    private javax.swing.JComboBox jComboBox_customer;
    private javax.swing.JComboBox jComboBox_product;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1_customer_balance;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4_back_g;
    private javax.swing.JLabel jLabel_Select_customer;
    private javax.swing.JLabel jLabel_bill_id_show;
    private javax.swing.JLabel jLabel_customer_name;
    private javax.swing.JLabel jLabel_date;
    public static javax.swing.JLabel jLabel_date_show;
    private javax.swing.JLabel jLabel_massage_balance;
    private javax.swing.JLabel jLabel_product_name;
    private javax.swing.JLabel jLabel_product_qnt1;
    private javax.swing.JLabel jLabel_product_rate2;
    private javax.swing.JLabel jLabel_purchase_qnt;
    private javax.swing.JLabel jLabel_select_product;
    private javax.swing.JLabel jLabel_status;
    private javax.swing.JLabel jLabel_time;
    public static javax.swing.JLabel jLabel_time_show;
    private javax.swing.JLabel jLabel_total;
    private javax.swing.JLabel jLabel_total_bill_amount;
    public static javax.swing.JLabel jLabel_total_bill_amount_show;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1_customer_id;
    private javax.swing.JTextField jTextField1_product_id;
    private javax.swing.JTextField jTextField1_product_rate_show;
    private javax.swing.JTextField jTextFieldProduct_qnt_show;
    private javax.swing.JTextField jTextField_customer_blnc_show;
    private javax.swing.JTextField jTextField_customer_name_show;
    private javax.swing.JTextField jTextField_product_name_show;
    public static javax.swing.JTextField jTextField_puchase_quantity;
    private javax.swing.JTextField jTextField_total_product_amount;
    // End of variables declaration//GEN-END:variables
}
