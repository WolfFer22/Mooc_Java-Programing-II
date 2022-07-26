package validating;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        
        if (name == null){            
            throw new IllegalArgumentException("Parameter name cannot be null");
        
        }else if (name.isEmpty() || name.length() > 40){            
            throw new IllegalArgumentException("Parameter name length cannot be greater than 40 or empty");          
        
        } else if (age < 0 || age > 120){            
            throw new IllegalArgumentException("Parameter age must be between 0 and 120");
        }         

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
