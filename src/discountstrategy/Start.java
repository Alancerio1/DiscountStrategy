/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author alancerio18
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CashRegister cr = new CashRegister();
        
        
        cr.NewSale("200", new FakeDatabase(), new ReceiptConsoleOutput());
        cr.addItemToSale("C222", 2);
        cr.addItemToSale("B205", 1);
        cr.endSaleAndOutputReceipt();
    }
    
}
