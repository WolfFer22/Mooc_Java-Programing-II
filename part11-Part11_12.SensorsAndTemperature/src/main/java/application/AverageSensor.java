package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {  
    
    private List<Sensor> sensorList; 
    private List<Integer> averageTemperatures;

    public AverageSensor() {
        this.sensorList = new ArrayList<>();
        this.averageTemperatures = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd){
        sensorList.add(toAdd);
    }
     
    public List<Integer> readings(){
        return averageTemperatures;
    }

    @Override
    public int read() {

        if (sensorList.size() == 0){
           throw new IllegalStateException("There is no sensors."); 
        }

        if (!isOn()){
            throw new IllegalStateException("There is no sensors on.");
        }
        
        int sum = 0;        
        for (int i = 0; i < sensorList.size(); i++){  
            
            int reading = sensorList.get(i).read();            
            sum += reading;

        }        
        int average = sum / sensorList.size();
        
        this.averageTemperatures.add(average);
        
        return average;
    }

    @Override
    public boolean isOn() {
        
        for (int i = 0 ; i < sensorList.size(); i++){
           if (sensorList.get(i).isOn()){               
                return true;
           }
        }
        
        return false;
    }

    @Override
    public void setOn() { 
        
        for (int i = 0 ; i < sensorList.size(); i++){
           sensorList.get(i).setOn();
        }
    }

    @Override
    public void setOff() {  
        
        for (int i = 0 ; i < sensorList.size(); i++){
           sensorList.get(i).setOff();
        }
    }

}
