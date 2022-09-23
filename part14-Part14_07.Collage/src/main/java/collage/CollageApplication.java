package collage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {

        // the example opens the image, creates a new image, and copies the opened image
        // into the new one, pixel by pixel
        Image sourceImage = new Image("file:monalisa.png");

        PixelReader imageReader = sourceImage.getPixelReader();

        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();

        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter imageWriter = targetImage.getPixelWriter();
        
        int yCoordinate = 0;
        while (yCoordinate < height) {
            int xCoordinate = 0;
            while (xCoordinate < width) {

                Color color = imageReader.getColor(xCoordinate, yCoordinate);
                double red = 1.0 - color.getRed();
                double green = 1.0 - color.getGreen();
                double blue = 1.0 - color.getBlue();
                double opacity = color.getOpacity();

                Color newColor = new Color(red, green, blue, opacity);              

                //imageWriter.setColor(xCoordinate, yCoordinate, newColor);                     
                
                int xCoordinate1 = xCoordinate / 2;
                int yCoordinate1 = yCoordinate / 2;                    
                imageWriter.setColor(xCoordinate1, yCoordinate1, newColor);

                int xCoordinate2 = xCoordinate1 + (width / 2);
                int yCoordinate2 = yCoordinate1;                    
                imageWriter.setColor(xCoordinate2, yCoordinate2, newColor);

                int xCoordinate3 = xCoordinate1;
                int yCoordinate3 = yCoordinate1 + (height / 2);                    
                imageWriter.setColor(xCoordinate3, yCoordinate3, newColor);

                int xCoordinate4 = xCoordinate2;
                int yCoordinate4 = yCoordinate3;                    
                imageWriter.setColor(xCoordinate4, yCoordinate4, newColor);

                xCoordinate += 2;
                //xCoordinate++;
            }

            yCoordinate += 2;
            //yCoordinate++;
        }

        ImageView image = new ImageView(targetImage);      

        Pane pane = new Pane();
        pane.getChildren().add(image);
        
        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
