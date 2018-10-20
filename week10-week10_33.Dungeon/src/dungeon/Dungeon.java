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
public class Dungeon {
  private int length;
  private int height;
  private int numVampires;
  private int numMoves;
  private boolean vampiresMove;
  private ArrayList<Vampire> vampires;
  private Random randomizer;
  private Player player;
  private char[][] map;
  private final Scanner reader;

  public Dungeon(int length, int height, int numVampires, int numMoves, 
          boolean vampiresMove) {
    this.length = length;
    this.height = height;
    this.numVampires = numVampires;
    this.numMoves = numMoves;
    this.vampiresMove = vampiresMove;
    vampires = new ArrayList<Vampire>();
    player = new Player(length-1, height-1);
    map = new char[length][height];
    randomizer = new Random();
    for(int i=0;i<numVampires;i++) {
      vampires.add(new Vampire(randomizer,length-1, height-1));
    }
    reader = new Scanner(System.in);
  }
  
  public void run() {
    while(numMoves>0) {
      System.out.println(numMoves);
      System.out.println("");
      System.out.println(player);
      for(Vampire vampire:vampires) System.out.println(vampire);
      System.out.println("");
      printMap();
      System.out.println("");
      String commands = reader.nextLine();
      movePlayer(commands);
      if(win()) break;
      if(vampiresMove) {
        moveVampire(commands.length());
        if(win()) break;        
      }
      numMoves--;
    }
    if(win()) System.out.println("YOU WIN");
    else System.out.println("YOU LOSE");
  }
  
  private void movePlayer(String commands) {
    int[] directions = new int[commands.length()];
    for(int i=0;i<commands.length();i++) {
      if(commands.charAt(i)=='w') directions[i] = 0;
      else if(commands.charAt(i)=='s') directions[i] = 1;
      else if(commands.charAt(i)=='a') directions[i] = 2;
      else if(commands.charAt(i)=='d') directions[i] = 3;
    }
    for(int direction:directions) {
      player.step(direction);
      if(player.positionOutOfBounds()) player.stepBack();
      else {
        Iterator<Vampire> vampire = vampires.iterator();
        while(vampire.hasNext()) {
          if(vampire.next().isOverLap(player)) vampire.remove();
        }
      }
    }
  }
  
  private void moveVampire(int numSteps) {
    Iterator<Vampire> vampire = vampires.iterator();
    while(vampire.hasNext()) {
      Vampire movingVampire = vampire.next();
      for(int i=0;i<numSteps;i++) {
        movingVampire.step(randomizer.nextInt(4));
        if(movingVampire.positionOutOfBounds()) {
          movingVampire.stepBack();
          break;
        } else if(movingVampire.isOverLap(player)) {
          vampire.remove();
          break;
        } else {
          for(Vampire other:vampires) {
            if((!movingVampire.equals(other))&&movingVampire.isOverLap(other)) {
              movingVampire.stepBack();
              break;
            }
          }
        }
      }
    }
  }
  
  private void printMap() {
    for(char[] row:map) Arrays.fill(row,'.');
    //Arrays.fill(map, '.');
    map[player.getY()][player.getX()] = '@';
    for(Vampire vampire:vampires) map[vampire.getY()][vampire.getX()] = 'v';
    for(int i=0;i<height;i++) {
      for(int j=0;j<length;j++) System.out.print(map[i][j]);
      System.out.println("");
    }
  }
  
  private boolean win() {
    return vampires.isEmpty();
  }
}
