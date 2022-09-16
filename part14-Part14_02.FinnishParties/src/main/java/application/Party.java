package application;

import java.util.HashMap;

public class Party {

    private String party;
    private HashMap<Integer, Double> partyResults;

    public Party(String party) { 
        this.party = party;
        this.partyResults = new HashMap<>();
    }

    Party() {        
    }

    public void setParty(String party) {
        this.party = party;
    }
    
    public String getParty() {
        return this.party;
    }

    public void addPartyResults(int electionYear, double results) {      
        this.partyResults.put(electionYear, results);               
    }

    public HashMap<Integer, Double> getPartyResults() {
        return partyResults;
    }
}
