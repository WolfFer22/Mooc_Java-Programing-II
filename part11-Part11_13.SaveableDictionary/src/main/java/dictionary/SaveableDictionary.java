package dictionary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class SaveableDictionary {

    private HashMap<String, String> dictionary;
    private String file;

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this.file = file;
        this.dictionary = new HashMap<>();
    }

    public void add(String words, String translation) {
        dictionary.putIfAbsent(words, translation);
    }

    public void delete(String word) {

        if (dictionary.containsKey(word)) {
            dictionary.remove(word);
        }

        if (dictionary.containsValue(word)) {
            dictionary.values().remove(word);;
        }
    }

    public String translate(String word) {

        String translation = null;

        if (dictionary.containsKey(word)) {
            translation = dictionary.get(word);
        }

        for (String keyWord : dictionary.keySet()) {
            if (dictionary.get(keyWord).equals(word)) {
                translation = keyWord;
            }
        }

        return translation;
    }

    public boolean load() {
        File fileToCheck = new File(this.file);

        if (fileToCheck.exists()) {
            readFile(this.file);
            return true;
        }

        return false;
    }

    public boolean save() {
        File file = new File(this.file);
        
        try {                     
            FileWriter newWriter = new FileWriter(file);

            for (String words : dictionary.keySet()){
                newWriter.write(words + ":" + dictionary.get(words) + "\n");
            }
            newWriter.close();

            return true;
     
        } catch (IOException ex){  
            return false;
        }             
    }

    public void readFile(String file) {

        try (Scanner fileReader = new Scanner(Paths.get(file))) {

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");

                this.add(parts[0], parts[1]);
            }

        } catch (Exception ex) {
        }
    }

}
