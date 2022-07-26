
package application;

import java.util.Random;

public class TemperatureSensor implements Sensor{
    
    private boolean sensor; 
    private int temperature;
    
    public TemperatureSensor(){  
        this.sensor = false;
    }

    public TemperatureSensor(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public boolean isOn() {         
        return sensor;
    }

    @Override
    public void setOn() {
        sensor = true;
    }

    @Override
    public void setOff() {        
        sensor = false;
    }

    @Override
    public int read() {
        this.temperature = new Random().nextInt(61) - 30; 
        return this.temperature;       
   }    
        
}
