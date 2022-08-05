
public class List <Type> {
    
    private Type[] values;
    private int firstFreeIndex;

    public List() {
        // creat array of length 10
        this.values = (Type[]) new Object[10];
        this.firstFreeIndex = 0;
    }
        
    public void add(Type value) {
        
        // check if array is full and use grow() if true
        if(this.firstFreeIndex == this.values.length) {
            grow();
        }
        
        // add value to the array
        this.values[this.firstFreeIndex] = value;
        this.firstFreeIndex++;
    }
    
    public int indexOfValue(Type value) {
        
        for (int i = 0; i < this.firstFreeIndex; i++) {
            
            if (this.values[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }
    
    private void moveToTheLeft(int fromIndex) {
        
        for (int i = fromIndex; i < this.firstFreeIndex - 1; i++) {
            this.values[i] = this.values[i + 1];
        }
    }
    
    public void remove(Type value) {
        
        int indexOfValue = indexOfValue(value);
        
        if (indexOfValue < 0) {
            return; // not found
        }

        moveToTheLeft(indexOfValue);
        
        this.firstFreeIndex--;
    }
    
    // grow array size
    private void grow() { 
        
        int newSize = this.values.length + this.values.length / 2;
        
        // create new Array with bigger size.
        Type[] newValues = (Type[]) new Object[newSize];
        
        for (int i = 0; i < this.values.length; i++) {
            // copy values from the old array to the new Array
            newValues[i] = this.values[i];
        }
        
        // substitute the old Array to the new one
        this.values = newValues;
    }
    
    public boolean contains(Type value) {
        return indexOfValue(value) >= 0;
    }
    
    public Type value(int index) {
        
        if (index < 0 || index >= this.firstFreeIndex) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + this.firstFreeIndex + "]");
        }

        return this.values[index];
    }
    
    public int size() {
        return this.firstFreeIndex;
    }
}
