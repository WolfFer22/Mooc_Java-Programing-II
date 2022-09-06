package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage window) {
        
        BorderPane layout = new BorderPane();
        
        HBox buttons = new HBox();
        buttons.setSpacing(5);
        buttons.getChildren().add(new Button("First"));
        buttons.getChildren().add(new Button("Second"));
        buttons.getChildren().add(new Button("Third"));
        
        VBox leftTexts = new VBox();
        leftTexts.setSpacing(10);
        leftTexts.getChildren().add(new Label("First"));
        leftTexts.getChildren().add(new Label("Second"));
        leftTexts.getChildren().add(new Label("Third"));

        HBox rightTexts = new HBox();
        rightTexts.setSpacing(10);
        rightTexts.getChildren().add(new Label("Letters: 0"));
        rightTexts.getChildren().add(new Label("Words: 0"));
        rightTexts.getChildren().add(new Label("The longest word is:"));
        
        layout.setTop(buttons);
        layout.setCenter(new TextArea(""));        
        layout.setBottom(rightTexts);

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        
        launch(TextStatisticsApplication.class);
        System.out.println("Hello world!");
    }

}
