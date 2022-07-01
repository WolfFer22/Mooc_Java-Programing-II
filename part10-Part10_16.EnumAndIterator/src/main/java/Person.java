
public class Person {
    
    private String name;
    private Education edu;

    public Person(String name, Education edu) {
        this.name = name;
        this.edu = edu;
    }

    public String getName() {
        return name;
    }

    public Education getEducation() {
        return edu;
    }
    
    public String toString(){
        return name + ", " + edu;
    }
    
}
