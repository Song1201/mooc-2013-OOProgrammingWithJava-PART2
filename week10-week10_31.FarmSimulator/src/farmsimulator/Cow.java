/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;
import java.util.*;
/**
 *
 * @author lison
 */
public class Cow implements Alive, Milkable {
  private String name;
  private double capacity;
  private double amount;
  private static final String[] NAMES = new String[]{
    "Anu", "Arpa", "Essi", "Heluna", "Hely",
    "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
    "Jaana", "Jami", "Jatta", "Laku", "Liekki",
    "Mainikki", "Mella", "Mimmi", "Naatti",
    "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
    "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
  private static final Random randomizer = new Random();
  private static final int LOWEST_CAPACITY = 15;
  private static final int HIGHEST_CAPACITY = 40;
  private static final double LOWEST_PRODUCE = 0.7;
  private static final double HIGHEST_PRODUCE = 2;
  
  public Cow() {
    this(NAMES[randomizer.nextInt(NAMES.length)]);
  }
  
  public Cow(String name) {
    this.name = name;
    capacity = randomizer.nextInt(HIGHEST_CAPACITY-LOWEST_CAPACITY+1) + 
            LOWEST_CAPACITY;
    amount = 0;
  }

  public String getName() {
    return name;
  }

  public double getCapacity() {
    return capacity;
  }

  public double getAmount() {
    return amount;
  }

  @Override
  public String toString() {
    return name + " " + Math.ceil(amount) + "/" + Math.ceil(capacity);
  }


  @Override
  public void liveHour() {
    amount = Math.min((amount + randomizer.nextDouble()*(HIGHEST_PRODUCE-
            LOWEST_PRODUCE)+LOWEST_PRODUCE),capacity);
  }

  @Override
  public double milk() {
    double milk = amount;
    amount = 0;
    return milk;
  }

}
