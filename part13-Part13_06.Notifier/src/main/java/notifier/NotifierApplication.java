package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class NotifierApplication extends Application{
    
    @Override
    public void start(Stage window) {

        TextField txtField = new TextField(); 
        
        Label label = new Label();
        
        Button button = new Button("Update");
        button.setOnAction((event -> {
            label.setText(txtField.getCharacters().toString());
        }));
        
        VBox components = new VBox();
        components.getChildren().addAll(txtField, button, label);        
        
        Scene scene = new Scene(components, 720, 480);
        
        window.setScene(scene);
        window.show();        
    }

    public static void main(String[] args) {
        
        launch(NotifierApplication.class);
        System.out.println("Hello world!");
    }

}
