package validating;

public class Calculator {

    public int factorial(int num) {

        if (num < 0) {
            throw new IllegalArgumentException("Must be positive numbers");          
        }
        
        int answer = 1;
        
        for (int i = 1; i <= num; i++) {
            answer *= i;
        } 
        
        return answer;
    }    
    
    public int binomialCoefficent(int setSize, int subsetSize) {
        
        int numerator, denominator;
        
        if (subsetSize <= setSize && subsetSize > 0){            
            numerator = factorial(setSize);
            denominator = factorial(subsetSize) * factorial(setSize - subsetSize);
       
        } else {
            throw new IllegalArgumentException("The size of the and set subset should be 0 or bigger and "
                    + "size of the set should be bigger than the subset");
        }

        return numerator / denominator;
    }
}
