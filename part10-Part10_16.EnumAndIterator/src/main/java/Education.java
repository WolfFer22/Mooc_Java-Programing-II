
public enum Education {
    
    PHD("Doctoral"), 
    MA("Masters"), 
    BA("Bachelors"),
    HS("High School");
    
    private String degree;
    
    private Education(String degree){
        this.degree = degree;
    }

    public String getDegree() {
        return this.degree;
    }
  
}
