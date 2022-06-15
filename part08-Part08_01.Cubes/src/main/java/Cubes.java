
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);        
        
        while(true) {            
            String input = scanner.nextLine();
            
            if (input.equals("end")){
                break;
                
            } else {
                int numberCube = Integer.valueOf(input);
            
                if (numberCube > 0) {
                    System.out.println(numberCube * numberCube * numberCube);
                } else {
                    System.out.println(numberCube);
                }  
            }            
            
        }

    }
}
