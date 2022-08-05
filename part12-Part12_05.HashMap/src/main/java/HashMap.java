
import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> {

    private List<Pair<K, V>>[] values;
    private int firstFreeIndex;

    public HashMap() {
        this.values = new List[32];
        this.firstFreeIndex = 0;
    }

    public V get(K key) {

        // Calculates the hash value for the key;
        // Modulo (remainder of division operation) is used for ensuring that
        // the index stays within the size boundaries of the internal array
        int hashValue = Math.abs(key.hashCode() % this.values.length);

        // If there are no key-value pairs with this key that have been stored -> null
        if (this.values[hashValue] == null) {
            return null;
        }

        // create a list into that index
        List<Pair<K, V>> valuesAtIndex = this.values[hashValue];

        // goes through the list at the index,         
        for (int i = 0; i < valuesAtIndex.size(); i++) {
            // Compare the parameter key to the key of every key-value pair on that list
            // If some of the keys matches the parameter key,
            // returns the value of that key-value pair
            if (valuesAtIndex.get(i).getKey().equals(key)) {
                return valuesAtIndex.get(i).getValue();
            }
        }

        return null;
    }

//    public void add(K key, V value) {
//        // Calculates the hash value for the key,
//        // and uses it to determine the suitable index in the internal array
//        int hashValue = Math.abs(key.hashCode() % values.length);
//        
//        // If there is no value in that index, we create a list into that index  
//        if (values[hashValue] == null) {
//            values[hashValue] = new List<>();
//        }
//
//        List<Pair<K, V>> valuesAtIndex = values[hashValue];
//
//        int index = -1;
//        
//        // Goes through the list at the index, and
//        // looks for a key-value pair whose key matches the key of the key-value pair to be added
//        for (int i = 0; i < valuesAtIndex.size(); i++) {
//            
//            // If the matching key is found,
//            // the value related to it is updated to match the new value.      
//            if (valuesAtIndex.value(i).getKey().equals(key)) {
//                index = i;
//                break;
//            }
//        }
//        
//        // Adds a new key-value pair in the list
//        // in which case the number of stored values is also incremented by one  
//        if (index < 0) {
//            valuesAtIndex.add(new Pair<>(key, value));
//            this.firstFreeIndex++;
//        
    // Value related to it is updated to match the new value  
//        } else {
//            valuesAtIndex.value(index).setValue(value);
//        }
//    }
    public void add(K key, V value) {

        List<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);

        int index = getIndexOfKey(valuesAtIndex, key);

        if (index < 0) {
            valuesAtIndex.add(new Pair<>(key, value));
            this.firstFreeIndex++;

        } else {
            valuesAtIndex.get(index).setValue(value);
        }
    }

    // Finding the list related to the key
    private List<Pair<K, V>> getListBasedOnKey(K key) {

        int hashValue = Math.abs(key.hashCode() % values.length);

        if (values[hashValue] == null) {
            values[hashValue] = new ArrayList<>();
        }

        return values[hashValue];
    }

    //  Finding the key on that list.
    private int getIndexOfKey(List<Pair<K, V>> myList, K key) {

        for (int i = 0; i < myList.size(); i++) {

            if (myList.get(i).getKey().equals(key)) {
                return i;
            }
        }

        return -1;
    }

    private void grow() {
        // Crete a new array, double size
        List<Pair<K, V>>[] newValues = new List[this.values.length * 2];

        for (int i = 0; i < this.values.length; i++) {
            // Copy the values of the old array into the new one
            copy(newValues, this.firstFreeIndex - 1);
        }

        // Replace the old array with the new one
        this.values = newValues;
    }

    private void copy(List<Pair<K, V>>[] newArray, int fromIdx) {
        
        for (int i = 0; i < this.values[fromIdx].size(); i++) {
            
            Pair<K, V> value = this.values[fromIdx].get(i);

            int hashValue = Math.abs(value.getKey().hashCode() % newArray.length);
            
            if (newArray[hashValue] == null) {
                newArray[hashValue] = new ArrayList<>();
            }

            newArray[hashValue].add(value);
        }
    }
}
