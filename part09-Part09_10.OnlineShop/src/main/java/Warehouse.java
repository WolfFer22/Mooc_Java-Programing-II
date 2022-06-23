
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {
    
    private Map<String, Integer> productsPrice = new HashMap<>();
    private Map<String, Integer> productStock = new HashMap<>();

    public Warehouse() {
    }

    public void addProduct(String product, int price, int stock) {
        this.productsPrice.put(product, price);
        this.productStock.put(product, stock);
    }

    public int price(String product) {
        return this.productsPrice.getOrDefault(product, -99);
    }

    public int stock(String product) {
        return this.productStock.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        if (this.productStock.containsKey(product)
                && this.productStock.get(product) > 0) {                                 
            this.productStock.put(product, this.productStock.get(product) - 1); 
            
            return true;
        }
        
        return false;
    }
    
    public Set<String> products(){
        return this.productStock.keySet();        
    }
}
