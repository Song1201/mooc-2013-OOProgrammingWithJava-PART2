/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author lison
 */
public class Player extends Creature{

  public Player(int X_BOUND, int Y_BOUND) {
    super(0, 0, X_BOUND, Y_BOUND);
  }

  @Override
  public String toString() {
    return "@ " + super.getPosition();
  }
  
  
  
}
