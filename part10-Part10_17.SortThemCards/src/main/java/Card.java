
import java.util.Collections;
import java.util.Comparator;

public class Card implements Comparable<Card> {

    private int value;
    private Suit suit;

    public Card(int value, Suit suit) {
        if (value < 2 || value > 14) {
            throw new IllegalArgumentException("Card value must be in range 2...14.");
        }

        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        String cardValue = "" + value;
        if(value == 11) {
            cardValue = "J";
        } else if (value == 12) {
            cardValue = "Q";
        } else if (value == 13) {
            cardValue = "K";
        } else if (value == 14) {
            cardValue = "A";
        }
        
        return suit + " " + cardValue;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card crd) {             
        if (value == crd.value) {
            return suit.ordinal() - crd.suit.ordinal();
        }
 
        return value - crd.value;
        // or:
//        if (this.value == crd.getValue()) {            
//            if (this.suit.ordinal() == crd.suit.ordinal()) {
//                return 0;
//            } else if (this.suit.ordinal() > crd.suit.ordinal()) {
//                return 1;
//            } else {
//                return -1;
//            }  
//            
//        } else if (this.value > crd.getValue()) {
//            return 1;            
//        } else {
//            return -1;
//        } 
    }

}
