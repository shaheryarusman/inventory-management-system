package Customer;


import Customer.Account_bal;
import Products.Update_product;
import Bill.Conform_bill_bal;
import Bill.New_bill;
import Bill.New_bill_bal;
import Login.Main_page;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shahyar
 */
public class Delete_customer extends javax.swing.JInternalFrame {

    /**
     * Creates new form Delete_customer
     */
     DefaultComboBoxModel Customer_list;
    public Delete_customer() {
        initComponents();
        Customer_list();
        show_Customer_info_show();
        jTextField2_customer_blnc_show.setEnabled(false);
        jTextField_customer_name_show.setEnabled(false);
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
            
            jComboBox1_customer_name.setModel(Customer_list);
             jTextField_customer_name_show.setText((String) jComboBox1_customer_name.getSelectedItem()); 
             
    }

     
     
     public void show_Customer_info_show()
    {
        New_bill_bal ob  = new New_bill_bal();
        String s; 
        int Customer_balance= 0;
       
        // name
        s = (String) jComboBox1_customer_name.getSelectedItem();
        jTextField_customer_name_show.setText(s);
        
        // balance
        
         try {
            Customer_balance = ob.getcustomer_balance(s);
         } catch (SQLException ex) {
             Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
         }         
        jTextField2_customer_blnc_show.setText(String.valueOf(Customer_balance));   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jButton1_dlt = new javax.swing.JButton();
        jButton1_search = new javax.swing.JButton();
        jButton2close = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4_status = new javax.swing.JLabel();
        jTextField2_customer_blnc_show = new javax.swing.JTextField();
        jTextField_customer_name_show = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1_customer_name = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jTextField1_id = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Delete Customer");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("AR BONNIE", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(104, 104, 232));
        jLabel5.setText("Delete Product");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 14, 248, 48));

        jButton1_dlt.setBackground(new java.awt.Color(51, 51, 255));
        jButton1_dlt.setFont(new java.awt.Font("AR BERKLEY", 0, 18)); // NOI18N
        jButton1_dlt.setForeground(new java.awt.Color(255, 255, 255));
        jButton1_dlt.setText("Delete");
        jButton1_dlt.setAutoscrolls(true);
        jButton1_dlt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1_dlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_dltActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_dlt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 78, 44));

        jButton1_search.setBackground(new java.awt.Color(51, 51, 255));
        jButton1_search.setFont(new java.awt.Font("AR BERKLEY", 0, 18)); // NOI18N
        jButton1_search.setForeground(new java.awt.Color(255, 255, 255));
        jButton1_search.setText("Search By ID");
        jButton1_search.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_searchActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 130, 44));

        jButton2close.setBackground(new java.awt.Color(51, 51, 255));
        jButton2close.setFont(new java.awt.Font("AR BERKLEY", 0, 18)); // NOI18N
        jButton2close.setForeground(new java.awt.Color(255, 255, 255));
        jButton2close.setText("Close");
        jButton2close.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2close.setDefaultCapable(false);
        jButton2close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2closeActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2close, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 78, 44));

        jLabel3.setForeground(new java.awt.Color(17, 111, 204));
        jLabel3.setText("Customer Balance");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 206, -1, -1));
        getContentPane().add(jLabel4_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 247, 261, 23));

        jTextField2_customer_blnc_show.setText("jTextField2");
        jTextField2_customer_blnc_show.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        jTextField2_customer_blnc_show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2_customer_blnc_showActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2_customer_blnc_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 200, 192, 26));

        jTextField_customer_name_show.setText("jTextField1");
        jTextField_customer_name_show.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        getContentPane().add(jTextField_customer_name_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 156, 192, 26));

        jLabel2.setForeground(new java.awt.Color(17, 111, 204));
        jLabel2.setText("Customer Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 166, -1, -1));

        jLabel1.setForeground(new java.awt.Color(17, 111, 204));
        jLabel1.setText("Select Customer By Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 118, -1, -1));

        jComboBox1_customer_name.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1_customer_name.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        jComboBox1_customer_name.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1_customer_nameItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox1_customer_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 112, 192, 26));

        jLabel4.setForeground(new java.awt.Color(17, 111, 204));
        jLabel4.setText("Enter Customer ID");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 74, 123, -1));

        jTextField1_id.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        jTextField1_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1_idFocusGained(evt);
            }
        });
        jTextField1_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_idKeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 68, 188, 26));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 68, 11, 237));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Customer/2_004.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 49, -1, 271));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Customer/customer_dlt_backgrond_2.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1_customer_nameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1_customer_nameItemStateChanged
        // TODO add your handling code here:
       show_Customer_info_show();
    }//GEN-LAST:event_jComboBox1_customer_nameItemStateChanged

    private void jButton1_dltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_dltActionPerformed
