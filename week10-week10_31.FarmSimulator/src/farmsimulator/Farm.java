/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.*;

/**
 *
 * @author lison
 */
public class Farm implements Alive{
  private String owner;
  private Barn barn;
  private Set<Cow> cows;

  public Farm(String owner, Barn barn) {
    this.owner = owner;
    this.barn = barn;
    cows = new HashSet<Cow>();
  }

  @Override
  public String toString() {
    String toReturn;
    toReturn = "Farm owner: " + owner +"\nBarn bulk tank: " + 
            barn.getBulkTank().toString() + "\n";
    if(cows.isEmpty()) toReturn += "No cows.";
    else {
      toReturn += "Animals:";
      for(Cow cow:cows) toReturn = toReturn + "\n        " + cow.toString();
    }
    return toReturn;
  }

  public String getOwner() {
    return owner;
  }
  
  public void addCow(Cow cow) {
    cows.add(cow);
  }
  
  public void installMilkingRobot(MilkingRobot robot) {
    barn.installMilkingRobot(robot);
  }

  @Override
  public void liveHour() {
    for(Alive creature:cows) creature.liveHour();
  }
  
  public void manageCows() {
    barn.takeCareOf(cows);
  }
}
