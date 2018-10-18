/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;
import java.util.*;
/**
 *
 * @author lison
 */
public class ContainerHistory {
  private ArrayList<Double> history;

  public ContainerHistory() {
    history = new ArrayList<Double>();
  }
  
  public void add(double situation) {
    history.add(situation);
  }
  
  public void reset() {
    history.clear();
  }

  @Override
  public String toString() {
    return history.toString();
  }
  
  public double maxValue() {
    if(history.isEmpty()) return 0;
    return Collections.max(history);
  }
  
  public double minValue() {
    if(history.isEmpty()) return 0;
    return Collections.min(history);
  }
  
  public double average() {
    if(history.isEmpty()) return 0;
    double sum = 0;
    for(double num:history) sum += num;
    return sum/history.size();
  }
  
  public double greatestFluctuation() {
    if(history.size()<2) return 0;
    double maxFluctuation = 0;
    for(int i=0;i<history.size()-1;i++) {
      double fluctuation = Math.abs(history.get(i+1) - history.get(i));
      if(fluctuation>maxFluctuation) {
        maxFluctuation = fluctuation;
      }
    }
    return maxFluctuation;
  }
  
  public double variance() {
    if(history.size()<2) return 0;
    double mean = average();
    double minusSquare = 0;
    for(double num:history) minusSquare += Math.pow(num - mean, 2);
    return minusSquare/(history.size()-1);
  }
}
