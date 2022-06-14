
import java.util.HashMap;


public class Abbreviations {
    private HashMap<String, String> abbreviations;
    
    public Abbreviations() {
        this.abbreviations = new HashMap<>();
    }
    
    public void addAbbreviation(String abbreviation, String explanation){
        if (hasAbbreviation(abbreviation)){
            System.out.println("key already exists");
        }
        this.abbreviations.put(abbreviation, explanation);
        
    }
    
    public boolean hasAbbreviation(String abbreviation){
        String stringCheck = sanitizedString(abbreviation);
        
        if (this.abbreviations.containsKey(stringCheck)){
            return true;
        }
        return false;
    }
    
    public String findExplanationFor(String abbreviation){
        if (this.abbreviations.containsKey(sanitizedString(abbreviation))){
            return this.abbreviations.get(abbreviation);
        }
        return null;
    }
    
    public String sanitizedString(String string){
        if ( string == null ){
            return "";
        }
        string = string.toLowerCase();
        return string.toString();
    }
}
