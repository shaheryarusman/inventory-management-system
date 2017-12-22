package Products;


import Bill.New_bill;
import Customer.Account_bal;
import Login.Main_page;
import static Login.Main_page.jDesktopPane2;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Add_product extends javax.swing.JInternalFrame {

    /**
     * Creates new form Add_product
     */
    public Add_product() throws SQLException {
        initComponents();
        jTextField_total_amnt.setEnabled(false);
         jTextField1_id.setEnabled(false);
        
         
        int id;
        Product_bal new_id = new Product_bal();
        id = new_id.get_New_product_id();
        jTextField1_id.setText(String.valueOf(id+1));
        jButton1.setEnabled(false);
        
        
        
       // this.setLocation(450, 350);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_reset = new javax.swing.JButton();
        jLabel_product_name = new javax.swing.JLabel();
        jLabel_product_rate = new javax.swing.JLabel();
        jLabel_product_qnt = new javax.swing.JLabel();
        jLabel_total_amt = new javax.swing.JLabel();
        jTextField_product_name = new javax.swing.JTextField();
        jTextField_product_rate = new javax.swing.JTextField();
        jTextField_procduct_qnt = new javax.swing.JTextField();
        jTextField_total_amnt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1_add = new javax.swing.JButton();
        jLabel_status = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1_id = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 51, 51));
        setClosable(true);
        setIconifiable(true);
        setTitle("Add product");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_reset.setBackground(new java.awt.Color(51, 51, 255));
        btn_reset.setFont(new java.awt.Font("AR BERKLEY", 0, 18)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setText("Reset");
        btn_reset.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        getContentPane().add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 289, 80, 45));

        jLabel_product_name.setForeground(new java.awt.Color(17, 111, 204));
        jLabel_product_name.setText("Product name");
        getContentPane().add(jLabel_product_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 110, 113, -1));

        jLabel_product_rate.setForeground(new java.awt.Color(17, 111, 204));
        jLabel_product_rate.setText("Product Rate");
        getContentPane().add(jLabel_product_rate, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 154, 113, -1));

        jLabel_product_qnt.setForeground(new java.awt.Color(17, 111, 204));
        jLabel_product_qnt.setText("Product quantity");
        getContentPane().add(jLabel_product_qnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 197, 113, 17));

        jLabel_total_amt.setForeground(new java.awt.Color(17, 111, 204));
        jLabel_total_amt.setText("Total Amount");
        getContentPane().add(jLabel_total_amt, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 242, 113, -1));

        jTextField_product_name.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_product_name.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        jTextField_product_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_product_nameFocusGained(evt);
            }
        });
        getContentPane().add(jTextField_product_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 104, 211, 26));

        jTextField_product_rate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_product_rate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        jTextField_product_rate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_product_rateFocusGained(evt);
            }
        });
        jTextField_product_rate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_product_rateActionPerformed(evt);
            }
        });
        jTextField_product_rate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextField_product_ratePropertyChange(evt);
            }
        });
        jTextField_product_rate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_product_rateKeyPressed(evt);
            }
        });
        getContentPane().add(jTextField_product_rate, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 148, 211, 26));

        jTextField_procduct_qnt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_procduct_qnt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        jTextField_procduct_qnt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_procduct_qntFocusGained(evt);
            }
        });
        jTextField_procduct_qnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_procduct_qntActionPerformed(evt);
            }
        });
        jTextField_procduct_qnt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_procduct_qntKeyPressed(evt);
            }
        });
        getContentPane().add(jTextField_procduct_qnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 192, 211, 26));

        jTextField_total_amnt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField_total_amnt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        getContentPane().add(jTextField_total_amnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 236, 211, 26));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 60, 11, 202));

        jButton1_add.setBackground(new java.awt.Color(51, 51, 255));
        jButton1_add.setFont(new java.awt.Font("AR BERKLEY", 0, 18)); // NOI18N
        jButton1_add.setForeground(new java.awt.Color(255, 255, 255));
        jButton1_add.setText("Add");
        jButton1_add.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_addActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 289, 72, 45));
        getContentPane().add(jLabel_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 262, 23));

        jLabel1.setForeground(new java.awt.Color(17, 111, 204));
        jLabel1.setText("Product ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 66, 86, -1));

        jTextField1_id.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField1_id.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        getContentPane().add(jTextField1_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 60, 211, 26));

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("AR BERKLEY", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD NEW ??");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 170, 45));

        jLabel2.setFont(new java.awt.Font("AR BONNIE", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(104, 104, 232));
        jLabel2.setText("Add New Product");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 328, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Products/resized.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 230, 210));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/off-white-gradient-background-health-nuts-media-beautiful.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 730, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_addActionPerformed

        String check_name = (String)jTextField_product_name.getText();
        String  check_rate = jTextField_product_rate.getText();
        String  check_qunatity = jTextField_procduct_qnt.getText();
        jTextField_product_name.setBackground(null);
        jTextField_product_rate.setBackground(null);
        jTextField_procduct_qnt.setBackground(null);
        Product_bal ob = new Product_bal();
        boolean Search_result = false;
        try {
           Search_result =  ob.Search_existed_porduct_for_add_new(check_name);
        } catch (SQLException ex) {
            Logger.getLogger(Add_product.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(Search_result)
        {
            jLabel_status.setForeground(Color.RED);
            jLabel_status.setText("Error! Product Name Is Already Exist");
            
        }
        else
        {
        
                if((check_name.equalsIgnoreCase("")) || check_rate.equalsIgnoreCase("") ||check_rate.equalsIgnoreCase("0")  ||check_qunatity.equalsIgnoreCase("") || check_qunatity.equalsIgnoreCase("0"))
                {
                    if(check_name.equalsIgnoreCase("") && (check_rate.equalsIgnoreCase("") || check_rate.equalsIgnoreCase("0"))  && (check_qunatity.equalsIgnoreCase("") || check_qunatity.equalsIgnoreCase("0")))
                    {
                         jTextField_product_name.setBackground(Color.red);
                         jTextField_product_rate.setBackground(Color.red);
                         jTextField_procduct_qnt.setBackground(Color.red);
                          JOptionPane.showMessageDialog(null,"Please Enter Complete Product Info" ,"New Product" , 2);
                    }
                    else
                    {
                        
                    
                    if(check_name.equalsIgnoreCase(""))
                            {
                            jTextField_product_name.setBackground(Color.red);
                            jLabel_status.setForeground(Color.red);
                           // jLabel_status.setText("Please Enter Complete Information");
                              JOptionPane.showMessageDialog(null,"Please Enter Product Name" ,"New product" , 1);
                    
                            }
                    if(check_rate.equalsIgnoreCase("") ||check_rate.equalsIgnoreCase("0"))
                            {
                            jTextField_product_rate.setBackground(Color.red);
                            jLabel_status.setForeground(Color.red);
                             JOptionPane.showMessageDialog(null,"Please Enter Product Rate" ,"New product" , 1);
                    
                      
                          //  jLabel_status.setText("Please Enter Complete Information");
                            }
                     if(check_qunatity.equalsIgnoreCase("") || check_qunatity.equalsIgnoreCase("0"))
                            {
                            jTextField_procduct_qnt.setBackground(Color.red);
                            jLabel_status.setForeground(Color.red);
                         //   jLabel_status.setText("Please Enter Complete Information");
                             JOptionPane.showMessageDialog(null,"Please Enter Product Quantity" ,"New product" , 1);
                    
                      
                            }
                    }
                }
            else
            {       
                int option = JOptionPane.showConfirmDialog(null, "Do you Want to Add New Customer..??", "Add Customer", JOptionPane.YES_NO_OPTION , 0);
    
                 if(option == 0 )
                  {
                int row = 0;
                int rate = (Integer.parseInt(jTextField_product_rate.getText()));
                int qnt = (Integer.parseInt(jTextField_procduct_qnt.getText()));
                int result = rate * qnt;
                String result_1 = String.valueOf(result);
            try {
               row = ob.AddProduct(jTextField_product_name.getText(), jTextField_product_rate.getText(), jTextField_procduct_qnt.getText());

               
               
                    if(row != 0)
                    {
                      jLabel_status.setForeground(Color.GREEN);
                    //  jLabel_status.setText("Product is Add");
                       JOptionPane.showMessageDialog(null,"New Product is Successfully Added" ,"New Product" , 1);
        
                      jTextField_total_amnt.setText(result_1);
                      jButton1_add.setEnabled(false);
                      btn_reset.setEnabled(false);
                      jButton1.setEnabled(true);
                    }
                    else
                    {
                       jLabel_status.setText("Product is not Add"); 
                    }
                    
                    
                    
            } catch (SQLException ex) {
                Logger.getLogger(Add_product.class.getName()).log(Level.SEVERE, null, ex);

            }
                  }
            }
        
        
        }
        
        
    }//GEN-LAST:event_jButton1_addActionPerformed

    private void jTextField_product_ratePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextField_product_ratePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_product_ratePropertyChange

    private void jTextField_product_rateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_product_rateKeyPressed
       
        int key = evt.getKeyCode();
        if((key >= evt.VK_0&&key<=evt.VK_9) || (key>=evt.VK_NUMPAD0 && key<= evt.VK_NUMPAD9) || key==KeyEvent.VK_BACKSPACE)
        {
            jTextField_product_rate.setEditable(true);
          jTextField_product_rate.setBackground(Color.yellow);
            jLabel_status.setText("");
        }
        else
        {
           jTextField_product_rate.setEditable(false);
            jTextField_product_rate.setBackground(Color.RED);
            jLabel_status.setForeground(Color.red);
        jLabel_status.setText("Please Enter Only Numeric Value");
        }
    }//GEN-LAST:event_jTextField_product_rateKeyPressed

    private void jTextField_procduct_qntKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_procduct_qntKeyPressed
        
        int key = evt.getKeyCode();
        if((key >= evt.VK_0&&key<=evt.VK_9) || (key>=evt.VK_NUMPAD0 && key<= evt.VK_NUMPAD9) || key==KeyEvent.VK_BACKSPACE)
        {
            jTextField_procduct_qnt.setEditable(true);
           jTextField_procduct_qnt.setBackground(Color.yellow);
            jLabel_status.setText("");
        }
        else
        {
           jTextField_procduct_qnt.setEditable(false);
             jTextField_procduct_qnt.setBackground(Color.RED);
            jLabel_status.setForeground(Color.red);
            jLabel_status.setText("Please Enter Only Numeric Value");
        }
    }//GEN-LAST:event_jTextField_procduct_qntKeyPressed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        jTextField_product_name.setText("");
        jTextField_product_rate.setText("");
        jTextField_procduct_qnt.setText("");        
        jLabel_status.setText("");     
        jTextField_product_name.setBackground(null);
        jTextField_procduct_qnt.setBackground(null);
        jTextField_product_rate.setBackground(null);
        jTextField_total_amnt.setText("");
    }//GEN-LAST:event_btn_resetActionPerformed

    private void jTextField_procduct_qntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_procduct_qntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_procduct_qntActionPerformed

    private void jTextField_product_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_product_nameFocusGained
        // TODO add your handling code here:
         jTextField_product_name.setBackground(null);
    }//GEN-LAST:event_jTextField_product_nameFocusGained

    private void jTextField_product_rateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_product_rateFocusGained
        // TODO add your handling code here:
         jTextField_product_rate.setBackground(null);
    }//GEN-LAST:event_jTextField_product_rateFocusGained

    private void jTextField_procduct_qntFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_procduct_qntFocusGained
        // TODO add your handling code here:
        jTextField_procduct_qnt.setBackground(null);
    }//GEN-LAST:event_jTextField_procduct_qntFocusGained

    private void jTextField_product_rateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_product_rateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_product_rateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);

        try {

            // open new bill
            Add_product new_entry = new Add_product();
            Main_page.jDesktopPane2.add(new_entry);
            Dimension pareentSize = jDesktopPane2.getSize();
            Dimension childSize = new_entry.getSize();
            new_entry.setLocation((pareentSize.width - childSize.width)/2, (pareentSize.height - childSize.height)/2);
            new_entry.setVisible(true);
        }   catch (SQLException ex) {
            Logger.getLogger(New_bill.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton1_add;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_product_name;
    private javax.swing.JLabel jLabel_product_qnt;
    private javax.swing.JLabel jLabel_product_rate;
    private javax.swing.JLabel jLabel_status;
    private javax.swing.JLabel jLabel_total_amt;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1_id;
    private javax.swing.JTextField jTextField_procduct_qnt;
    private javax.swing.JTextField jTextField_product_name;
    private javax.swing.JTextField jTextField_product_rate;
    private javax.swing.JTextField jTextField_total_amnt;
    // End of variables declaration//GEN-END:variables
}
