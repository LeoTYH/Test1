package com.magazine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import com.magazine.ui.HomeScreen;
import com.magazine.model.MagazineService;

public class Main extends Application {
    private MagazineService magazineService;

    @Override
    public void start(Stage primaryStage) {
        magazineService = MagazineService.getInstance();
        
        // Create mode selection dialog
        ChoiceDialog<String> modeDialog = new ChoiceDialog<>("View", "View", "Edit", "Create");
        modeDialog.setTitle("Magazine Service");
        modeDialog.setHeaderText("Select Mode");
        modeDialog.setContentText("Choose operation mode:");
        
        modeDialog.showAndWait().ifPresent(mode -> {
            HomeScreen homeScreen = new HomeScreen(magazineService, mode);
            Scene scene = new Scene(homeScreen, 1024, 768);
            scene.getStylesheets().add(getClass().getResource("/styles/main.css").toExternalForm());
            
            primaryStage.setTitle("Magazine Service Management");
            primaryStage.setScene(scene);
            primaryStage.show();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}