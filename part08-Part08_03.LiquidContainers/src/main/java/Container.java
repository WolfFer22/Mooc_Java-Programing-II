
public class Container {

    private String name;
    private int liquidContaining;

    public Container(String name, int liquidContaining) {
        this.name = name;
        this.liquidContaining = 0;
    }

    public int getLiquidContaining() {
        return liquidContaining;
    }

    public int addAmount(int amount) {
        if (amount > 0) {
            this.liquidContaining = this.liquidContaining + amount;
            if (this.liquidContaining > 100) {
                this.liquidContaining = 100;
            }
        }
        return this.liquidContaining;
    }

    public int removeAmount(int amount) {
        this.liquidContaining = this.liquidContaining - amount;
        if (this.liquidContaining < 0) {
            this.liquidContaining = 0;
        }
        return this.liquidContaining;
    }

    @Override
    public String toString() {
        return name + ": " + liquidContaining + "/100";
    }

}
