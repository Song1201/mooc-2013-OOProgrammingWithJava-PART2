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
public class Container {
  private ArrayList<Suitcase> suitcases;
  private int weightLimit;
  
  public Container(int weightLimit) {
    suitcases = new ArrayList<Suitcase>();
    this.weightLimit = weightLimit;
  }
  
  public void addSuitcase(Suitcase suitcase) {
    if(weightLimit-totalWeight()>= suitcase.totalWeight()) 
      suitcases.add(suitcase);
  }
  
  public int totalWeight() {
    int totalWeight = 0;
    for(Suitcase suitcase:suitcases) totalWeight += suitcase.totalWeight();
    return totalWeight;
  }
  
  public String toString() {
    return ""+suitcases.size() + " suitcases (" + totalWeight() + " kg)";
  }
  
  public void printThings() {
    for(Suitcase suitcase:suitcases) suitcase.printThings();
  }
}
