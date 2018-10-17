/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import java.util.*;
/**
 *
 * @author lison
 */
public class Person implements Comparable<Person>{
  private String name;
  private Set<String> numbers;
  private Set<String> addresses;

  public Person(String name) {
    this.name = name;
    numbers = new HashSet<String>();
    addresses = new HashSet<String>();
  }
  
  public void addNumber(String number) {
    numbers.add(number);
  }

  public Set<String> getNumbers() {
    return numbers;
  }

  public String getName() {
    return name;
  }
  
  public void addAddress(String address) {
    addresses.add(address);
  }

  public Set<String> getAddresses() {
    return addresses;
  }

  @Override
  public int compareTo(Person other) {
    return name.compareTo(other.name);
  }


  
}
