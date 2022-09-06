package textstatistics;

import java.lang.reflect.Array;
import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage window) throws Exception{

        BorderPane layout = new BorderPane();
        
        Label lettersLabel = new Label("Letters: 0");
        Label wordsLabel = new Label("Words: 0");
        Label longestWordLabel = new Label("The longest word is: ");        

        TextArea textStatistics = new TextArea();
        textStatistics.textProperty().addListener((change, oldValue, newValue) -> {

            int lettersCount = newValue.length();

            String[] parts = newValue.split(" ");
            int wordsCount = parts.length;

            String longestWord = Arrays.stream(parts)
                    .sorted((w1, w2) -> w2.length() - w1.length())
                    .findFirst()
                    .get();
            
            lettersLabel.setText("Letters: " + lettersCount);
            wordsLabel.setText("Words: " + wordsCount);
            longestWordLabel.setText("The longest word is: " + longestWord);
        });
        
        HBox rightTexts = new HBox();
        rightTexts.setSpacing(10);
        rightTexts.getChildren().addAll(lettersLabel, wordsLabel, longestWordLabel);

        layout.setCenter(textStatistics);
        layout.setBottom(rightTexts);

        Scene scene = new Scene(layout, 720, 480);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {

        launch(TextStatisticsApplication.class);
        System.out.println("Hello world!");
    }

}
