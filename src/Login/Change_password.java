/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Shahyar
 */
public class Change_password extends javax.swing.JInternalFrame {

    /**
     * Creates new form Change_password
     */
    public Change_password() {
        initComponents();
        
         if(Login_window.Current_user_Type == 0)
      {
          jTextField1_user_name.setText(Login_window.Current_User_Name);
         //jTextField2.setText(Login_window.Current_User_Password);
          jLabel2_type_display.setText("Admin "+"Mode");     
      }
      else
      {
          jTextField1_user_name.setText(Login_window.Current_User_Name);
          //jTextField2.setText(Login_window.Current_User_Password);
          jLabel2_type_display.setText("User "+"Mode"); 
      }
         jTextField1_user_name.setEnabled(false);
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2_type_display = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1_user_name = new javax.swing.JTextField();
        btn_save = new javax.swing.JButton();
        btn_cancle = new javax.swing.JButton();
        jPasswordField1_New_pass = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel4_stattus = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1_old_pass = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel_image_change_status = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Change Password");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("AR BONNIE", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(104, 104, 232));
        jLabel1.setText("Change Password");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 6, 235, -1));

        jLabel2_type_display.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2_type_display.setForeground(new java.awt.Color(21, 63, 105));
        jLabel2_type_display.setText("jLabel2");
        getContentPane().add(jLabel2_type_display, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 61, 147, 34));

        jLabel2.setForeground(new java.awt.Color(17, 111, 204));
        jLabel2.setText("User Name ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 112, -1, -1));

        jLabel3.setForeground(new java.awt.Color(17, 111, 204));
        jLabel3.setText("Enter New Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 181, 130, -1));

        jTextField1_user_name.setToolTipText("User Name");
        jTextField1_user_name.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        getContentPane().add(jTextField1_user_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 145, 26));

        btn_save.setBackground(new java.awt.Color(51, 51, 255));
        btn_save.setFont(new java.awt.Font("AR BERKLEY", 0, 18)); // NOI18N
        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        getContentPane().add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 267, 94, 40));

        btn_cancle.setBackground(new java.awt.Color(51, 51, 255));
        btn_cancle.setFont(new java.awt.Font("AR BERKLEY", 0, 18)); // NOI18N
        btn_cancle.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancle.setText("Cancel");
        btn_cancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancleActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancle, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 267, 94, 40));

        jPasswordField1_New_pass.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        jPasswordField1_New_pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField1_New_passFocusGained(evt);
            }
        });
        jPasswordField1_New_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1_New_passActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField1_New_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 145, 26));

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(11, 75, 139));
        jCheckBox1.setText("Show Password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 219, -1, -1));

        jLabel4_stattus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(jLabel4_stattus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 210, 10));

        jLabel4.setForeground(new java.awt.Color(17, 111, 204));
        jLabel4.setText("Enter Old Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 144, -1, -1));

        jPasswordField1_old_pass.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 126), 2, true));
        jPasswordField1_old_pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField1_old_passFocusGained(evt);
            }
        });
        getContentPane().add(jPasswordField1_old_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 145, 26));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 15, 252));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/resizes_key.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));

        jLabel_image_change_status.setFont(new java.awt.Font("AR BONNIE", 0, 24)); // NOI18N
        jLabel_image_change_status.setForeground(new java.awt.Color(104, 104, 232));
        getContentPane().add(jLabel_image_change_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 4, 290, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/change_pw_backGrong.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
      if(jCheckBox1.isSelected())
      {
          jPasswordField1_New_pass.setEchoChar((char)0);
          jPasswordField1_old_pass.setEchoChar((char)0);
      }
      else
      {
          jPasswordField1_New_pass.setEchoChar('*');
          jPasswordField1_old_pass.setEchoChar('*');
      }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void btn_cancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancleActionPerformed
            this.setVisible(false);       
            
    }//GEN-LAST:event_btn_cancleActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        String name = jTextField1_user_name.getText();
        String old_pass = jPasswordField1_old_pass.getText();
        String new_pass = jPasswordField1_New_pass.getText();
         textfield_bal update_passwpord = new textfield_bal();
         int status =0; 
        
            if(old_pass.equalsIgnoreCase("") || new_pass.equalsIgnoreCase(""))
             {
                        if(old_pass.equalsIgnoreCase("") && new_pass.equalsIgnoreCase(""))
                        {
                            JOptionPane.showMessageDialog(null,"Please Enter Complete Info" ,"Change Password" , 2);
                        }
                        else
                        {               
                            if(old_pass.equalsIgnoreCase(""))
                            {
                                jPasswordField1_old_pass.setBackground(Color.red);
                                jLabel4_stattus.setForeground(Color.RED);
                               // jLabel4_stattus.setText("ERROR! Enter all information");
                                 JOptionPane.showMessageDialog(null,"Please Enter Your Old Password" ,"Change Password" , 2);

                            }
                            if(new_pass.equalsIgnoreCase(""))
                            {
                                jPasswordField1_New_pass.setBackground(Color.red);
                                jLabel4_stattus.setForeground(Color.RED);
                               JOptionPane.showMessageDialog(null,"Please Enter Your New Password" ,"Change Password" , 2);
                            }
                        } 
            }              
                    else // after emplty field check , update password
                    {
                                if(Login_window.Current_user_Type == 0)
                                {
                                 int option = JOptionPane.showConfirmDialog(null, "Do you Want to Change Password..??", "Change Password", JOptionPane.YES_NO_OPTION , 0);

                                    if(option== 0 )
                                    { 
                                    try {
                                       status = update_passwpord.change_pass_in_Admin(name, old_pass, new_pass);
                                      if(status != 0)
                                        {
                                           // jLabel4_stattus.setForeground(Color.GREEN);
                                            //jLabel4_stattus.setText("");
                                            jLabel_image_change_status.setText("Admin Password Is Change");
                                             ImageIcon ic = new ImageIcon(getClass().getResource("/Login/resizes_key__2.png"));
                                            jLabel6.setIcon(ic);
                                        }
                                        else
                                        {
                                            jPasswordField1_New_pass.setBackground(Color.red);
                                            jPasswordField1_old_pass.setBackground(Color.red);

                                            jLabel4_stattus.setForeground(Color.RED);

                                            jLabel_image_change_status.setText("ERROR! Password Not Change.");
                                        } // try

                                    } catch (SQLException ex) {
                                        Logger.getLogger(Change_password.class.getName()).log(Level.SEVERE, null, ex);
                                    } // cathch

                            } // jo option pane

                                } // if for user type = 0 (Admin)



                                if(Login_window.Current_user_Type == 1)
                                {
                                     int option = JOptionPane.showConfirmDialog(null, "Do you Want to Change Password..??", "Change Password", JOptionPane.YES_NO_OPTION , 0);

                                    if(option== 0 )
                                    { 
                                     try {
                                            status = update_passwpord.change_pass_in_User(name, old_pass, new_pass);
                                             if(status != 0)
                                             {
                                                 jLabel4_stattus.setForeground(Color.GREEN);
                                                 jLabel_image_change_status.setText("User Password Is Change");
                                                 ImageIcon ic = new ImageIcon(getClass().getResource("/Login/resizes_key__2.png"));
                                                 jLabel6.setIcon(ic);
                                                // jLabel4_stattus.setText("User Password Is Change");
                                             }
                                             else
                                             {
                                                  jPasswordField1_New_pass.setBackground(Color.red);
                                                 jPasswordField1_old_pass.setBackground(Color.red);
                                                  jLabel4_stattus.setForeground(Color.RED);

                                                  jLabel_image_change_status.setText("ERROR! Password Not Change.");
                             //                    jLabel4_stattus.setText("ERROR! Password Not Change.");
                                             }
                                         } catch (SQLException ex) {
                                             Logger.getLogger(Change_password.class.getName()).log(Level.SEVERE, null, ex);
                                         } // cathch
                                    } // Joption Pane
                                } // if user type  = 1 (User)

                    
                        
                        
                    {
                       // JOPTION PANE

                }

       }// if for admin selected   
                    
                    
    
    }//GEN-LAST:event_btn_saveActionPerformed

    private void jPasswordField1_New_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1_New_passActionPerformed
       
        
    }//GEN-LAST:event_jPasswordField1_New_passActionPerformed

    private void jPasswordField1_old_passFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField1_old_passFocusGained
        // TODO add your handling code here:
        jPasswordField1_old_pass.setBackground(null);
         jLabel4_stattus.setText("");
    }//GEN-LAST:event_jPasswordField1_old_passFocusGained

    private void jPasswordField1_New_passFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField1_New_passFocusGained
        // TODO add your handling code here:
        jPasswordField1_New_pass.setBackground(null);
         jLabel4_stattus.setText("");
    }//GEN-LAST:event_jPasswordField1_New_passFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancle;
    private javax.swing.JButton btn_save;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel2_type_display;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel4_stattus;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_image_change_status;
    private javax.swing.JPasswordField jPasswordField1_New_pass;
    private javax.swing.JPasswordField jPasswordField1_old_pass;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1_user_name;
    // End of variables declaration//GEN-END:variables
}
