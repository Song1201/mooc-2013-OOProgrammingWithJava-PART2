/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
/**
 *
 * @author lison
 */
public class PromissoryNote {
  private HashMap<String,Double> whomDebts;
  
  public PromissoryNote() {
    whomDebts = new HashMap<String, Double>();
  }
  
  public void setLoan(String whom,double value) {
    whomDebts.put(whom, value);
  }
  
  public double howMuchIsTheDebt(String whom) {
    if(whomDebts.containsKey(whom)){
      return whomDebts.get(whom);
    }
    return 0;
  }
}
