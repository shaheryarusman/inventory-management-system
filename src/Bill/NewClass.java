/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bill;

import java.sql.SQLException;

/**
 *
 * @author Shahyar
 */
public class NewClass {
    public static void main(String[] args) throws SQLException {
        
       
    int id;
    New_bill_bal ob = new New_bill_bal();
    id = ob.getNewBillId();
    
        System.out.println(""+(id+1));
    }
}
