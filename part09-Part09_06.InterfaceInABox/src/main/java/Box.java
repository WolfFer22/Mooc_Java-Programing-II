
import java.util.ArrayList;

public class Box implements Packable {
    
    private double capacity;
    private ArrayList<Packable> items;
    
    public Box (double capacity){
        this.capacity = capacity;
        this.items = new ArrayList<>();        
    }
    
    public void add(Packable item){
        if (item.weight()<= capacity){
            items.add(item);
            capacity = capacity - item.weight();
        }
    }

    public double weight(){
        double weight = 0;
        
        if (items.size() > 0){
            for (Packable x : items){
                weight = weight + x.weight();
            }
        }        
        
        return weight;
    }
    
    public String toString(){
        return "Box: " + items.size() + " items, total weight " + weight() + " kg";
    }
    
}
