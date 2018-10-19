/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;
import java.util.*;
/**
 *
 * @author lison
 */
public class MaxWeightBox extends Box{
  private int maxWeight;
  private List<Thing> things;

  public MaxWeightBox(int maxWeight) {
    this.maxWeight = maxWeight;
    things = new ArrayList<Thing>();
  }
  
  

  @Override
  public void add(Thing thing) {
    if(isInTheBox(thing)) ;
    else if(thing.getWeight()<=maxWeight-totalWeight()) things.add(thing);
  }

  
  @Override
  public boolean isInTheBox(Thing thing) {
    return things.contains(thing);
  }
  
  private int totalWeight() {
    int totalWeight = 0;
    for(Thing thing:things) totalWeight += thing.getWeight();
    return totalWeight;
  }
  
}
