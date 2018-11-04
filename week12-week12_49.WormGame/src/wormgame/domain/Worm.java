/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;
import wormgame.Direction;
import java.util.*;
/**
 *
 * @author lison
 */
public class Worm {
  private final LinkedList<Piece> worm;
  private Direction direction;
  private boolean growed;

  public Worm(int x, int y, Direction direction) {
    worm = new LinkedList<Piece>();
    worm.add(new Piece(x,y));
    this.direction = direction;
    growed = true;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }
  
  public int getLength() {
    return worm.size();
  }
  
  public List<Piece> getPieces() {
    return worm;
  }
  
  public void move() {
    Piece head = worm.getLast();
    Piece newHead = new Piece(1,1);
    if(direction==Direction.UP) newHead = new Piece(head.getX(),head.getY()-1); 
    else if(direction==Direction.DOWN) 
      newHead = new Piece(head.getX(),head.getY()+1); 
    else if(direction==Direction.LEFT) 
      newHead = new Piece(head.getX()-1,head.getY()); 
    else if(direction==Direction.RIGHT) 
      newHead = new Piece(head.getX()+1,head.getY()); 
    worm.add(newHead);
    if(growed) growed = false;
    else worm.pop();
    if(worm.size()<3) growed = true;
  }
  
  public void grow() {
    growed = true;
  }
  
  public boolean runsInto(Piece piece) {
    for(Piece aPiece:worm) {
      if(piece.runsInto(aPiece)) return true;
    }
    return false;
  }
  
  public boolean runsIntoItself() {
    Iterator<Piece> iter = worm.descendingIterator();
    Piece head = iter.next();
    while(iter.hasNext()) {
      if(head.runsInto(iter.next())) return true;
    }
    return false;
  }
  
  public boolean hitBorder(int width, int height) {
    Piece head = worm.getLast();
    return head.getX()<0||head.getX()>=width||head.getY()<0||
            head.getY()>=height;
  }
}