if(jTextField_customer_name_show.getText().equals(""))
{
   // jLabel4_status.setText("Customer Info Not Available");
 
    JOptionPane.showMessageDialog(null,"Customer Info is Not Available" ,"Delete" , 0);
}
else
{
    //int r = JOptionPane.showConfirmDialog(null, "Do you Want to delete..??", "Delete", JOptionPane.YES_NO_OPTION);
    int option = JOptionPane.showConfirmDialog(null, "Do you Want to delete..??", "Delete", JOptionPane.YES_NO_OPTION , 0);
    
    if(option == 0 )
    {
        String customer_name = jTextField_customer_name_show.getText();

        Account_bal delete_customer = new Account_bal();
        try {
            delete_customer.Delete_customer(customer_name);
        } catch (SQLException ex) {
            Logger.getLogger(Update_product.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null,"Customer Deleted" ,"Delete" , 2);
       // jLabel4_status.setText("Customer Deleted");
        Customer_list();
        show_Customer_info_show();
        jTextField1_id.setText("");
    }
    
}

    }//GEN-LAST:event_jButton1_dltActionPerformed

    private void jButton2closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2closeActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2closeActionPerformed

    private void jButton1_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_searchActionPerformed
        jLabel4_status.setText("");
 
        if(String.valueOf(jTextField1_id.getText()).equalsIgnoreCase(""))
        {
            
            jTextField1_id.setBackground(Color.RED);
            jLabel4_status.setForeground(Color.red);
            //jLabel4_status.setText("Enter ID First");
            JOptionPane.showMessageDialog(this, "Please Enter Customer ID First", "Search ID", 2);
        }
        else{
        
        
        int id =Integer.parseInt(jTextField1_id.getText());
      
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        String Query = "select customer_name , customer_balnce from account\n" +
       " where \n" +
       " account_id = ?";
         try {       
             ps=Main_page.con.prepareStatement(Query);
             ps.setInt(1, id); 
            rs = ps.executeQuery();
             int count = 0;
            while(rs.next())
            {
                
             jTextField_customer_name_show.setText(rs.getString("customer_name"));
             jTextField2_customer_blnc_show.setText(rs.getString("customer_balnce"));
            count++;
                }
                
              Account_bal ob = new Account_bal();
            String customer_name;
            customer_name = ob.get_single_customer_name(id);
            jComboBox1_customer_name.setSelectedItem(customer_name);
            
                if(count == 0)
                {
                    jLabel4_status.setForeground(Color.red);
                  //  jLabel4_status.setText("ID NOT FOUND");
                     JOptionPane.showMessageDialog(this, "Please Enter Correct ID", "Search ID", 2);
                }
            
         } catch (SQLException ex) {
             Logger.getLogger(Update_account.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        }
    }//GEN-LAST:event_jButton1_searchActionPerformed

    private void jTextField1_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1_idFocusGained
    //jLabel4_status.setText("");    
    jTextField1_id.setBackground(Color.white);
    // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_idFocusGained

    private void jTextField1_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_idKeyPressed
  int key = evt.getKeyCode();
        if((key >= evt.VK_0&&key<=evt.VK_9) || (key>=evt.VK_NUMPAD0 && key<= evt.VK_NUMPAD9) || key==KeyEvent.VK_BACKSPACE)
        {
             jTextField1_id.setEditable(true);
          jTextField1_id.setBackground(Color.yellow);
            jLabel4_status.setText("");
        }
        else
        {
           jTextField1_id.setEditable(false);
             jTextField1_id.setBackground(Color.RED);
           jLabel4_status.setForeground(Color.red);
            jLabel4_status.setText("Please Enter Only Numeric Value");
        }        // TODO add your handl        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_idKeyPressed

    private void jTextField2_customer_blnc_showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2_customer_blnc_showActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2_customer_blnc_showActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_dlt;
    private javax.swing.JButton jButton1_search;
    private javax.swing.JButton jButton2close;
    private javax.swing.JComboBox jComboBox1_customer_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel4_status;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1_id;
    private javax.swing.JTextField jTextField2_customer_blnc_show;
    private javax.swing.JTextField jTextField_customer_name_show;
    // End of variables declaration//GEN-END:variables
}
