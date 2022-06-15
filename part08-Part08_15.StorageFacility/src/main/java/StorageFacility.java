
import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    
    private HashMap<String, ArrayList<String>> storage;

    public StorageFacility() {
        this.storage = new HashMap<>();
    }    
    
    public void add(String unit, String item){
        storage.putIfAbsent(unit, new ArrayList<>());
        storage.get(unit).add(item);
    }
    
    public ArrayList<String> contents(String storageUnit){        
        return storage.getOrDefault(storageUnit, new ArrayList<>());
    }
    
    public void remove(String storageUnit, String item){
        storage.get(storageUnit).remove(item);
        if (storage.get(storageUnit).isEmpty()){
            storage.remove(storageUnit);
        }
    }
    
    public ArrayList<String> storageUnits(){
        ArrayList<String> set = new ArrayList<>();
        
        if (storage.isEmpty() || storage.values().isEmpty()){
            return new ArrayList<>();
        } else {
            set = new ArrayList<>(storage.keySet());
        }        
        return set;
    }
    
}
