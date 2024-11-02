package com.magazine.ui;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import com.magazine.model.*;
import javafx.collections.FXCollections;

public class HomeScreen extends BorderPane {
    private MagazineService service;
    private String mode;
    private ListView<Supplement> supplementList;
    private ListView<Customer> customerList;
    private VBox infoPanel;
    
    public HomeScreen(MagazineService service, String mode) {
        this.service = service;
        this.mode = mode;
        
        setupUI();
        loadData();
    }
    
    private void setupUI() {
        // Left panel with lists
        VBox leftPanel = new VBox(10);
        leftPanel.setPadding(new Insets(10));
        
        Label supplementsLabel = new Label("Supplements");
        supplementList = new ListView<>();
        supplementList.setPrefHeight(300);
        
        Label customersLabel = new Label("Customers");
        customerList = new ListView<>();
        customerList.setPrefHeight(300);
        
        leftPanel.getChildren().addAll(
            supplementsLabel, supplementList,
            customersLabel, customerList
        );
        
        // Info panel on the right
        infoPanel = new VBox(10);
        infoPanel.setPadding(new Insets(10));
        infoPanel.setStyle("-fx-background-color: #f4f4f4;");
        
        // Add event handlers
        supplementList.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldVal, newVal) -> showSupplementInfo(newVal));
            
        customerList.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldVal, newVal) -> showCustomerInfo(newVal));
        
        // Add toolbar if in edit or create mode
        if (!mode.equals("View")) {
            ToolBar toolbar = createToolbar();
            setTop(toolbar);
        }
        
        setLeft(leftPanel);
        setCenter(infoPanel);
    }
    
    private ToolBar createToolbar() {
        ToolBar toolbar = new ToolBar();
        
        Button addCustomerBtn = new Button("Add Customer");
        Button addSupplementBtn = new Button("Add Supplement");
        Button saveBtn = new Button("Save Changes");
        
        addCustomerBtn.setOnAction(e -> showAddCustomerDialog());
        addSupplementBtn.setOnAction(e -> showAddSupplementDialog());
        saveBtn.setOnAction(e -> saveChanges());
        
        toolbar.getItems().addAll(addCustomerBtn, addSupplementBtn, saveBtn);
        
        return toolbar;
    }
    
    private void loadData() {
        supplementList.setItems(FXCollections.observableArrayList(service.getSupplements()));
        customerList.setItems(FXCollections.observableArrayList(service.getCustomers()));
    }
    
    private void showSupplementInfo(Supplement supplement) {
        if (supplement == null) return;
        
        infoPanel.getChildren().clear();
        
        Label nameLabel = new Label("Name: " + supplement.getName());
        Label costLabel = new Label("Weekly Cost: $" + supplement.getWeeklyCost());
        Label dateLabel = new Label("Start Date: " + supplement.getStartDate());
        
        // Show subscribed customers
        Label subscribersLabel = new Label("Subscribed Customers:");
        ListView<String> subscribers = new ListView<>();
        
        service.getCustomers().stream()
            .filter(c -> c.getSupplements().contains(supplement))
            .map(Customer::getName)
            .forEach(name -> subscribers.getItems().add(name));
        
        infoPanel.getChildren().addAll(
            nameLabel, costLabel, dateLabel,
            subscribersLabel, subscribers
        );
    }
    
    private void showCustomerInfo(Customer customer) {
        if (customer == null) return;
        
        infoPanel.getChildren().clear();
        
        Label nameLabel = new Label("Name: " + customer.getName());
        Label emailLabel = new Label("Email: " + customer.getEmail());
        Label addressLabel = new Label("Address: " + customer.getAddress().toString());
        
        Label typeLabel = new Label("Type: " + 
            (customer instanceof PayingCustomer ? "Paying Customer" : "Associate Customer"));
        
        // Show supplements
        Label supplementsLabel = new Label("Subscribed Supplements:");
        ListView<String> supplements = new ListView<>();
        customer.getSupplements().stream()
            .map(Supplement::getName)
            .forEach(name -> supplements.getItems().add(name));
        
        infoPanel.getChildren().addAll(
            nameLabel, emailLabel, addressLabel,
            typeLabel, supplementsLabel, supplements
        );
        
        // Show additional info for paying customers
        if (customer instanceof PayingCustomer) {
            PayingCustomer payingCustomer = (PayingCustomer) customer;
            
            Label paymentLabel = new Label("Payment Method: " + 
                payingCustomer.getPaymentMethod().getPaymentDetails());
            
            Label associatesLabel = new Label("Associate Customers:");
            ListView<String> associates = new ListView<>();
            payingCustomer.getAssociateCustomers().stream()
                .map(Customer::getName)
                .forEach(name -> associates.getItems().add(name));
            
            // Show billing history in a separate thread
            Thread billingThread = new Thread(() -> {
                ListView<String> billingHistory = new ListView<>();
                payingCustomer.getBillingHistory().stream()
                    .map(record -> String.format("%s: $%s - %s (%s)",
                        record.getDate(),
                        record.getAmount(),
                        record.getDescription(),
                        record.isPaid() ? "Paid" : "Pending"))
                    .forEach(text -> {
                        javafx.application.Platform.runLater(() ->
                            billingHistory.getItems().add(text));
                    });
                
                javafx.application.Platform.runLater(() -> {
                    Label billingLabel = new Label("Billing History:");
                    infoPanel.getChildren().addAll(billingLabel, billingHistory);
                });
            });
            
            billingThread.start();
            
            infoPanel.getChildren().addAll(
                paymentLabel, associatesLabel, associates
            );
        }
    }
    
    private void showAddCustomerDialog() {
        // Implementation for adding a new customer
    }
    
    private void showAddSupplementDialog() {
        // Implementation for adding a new supplement
    }
    
    private void saveChanges() {
        // Implementation for saving changes
    }
}