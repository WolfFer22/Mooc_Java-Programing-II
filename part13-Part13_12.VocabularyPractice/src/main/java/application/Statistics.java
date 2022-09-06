
package application;

public class Statistics {
    
    private Dictionary dictionary;
    private int guesses;
    private int correctGuesses;

    public Statistics(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.guesses = 0;
        this.correctGuesses = 0;
    }

    public int getGuesses() {
        return guesses;
    }

    public int getCorrectGuesses() {
        return correctGuesses;
    }    
    
    public void incrementGuesses() {
        this.guesses++;
    }

    public void incrementCorrectGuesses() {
        this.correctGuesses++;
    }
    
    public int getWordCount() {
        return this.dictionary.wordCount();
    }    
 
}
