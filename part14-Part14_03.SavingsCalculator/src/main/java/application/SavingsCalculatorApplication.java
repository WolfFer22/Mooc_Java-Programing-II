package application;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {
    
    private int years;

    public SavingsCalculatorApplication() {         
//        System.out.println("How many years?");
//        Scanner scan = new Scanner(System.in);
//        this.years = Integer.valueOf(scan.nextLine());
        this.years = 30;           
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20, 20, 20, 20));
        

        //TOP VIEW 
        VBox slidersData = new VBox();
        slidersData.setAlignment(Pos.CENTER);
        slidersData.setSpacing(20); 
        
        //slider savings(1st slider)
        BorderPane MonthlySavings = new BorderPane();  
        
        Label savings = new Label("Monthly savings");
        
        Slider sliderSavings = new Slider(25, 250, 25);
        sliderSavings.setShowTickMarks(true); 
        sliderSavings.setShowTickLabels(true);               
        sliderSavings.setBlockIncrement(1);
        
        Label savingsValue = new Label("25");
        
        MonthlySavings.setLeft(savings);
        MonthlySavings.setCenter(sliderSavings);
        MonthlySavings.setRight(savingsValue); 
        MonthlySavings.setPadding(new Insets(10));
        
        //slider interest rate(2nd slider)
        BorderPane YearlyInterestRate = new BorderPane();    
        
        Label interestRate = new Label("Yearly interest rate");        
        Slider sliderInterestRate = new Slider(0, 10, 0);
        sliderInterestRate.setBlockIncrement(0.1);
        sliderInterestRate.setShowTickLabels(true);
        sliderInterestRate.setShowTickMarks(true);
        
        Label interestRateValue = new Label("0");
        
        YearlyInterestRate.setLeft(interestRate);
        YearlyInterestRate.setCenter(sliderInterestRate);
        YearlyInterestRate.setRight(interestRateValue);   
        YearlyInterestRate.setPadding(new Insets(10));
        
        layout.setTop(slidersData);
        
        //linear chart
        NumberAxis xAxis = new NumberAxis(0, this.years, 1);
        xAxis.setLabel("[ Years ]");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("[ € ]");
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings");
        lineChart.setLegendVisible(false);
        
        layout.setCenter(lineChart);
        
        //get data and handle it
        HashMap<String, HashMap<Integer, Double>> values = new HashMap<>(); 
        
        //chart output of sliders input                
        sliderSavings.valueProperty().addListener((ObservableValue <? extends Number>
                observable, Number oldValue, Number newValue) -> { 

            double savingValue = Math.floor(newValue.doubleValue());
            savingsValue.setText(String.valueOf(savingValue));

            lineChart.getData().clear();                
            handleValues(savingsValue, interestRateValue, values);

            values.keySet().stream().forEach(entrySaving -> {                
                XYChart.Series series = new XYChart.Series();
                series.setName(entrySaving);

                values.get(entrySaving).entrySet().stream().forEach(pair -> {
                    series.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));                              
                });

                lineChart.getData().add(series);                
            });                
            
        }); 

        sliderInterestRate.valueProperty().addListener((ObservableValue <? extends Number>
                observable, Number oldValue, Number newValue) -> {           

            double interestValue = Math.floor(newValue.doubleValue() * 100.0)/100.0;         
            interestRateValue.setText(String.valueOf(interestValue));   
   
            lineChart.getData().clear();                
            handleValues(savingsValue, interestRateValue, values);

            values.keySet().stream().forEach(entrySaving -> {
                XYChart.Series series = new XYChart.Series();
                series.setName(entrySaving);

                values.get(entrySaving).entrySet().stream().forEach(pair -> {
                    series.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
                });

                lineChart.getData().add(series);
            });
 
        });

        slidersData.getChildren().addAll(MonthlySavings, YearlyInterestRate);

        Scene scene = new Scene(layout);
        stage.setTitle("Savings Calculator");
        stage.setScene(scene);
        stage.show();
        
    }    
    
    private void handleValues(Label savingLabel, Label interestLabel, HashMap<String, HashMap<Integer, Double>> savingsMap) {
        
        String originSaving = "Savings";
        String interestSaving = "Savings with interests"; 
        
        double valueDefault = 0.0;
        double saving = Double.valueOf(savingLabel.getText());        
        HashMap<Integer, Double> mapDefault = new HashMap();        
        
        for (int i = 0; i <= this.years; i++) {            
            mapDefault.put(i, valueDefault);
            valueDefault += 12 * saving;            
        }        
        savingsMap.put(originSaving, mapDefault);
        
        double valueInterest = 0.0;    
        double interest = Double.valueOf(interestLabel.getText());        
        HashMap<Integer, Double> mapInterest = new HashMap();
        
        for (int j = 0; j <= this.years; j++) {            
            mapInterest.put(j, valueInterest);
            valueInterest = (valueInterest + (12 * saving)) * ((interest / 100) + 1);
        }        
        savingsMap.put(interestSaving, mapInterest);
        
    }
    
    public static void main(String[] args) {        
        launch(SavingsCalculatorApplication.class);        
    }

}
