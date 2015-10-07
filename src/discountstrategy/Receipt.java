/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author alancerio18
 */
public class Receipt  {
    private Customer customer;
    private LineItem[] lineItem;
    private ReceiptDataAccessStrategy db;
    private ReceiptOutputStrategy output;
    private static int receiptNo = 0;
    private String dateFormat = "M/d/yyyy hh:mm a";
    private Date receiptDate;
    private final String DataSourceError =
            "Data source is a required field";

   public Receipt(String custId, ReceiptDataAccessStrategy db, ReceiptOutputStrategy output) {
        this.setDb(db);
        this.output = output;
        this.customer = db.findCustomer(custId);
        receiptNo++;
        lineItem = new LineItem[0];
        receiptDate = new Date();
    }
  
    public String getReceiptDateFormatted() {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(receiptDate);
    }
    
    public final double getSubTotalBeforeDiscount() {
        double total = 0.0;
        for(LineItem item : lineItem) {
            total += item.getSubTotal();
        }
        return total;
    }
    
     public final double getSubTotalDiscount() {
        double total = 0.0;
        for(LineItem item : lineItem) {
            total += item.getSubTotalDiscount();
        }
        return total;
    }
   
    public final void addLineItem(final String prodId, final int qty) {
        LineItem item = new LineItem(db,qty,prodId);
        addToArray(item);
    }
    
    private void addToArray(final LineItem item) {
        LineItem[] tempItems = new LineItem[lineItem.length + 1];
        System.arraycopy(lineItem, 0, tempItems, 0, lineItem.length);
        tempItems[lineItem.length] = item;
        lineItem = tempItems;
    }
     public final void outputReceipt() {
         NumberFormat nf = NumberFormat.getCurrencyInstance();
       
        StringBuilder receiptData = new StringBuilder("Thank you for shopping at Kohls!\n\n");
        receiptData.append("Sold to: ").append(customer.getName()).append("\n");
        receiptData.append("Date of Sale: ").append(getReceiptDateFormatted()).append("\n");
        receiptData.append("Receipt No.: " ).append(Receipt.receiptNo).append("\n\n");
        
        receiptData.append("ID\tItem\t\t\tPrice\tQty\tSubtotal\tDiscount").append("\n");
        receiptData.append("------------------------------------------------------------------------").append("\n");
        for(LineItem item : lineItem) {
            receiptData.append(item.getProduct().getProdId()).append("\t");
            receiptData.append(item.getProduct().getName()).append("\t");
            receiptData.append(nf.format(item.getProduct().getUnitPrice())).append("\t");
            receiptData.append(item.getQuantity()).append("\t");
            receiptData.append(nf.format(item.getSubTotal())).append("\t\t");
            receiptData.append(nf.format(item.getSubTotalDiscount())).append("\n");
        }
       
        receiptData.append("\n");
        receiptData.append("\t\t\t\t\t\t\t\t--------").append("\n");
        double total = getSubTotalBeforeDiscount();
        receiptData.append("\t\t\t\t\t\tTotal:  \t").append(nf.format(total)).append("\n");
        double totalDiscount = getSubTotalDiscount();
        receiptData.append("\t\t\t\t\t\tTotal Saved: \t-").append(nf.format(totalDiscount)).append("\n");
        double totalDue = total - totalDiscount;
        receiptData.append("\t\t\t\t\t\tTotal Due: \t").append(nf.format(totalDue)).append("\n");
        
       
        output.outputReceipt(receiptData.toString());
       
     }
      public final void setDb(ReceiptDataAccessStrategy db) {
        this.db = db;
    }
}
