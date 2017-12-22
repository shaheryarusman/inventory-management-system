package Bill;

import Data_base_Conection.DataBase_connection;
import Bill.Bill_search;
import Login.Main_page;
import static Login.Main_page.con;
import Products.View_product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
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
public class Daily_sale extends javax.swing.JInternalFrame {

    /**
     * Creates new form Daily_sale
     */
    
    public Daily_sale() throws SQLException {
        initComponents();
        // for show in label
          Date date = new Date();
        SimpleDateFormat dateformat11 =new SimpleDateFormat("dd-MM-yyyy");
        jLabel_date_sho.setText(dateformat11.format(date));        
        Date time = new Date(); 
        SimpleDateFormat timeformat11 =new SimpleDateFormat("hh:mm:ss");
        jLabel_time_show.setText(timeformat11.format(time));
        // for search in database
        
        String Date_1 = "";
        String mounth = "";
        String year = "";
        SimpleDateFormat format_for_date =new SimpleDateFormat("dd");
        Date_1 = format_for_date.format(date);
        SimpleDateFormat format_for_mounth =new SimpleDateFormat("MMM");
        mounth = format_for_mounth.format(date);
        SimpleDateFormat format_for_year =new SimpleDateFormat("yyyy");
        year = format_for_year.format(date);
        String whole_date = Date_1+"-"+mounth+"-"+year;
        System.out.println(""+whole_date);
        PreparedStatement ps =null;
        ResultSet rs=null;
       
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
                 ps.setString(1,whole_date);
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

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_time_show = new javax.swing.JLabel();
        jLabel_date_sho = new javax.swing.JLabel();
        jButton_btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Daily Sale Records");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("AR BONNIE", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Current Date :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 113, -1));

        jLabel2.setFont(new java.awt.Font("AR BONNIE", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Current Time : ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, -1, -1));

        jLabel_time_show.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel_time_show.setForeground(new java.awt.Color(255, 102, 0));
        jLabel_time_show.setText("jLabel4");
        getContentPane().add(jLabel_time_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 58, 103, -1));

        jLabel_date_sho.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel_date_sho.setForeground(new java.awt.Color(255, 102, 0));
        getContentPane().add(jLabel_date_sho, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 20, 104, 20));

        jButton_btn.setBackground(new java.awt.Color(255, 102, 0));
        jButton_btn.setText("Print");
        jButton_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_btnActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(713, 451, 126, 51));

        jLabel5.setFont(new java.awt.Font("AR BONNIE", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 153));
        jLabel5.setText("Daily Sale Record");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 11, 251, 60));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 107, 909, 314));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bill/off-white-gradient-background-health-nuts-media-beautiful.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_btnActionPerformed
        
         Date date = new Date();
        SimpleDateFormat dateformat11 =new SimpleDateFormat("dd-MM-yyyy");
        jLabel_date_sho.setText(dateformat11.format(date));        
        Date time = new Date(); 
        SimpleDateFormat timeformat11 =new SimpleDateFormat("hh:mm:ss");
        jLabel_time_show.setText(timeformat11.format(time));
        // for search in database
        
        String Date_1 = "";
        String mounth = "";
        String year = "";
        SimpleDateFormat format_for_date =new SimpleDateFormat("dd");
        Date_1 = format_for_date.format(date);
        SimpleDateFormat format_for_mounth =new SimpleDateFormat("MMM");
        mounth = format_for_mounth.format(date);
        SimpleDateFormat format_for_year =new SimpleDateFormat("yyyy");
        year = format_for_year.format(date);
        String whole_date = Date_1+"-"+mounth+"-"+year;
        
        try {
            // C:\Users\Shahyar\Desktop
            //JasperDesign jd  = JRXmlLoader.load("C:\\Users\\Shahyar\\Documents\\NetBeansProjects\\Report_practise\\report2.jrxml");
              //String sql =  "select * from account";
              JasperDesign jd  = JRXmlLoader.load("C:\\Users\\Shahyar\\Documents\\NetBeansProjects\\Inventory_managment\\Reports\\Bills\\daily_sales.jrxml");

             String sql =  "select Bill_Amount.Bill_ID , Bill_Product.Date_ , Bill_Product.Time_ , Bill_Amount.customer_name ,  Bill_Product.Prodcut_name ,\n" +
" Bill_Product.Quantity , Bill_Product.Rate ,  Bill_Amount.Bill_Amount \n" +
" from \n" +
" Bill_Amount\n" +
" right join\n" +
" Bill_Product\n" +
" on \n" +
" Bill_Amount.Bill_ID = Bill_Product.Bill_ID\n" +
" where\n" +
" Date_ = '"+whole_date+"'\n" +
" order by \n" +
" Bill_ID";
            
            
            JRDesignQuery  newquer  = new JRDesignQuery();
             newquer.setText(sql);
            jd.setQuery(newquer);
            JasperReport jr =  JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null , con);
             JasperViewer.viewReport(jp,false);
        } catch (JRException ex) {
            Logger.getLogger(View_product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_date_sho;
    private javax.swing.JLabel jLabel_time_show;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
