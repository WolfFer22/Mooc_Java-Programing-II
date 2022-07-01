
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputNumbers = new ArrayList<>();
        
        System.out.println("Input numbers, type \"end\" to stop");
        
        while(true){
            String input = scanner.nextLine();            
            if (input.equals("end")){
                break;
            }
            
            inputNumbers.add(Integer.valueOf(input));
        }
        
        double averagePositive = inputNumbers.stream()
                .mapToInt(s -> s)
                .filter(number -> number > 0)
                .average()
                .getAsDouble();
        
        double averageNegative = inputNumbers.stream()
                .mapToInt(s -> s)
                .filter(number -> number < 0)
                .average()
                .getAsDouble();                
        
        System.out.println("");
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String whatToPrint = scanner.nextLine();
        
        if (whatToPrint.equals("n")){
            System.out.println("Average of the negative numbers: " + averageNegative);
        } else {
            System.out.println("Average of the positive numbers: " + averagePositive);        
        }
        
    }
}
