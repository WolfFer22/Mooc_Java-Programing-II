
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
    
    private List<Person> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }
    
    public void add(Person personToAdd){
        employees.add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd){       
        peopleToAdd.stream()
                .forEach(person -> employees.add(person));        
    }
    
    public void print(){
        Iterator<Person> it = employees.iterator();
        
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    
    public void print(Education education){
        Iterator<Person> it = employees.iterator();
        
        while(it.hasNext()){
            Person person = it.next();
            if (person.getEducation().equals(education)){  // ou, == education                           
                System.out.println(person);                
            }
        }            
    }
    
    public void fire(Education education){
        Iterator<Person> it = employees.iterator();
        
        while(it.hasNext()){
            if (it.next().getEducation().equals(education)){
                it.remove();
            }
        } 
    }
}
