/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.domain;

/**
 *
 * @author lison
 */
public class Film {
  private String name;

  public Film(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
  
  @Override
  public String toString() {
    return name;
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if(obj==null) return false;
    if(obj.getClass()!=getClass()) return false;
    Film other = (Film)obj;
    return hashCode()==other.hashCode();
  }
}
