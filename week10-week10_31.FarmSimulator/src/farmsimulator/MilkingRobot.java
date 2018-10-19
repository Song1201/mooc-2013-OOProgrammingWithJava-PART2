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
public class MilkingRobot {
  private BulkTank bulkTank;

  public MilkingRobot() {
  }

  public BulkTank getBulkTank() {
    return bulkTank;
  }

  public void setBulkTank(BulkTank bulkTank) {
    this.bulkTank = bulkTank;
  }
  
  public void milk(Milkable milkabe) {
    if(bulkTank==null) throw new IllegalStateException();
    bulkTank.addToTank(milkabe.milk());
  }
  
  
}
