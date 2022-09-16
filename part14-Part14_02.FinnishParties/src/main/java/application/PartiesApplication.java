
package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        // create the x and y axis
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        // create the line chart. The values of the chart are given as numbers
        // and it uses the axes we created earlier
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");
        
        // read data from file
        ArrayList<String> fileData = new ArrayList<>();
        getDataFromFile("partiesdata.tsv", fileData);   
        
        // handle data
        PartyCollection partyCollection = new PartyCollection(); 
        handleData(fileData, partyCollection);
        
        // go through the parties and add them to the chart
        partyCollection.getPartyData().entrySet().stream().forEach(party -> {
            // a different data set for every party
            XYChart.Series data = new XYChart.Series();
            data.setName(party.getKey());

            // add the party's support numbers to the data set
            partyCollection.getPartyData().get(data.getName()).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });

            // and add the data set to the chart
            lineChart.getData().add(data);
        });

        // display the line chart
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
        
    }
    
    public static void getDataFromFile(String file, ArrayList<String> rows) throws Exception {        
        try {
            Files.lines(Paths.get(file))
                .forEach((line -> rows.add(line)));
            
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    private static void handleData(ArrayList<String> rows, PartyCollection partyCollection) {                       
        ArrayList<Integer> years = new ArrayList<>();         
        // handle firs row
        String[] firstRowParts = rows.get(0).split("\t");
        
        for (int i = 1; i < firstRowParts.length; i++) {
            years.add(Integer.valueOf(firstRowParts[i]));                                            
        }                
        // handle remaining rows
        for (int j = 1; j < rows.size(); j++){            
            String[] parts = rows.get(j).split("\t");            
            Party party = new Party(parts[0]);          
                                  
            for (int k = 1; k < parts.length; k++){
                if (!parts[k].equals("-")){
                    party.addPartyResults(years.get(k - 1), Double.valueOf(parts[k]));                                       
                }                              
            }             
            partyCollection.addPartyData(party);
        }        
    }
    
    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

}

//OTHER WAYS:
// 
//public class PartiesApplication extends Application{
//    
//    @Override
//    public void start(Stage stage) throws Exception {
//        // create the x and y axis
//        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
//        NumberAxis yAxis = new NumberAxis(0, 30, 5);
//
//        // create the line chart. The values of the chart are given as numbers
//        // and it uses the axes we created earlier
//        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
//        lineChart.setTitle("Relative support of the parties");
//        
//        // read data from file
//        ArrayList<String> rows = new ArrayList<>();
//        getDataFromFile("partiesdata.tsv", rows);
//        
//        HashMap<String, HashMap<Integer, Double>> values = new HashMap<>();
//        handleData(rows, values);
//
//
//        values.keySet().stream().forEach(party -> {
//            // a different data set for each party
//            XYChart.Series data = new XYChart.Series();
//            data.setName(party);
//
//            // add the party's support numbers to the data set
//            values.get(party).entrySet().stream().forEach(pair -> {
//                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
//            });
//
//            // and add the data to the chart
//            lineChart.getData().add(data);
//        });  
//
//        // display the line chart
//        Scene view = new Scene(lineChart, 640, 480);
//        stage.setScene(view);
//        stage.show();
//        
//    }
//    
//    public static void getDataFromFile(String file,  ArrayList<String> rows) throws Exception {        
//        try {
//            Files.lines(Paths.get(file))                    
//                .forEach((row -> rows.add(row)));
//            
//        } catch (IOException e) {
//            System.out.println("ERROR: " + e);
//        }
//    }
//    
//    public static void handleData(ArrayList<String> rows, HashMap<String, HashMap<Integer, Double>> map) {     
//        ArrayList<Integer> years = new ArrayList<>();         
//        // handle firs row
//        String[] firstRowParts = rows.get(0).split("\t");
//        
//        for (int i = 1; i < firstRowParts.length; i++) {
//            years.add(Integer.valueOf(firstRowParts[i]));                                            
//        }                
//        // handle remaining rows
//        for (int j = 1; j < rows.size(); j++){            
//            String[] parts = rows.get(j).split("\t");
//            String name = parts[0]; 
//            
//            HashMap<Integer, Double> results = new HashMap<>();            
//                                  
//            for (int k = 1; k < parts.length; k++){
//                if (!parts[k].equals("-")){                
//                    results.put(years.get(k - 1), Double.valueOf(parts[k]));                    
//                }                              
//            } 
//            
//            map.put(name, results);
//        }
//    }
//    
//    public static void main(String[] args) {
//        launch(PartiesApplication.class);
//    }
//
//}
