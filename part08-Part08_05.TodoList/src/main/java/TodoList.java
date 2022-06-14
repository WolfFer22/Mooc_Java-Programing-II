
import java.util.ArrayList;


public class TodoList {
    
    private ArrayList<String> todoList;
    
    public TodoList() {
        this.todoList = new ArrayList<>();
    }

    public void add(String task) {
        this.todoList.add(task);
    }
    
    public boolean isCompleted(int task){
        if (task > todoList.size()){
            return false;
        }
        remove(task);
        return true;
    }
    
    public void remove(int task){        
        todoList.remove(task - 1);        
    }

    public String getTodoList(int task) {
        return todoList.get(task - 1);
    }     
    
    public void print(){   
        if (todoList.isEmpty()){
            System.out.println("List is empty");
        }
        int taskNumber = 1;
        for (String list : todoList){
            System.out.println(taskNumber + ": " + list);
            taskNumber++;
        }
    }
}
