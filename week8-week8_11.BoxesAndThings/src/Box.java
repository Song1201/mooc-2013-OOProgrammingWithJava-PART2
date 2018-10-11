/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author lison
 */
public class Box implements ToBeStored {
  private double capacity;
  private ArrayList<ToBeStored> things;
  
  public Box(double capacity) {
    this.capacity = capacity;
    things = new ArrayList<ToBeStored>();
  }
  
  public double weight() {
    double weight = 0;
    for(ToBeStored sth:things) weight += sth.weight();
    return weight;
  }
  
  public void add(ToBeStored sth) {
    if(sth.weight()<=capacity-weight()) things.add(sth);
  }
  
  public String toString() {
    return "Box: " + things.size() + " things, total weight " + weight() + 
            " kg";
  }
}
