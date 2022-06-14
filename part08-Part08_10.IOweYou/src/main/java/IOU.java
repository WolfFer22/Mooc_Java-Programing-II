
import java.util.HashMap;


public class IOU {
    
    private HashMap<String, Double> amountOwed;
    
    public IOU() {        
        this.amountOwed = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount){
        this.amountOwed.put(toWhom, amount);
    }
    
    public double howMuchDoIOweTo(String toWhom){        
        return this.amountOwed.getOrDefault(toWhom, 0.0);
    }
}
