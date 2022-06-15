
import java.util.HashMap;
import java.util.Scanner;

public class Nicknames {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        HashMap<String, String> names = new HashMap<>();
        
        names.put("Matthew", "matt");
        names.put("Michael", "mix");
        names.put("Arthur", "artie");
        
        System.out.println(names.get("Matthew"));
    }
}
