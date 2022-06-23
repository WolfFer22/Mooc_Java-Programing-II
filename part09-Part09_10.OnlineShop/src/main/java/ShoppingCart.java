
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    
    private Map<String, Item> cart = new HashMap<>();
    
    public void add(String product, int price){                                 
        cart.putIfAbsent(product, new Item(product, 0, price));                            
        cart.put(product, new Item(product, cart.get(product).getQuantity() + 1, price));
    }
    
    public int price(){
        int totalPrice = 0;
        
        if (!cart.isEmpty()){
            for (Item x : cart.values()){
                totalPrice += x.price();
            }
        }
        
        return totalPrice;
    }
    
    public void print(){
        if (!cart.isEmpty()){
            for (Item x : cart.values()){
                System.out.println(x.getProduct() + ": " + x.getQuantity());
            }
        }
    }
}
