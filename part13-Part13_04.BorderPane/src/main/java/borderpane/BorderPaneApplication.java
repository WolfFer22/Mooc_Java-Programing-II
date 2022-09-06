package borderpane;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneApplication extends Application {

    @Override
    public void start(Stage window) throws Exception {
        
        BorderPane layout = new BorderPane();
        
        Label topEdge = new Label("NORTH");          
        layout.setTop(topEdge);
        
        Label rightEdge = new Label("EAST");          
        layout.setRight(rightEdge);  
        
        Label bottonEdge = new Label("SOUTH");          
        layout.setBottom(bottonEdge);

        Scene view = new Scene(layout, 720, 480);

        window.setScene(view);
        window.show();
        
    }


    public static void main(String[] args) {
        
        launch(BorderPaneApplication.class);
        System.out.println("Hello world!");
    }    

}
