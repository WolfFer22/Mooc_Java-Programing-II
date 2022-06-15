
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


public class VehicleRegistry {
    private HashMap<LicensePlate, String> registry;    

    public VehicleRegistry() {
        this.registry = new HashMap<>();        
    }   
 
    public boolean add(LicensePlate licensePlate, String owner){
        if (owner == null){
            return true;
        }
        if (registry.containsKey(licensePlate)){
            return false;
        }
        
        registry.put(licensePlate, owner);
        return true;
    }
    
    public String get(LicensePlate licensePlate){
        return this.registry.get(licensePlate);
    }
    
    public boolean remove(LicensePlate licensePlate){
        if (registry.containsKey(licensePlate)){
            registry.remove(licensePlate);
            return true;
        }
        return false;        
    }
    
    public void printLicensePlates(){
        for (Object licensePlates : registry.keySet()){
            System.out.println(licensePlates);
        }
    }
    
    public void printOwners(){
        ArrayList<String> ownersList = new ArrayList<>();
        
        for (Object owners : registry.values()){
            if (! (ownersList.contains(owners))){
                ownersList.add(owners.toString());
            } else{
                continue;
            }            
        }
        
        for (int i = 0; i < ownersList.size(); i++){
            System.out.println(ownersList.get(i));
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.registry);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VehicleRegistry other = (VehicleRegistry) obj;
        if (!Objects.equals(this.registry, other.registry)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VehicleRegistry{" + "registry=" + registry + '}';
    }    
    
}
