package application;

import java.util.Random;

public class TemperatureSensor implements  Sensor{
private int temperature;
public boolean isOn;

public TemperatureSensor(){
    temperature = 0;
    isOn = false;
}
    @Override
    public boolean isOn() {
    return isOn;
    }

    @Override
    public void setOn() {
        isOn = true;
    }

    @Override
    public void setOff() {
        isOn = false;
    }

    @Override
    public int read() throws IllegalAccessException {
        if (!isOn()){
            throw new IllegalAccessException("Sensor is off");
        }
        Random random = new Random();
        temperature = random.nextInt(-30, 31);
        return temperature;
    }
}
