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
public class Barn {
  private BulkTank bulkTank;
  private MilkingRobot robot;
  
  public Barn(BulkTank tank) {
    bulkTank = tank;
  }

  public BulkTank getBulkTank() {
    return bulkTank;
  }
  
  public void installMilkingRobot(MilkingRobot robot) {
    this.robot = robot;
    this.robot.setBulkTank(bulkTank);
  }
  
  public void takeCareOf(Cow cow) {
    if(robot==null) throw new IllegalStateException();
    robot.milk(cow);
  }
  
  public void takeCareOf(Collection<Cow> cows) {
    if(robot==null) throw new IllegalStateException();
    for(Cow cow:cows) robot.milk(cow);
  }
  
  @Override
  public String toString() {
    return "Barn: " + bulkTank.toString();
  }
  
  
}
