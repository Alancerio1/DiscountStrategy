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
public class FakeDatabase implements ReceiptDataAccessStrategy {
   
    
    private final Customer[] customers = {
        new Customer("100","John Smith","1234 main Street","Pewaukee","WI"),
        new Customer("200", "Sally Jones","1111 main Street","Milwaukee","WI"),
        new Customer("300", "Bob Clementi","2222 main Street","West Allis","WI")
    };
    

    
    private final Product[] products = {
        new Product("A101", "MLB Brewer's Hat ", 19.95, new PercentOffDiscount(0.15)),
        new Product("B205", "Men's Dress Shirt", 35.50, new QuantityDiscount(.10,5)),
        new Product("C222", "Women's Socks    ", 9.50, new NoDiscount())
    };
    
    /**
     * Tries to find a Customer by customer id.
     * @param custId - must not be null or empty
     * @return found Customer or null if not found or bad argument
     */
    
   
    @Override
    public final Customer findCustomer(final String custId) {
        if(custId == null || custId.length() == 0) {
            System.out.println("Sorry, FakeDatabase.findCustomer method has "
                    + "illegal argument");
            return null;  
        }
        
        Customer customer = null;
        for(Customer c : customers) {
            if(custId.equals(c.getCustomerId())) {
                customer = c;
                break;
            }
        }
        
        return customer;
    }
    
    /**
     * Tries to find a Proudct by product id.
     * @param prodId - must not be null or empty
     * @return found Product or null if not found or bad argument
     */
    
    @Override
    public final Product findProduct(final String prodId) {    
        if(prodId == null || prodId.length() == 0) {
            System.out.println("Sorry, FakeDatabase.findProduct method has "
                    + "illegal argument");
            return null;  
        }
        
        Product product = null;
        for(Product p : products) {
            if(prodId.equals(p.getProdId())) {
                product = p;
                break;
            }
        }
        
        return product;
    }

   

    
}
