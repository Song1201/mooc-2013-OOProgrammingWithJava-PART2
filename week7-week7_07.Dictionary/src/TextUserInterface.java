/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author lison
 */
public class TextUserInterface {
  private Scanner reader;
  private Dictionary dictionary;
  
  public TextUserInterface(Scanner reader,Dictionary dictionary) {
    this.reader = reader;
    this.dictionary = dictionary;
  }
  
  public void start() {
    System.out.println("Statement:");
    System.out.println("  add - adds a word pair to the dictionary");
    System.out.println("  translate - asks a word and prints its translation");
    System.out.println("  quit - quit the text user interface");
    while(true) {
      String command = reader.nextLine();
      if(command.equals("quit")) {
        System.out.println("Cheers!");
        break;
      } else if(command.equals("add")) {
        System.out.print("In Finnish: ");
        String key = reader.nextLine();
        System.out.print("Translation: ");
        String value = reader.nextLine();
        dictionary.add(key, value);
      } else if(command.equals("translate")) {
        System.out.print("Give a word: ");
        System.out.println(dictionary.translate(reader.nextLine()));
      }
      System.out.println("Unknown statement");
    }
  }
}
