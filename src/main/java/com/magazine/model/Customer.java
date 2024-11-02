package com.magazine.model;

import java.io.Serializable;
import java.util.*;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private Address address;
    private String email;
    private List<Supplement> supplements;
    
    public Customer(String name, Address address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.supplements = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<Supplement> getSupplements() {
        return new ArrayList<>(supplements);
    }
    
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }
    
    public void removeSupplement(Supplement supplement) {
        supplements.remove(supplement);
    }
}