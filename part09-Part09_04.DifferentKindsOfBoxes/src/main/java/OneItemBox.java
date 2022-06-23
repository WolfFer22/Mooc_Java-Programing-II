
import java.util.ArrayList;


public class OneItemBox extends Box{
    
    private ArrayList<Item> list;
    
    public OneItemBox(){  
        this.list = new ArrayList<>();
    }

    @Override // Box add method extended
    public void add(Item item) {
        if (list.isEmpty()){
            list.add(item);
        }        
    }

    @Override // Box boolean method extend
    public boolean isInBox(Item item) {        
        return list.contains(item);
    }
    
}
