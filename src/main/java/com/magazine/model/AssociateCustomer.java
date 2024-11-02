package com.magazine.model;

public class AssociateCustomer extends Customer {
    private static final long serialVersionUID = 1L;
    
    private PayingCustomer payingCustomer;
    
    public AssociateCustomer(String name, Address address, String email, PayingCustomer payingCustomer) {
        super(name, address, email);
        this.payingCustomer = payingCustomer;
    }
    
    public PayingCustomer getPayingCustomer() {
        return payingCustomer;
    }
    
    public void setPayingCustomer(PayingCustomer payingCustomer) {
        this.payingCustomer = payingCustomer;
    }
}