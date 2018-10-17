/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;
import java.util.*;

/**
 *
 * @author lison
 */
public class PersonalDuplicateRemover implements DuplicateRemover{
  private Set<String> uniqueStrings;
  private int duplicates;

  public PersonalDuplicateRemover() {
    uniqueStrings = new HashSet<String>();
    duplicates = 0;
  }

  @Override
  public void add(String characterString) {
    if(uniqueStrings.contains(characterString)) duplicates++;
    else uniqueStrings.add(characterString);
  }

  @Override
  public int getNumberOfDetectedDuplicates() {
    return duplicates;
  }

  @Override
  public Set<String> getUniqueCharacterStrings() {
    return uniqueStrings;
  }

  @Override
  public void empty() {
    uniqueStrings.clear();
    duplicates = 0;
  }
  
  
}
