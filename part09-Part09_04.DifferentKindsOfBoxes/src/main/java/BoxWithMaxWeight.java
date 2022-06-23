
import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {

    private int capacity;    
    private ArrayList<Item> itemsList; 

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.itemsList = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }
    
    @Override // Box add method extended
    public void add(Item item) {
        if (item.getWeight() <= this.capacity){
            itemsList.add(item); 
            this.capacity -= item.getWeight();
        }                          
    }

    @Override // Box boolean method extend
    public boolean isInBox(Item item) {
        return itemsList.contains(item);      
    }
    
}
