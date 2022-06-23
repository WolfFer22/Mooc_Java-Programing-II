
public class Item {
    
    private String product;
    private int quantity;
    private int unitPrice;

    public Item(String product, int quantity, int unitPrice) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;        
    }
    
    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }    
    
    public int price(){
        return this.unitPrice * this.quantity;
    }
    
    public void increaseQuantity(){
        this.quantity++;
    }
    
    public String toString(){
        return this.product + ": " + this.quantity;
    }
}
