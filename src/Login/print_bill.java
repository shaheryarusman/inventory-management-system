/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Bill.New_bill;
import static Bill.New_bill.jTextField_puchase_quantity;
import static Login.Main_page.con;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Shahyar
 */
public class print_bill extends javax.swing.JInternalFrame {

    /**
     * Creates new form print_bill
     */
    public print_bill() {
        initComponents();
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
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2_status = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(17, 111, 204));
        jLabel1.setText("Enter Bill ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, 76, 32));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 13, 215, 29));

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("AR BERKLEY", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Print Bill");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 63, 295, 53));
        getContentPane().add(jLabel2_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 122, 295, 15));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/off-white-gradient-background-health-nuts-media-beautiful.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        
        /// jesper report
        
        try {
            
              JasperDesign jd  = JRXmlLoader.load("C:\\Users\\Shahyar\\Documents\\NetBeansProjects\\Inventory_managment\\Reports\\Bills\\invo - Copy.jrxml");
             String id  = jTextField1.getText();
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
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
//jLabel_massage_balance.setText("");
//jLabel_message_quantity.setText("");
        int key = evt.getKeyCode();
        
        if((key >= evt.VK_0&&key<=evt.VK_9) || (key>=evt.VK_NUMPAD0 && key<= evt.VK_NUMPAD9) || key==KeyEvent.VK_BACKSPACE)
        {
            jTextField1.setEditable(true);
            jTextField1.setBackground(Color.yellow);
            jLabel2_status.setText("");
        }
        else
        {
          jTextField1.setEditable(false);
            jTextField1.setBackground(Color.RED);
            jLabel2_status.setForeground(Color.red);
        jLabel2_status.setText("Please Enter Only Numeric Value");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel2_status;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
