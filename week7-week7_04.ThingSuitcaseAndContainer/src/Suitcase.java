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
public class Suitcase {
  private int weightLimit;
  private ArrayList<Thing> things;
  
  public Suitcase(int weightLimit) {
    this.weightLimit = weightLimit;
    things = new ArrayList<Thing>();
  }
  
  public void addThing(Thing thing) {
    if(weightLimit-totalWeight()>=thing.getWeight()) {
      things.add(thing);
    }
  }
  
  public String toString() {
    if(things.size()==0) return "empty (" + totalWeight() + " kg)";
    if(things.size()==1) return ""+things.size() + " thing (" + totalWeight() + 
            " kg)";
    return ""+things.size() + " things (" + totalWeight() + " kg)"; 
  }
  
  public int totalWeight() {
    int totalWeight = 0;
    for(Thing thing:things) {
      totalWeight += thing.getWeight();
    }
    return totalWeight;
  }
  
  public void printThings() {
    for(Thing thing:things) System.out.println(thing);
  }
  
  public Thing heaviestThing() {
    if(things.size()==0) return null;
    Thing heavistThing = new Thing("None",0);
    for(Thing thing:things) {
      if(heavistThing.getWeight()<thing.getWeight()) heavistThing = thing;
    }
    return heavistThing;
  }
}
