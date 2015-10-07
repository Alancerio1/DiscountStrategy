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
public class LineItem {
    private int quantity;
    private Product product;
    private final ReceiptDataAccessStrategy db;

    public LineItem(ReceiptDataAccessStrategy db,int quantity, String prodId) {
        this.db = db;
        setQuantity(quantity);
        this.product = db.findProduct(prodId);
    }

   
//    public final Product findProduct(final String prodId){
//        return db.findProduct(prodId);
//    }
    
    public final double getSubTotal(){
        return product.getUnitPrice()* quantity;
    }
    public final double getSubTotalDiscount(){
        return product.getAmountSaved(quantity);
    }
    public final String getProdId(){
        return product.getProdId();
    }
    public final String getName(){
        return product.getName();
    }
    public  final double getUnitPrice(){
        return product.getUnitPrice();
    }

    public final double getQuantity() {
        return quantity;
    }

    public final void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        this.product = product;
    }
   
   
}