
public class Book implements Comparable<Book> {
    private String name;
    private int recomendedAge;

    public Book(String name, int age) {
        this.name = name;
        this.recomendedAge = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return recomendedAge;
    }

    @Override
    public String toString() {
        return name + " (recommended for " + recomendedAge + " years-olds or older)";
    }

    @Override
    public int compareTo(Book otherBook) {
        if (this.recomendedAge == otherBook.getAge()){
            return this.name.compareTo(otherBook.getName());
        }                
        return this.recomendedAge - otherBook.getAge();
    }
    
    
}
