package application;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class UnfairAdvertisementApplication extends Application {

//    @Override
//    public void start(Stage window) {
//        CategoryAxis xAxis = new CategoryAxis();
//        NumberAxis yAxis = new NumberAxis(75.0, 80.0, 0.1);
//        yAxis.setTickLabelsVisible(true);
//        yAxis.setLabel("Faster and Better!");
//
//        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
//
//        barChart.setTitle("Internet speed");
//        barChart.setLegendVisible(false);
//
//        XYChart.Series speeds = new XYChart.Series();
//        speeds.getData().add(new XYChart.Data("NDA", 77.4));
//        speeds.getData().add(new XYChart.Data("Fastie", 77.2));
//        speeds.getData().add(new XYChart.Data("SuperNet", 77.1));
//        speeds.getData().add(new XYChart.Data("Meganet", 77.1));
//
//        barChart.getData().add(speeds);
//        Scene view = new Scene(barChart, 400, 300);
//        window.setScene(view);
//        window.show();
//    }
//
//    public static void main(String[] args) {
//        launch(UnfairAdvertisementApplication.class);
//    }
//
//}
    @Override
    public void start(Stage stage) {
        // The class Random is used to randomize the dice rolls
        Random random = new Random();

        NumberAxis xAxis = new NumberAxis();
        // y-axes represents the average of the rolls. The average is always between [1-6]
        NumberAxis yAxis = new NumberAxis(1, 6, 1);

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        // removing elements of the chart, e.g. circles on points
        lineChart.setLegendVisible(false);
        lineChart.setAnimated(false);
        lineChart.setCreateSymbols(false);

        // we create a variable representing the data and add it to the chart
        XYChart.Series average = new XYChart.Series();
        lineChart.getData().add(average);

        new AnimationTimer() {
            private long previous;
            private long sum;
            private long count;

            @Override
            public void handle(long current) {
                if (current - previous < 100_000_000L) {
                    return;
                }

                previous = current;

                // roll the dice
                int number = random.nextInt(6) + 1;

                // we grow the sum and increment the count
                sum += number;
                count++;

                // we add a new data point to the chart
                average.getData().add(new XYChart.Data(count, 1.0 * sum / count));

                if (average.getData().size() > 100) {
                    average.getData().remove(0);
                    xAxis.setLowerBound(xAxis.getLowerBound() + 1);
                    xAxis.setUpperBound(xAxis.getUpperBound() + 1);
                }
            }
        }.start();

        Scene scene = new Scene(lineChart, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(UnfairAdvertisementApplication.class);
    }

}