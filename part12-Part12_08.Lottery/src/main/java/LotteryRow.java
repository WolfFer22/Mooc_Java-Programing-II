
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        // Implement the random number generation here
        // the method containsNumber is probably useful
        Random random = new Random();
        
        for (int i = 0; i < 7; i++){         

            while (this.numbers.size() < 7){
                
                int numberRandomized = random.nextInt(40) + 1; ;
                
                if (!containsNumber(numberRandomized)){
                    this.numbers.add(numberRandomized);                    
                }                 
            }                
        }
    }

    public boolean containsNumber(int number) {
        // Check here whether the number is among the drawn numbers        
        return numbers.contains(number);
    }
}

