package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application{

    @Override
    public void start(Stage window) {

        BorderPane firstLayout = new BorderPane();
        firstLayout.setTop(new Label("First View"));
        Button toSecondView = new Button("To second view");
        firstLayout.setCenter(toSecondView);        
        
        VBox secondLayout = new VBox();
        secondLayout.setSpacing(10);
        Button toThirdView = new Button("To the third view");
        Label buttonLabel = new Label("Second view");
        secondLayout.getChildren().addAll(toThirdView, buttonLabel);
        
        GridPane thirdLayout = new GridPane();
        Label gridLabel = new Label("Third view");
        Button toFirstView = new Button("To first view");
        thirdLayout.add(gridLabel, 0, 0);
        thirdLayout.add(toFirstView, 1, 1);
        

        Scene first = new Scene(firstLayout,640, 480);
        Scene second = new Scene(secondLayout, 640, 480);
        Scene third = new Scene(thirdLayout, 640, 480);

        toSecondView.setOnAction((event) -> {            
            window.setScene(second);
        });

        toThirdView.setOnAction((event) -> {
            window.setScene(third);
        });
        
        toFirstView.setOnAction((event) -> {
            window.setScene(first);
        });

        window.setScene(first);
        window.show();
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

}
