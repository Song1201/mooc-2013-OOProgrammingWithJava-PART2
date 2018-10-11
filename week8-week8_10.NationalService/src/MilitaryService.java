/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lison
 */
public class MilitaryService implements NationalService {
  private int daysLeft;
  
  public MilitaryService(int daysLeft) {
    this.daysLeft = daysLeft;
  }
  
  public int getDaysLeft() {
    return daysLeft;
  }
  
  public void work() {
    if(daysLeft>0) daysLeft--;
  }
}
