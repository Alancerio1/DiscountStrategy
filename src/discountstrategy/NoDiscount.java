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
public class NoDiscount implements DiscountStrategy{
    
    private double discountRate;

    @Override
    public double getAmountSaved(double unitPrice, int quantity) {
        return 0;
    };

    @Override
    public double getDiscountProductTotal(double unitPrice, int quantity) {
        return 0;
    };

    @Override
    public double getDiscountRate() {
        return 0;
    };

    @Override
    public void setDiscountRate(double discountRate) {
    };
}
