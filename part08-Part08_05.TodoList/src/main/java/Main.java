
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TodoList list = new TodoList();
        Scanner scanner = new Scanner(System.in);
        
        list.add("one");
        list.add("two");
        list.add("three");
        
        UserInterface ui = new UserInterface(list, scanner);
        ui.start();
        list.print();
    }
}
