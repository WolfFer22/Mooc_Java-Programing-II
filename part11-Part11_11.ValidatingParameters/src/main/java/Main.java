import validating.Calculator;
import validating.Person;

public class Main {

    public static void main(String[] args) {
        Person first = new Person(null, 20);
        System.out.println(first.getName());
        
        Person second = new Person("Ana", -1);
        System.out.println(second.getAge());
    }
    
}
