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
public class CashRegister {
    private Receipt receipt;
    
 public final void endSaleAndOutputReceipt() {
        receipt.outputReceipt();
    }
  public final void addItemToSale(String prodId, int qty) {
           
            receipt.addLineItem(prodId, qty);
    }
  public final void NewSale(String custId, ReceiptDataAccessStrategy db, ReceiptOutputStrategy output) {
        
        receipt = new Receipt(custId, db, output);
    }
}