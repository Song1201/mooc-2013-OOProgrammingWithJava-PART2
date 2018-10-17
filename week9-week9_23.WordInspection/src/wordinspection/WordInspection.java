/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;
import java.io.File;
import java.util.*;
/**
 *
 * @author lison
 */
public class WordInspection {
  private File file;

  public WordInspection(File file) {
    this.file = file;
  }
  
  public int wordCount() throws Exception{
    int numWords = 0;
    Scanner reader = new Scanner(file,"UTF-8");
    while(reader.hasNext()) {
      reader.next();
      numWords++;
    }
    return numWords;
  }
  
  public List<String> wordsContainingZ() throws Exception{
    ArrayList<String> words = new ArrayList<String>();
    Scanner reader = new Scanner(file,"UTF-8");
    while(reader.hasNext()) {
      String word = reader.next();
      if(word.contains("z")) words.add(word);
    }
    return words;
  }
  
  public List<String> wordsEndingInL() throws Exception{
    ArrayList<String> words = new ArrayList<String>();
    Scanner reader = new Scanner(file,"UTF-8");
    while(reader.hasNext()) {
      String word = reader.next();
      //if(word.charAt(word.length()-1)=='l') words.add(word);
      if(word.endsWith("l")) words.add(word);
    }
    return words;    
  }
  
  public List<String> palindromes() throws Exception{
    ArrayList<String> words = new ArrayList<String>();
    Scanner reader = new Scanner(file,"UTF-8");
    while(reader.hasNext()) {
      String word = reader.next();
      if(isPalindrome(word)) words.add(word);
    }
    return words;        
  }
  
  private boolean isPalindrome(String word) {
    for(int i=0;i<word.length()/2;i++) {
      if(word.charAt(i)!=word.charAt(word.length()-i-1)) return false;
    }
    return true;
  }
  
  public List<String> wordsWhichContainAllVowels() throws Exception{
    ArrayList<String> words = new ArrayList<String>();
    Scanner reader = new Scanner(file,"UTF-8");
    while(reader.hasNext()) {
      String word = reader.next();
      if(containAllVowels(word)) words.add(word);
    }
    return words;        
  }
  
  private boolean containAllVowels(String word) {
    List<String> vowels = Arrays.asList("a","e","i","o","u","y","ä","ö");
    for(String vowel:vowels) {
      if(!word.contains(vowel)) return false;
    }
    return true;
  }
}
