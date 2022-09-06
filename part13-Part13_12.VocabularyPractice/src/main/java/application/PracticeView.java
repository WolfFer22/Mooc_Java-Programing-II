
package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class PracticeView {

    private Dictionary dictionary;
    private Statistics statistics;
    private String word;

    public PracticeView(Dictionary dictionary, Statistics statistics) {
        
        this.dictionary = dictionary;
        this.statistics = statistics;
        
        if (dictionary.wordCount() > 1){
            this.word = dictionary.getRandomWord();
        } else {
            dictionary.add("word", "palavra");
            this.word = dictionary.getRandomWord();
        }    
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Label wordInstruction = new Label("Translate the word '" + this.word + "'");
        TextField translationField = new TextField();
        Button addButton = new Button("Check");
        Label feedback = new Label("");   
        
        // Add statistics Box(Labels)       
        Label guesses = new Label("Guesses: 0");
        Label correctGuesses = new Label("Correct Guesses: 0");
        
        HBox statisticsText = new HBox();
        statisticsText.setSpacing(10);
        statisticsText.getChildren().addAll(guesses, correctGuesses);
 
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        layout.add(wordInstruction, 0, 0);
        layout.add(translationField, 0, 1);
        layout.add(addButton, 0, 2);
        layout.add(feedback, 0, 3);
        layout.add(statisticsText, 0, 4);

        addButton.setOnMouseClicked((event) -> {
            String translation = translationField.getText();
            
            if (dictionary.get(word).equals(translation)) { 
                
                statistics.incrementCorrectGuesses();
                statistics.incrementGuesses();
                
                feedback.setText("Correct!");                
                
            } else {
                
                statistics.incrementGuesses();
                
                feedback.setText("Incorrect! The translation fo the word '" + word + "' is '" + dictionary.get(word) + "'.");
                return;
            }

            this.word = this.dictionary.getRandomWord();
            wordInstruction.setText("Translate the word '" + this.word + "'");
            translationField.clear();
            
            guesses.setText("Guesses: " + statistics.getGuesses());
            correctGuesses.setText("Correct Guesses: " + statistics.getCorrectGuesses());
        });

        return layout;
    }
}