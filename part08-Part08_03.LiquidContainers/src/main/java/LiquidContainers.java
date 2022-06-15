
import java.util.ArrayList;
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Container first = new Container("First", 0);
        Container second = new Container("Second", 0);

        OUTER:
        while (true) {
            System.out.println(first);
            System.out.println(second);

            String input = scan.nextLine();

            if (input.equals("quit")) {
                break;
                
            } else {
                String[] parts = input.split(" ");
                String inputCommand = parts[0];
                int amount = Integer.valueOf(parts[1]);
                
                switch (inputCommand) {
                    case "add":
                        first.addAmount(amount);
                        break;
                        
                    case "move":
                        if (amount > first.getLiquidContaining()){
                            second.addAmount(first.getLiquidContaining());
                            first.removeAmount(amount);
                            break;
                        } else {
                            first.removeAmount(amount);                        
                            second.addAmount(amount);
                            break;
                        }
                        
                    case "remove":
                        second.removeAmount(amount);
                        break;
                        
                    default:
                        System.out.println("Unkown command.");
                        break;
                }
            }
        }
    }
}
