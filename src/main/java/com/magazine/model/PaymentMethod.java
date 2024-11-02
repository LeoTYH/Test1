package com.magazine.model;

import java.io.Serializable;

public abstract class PaymentMethod implements Serializable {
    private static final long serialVersionUID = 1L;
    
    protected String accountHolder;
    
    public PaymentMethod(String accountHolder) {
        this.accountHolder = accountHolder;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public abstract String getPaymentDetails();
}

class CreditCard extends PaymentMethod {
    private static final long serialVersionUID = 1L;
    
    private String cardNumber;
    private String expiryDate;
    
    public CreditCard(String accountHolder, String cardNumber, String expiryDate) {
        super(accountHolder);
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }
    
    @Override
    public String getPaymentDetails() {
        return String.format("Credit Card: **** **** **** %s", 
            cardNumber.substring(cardNumber.length() - 4));
    }
}

class DirectDebit extends PaymentMethod {
    private static final long serialVersionUID = 1L;
    
    private String bankAccount;
    private String bsb;
    
    public DirectDebit(String accountHolder, String bankAccount, String bsb) {
        super(accountHolder);
        this.bankAccount = bankAccount;
        this.bsb = bsb;
    }
    
    @Override
    public String getPaymentDetails() {
        return String.format("Direct Debit: BSB: %s, Account: ***%s", 
            bsb, bankAccount.substring(bankAccount.length() - 3));
    }
}