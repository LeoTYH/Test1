package com.magazine.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BillingRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private LocalDate date;
    private BigDecimal amount;
    private String description;
    private boolean paid;
    
    public BillingRecord(LocalDate date, BigDecimal amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.paid = false;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    
    public String getDescription() {
        return description;
    }
    
    public boolean isPaid() {
        return paid;
    }
    
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}