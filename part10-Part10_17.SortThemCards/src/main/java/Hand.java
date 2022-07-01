
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand implements Comparable<Hand> {
    
    private ArrayList<Card> cards;    

    public Hand() {
        this.cards = new ArrayList<>();
    }
    
    public void add(Card card){
        this.cards.add(card);
    }
    
    public void print(){
        this.cards.stream()
                .forEach(crd -> System.out.println(crd));
    }
    
    public void sort(){      
        Collections.sort(cards);
    }
    
    public int handValue(Hand hand){
        return hand.cards.stream()
                .mapToInt(c -> Integer.valueOf(c.getValue()))
                .sum();
        // or:
//        int sum = 0; 
//        for (Card card : cards) {
//            sum += card.getValue();
//        } 
//        return sum;
    }

    @Override
    public int compareTo(Hand handCompare) {        
        return handValue(this) - handValue(handCompare);
    }

    public void sortBySuit() {
        Comparator<Card> comp = Comparator
                .comparing(Card::getSuit)
                .thenComparing(Card::getValue);
        
        Collections.sort(this.cards, comp);
        // or:
//        Collections.sort(cards, new BySuitInValueOrder());
    }
}    
