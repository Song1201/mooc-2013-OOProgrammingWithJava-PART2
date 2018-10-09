/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
import java.util.ArrayList;
/**
 *
 * @author lison
 */
public class Dictionary {
  private HashMap<String,String> finnishEnglish; 
  
  public Dictionary() {
    finnishEnglish = new HashMap<String, String>();
  }
  
  public String translate(String word) {
    return finnishEnglish.get(word);
  }
  
  public void add(String finnish,String english) {
    finnishEnglish.put(finnish, english);
  }
  
  public int amountOfWords() {
    return finnishEnglish.size();
  }
  
  public ArrayList<String> translationList() {
    ArrayList<String> pairList = new ArrayList<String>();
    for(String key:finnishEnglish.keySet()) {
      pairList.add(key+" = "+finnishEnglish.get(key));
    }
    return pairList;
  }
}
