package smiley;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    @Override
    public void start(Stage stage) {

        Canvas paintingCanvas = new Canvas(640, 480);         
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();          
//        painter.setFill(Color.WHITE); //Background color
//        painter.clearRect(0, 0, 640, 480);

        painter.setFill(Color.BLACK);  //Drawing color       
        painter.fillRect(100, 50, 50, 50);
        painter.fillRect(300, 50, 50, 50);
        painter.fillRect(50, 200, 50, 50);
        painter.fillRect(100, 250, 250, 50);
        painter.fillRect(350, 200, 50, 50);

        BorderPane paintingLayout = new BorderPane();
        paintingLayout.setCenter(paintingCanvas);

        Scene view = new Scene(paintingLayout, Color.WHITE);
        
        stage.setScene(view);        
        stage.show();        
    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }
}

