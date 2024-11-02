package com.magazine.model;

import java.util.*;

public class PayingCustomer extends Customer {
    private static final long serialVersionUID = 1L;
    
    private PaymentMethod paymentMethod;
    private List<Customer> associateCustomers;
    private List<BillingRecord> billingHistory;
    
    public PayingCustomer(String name, Address address, String email, PaymentMethod paymentMethod) {
        super(name, address, email);
        this.paymentMethod = paymentMethod;
        this.associateCustomers = new ArrayList<>();
        this.billingHistory = new ArrayList<>();
    }
    
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
    
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    public List<Customer> getAssociateCustomers() {
        return new ArrayList<>(associateCustomers);
    }
    
    public void addAssociateCustomer(Customer customer) {
        associateCustomers.add(customer);
    }
    
    public void removeAssociateCustomer(Customer customer) {
        associateCustomers.remove(customer);
    }
    
    public List<BillingRecord> getBillingHistory() {
        return new ArrayList<>(billingHistory);
    }
    
    public void addBillingRecord(BillingRecord record) {
        billingHistory.add(record);
    }
}