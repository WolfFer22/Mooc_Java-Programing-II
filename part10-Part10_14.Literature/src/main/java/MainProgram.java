
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Book> books = new ArrayList<>();
        
        while(true) {            
            System.out.println("Input the name of the book, empty stops:");
            String input = scanner.nextLine();
            
            if (input.equals("")){
                break;               
            } else {
                String bookName = input;
                
                System.out.println("Input the age recommendation:");
                int recomendedAge = Integer.valueOf(scanner.nextLine());
            
                books.add(new Book(bookName, recomendedAge));
            }  
        }
        
        System.out.println(books.size() + " books in total.");
        
        System.out.println();
        
        System.out.println("Books:");
        
        // Sort by age them name, using compareTo-method implemented by interface Comparable in the Class
        books.stream().sorted().forEach(book -> {
            System.out.println(book);
        });
        
        System.out.println();
        
        // Sort by age them name, using Comparator class and Comparator-methods comparing() and thenComparing()
        Comparator<Book> comparator = Comparator
                .comparing(Book::getAge)
                .thenComparing(Book::getName);
        
        Collections.sort(books, comparator);
        
        books.stream().forEach(book -> System.out.println(book));
    }

}
