/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.File;
/**
 *
 * @author lison
 */
public class Printer {
  private File file;

  public Printer(String fileName) {
    file = new File(fileName);
  }
  
  public void printLinesWhichContain(String word) throws Exception {
    Scanner reader = new Scanner(file);
    while(reader.hasNextLine()) {
      String line = reader.nextLine();
      if(line.contains(word)) System.out.println(line);
    }
  }
  
  
  
}
