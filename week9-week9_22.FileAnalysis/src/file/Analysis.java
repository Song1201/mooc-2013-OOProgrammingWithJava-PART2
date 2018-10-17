/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;
import java.io.File;
import java.util.*;
/**
 *
 * @author lison
 */
public class Analysis {
  private File file;

  public Analysis(File file) {
    this.file = file;
  }
  
  public int lines() throws Exception{
    Scanner reader = new Scanner(file);
    int numLines = 0;
    while(reader.hasNextLine()) {
      reader.nextLine();
      numLines++;
    }
    return numLines;
  }
  
  public int characters() throws Exception{
    Scanner reader = new Scanner(file);
    int numCharacters = 0;
    while(reader.hasNextLine()) {
      String line = reader.nextLine();
      numCharacters += line.length()+1;
    }
    return numCharacters;
  }
}
