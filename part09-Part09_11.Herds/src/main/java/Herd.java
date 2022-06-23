
import java.util.ArrayList;
import java.util.List;

public class Herd implements Movable{
    
    private List<Movable> list;

    public Herd() {
        this.list = new ArrayList<>();
    }     
    
    public void addToHerd(Movable movable){               
        this.list.add(movable);
    }
    
    @Override
    public void move(int dx, int dy){
        if (!list.isEmpty()){
            for (Movable x : list){
            x.move(dx, dy);
            }
        }        
    }    
    
    @Override
    public String toString(){        
        StringBuilder positions = new StringBuilder();
        for (Movable x : list){
            positions.append(x + "\n");
        }
        return positions.toString();
    }

}
