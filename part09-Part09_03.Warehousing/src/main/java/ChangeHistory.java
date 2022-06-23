
import java.util.ArrayList;


public class ChangeHistory {
    
    private ArrayList<Double> changes;
    
    public ChangeHistory() {        
        this.changes = new ArrayList<>();
    }

    public void add(double status){ 
        changes.add(status);
    }   
    
    public void clear(){
        this.changes.clear();
    }
    
    public double maxValue(){
        if (changes.isEmpty()){
            return 0.0;
        }    
            
        double maxValue = changes.get(0);            
        for ( int i = 1 ; i < changes.size(); i++){
                
            if (changes.get(i) > maxValue){
                maxValue = changes.get(i);
            }
        }
        return maxValue;
    }
    
    public double minValue(){
        if (changes.isEmpty()){
            return 0.0;
        }    
            
        double minValue = changes.get(0);            
        for ( int i = 1 ; i < changes.size(); i++){
                
            if (changes.get(i) < minValue){
                minValue = changes.get(i);
            }
        }
        return minValue;
    }

    public double average(){
        if (changes.isEmpty()){
            return 0.0;
        }
        
        double sum = 0;
        for (int i = 0; i < changes.size(); i++){
            sum = sum + changes.get(i);
        }
        return sum / (changes.size());
    }
    
    public String toString() {
        return changes.toString();
    }
}
