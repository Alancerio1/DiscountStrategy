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
public class Customer {
    private String custId;
    private String name;
    private String address;
    private String city;
    private String State;

    public Customer(String customerId, String name, String address, String city, String State) {
        this.custId = customerId;
        this.name = name;
        this.address = address;
        this.city = city;
        this.State = State;
    }

   
    
    public final String getCustomerId() {
        return custId;
    }

    public final void setCustomerId(String customerId) {
        this.custId = customerId;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getAddress() {
        return address;
    }

    public final void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    Object append(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

  
    
    
}
