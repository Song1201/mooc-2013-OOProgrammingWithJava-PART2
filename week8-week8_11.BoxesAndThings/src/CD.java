/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lison
 */
public class CD implements ToBeStored {
  private String artist;
  private String title;
  private int publishYear;
  private static final double WEIGHT = 0.1;

  public CD(String artist, String title, int publishYear) {
    this.artist = artist;
    this.title = title;
    this.publishYear = publishYear;
  }

  public double weight() {
    return WEIGHT;
  }

  @Override
  public String toString() {
    return artist + ": " + title + " (" + publishYear + ")"; 
  }
  
  
  
  
}
