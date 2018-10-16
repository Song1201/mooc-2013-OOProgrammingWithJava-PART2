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
public class Thermometer implements Sensor {
  private static final int OFFSET=30;
  private boolean isOn;
  private Random randomizer;

  public Thermometer() {
    isOn = false;
    randomizer = new Random();
  }
  
  
  

  @Override
  public boolean isOn() {
    return isOn;
  }

  @Override
  public void on() {
    isOn = true;
  }

  @Override
  public void off() {
    isOn = false;
  }

  @Override
  public int measure() {
    if(isOn) return randomizer.nextInt(61) - OFFSET;
    throw new IllegalStateException();
  }
  
}
