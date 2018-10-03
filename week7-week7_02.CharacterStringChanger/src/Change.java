/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lison
 */
public class Change {
  private char fromCharacter;
  private char toCharacter;
  
  public Change(char fromCharacter, char toCharacter) {
    this.fromCharacter = fromCharacter;
    this.toCharacter = toCharacter;
  }
  
  public String change(String s) {
    return s.replace(this.fromCharacter, this.toCharacter);
  }
}

