
import java.util.ArrayList;

public abstract class Box {  

    public abstract void add(Item item); //abstrat void method(add item)

    public void add(ArrayList<Item> items) {
        for (Item item : items) {
            Box.this.add(item);
        }
    }

    public abstract boolean isInBox(Item item); //abstract boolean method(item exists)
}
