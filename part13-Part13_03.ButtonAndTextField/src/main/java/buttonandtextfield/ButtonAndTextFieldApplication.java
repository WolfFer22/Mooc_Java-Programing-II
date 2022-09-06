package buttonandtextfield;

import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import static javafx.scene.control.ContentDisplay.CENTER;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ButtonAndTextFieldApplication  extends Application{
    
    @Override
    public void start(Stage window) {
        
        Group root = new Group();
        
        Scene scene = new Scene(root, 720, 480);
        
        Button button = new Button("I am a button");
        button.setMinSize(90, 50);
        button.setLayoutX(0);
        button.setLayoutY(0); 
        
        TextField textButton = new TextField();  
        textButton.setLayoutX(95);
        textButton.setLayoutY(12.5);        
        textButton.setPrefColumnCount(10);       

        root.getChildren().add(button);
        root.getChildren().add(textButton);
        
        window.setScene(scene);
        window.show();        
    }

    public static void main(String[] args) {
        
        launch(ButtonAndTextFieldApplication.class);
        
        System.out.println("Hello world!");
    }


}
