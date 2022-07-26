package FlightControl;

import flightControl.logic.FlightControl;
import flightControl.ui.TextUI;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        FlightControl control = new FlightControl();
                
        TextUI ui = new TextUI(control, sc);
        
        ui.start();
    }
}