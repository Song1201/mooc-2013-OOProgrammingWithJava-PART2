/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.stream.IntStream;
/**
 *
 * @author lison
 */
public class Tournament {
  private ArrayList<Player> players;
  private final Scanner reader;
  private final Random randomizer;
  private final int NUM_JUDGES;
  private final int SCORE_RANGE;
  private final int MIN_SCORE;
  private final int LENGTH_RANGE;
  private final int MIN_lENGTH;

  public Tournament() {
    players = new ArrayList<Player>();
    reader = new Scanner(System.in);
    randomizer = new Random();
    NUM_JUDGES = 5;
    SCORE_RANGE = 11;
    MIN_SCORE = 10;
    LENGTH_RANGE = 61;
    MIN_lENGTH = 60;   
  }
  
  public void start() {
    System.out.println("Kumpula ski jumping week\n");
    signUpPhase();
    jumpingPhase();
    showResults();
  }
  
  private void signUpPhase() {
    System.out.println("Write the names of the participants one at a time; an "
            + "empty string brings you to the jumping phase.");
    while(true) {
      System.out.print("  Participant name: ");
      String name = reader.nextLine();
      if(name.equals("")) break;
      players.add(new Player(name));
    }
    System.out.println("");
  }
  
  private void jumpingPhase() {
    System.out.println("The tournament begins!\n");    
    int numRounds = 0;
    while(true) {
      System.out.print("Write \"jump\" to jump; otherwise you quit: ");
      String command = reader.nextLine();
      System.out.println("");
      if(!command.equals("jump")) break;
      numRounds++;
      jump(numRounds);
    }
    System.out.println("Thanks!\n");
  }
  
  private void jump(int numRounds) {
    System.out.println("Round " + numRounds + "\n");
    System.out.println("Jumping order:");
    Collections.sort(players);
    for(int i=0;i<players.size();i++) {
      System.out.println("  " + (i+1) + ". " + players.get(i));
    }
    System.out.println("");
    System.out.println("Results of round " + numRounds);
    for(Player player:players) {
      System.out.println("  " + player.getName());
      int length = randomizer.nextInt(LENGTH_RANGE) + MIN_lENGTH;
      System.out.println("    length: " + length);
      player.addLength(length);
      player.incrementTotalScore(vote()+length);
    }
    System.out.println("");
  }
   
  private int vote() {
    int[] votes = new int[NUM_JUDGES];
    int max = MIN_SCORE - 1;
    int min = MIN_SCORE + SCORE_RANGE;
    int sum = 0;
    for(int i=0;i<NUM_JUDGES;i++) {
      votes[i] = randomizer.nextInt(SCORE_RANGE) + MIN_SCORE;
      max = Math.max(max,votes[i]);
      min = Math.min(min,votes[i]);
      sum += votes[i];
    }
    System.out.println("    judge votes: " + Arrays.toString(votes));
    return sum - max - min;
    
  }
  
  private void showResults() {
    System.out.println("Tournament results:");
    System.out.println("Position    Name");
    Collections.sort(players);
    Collections.reverse(players);
    for(int i=0;i<players.size();i++) {
      System.out.println((i+1) + "           " + players.get(i));
      System.out.println("            jump lengths: " + 
              players.get(i).lengthsToString());
    }
    
  }
  
}
