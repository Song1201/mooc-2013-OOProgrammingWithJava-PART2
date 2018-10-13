
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lison
 */
public class Player implements Comparable<Player> {
  private String name;
  private ArrayList<Integer> lengths;
  private int totalScore;

  public Player(String name) {
    this.name = name;
    lengths = new ArrayList<Integer>();
    totalScore = 0;
  }

  @Override
  public int compareTo(Player other) {
    return totalScore - other.totalScore; 
  }

  @Override
  public String toString() {
    return name + " (" + totalScore + " points)";
  }

  public String getName() {
    return name;
  }
  
  public void addLength(int length) {
    lengths.add(length);
  }
  
  public void incrementTotalScore(int score) {
    totalScore += score;
  }  
  
  public String lengthsToString() {
    String lengthsInString = "";
    for(int i=0;i<lengths.size();i++) {
      lengthsInString += lengths.get(i) + " m";
      if(i<lengths.size()-1) lengthsInString += ", ";     
    }
    return lengthsInString;
  }
}
