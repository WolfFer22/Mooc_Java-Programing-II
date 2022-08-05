
import java.util.ArrayList;
import java.util.List;

public class Hideout <T> {
    
    private List<T> objects;
    
    Hideout(){
        this.objects = new ArrayList<>();
    }
    
    public void putIntoHideout(T toHide){
        
        this.objects.clear();
        this.objects.add(toHide);        
    }
    
    public T takeFromHideout(){
        
        if (this.objects.isEmpty()){
            return null;
        }
           
        T object = this.objects.get(0);
        this.objects.remove(object);
        
        return object;
    }
    
    public boolean isInHideout(){
        return !this.objects.isEmpty();
    }
}
