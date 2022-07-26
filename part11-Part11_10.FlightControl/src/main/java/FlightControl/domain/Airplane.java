
package flightControl.domain;

public class Airplane {  
    
    private String id;
    private int capacity;

    public Airplane(String ID, int capacity) {
        this.id = ID;
        this.capacity = capacity;
    }

    public String getID() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return id + " (" + capacity + " capacity)";
    }    
    
}
