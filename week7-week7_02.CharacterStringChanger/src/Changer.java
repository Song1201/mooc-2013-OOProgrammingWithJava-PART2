/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author lison
 */
public class Changer {
  private ArrayList<Change> changes;
  
  public Changer() {
    this.changes = new ArrayList<Change>();
  }
  
  public void addChange(Change change) {
    this.changes.add(change);
  }
  
  public String change(String s) {
    for(Change change:this.changes) {
      s = change.change(s);
    }
    return s;
  }
}
