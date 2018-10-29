/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnel;
import java.util.*;

/**
 *
 * @author lison
 */
public class Employees {
  private ArrayList<Person> employees;

  public Employees() {
    employees = new ArrayList<Person>();
  }
  
  public void add(Person person) {
    employees.add(person);
  }
  
  public void add(List<Person> persons) {
    employees.addAll(persons);
  }
  
  public void print() {
    Iterator<Person> iter = employees.iterator();
    while(iter.hasNext()) System.out.println(iter.next());
  }
  
  public void print(Education education) {
    Iterator<Person> iter = employees.iterator();
    while(iter.hasNext()) {
      Person employee = iter.next();
      if(employee.getEducation()==education) System.out.println(employee);
    }
  }
  
  public void fire(Education education) {
    Iterator<Person> iter = employees.iterator();
    while(iter.hasNext()) {
      if(iter.next().getEducation()==education) iter.remove();
    }
  }
}
