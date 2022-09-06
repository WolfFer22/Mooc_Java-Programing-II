package ticTacToe;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {
    
    private ArrayList<Button> buttons;
    private String turn;

    public TicTacToeApplication() {        
        this.buttons = new ArrayList<>();
        this.turn = "X";
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();
        
        Label turnInformation = new Label("Turn: X");
        turnInformation.setFont(Font.font("Monospaced", 20));

        GridPane gameBoard = new GridPane();
           
        for (int x = 1; x <= 3; x++){            
            for (int y = 1; y <= 3 ; y++){                
                Button button = new Button(" ");                
                button.setFont(Font.font("Monospaced", 20));
                button.setMinSize(50, 50);
                button.setBackground(new Background(new BackgroundFill(Color.SILVER,CornerRadii.EMPTY, Insets.EMPTY)));
                
                gameBoard.add(button, x, y);  
                this.buttons.add(button);
                /* GridPan(position)        ArrayList[i]
                  {(1,1),(2,1),(3,1)}      {[0],[3],[6}}
                  {(1,2),(2,2),(3,2)}  <=> {[1],[4],[7]}
                  {(1,3),(2,3),(3,3)}      {[2],[5],[8]}*/
            }
        } 
        
        
        gameBoard.setAlignment(Pos.CENTER);
        gameBoard.setHgap(10);
        gameBoard.setVgap(10);
        gameBoard.setPadding(new Insets(10, 10, 10, 10));

        layout.setTop(turnInformation);
        layout.setCenter(gameBoard);
        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTSLATEGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        buttonOnAction(turnInformation, buttons);        
        
        Scene view = new Scene(layout);
        
        stage.setScene(view);        
        stage.setTitle("TicTacToe");
        stage.show();
    }

    public void styleButton(Button button) {
        button.setFont(Font.font("Monospaced", 20));
        button.setMinSize(50, 50);
        button.setBackground(new Background(new BackgroundFill(Color.SILVER, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void changeLabelText(Label label) {           
        if(endGame()) {
            label.setText("The end!"); 
            
        } else {
            if (label.getText().equals("Turn: X")) {                               
                label.setText("Turn: O");
                
            } else {
                label.setText("Turn: X"); 
                
            }    
        }        
    }

    public void buttonOnAction(Label label, ArrayList<Button> buttons) {                
        for (int i = 0; i < buttons.size(); i++){
            Button button = buttons.get(i);
            
            buttons.get(i).setOnAction(event -> {
                if (button.getText().equals(" ")) {
                    String labelText = label.getText().trim();
                    char[] chrs = labelText.toCharArray();
                    char lastChar = chrs[chrs.length - 1];
                    this.turn = "" + lastChar;
                    
                    if (!this.turn.equals("!")){
                        button.setText(this.turn);                             
                        changeLabelText(label);
                    }                                
                }          
            });            
        }        
    }
    
    public boolean endGame(){        
        for (int i = 0; i < this.buttons.size(); i++){            
            /*ArrayList[i]
             {[0],[3],[6}}
             {[1],[4],[7]}
             {[2],[5],[8]}*/
            
            //check collumns
            if (!this.buttons.get(0).getText().equals(" ") &&
                this.buttons.get(0).getText().equals(this.buttons.get(1).getText()) &&
                this.buttons.get(0).getText().equals(this.buttons.get(2).getText())){
                return true;
            }
            if (!this.buttons.get(3).getText().equals(" ") &&
                this.buttons.get(3).getText().equals(this.buttons.get(4).getText()) &&
                this.buttons.get(3).getText().equals(this.buttons.get(5).getText())){
                return true;
            }
            if (!this.buttons.get(6).getText().equals(" ") &&
                this.buttons.get(6).getText().equals(this.buttons.get(7).getText()) &&
                this.buttons.get(6).getText().equals(this.buttons.get(8).getText())){
                return true;
            }
            //check rows
            if (!this.buttons.get(0).getText().equals(" ") &&
                this.buttons.get(0).getText().equals(this.buttons.get(3).getText()) &&
                this.buttons.get(0).getText().equals(this.buttons.get(6).getText())){
                return true;
            }
            if (!this.buttons.get(1).getText().equals(" ") &&
                this.buttons.get(1).getText().equals(this.buttons.get(4).getText()) &&
                this.buttons.get(1).getText().equals(this.buttons.get(7).getText())){
                return true;
            }
            if (!this.buttons.get(2).getText().equals(" ") &&
                this.buttons.get(2).getText().equals(this.buttons.get(5).getText()) &&
                this.buttons.get(2).getText().equals(this.buttons.get(8).getText())){
                return true;
            }
            //check diagonals
            if (!this.buttons.get(0).getText().equals(" ") &&
                this.buttons.get(0).getText().equals(this.buttons.get(4).getText()) &&
                this.buttons.get(0).getText().equals(this.buttons.get(8).getText())){
                return true;
            }
            if (!this.buttons.get(2).getText().equals(" ") &&
                this.buttons.get(2).getText().equals(this.buttons.get(4).getText()) &&
                this.buttons.get(2).getText().equals(this.buttons.get(6).getText())){
                return true;
            }
            //check all
            if (!this.buttons.get(0).getText().equals(" ") &&
                !this.buttons.get(1).getText().equals(" ") &&
                !this.buttons.get(2).getText().equals(" ") &&
                !this.buttons.get(3).getText().equals(" ") &&
                !this.buttons.get(4).getText().equals(" ") &&
                !this.buttons.get(5).getText().equals(" ") &&
                !this.buttons.get(6).getText().equals(" ") &&
                !this.buttons.get(7).getText().equals(" ") &&
                !this.buttons.get(8).getText().equals(" ")){                
                return true;
            }
        }        
        return false;
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);        
    }

}
