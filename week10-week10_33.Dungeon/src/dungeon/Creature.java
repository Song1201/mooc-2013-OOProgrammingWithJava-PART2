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
public class Creature {
  private int x;
  private int y;
  private int previousX;
  private int previousY;
  private final int X_BOUND;
  private final int Y_BOUND;

  public Creature(int x, int y, int X_BOUND, int Y_BOUND) {
    this.x = x;
    this.y = y;
    previousX = x;
    previousY = y;
    this.X_BOUND = X_BOUND;
    this.Y_BOUND = Y_BOUND;
  }

  public void step(int directioin) {
    previousX = x;
    previousY = y;
    if(directioin==0) y--;
    else if(directioin==1) y++;
    else if(directioin==2) x--;
    else if(directioin==3) x++;
  }
  
  public void stepBack() {
    x = previousX;
    y = previousY;
  }
  
  public boolean positionOutOfBounds() {
    return x<0 || x>X_BOUND || y<0 || y>Y_BOUND;
  }
    
  public boolean isOverLap(Creature other) {
    return x==other.x && y==other.y;
  }

  public String getPosition() {
    return "" + x + " " + y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
  
  
  
  
}
