package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.HPos;

public class GreeterApplication extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        
        GridPane grid = new GridPane();        
 
        Label askName = new Label("Enter your name and start.");        
        TextField nameField = new TextField();       
        Button startButton = new Button("Start");
 
        //Adding children to GridPane
        grid.add(askName, 0, 0);
        grid.add(nameField, 0, 1);
        grid.add(startButton, 0, 2);
        
        //Styling GridPane
        /* To enter elements in the Grid individualy
        GridPane.setHalignment(askName, HPos.CENTER);
        GridPane.setHalignment(startButton, HPos.CENTER);*/
        grid.setAlignment(Pos.CENTER);   
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));
        
        Label nameWelcome = new Label();
        nameField.textProperty().addListener((cange, oldValue, newValue) -> {
            String name = newValue;
            nameWelcome.setText("Welcome " + name + "!");
        });
        nameWelcome.setAlignment(Pos.CENTER);
               
        Scene firstView = new Scene(grid, 640, 480);
        Scene secondView = new Scene(nameWelcome, 640, 480);
        
        startButton.setOnAction(event -> {
            stage.setScene(secondView);});
        
        stage.setScene(firstView);
        stage.show();        
    }

    public static void main(String[] args) {
        
        launch(GreeterApplication.class);
    }
    
}
