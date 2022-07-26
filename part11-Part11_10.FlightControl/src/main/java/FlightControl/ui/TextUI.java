package flightControl.ui;

import flightControl.domain.Flight;
import flightControl.domain.Airplane;
import java.util.Scanner;
import flightControl.logic.FlightControl;

public class TextUI {

    private FlightControl flightControl;
    private Scanner scanner;

    public TextUI(FlightControl flightControl, Scanner scanner) {
        this.flightControl = flightControl;
        this.scanner = scanner;
    }

    public TextUI() {
    }

    public void start() {
        AssetControl();
        System.out.println();
        FlightControl();
    }

    public void AssetControl() {
        System.out.println("Airport Asset Control\n");
        
        String action;
        do{
            System.out.println("Choose an action:\n"
                    + "[1] Add an airplane\n"
                    + "[2] Add a flight\n"
                    + "[x] Exit Airport Asset Control");
            
            System.out.println("> ");
            action = scanner.nextLine();
            
            if (action.equals("1")){
                addAirplane();                
            }
            
            else if (action.equals("2")){
                addFlight();              
            }
            
        } while (!action.equals("x"));
    }

    public void addAirplane() {
        System.out.println("Give the airplane id: ");
        String id = scanner.nextLine();
        System.out.println("Give the airplane capacity: ");
        int capacity = scanner.nextInt();

        flightControl.addAirplane(id, capacity);
    }

    public void addFlight() {
        System.out.println("Give the airplane id: ");
        String iD = scanner.nextLine();
        System.out.println("Give the departure airport id: ");
        String departureID = scanner.nextLine();
        System.out.println("Give the target airport id: ");
        String targetID = scanner.nextLine();

        flightControl.addFlight(flightControl.getAirplane(iD), departureID, targetID);
    }

    public void FlightControl() {
        System.out.println("Flight Control\n");

        String action;
        do {
            System.out.println("Choose an action:\n"
                    + "[1] Print airplanes\n"
                    + "[2] Print flights\n"
                    + "[3] Print airplane details\n"
                    + "[x] Quit");
            
            System.out.println("> ");
            action = scanner.nextLine();

            switch (action) {

                case ("1"):
                    flightControl.getAirplanes().stream()
                            .forEach(x -> System.out.println(x.toString()));
                    break;

                case ("2"):
                    flightControl.getFlights().stream()
                            .forEach(x -> System.out.println(x.toString()));
                    break;

                case ("3"):
                    System.out.println("Give the airplane id: ");
                    String id = scanner.nextLine();
                    
                    System.out.println(flightControl.getAirplane(id).toString());
                    break;
            }
            
        } while (!action.equals("x"));
    }
}
