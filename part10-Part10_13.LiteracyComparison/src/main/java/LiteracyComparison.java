
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    
    public static void main(String[] args) {
                
        ArrayList<Literacy> statistics = new ArrayList<>();
        
        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(row -> row.split(","))
                    .filter(parts -> parts.length == 6)                    
                    .map(parts -> new Literacy(parts[2].replace("(%)", "").trim(), parts[3], Integer.valueOf(parts[4]), Double.valueOf(parts[5])))                    
                    .forEach(csvObject -> statistics.add(csvObject));
                        
        } catch (Exception e){
            System.out.println("Eror: " + e);
        }
        
        statistics.stream()            
            .sorted()
            .forEach(line -> System.out.println(line.toString()));
        
    }

    public static class Literacy implements Comparable<Literacy>{

        private String gender;
        private String country;
        private int year;
        private double literacyPercentage;

        public Literacy(String gender, String country, int year, double literacyPercentage) {

            this.gender = gender;
            this.country = country;
            this.year = year;
            this.literacyPercentage = literacyPercentage;
        }

        public double getLiteracyPercentage() {
            return literacyPercentage;
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(); 
            sb.append(country);
            sb.append(" (").append(year).append("), ");
            sb.append(gender);
            sb.append(", ").append(literacyPercentage);            
            return sb.toString();
        }

        @Override
        public int compareTo(Literacy otherObject) {
            if ( this.literacyPercentage < otherObject.getLiteracyPercentage()) {
                return -1;
            } else if (this.literacyPercentage > otherObject.getLiteracyPercentage()) {
                return 1;
            } else {
                return 0;
            }
        }   
    }
}
