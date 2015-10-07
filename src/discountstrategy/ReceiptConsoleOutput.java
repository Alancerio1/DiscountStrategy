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
public class ReceiptConsoleOutput implements ReceiptOutputStrategy {
      @Override
    public void outputReceipt(String data) {
        System.out.println(data);
    }

    @Override
    public void outputMessage(String msg) {
        System.out.println("\n========== Data Entry Error ==========");
        System.out.println(msg);
        System.out.println("=======================================\n");
    }
    
}
