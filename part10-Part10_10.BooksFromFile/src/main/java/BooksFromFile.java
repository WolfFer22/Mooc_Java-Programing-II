
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
    }
    
    public static List<Book> readBooks(String file){
        List<Book> booksFromFile = new ArrayList<>();
        
        try {
            Files.lines(Paths.get(file))
                    .map(row -> row.split(","))
                    .filter(parts -> parts.length == 4)
                    .map(parts -> new Book(parts[0], Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), parts[3]))
                    .forEach(book -> booksFromFile.add(book));
            
        } catch (Exception ex){
            System.out.println("Error: " + ex);
        }
        
        return booksFromFile;
//        try {
//            return Files.lines(Paths.get(file))
//                    .map(line -> line.split(","))
//                    .map(parts -> new Book(parts[0], Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), parts[3]))
//                    .collect(Collectors.toList());
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        
//        return new ArrayList<>();
    }

}
