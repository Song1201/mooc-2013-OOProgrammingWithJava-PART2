/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author lison
 */
public class BulkTank {
  private double capacity;
  private static final double DEFAULT_CAPACITY = 2000;
  private double volume = 0;
  
  public BulkTank(double capacity) {
    this.capacity = capacity;
    volume = 0;
  }

  public BulkTank() {
    this(DEFAULT_CAPACITY);
  }

  public double getCapacity() {
    return capacity;
  }

  public double getVolume() {
    return volume;
  }
  
  public double howMuchFreeSpace() {
    return capacity - volume;
  }
  
  public void addToTank(double amount) {
    volume = Math.min(capacity, volume+amount);
  }

  public double getFromTank(double amount) {
    double taken = 0;
    if(amount>=volume) {
      taken = volume;
      volume = 0;
    }
    else {
      taken = amount;
      volume -= taken;
    }
    return taken;
  }

  @Override
  public String toString() {
    return "" + Math.ceil(volume) + "/" + Math.ceil(capacity);
  }
  
  
  
  
}
