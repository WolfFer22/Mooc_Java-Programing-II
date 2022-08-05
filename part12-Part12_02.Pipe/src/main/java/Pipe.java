
import java.util.ArrayList;
import java.util.List;

public class Pipe <T> {
    
    private List<T> values;
    
    Pipe() {     
        this.values = new ArrayList<>();
    }
    
    public void putIntoPipe(T value) {
        this.values.add(value);
    }
    
    public T takeFromPipe(){
        
        if (this.values.isEmpty()) return null;
        
        T value = this.values.get(0);
        this.values.remove(value);
        
        return value;
    }
    
    public boolean isInPipe(){
        return !this.values.isEmpty();
    }
}
