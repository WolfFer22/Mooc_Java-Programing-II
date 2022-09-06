
package buttonandlabel;

//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.stage.Stage;
//
//public class ButtonAndLabelApplication extends Application{
//    
//    @Override
//    public void start(Stage window) {
//        
//        Group root = new Group();
//        
//        Scene scene = new Scene(root, 720, 480);
//        
//        Label label = new Label("This is a label");   
//        label.setLayoutX(0);
//        label.setLayoutY(0);
//        
//        Button button = new Button("This is a button"); 
//        button.setLayoutX(0);
//        button.setLayoutY(20);        
//               
//        root.getChildren().add(label);
//        root.getChildren().add(button);        
//
//        window.setScene(scene);
//        window.show();
//    }
//
//    public static void main(String[] args) {    
//        
//        launch(ButtonAndLabelApplication.class);
//    }
//}
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {

    @Override
    public void start(Stage window) {
        Button buttonComponent = new Button("This is a button");
        Label textComponent = new Label("Text element");

        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(buttonComponent);
        componentGroup.getChildren().add(textComponent);

        Scene view = new Scene(componentGroup, 40, 40);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }
}