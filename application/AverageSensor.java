package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AverageSensor implements Sensor{
    private List<Sensor> sensorList;
    private List<Integer> readings;
    private boolean isOn;
    private int temperature;

    public AverageSensor(){
        this.sensorList = new ArrayList<>();
        this.readings = new ArrayList<>();
        isOn = true;
        temperature = 0;
    }

    public void addSensor(Sensor toAdd){
        this.sensorList.add(toAdd);
    }

    public List<Sensor> getSensorList() {
        return sensorList;
    }

    @Override
    public boolean isOn() {
        for (int i = 0; i < this.sensorList.size(); i++){
            if (!this.sensorList.get(i).isOn()){
                isOn = false;
            }
        }
        return isOn;
    }

    @Override
    public void setOn() {
       this.sensorList.stream().forEach(sensor -> sensor.setOn());
    }

    @Override
    public void setOff() {
        this.sensorList.stream().forEach(sensor -> sensor.setOff());
    }

    @Override
    public int read() throws IllegalAccessException {
        if ((this.isOn == false))  {
            throw new IllegalAccessException("The average sensor is off.");
        }

        if (this.sensorList.isEmpty())  {
            throw new IllegalAccessException("The average sensor is empty.");
        }

        int number = 0;

        for (int i = 0; i < this.sensorList.size(); i++){
            number += this.sensorList.get(i).read();
        }
        int average = number / this.sensorList.size();
        this.readings.add(average);
        return average;
    }

    public List<Integer> readings(){
        return this.readings;
    }
}

