import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class DictionaryOfManyTranslations {

    private HashMap<String, ArrayList<String>> translationsMap;

    public DictionaryOfManyTranslations() {
        this.translationsMap = new HashMap<>();
    }

    public void add(String word, String translation) {
//        if (!this.translationsMap.containsKey(word)) {
//            this.translationsMap.put(word, new ArrayList<>());
//        }
//
//        ArrayList<String> translations = this.translationsMap.get(word);
//        
//        translations.add(translation);
        this.translationsMap.putIfAbsent(word, new ArrayList<>());
        this.translationsMap.get(word).add(translation);
        
    }

    public ArrayList<String> translate(String word) {
//        if (!this.translationsMap.containsKey(word)
//                || this.translationsMap.values().isEmpty()) {
//            return new ArrayList<String>();
//        }
//        
//        ArrayList<String> names = new ArrayList<>(this.translationsMap.get(word));
//       
//        names.stream().distinct().collect(Collectors.toList());                 
//        
//        return names;
        return this.translationsMap.getOrDefault(word, new ArrayList<>());

    }

    public void remove(String word) {
        if (this.translationsMap.containsKey(word)) {
            this.translationsMap.remove(word);
        }
    }
    

}
