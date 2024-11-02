package com.magazine.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Supplement implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private BigDecimal weeklyCost;
    private LocalDate startDate;
    
    public Supplement(String name, BigDecimal weeklyCost, LocalDate startDate) {
        this.name = name;
        this.weeklyCost = weeklyCost;
        this.startDate = startDate;
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
    
    public LocalDate getStartDate() {
        return startDate;
    }
    
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}