/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author lison
 */
public class PersonalBoard extends GameOfLifeBoard{

  public PersonalBoard(int width, int height) {
    super(width, height);    
  }

  @Override
  public void initiateRandomCells(double probability) {
    Random randomizer = new Random();
    for(boolean row[]:getBoard()) {
      for(int i=0;i<row.length;i++) {
        row[i] = randomizer.nextDouble()<probability;
      }
    }
  }

  @Override
  public boolean isAlive(int x, int y) {
  // GameOfLifeBoard is somehow rotated, so that in [x][y], the first index is 
  // horizontal index.
    if(isInBound(x, y)) return getBoard()[x][y];
    return false;
  }

  @Override
  public void turnToLiving(int x, int y) {
    if(isInBound(x, y)) getBoard()[x][y] = true;
  }

  @Override
  public void turnToDead(int x, int y) {
    if(isInBound(x, y)) getBoard()[x][y] = false;
  }

  @Override
  public int getNumberOfLivingNeighbours(int x, int y) {
    int numLivingNeighbor = 0;
    for(int neighborX=x-1;neighborX<x+2;neighborX++) {
      for(int neighborY=y-1;neighborY<y+2;neighborY++) {        
        if(neighborX!=x || neighborY!=y) {
          if(isAlive(neighborX, neighborY)) numLivingNeighbor++;
        }
        
      }
    }
    return numLivingNeighbor;
  }

  @Override
  public void manageCell(int x, int y, int numLivingNeighbor) {
    if(numLivingNeighbor<2) getBoard()[x][y] = false;
    else if(numLivingNeighbor>3) getBoard()[x][y] = false;
    else if(numLivingNeighbor==3) getBoard()[x][y] = true;
  }
  
  private boolean isInBound(int x, int y) {
    return x>=0 && x<getWidth() && y>=0 && y<getHeight();
  }
  
  
  
}
