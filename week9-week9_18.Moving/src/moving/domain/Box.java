/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;
import java.util.*;
/**
 *
 * @author lison
 */
public class Box implements Thing {
  private int capacity;
  private ArrayList<Thing> things; 

  public Box(int capacity) {
    this.capacity = capacity;
    things = new ArrayList<Thing>();
  }
  
  public boolean addThing(Thing thing) {
    if(thing.getVolume()>capacity-getVolume()) return false;
    things.add(thing);
    return true;    
  }

  @Override
  public int getVolume() {
    int usedVolume = 0;
    for(Thing thing:things) usedVolume += thing.getVolume();
    return usedVolume;
  }
  
  
}
