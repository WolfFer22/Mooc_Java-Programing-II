
import java.util.ArrayList;


public class ProductWarehouseWithHistory  extends ProductWarehouse{   
    
    private ChangeHistory changes = new ChangeHistory();

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);         
        
        this.setBalance(initialBalance);   // Set initial balance WareHouse
        
        changes.add(initialBalance);  // Add first value to ChangeHistory
    }    

    @Override
    public double takeFromWarehouse(double amount) {         
        changes.add(super.getBalance() - amount);
        
        return super.takeFromWarehouse(amount);
    }

    @Override
    public void addToWarehouse(double amount) {           
        changes.add(super.getBalance() + amount);
        
        super.addToWarehouse(amount);        
    }   

    public String history(){        
        return changes.toString();
    }
    
    public void printAnalysis(){        
        System.out.println("Product: " + super.getName()
                + "\nHistory: " + history()
                + "\nLargest amount of product: " + changes.maxValue()
                + "\nSmallest amount of product: " + changes.minValue()
                + "\nAverage: " + changes.average());                  
    }

}
