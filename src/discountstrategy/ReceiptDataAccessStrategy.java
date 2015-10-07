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
public interface ReceiptDataAccessStrategy {
    Product findProduct(String prodId);
    Customer findCustomer(String custId);
}
