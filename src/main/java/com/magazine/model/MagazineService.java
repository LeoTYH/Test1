package com.magazine.model;

import java.io.*;
import java.util.*;

public class MagazineService implements Serializable {
    private static final long serialVersionUID = 1L;
    private static MagazineService instance;
    
    private Magazine magazine;
    private List<Customer> customers;
    private List<Supplement> supplements;
    
    private MagazineService() {
        customers = new ArrayList<>();
        supplements = new ArrayList<>();
    }
    
    public static MagazineService getInstance() {
        if (instance == null) {
            instance = loadFromFile();
            if (instance == null) {
                instance = new MagazineService();
            }
        }
        return instance;
    }
    
    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }
    
    public Magazine getMagazine() {
        return magazine;
    }
    
    public void addCustomer(Customer customer) {
        customers.add(customer);
        saveToFile();
    }
    
    public void removeCustomer(Customer customer) {
        customers.remove(customer);
        saveToFile();
    }
    
    public List<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }
    
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
        saveToFile();
    }
    
    public void removeSupplement(Supplement supplement) {
        supplements.remove(supplement);
        saveToFile();
    }
    
    public List<Supplement> getSupplements() {
        return new ArrayList<>(supplements);
    }
    
    private static MagazineService loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("magazine-service.dat"))) {
            return (MagazineService) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }
    
    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("magazine-service.dat"))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}