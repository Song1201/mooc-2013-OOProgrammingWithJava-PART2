/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;
import java.util.*;

/**
 *
 * @author lison
 */
public class AverageSensor implements Sensor {
  private ArrayList<Sensor> sensors;
  private ArrayList<Integer> pastTemperatures;

  public AverageSensor() {
    sensors = new ArrayList<Sensor>();
    pastTemperatures = new ArrayList<Integer>();
  }  
  
  public void addSensor(Sensor additional) {
    sensors.add(additional);
  }
  
  @Override
  public boolean isOn() {
    boolean isOn = true;
    for(Sensor sensor:sensors) isOn = isOn && sensor.isOn();
    return isOn;
  }

  @Override
  public void on() {
    for(Sensor sensor:sensors) sensor.on();
  }

  @Override
  public void off() {
    if(sensors.size()>0) sensors.get(0).off();
  }

  @Override
  public int measure() {
    if(!isOn()||sensors.size()==0) throw new IllegalStateException();
    int sum = 0;
    for(Sensor sensor:sensors) sum += sensor.measure();
    int average = sum/sensors.size();
    pastTemperatures.add(average);
    return average;
  }
  
  public List<Integer> readings() {
    return pastTemperatures;
  }
  
}
