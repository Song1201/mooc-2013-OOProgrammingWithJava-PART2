/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;
import java.util.*;
import java.io.*;
/**
 *
 * @author lison
 */
public class MindfulDictionary {
  private Map<String,String> dictionary;
  private String sourceFileName;

  public MindfulDictionary() {
    dictionary = new HashMap<String, String>();
  }
  
  public MindfulDictionary(String fileName) {
    dictionary = new HashMap<String, String>();
    sourceFileName = fileName;
  }
  
  public boolean load() {
    try {
      File sourceFile = new File(sourceFileName);
      Scanner reader = new Scanner(sourceFile);
      while(reader.hasNextLine()) {
        String[] line = reader.nextLine().split(":");
        add(line[0],line[1]);
      }
      reader.close();
      return true;
    } catch (FileNotFoundException e) {
      return false;
    }
  }
  
  public void add(String word, String translation) {
    if(!dictionary.containsKey(word)) {
      dictionary.put(word, translation);
      dictionary.put(translation, word);
    }
  }
  
  public String translate(String word) {
    if(dictionary.containsKey(word)) return dictionary.get(word);
    return null;
  }
  
  public void remove(String word) {
    dictionary.remove(dictionary.get(word));
    dictionary.remove(word);
  }
  
  public boolean save() {
    try {
      Set<String> half = new HashSet<String>();
      String content = "";
      for(String word:dictionary.keySet()) {
        if(half.contains(dictionary.get(word))) {
        } else {
          half.add(word);
          content = content + word + ":" + dictionary.get(word) + "\n";
        }
      }
      FileWriter writer = new FileWriter(sourceFileName);
      writer.write(content);
      writer.close();
      return true;
    } catch(IOException e) {
      return false;
    }
  }
  
  
}
