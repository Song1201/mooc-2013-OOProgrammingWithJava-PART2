/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author lison
 */
public class Hand implements Comparable<Hand> {
  private ArrayList<Card> hand;

  public Hand() {
    hand = new ArrayList<Card>();
  }
  
  public void add(Card card) {
    hand.add(card);
  }
  
  public void print() {
    for(Card card:hand) {
      System.out.println(card);
    }
  }
  
  public void sort() {
    Collections.sort(hand);
  }

  @Override
  public int compareTo(Hand other) {
    int thisValue = 0;
    int otherValue = 0;
    for(Card card:hand) thisValue += card.getValue();
    for(Card card:other.hand) otherValue += card.getValue();
    return thisValue - otherValue;
  }
  
  public void sortAgainstSuit() {
    Collections.sort(hand, new SortAgainstSuitAndValue());
  }
  
  
}
