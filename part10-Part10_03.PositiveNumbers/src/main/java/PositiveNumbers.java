
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);
        
        List<Integer> numbersList = new ArrayList<>();
        while(true){
            String number = scanner.nextLine();            
            if(number.equals("end")){                
                break;
            }            
            numbersList.add(Integer.valueOf(number));
        }
        
        positive(numbersList);            
    }
    
    public static List<Integer> positive(List<Integer> numbers){
        /*return numbers.stream()
                        .filter(number -> number > 0)
                        .collect(Collectors.toList());*/
        
        ArrayList<Integer> list = numbers.stream()
                .filter(value -> value > 0)                       
                .collect(Collectors.toCollection(ArrayList::new));                
        
        return list;                      
    }

}


