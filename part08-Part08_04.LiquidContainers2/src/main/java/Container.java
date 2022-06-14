
public class Container {

    private int liquidContaining;

    public Container() {
        
        this.liquidContaining = 0;
    }

    public int contains() {
        return liquidContaining;
    }

    public void add(int amount) {
        if (amount > 0) {
            this.liquidContaining = this.liquidContaining + amount;
            if (this.liquidContaining > 100) {
                this.liquidContaining = 100;
            }
        }        
    }

    public void remove(int amount) {
        this.liquidContaining = this.liquidContaining - amount;
        if (this.liquidContaining < 0) {
            this.liquidContaining = 0;
        }        
    }

    @Override
    public String toString() {
        return liquidContaining + "/100";
    }

}
