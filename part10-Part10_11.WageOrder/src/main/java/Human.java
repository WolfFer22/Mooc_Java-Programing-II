
public class Human implements Comparable<Human> {

    private int wage;
    private String name;

    public Human(String name, int wage) {
        this.name = name;
        this.wage = wage;
    }

    public String getName() {
        return name;
    }

    public int getWage() {
        return wage;
    }

    @Override
    public String toString() {
        return name + " " + wage;
    }

    @Override
    public int compareTo(Human otherHuman) {
        return this.wage - otherHuman.getWage();
    }

    // compareTo longer vertion (ascending order):
//    
//    @Override
//    public int compareTo(Human otherHuman) {
//        if (this.wage == otherHuman.getWage()) {
//            return 0;
//        } else if (this.wage > otherHuman.getWage()) {
//            return 1;
//        } else {
//            return -1;
//        }
//    }

}
