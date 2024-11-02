package com.magazine.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Magazine implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private BigDecimal weeklyCost;
    
    public Magazine(String name, BigDecimal weeklyCost) {
        this.name = name;
        this.weeklyCost = weeklyCost;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public BigDecimal getWeeklyCost() {
        return weeklyCost;
    }
    
    public void setWeeklyCost(BigDecimal weeklyCost) {
        this.weeklyCost = weeklyCost;
    }
}