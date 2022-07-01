
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Checker checker = new Checker();
        System.out.println("Enter a string:");
        String dayOfWeek = scanner.nextLine();
        checker.isDayOfWeek(dayOfWeek); 
        
        System.out.println();
        
        System.out.println("Enter a string");
        String vowels = scanner.nextLine();
        checker.allVowels(vowels);
        
        System.out.println();
        
        System.out.println("Enter a string");
        String time = scanner.nextLine();
        checker.timeOfDay(time);
        
    }
}
