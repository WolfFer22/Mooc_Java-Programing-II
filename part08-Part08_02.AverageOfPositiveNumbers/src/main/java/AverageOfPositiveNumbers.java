
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double average = 0.0;
        int sum = 0;
        int count = 0;
        
        while (true) {
            int inputNumbers = scanner.nextInt();
            
            if (inputNumbers == 0){                
                break;
            }
            
            if (inputNumbers > 0){
                sum += inputNumbers;
                count++;
            }
        }
        
        if ( count == 0){
            System.out.println("Cannot calculate the average");
        } else {
            average = 1.0 * sum / count;
            System.out.println(average);
        }

    }
}
