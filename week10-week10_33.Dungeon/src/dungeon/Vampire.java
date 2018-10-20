/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;
import java.util.*;
/**
 *
 * @author lison
 */
public class Vampire extends Creature{

  public Vampire(Random randomizer, int X_BOUND, int Y_BOUND) {
    super(randomizer.nextInt(X_BOUND)+1, randomizer.nextInt(Y_BOUND)+1, X_BOUND,
            Y_BOUND);
  }

  @Override
  public String toString() {
    return "v " + super.getPosition();
  }
  
  
  
}
