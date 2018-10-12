/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Comparator;
/**
 *
 * @author lison
 */
public class SortAgainstSuitAndValue implements Comparator<Card> {
  @Override
  public int compare(Card card1, Card card2) {
    return card1.getSuit()*Card.VALUES.length + card1.getValue() - 
            (card2.getSuit()*Card.VALUES.length + card2.getValue());
  }
  
}
