
import java.util.Scanner;

public class UserInterface {

    private TodoList list;
    private Scanner scanner;

    public UserInterface(TodoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }

    public void start() {

        while (true) {
            System.out.println("Command:");
            String command = scanner.nextLine();

            if (command.equals("stop")) {
                break;
                
            } else {              
                
                if (command.equals("add")) {
                    System.out.println("Task:");
                    String task = scanner.nextLine();
                    list.add(task);

                } else if (command.equals("list")) {
                    list.print();

                } else if (command.equals("completed")) {
                    System.out.println("Which task was completed?");
                    int numberTask = scanner.nextInt();
                    list.isCompleted(numberTask);
                    System.out.println("Task " + list.getTodoList(numberTask) + " is completed");

                } else if (command.equals("remove")){
                    System.out.println("Which one is removed?");
                    int taskToRemove = scanner.nextInt();
                    list.remove(taskToRemove);
                    
                } else {
                    System.out.println("Unknown command");
                }                                   
            }
            
        }

    }
    
}    
