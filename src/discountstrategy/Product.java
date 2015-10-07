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
public class Product {
    private String prodId;
    private String Name;
    private double unitPrice;
    private DiscountStrategy discount;

    public Product(String prodId, String Name, double unitPrice, DiscountStrategy discount) {
        this.prodId = prodId;
        this.Name = Name;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }
    
     public final double getDiscountProductTotal( int quantity){
        return discount.getDiscountProductTotal(unitPrice,quantity);
    };

    public final double getAmountSaved( int quantity){
        return discount.getAmountSaved(unitPrice, quantity);
    };
    
    public final String getProdId() {
        return prodId;
    }

    public final void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public final String getName() {
        return Name;
    }

    public final void setName(String Name) {
        this.Name = Name;
    }

    public final double getUnitPrice() {
        return unitPrice;
    }

    public final void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public final DiscountStrategy getDiscount() {
        return discount;
    }

  public final void setDiscount(DiscountStrategy discount) {
        this.discount = discount;
    }
    public static void main(String[] args) {
        Product product = new Product("A100","Hat",20.00,new PercentOffDiscount(.10));
        double amountSaved= product.getAmountSaved(2);
        System.out.println("Expect 2.00, and got:" + amountSaved);
    }
    
}
