package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application{

    @Override
    public void start(Stage window) throws Exception{
        
        BorderPane layout = new BorderPane();
        
        HBox menu = new HBox();
        
        Button firstB = new Button("Joke");
        Button secondB = new Button("Answer");
        Button thirdB = new Button("Explanation");
        
        menu.getChildren().addAll(firstB, secondB, thirdB);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);
        
        layout.setTop(menu);        

        StackPane firstView = new StackPane(new Label("What do you call a bear with no teeth?"));
        StackPane secondView = new StackPane(new Label("A gummy bear."));
        StackPane thirdView = new StackPane(new Label("It's a sweet joke :)"));
        
        layout.setCenter(firstView);
        
        firstB.setOnAction((event) -> layout.setCenter(firstView));
        secondB.setOnAction((event) -> layout.setCenter(secondView));
        thirdB.setOnAction((event) -> layout.setCenter(thirdView));
        
        Scene scene = new Scene(layout, 300, 180);
        
        window.setTitle("Jokes Application");
        window.setScene(scene);
        window.show();
    }    
    
    public static void main(String[] args) {
        
        launch(JokeApplication.class);
    }
    
}
