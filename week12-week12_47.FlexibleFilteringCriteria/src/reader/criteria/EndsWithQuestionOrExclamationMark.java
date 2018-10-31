package reader.criteria;


import reader.criteria.Criterion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lison
 */
public class EndsWithQuestionOrExclamationMark implements Criterion{

  @Override
  public boolean complies(String line) {
    return line.endsWith("?") || line.endsWith("!");
  }
  
}
