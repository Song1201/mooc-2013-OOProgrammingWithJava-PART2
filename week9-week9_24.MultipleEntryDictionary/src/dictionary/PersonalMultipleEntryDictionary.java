/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;
import java.util.*;

/**
 *
 * @author lison
 */
public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary{
  private Map<String,Set<String>> dictionary;

  public PersonalMultipleEntryDictionary() {
    dictionary = new HashMap<String, Set<String>>();
  }
  
  @Override
  public void add(String word, String entry) {
    if(dictionary.containsKey(word)) dictionary.get(word).add(entry);
    else {
      Set<String> translation= new HashSet<String>();
      translation.add(entry);
      dictionary.put(word, translation);
    }
  }

  @Override
  public Set<String> translate(String word) {
    return dictionary.get(word);
  }

  @Override
  public void remove(String word) {
    dictionary.remove(word);
  }
  
}
