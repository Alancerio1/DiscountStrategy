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
public class QuantityDiscount implements DiscountStrategy {
    
    private double discountRate;
    private double minQuantity;

    public QuantityDiscount(double discountRate,int minQuantity) {
        this.discountRate = discountRate;
        this.minQuantity= minQuantity;
    }
    
    @Override
     public double getDiscountProductTotal(double unitPrice, int quantity){
         if(quantity >= minQuantity){
        return (unitPrice * quantity) - getAmountSaved(unitPrice,quantity);
         }else{
             return unitPrice * quantity;
         }
    };
    
    @Override
    public double getAmountSaved(double unitPrice, int quantity){
        if(quantity >= minQuantity){
        return unitPrice * quantity * discountRate;
        }else{
            return 0;
        }
    };

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(double minQuantity) {
        this.minQuantity = minQuantity;
    }
    
    
}
