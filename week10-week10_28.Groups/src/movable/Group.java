/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;
import java.util.*;
/**
 *
 * @author lison
 */
public class Group implements Movable{
  private List<Movable> group;

  public Group() {
    group = new ArrayList<Movable>();
  }

  @Override
  public String toString() {
    String allThings = "";
    for(Movable thing:group) allThings = allThings + thing.toString() + "\n";
    return allThings;
  }
  
  public void addToGroup(Movable movable) {
    group.add(movable);
  }
  
  @Override
  public void move(int dx, int dy) {
    for(Movable thing:group) thing.move(dx, dy);
  }
  
}
