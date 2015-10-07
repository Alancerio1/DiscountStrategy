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
public class PercentOffDiscount implements DiscountStrategy {
    
    private double discountRate;

    public PercentOffDiscount(double discountRate) {
        this.discountRate = discountRate;
    }
    
    @Override
     public double getDiscountProductTotal(double unitPrice, int quantity){
        return (unitPrice * quantity) - getAmountSaved(unitPrice,quantity);
    };
    
    @Override
    public double getAmountSaved(double unitPrice, int quantity){
        return unitPrice * quantity * discountRate;
    };

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    public static void main(String[] args) {
        DiscountStrategy discount = new QuantityDiscount(.10, 2);
        double amount = discount.getAmountSaved(10.00, 2);
        System.out.println("Discount Amount:" + amount);
        double newTotal = discount.getDiscountProductTotal(10.00, 2);
        System.out.println("Discounted Product Total:" + newTotal);
    }
    
}
