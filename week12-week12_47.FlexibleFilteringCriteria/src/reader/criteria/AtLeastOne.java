/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;
import java.util.*;
/**
 *
 * @author lison
 */
public class AtLeastOne implements Criterion{
  private ArrayList<Criterion> criterions;

  public AtLeastOne(Criterion... criterions) {
    this.criterions = new ArrayList<Criterion>();
    this.criterions.addAll(Arrays.asList(criterions));
  }
  
  

  @Override
  public boolean complies(String line) {
    boolean result = false;
    for(Criterion criterion:criterions) result |= criterion.complies(line);
    return result;
  }
  
}
