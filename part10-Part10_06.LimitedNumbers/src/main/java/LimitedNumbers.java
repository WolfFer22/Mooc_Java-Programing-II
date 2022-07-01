
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Integer> inputNumbers = new ArrayList<>();
        
        while(true) {
            int input = scanner.nextInt();
            if(input == -1){
                break;
            }
            
            inputNumbers.add(input);
        }
        
        inputNumbers.stream()
                .filter(number -> number >= 1 && number <= 5)
                .forEach(number -> System.out.println(number));
    }
}
