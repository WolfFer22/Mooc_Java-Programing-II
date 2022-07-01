
import java.util.ArrayList;



public class MainProgram {

    public static void main(String[] args) {
        Student first = new Student("jamo1");
        Student second = new Student("jamo");
        System.out.println(first.compareTo(second));
        System.out.println("***");
        
        ArrayList<Student> students = new ArrayList<>();
        students.add(first);
        students.add(second);
        
        students.stream().forEach(name -> System.out.println(name));
        System.out.println("***");
        students.stream().sorted().forEach(name -> System.out.println(name));
        System.out.println(students);
    }
}
