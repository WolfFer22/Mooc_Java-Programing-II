
package application;

import java.util.HashMap;

public class PartyCollection extends Party{
    
    private Party party;
    private HashMap<String, HashMap<Integer, Double>> partyData;

    public PartyCollection() {
        this.partyData = new HashMap<>();
    }
    
    public void addPartyData(Party party){
        partyData.put(party.getParty(), party.getPartyResults());
    } 
    
    public HashMap<String, HashMap<Integer, Double>> getPartyData() {
        return partyData;
    }   
}