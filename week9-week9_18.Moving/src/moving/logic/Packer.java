/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.logic;
import moving.domain.*;
import java.util.*;
/**
 *
 * @author lison
 */
public class Packer {
  private int boxesVolume;

  public Packer(int boxesVolume) {
    this.boxesVolume = boxesVolume;
  }
  
  public List<Box> packThings(List<Thing> things) {
    ArrayList<Box> boxes = new ArrayList<Box>();
    boxes.add(new Box(boxesVolume));
    for(Thing thing:things) {
      if(boxes.get(boxes.size()-1).addThing(thing)) {
        
      } else {
        boxes.add(new Box(boxesVolume));
        boxes.get(boxes.size()-1).addThing(thing);
      }      
    }
    return boxes;
  }
}
