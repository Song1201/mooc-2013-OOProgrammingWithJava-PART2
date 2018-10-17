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
public class Database {
  private Map<String,Person> namePerson;
  private Map<String,Person> numberPerson;
  private Map<String,Person> addressPerson;
  private Scanner reader;

  public Database(Scanner reader) {
    namePerson = new HashMap<String, Person>();
    numberPerson = new HashMap<String, Person>();
    addressPerson = new HashMap<String, Person>();    
    this.reader = reader;
  }
  
  public void startUserInterface() {
    System.out.println("phone search\n" +
    "available operations:\n" +
    " 1 add a number\n" +
    " 2 search for a number\n" +
    " 3 search for a person by phone number\n" +
    " 4 add an address\n" +
    " 5 search for personal information\n" +
    " 6 delete personal information\n" +
    " 7 filtered listing\n" +
    " x quit\n");
    
    while(true) {
      System.out.println("command: ");
      String command = reader.nextLine();
      if(command.equals("1")) addNumber();
      else if(command.equals("2")) searchNumberByName();
      else if(command.equals("3")) searchNameByNumber();
      else if(command.equals("4")) addAddress();
      else if(command.equals("5")) searchPersonByName();
      else if(command.equals("6")) deletePerson();
      else if(command.equals("7")) searchKeyword();
      else if(command.equals("x")) break;
      System.out.println("");
    }
  }
    
  
  private void addNumber() {
    System.out.println("whose number: ");
    String name = reader.nextLine();
    System.out.println("number: ");
    String number = reader.nextLine();
    if(namePerson.containsKey(name)) namePerson.get(name).addNumber(number);
    else {
      Person person = new Person(name);
      person.addNumber(number);
      namePerson.put(name, person);
    }
    numberPerson.put(number, namePerson.get(name));
  }
  
  private void searchNumberByName() {
    System.out.println("whose number: ");
    String name = reader.nextLine();
    if(namePerson.containsKey(name)) {
      Set<String> numbers = namePerson.get(name).getNumbers();
      if(numbers.isEmpty()) System.out.println(" phone number unknown");
      else {
        for(String number:namePerson.get(name).getNumbers()) {
          System.out.println(" " + number);
        }
      }
    } else {
      System.out.println("  not found");
    }
  }
  
  private void searchNameByNumber() {
    System.out.println("number: ");
    String number = reader.nextLine();
    if(numberPerson.containsKey(number)) {
      System.out.println(" " + numberPerson.get(number).getName());
    } else System.out.println(" not found");
  }
  
  private void addAddress() {
    System.out.println("whose address: ");
    String name = reader.nextLine();
    System.out.println("Street: ");
    String address = reader.nextLine();
    System.out.println("City: ");
    address = address + " " + reader.nextLine();
    if(namePerson.containsKey(name)) {
      namePerson.get(name).addAddress(address);
      addressPerson.put(address,namePerson.get(name));
    } else {
      Person person = new Person(name);
      person.addAddress(address);
      namePerson.put(name, person);
      addressPerson.put(address, person);
    }
  }
  
  private void searchPersonByName() {
    System.out.println("whose information: ");
    String name = reader.nextLine();
    if(namePerson.containsKey(name)) {
      printPerson(namePerson.get(name));
    } else System.out.println("  not found");
  }
  
  private void printPerson(Person person) {
    Set<String> addresses = person.getAddresses();
    if(addresses.isEmpty()) {
      System.out.println("  address unknown");
    } else {
      System.out.print("  address: ");
      for(String address:addresses) System.out.print(address);
      System.out.println("");
    }
    Set<String> numbers = person.getNumbers();
    if(numbers.isEmpty()) System.out.println("  phone number not found");
    else {
      System.out.println("  phone numbers:");
      for(String number:numbers) System.out.println("   " + number);
    }      
  }
  
  private void deletePerson() {
    System.out.println("whose information: ");
    String name = reader.nextLine();
    if(namePerson.containsKey(name)) {
      for(String number:namePerson.get(name).getNumbers()) {
        numberPerson.remove(number);
      }
      for(String address:namePerson.get(name).getAddresses()) {
        addressPerson.remove(address);
      }
      namePerson.remove(name);
    }
  }
  
  private void searchKeyword() {
    System.out.println("keyword (if empty, all listed): ");
    String keyword = reader.nextLine();
    System.out.println("");
    Set<Person> matchPersons = new HashSet<Person>();
    for(String name:namePerson.keySet()) {
      if(name.contains(keyword)) matchPersons.add(namePerson.get(name));
    }
    for(String address:addressPerson.keySet()) {
      if(address.contains(keyword)) {
        matchPersons.add(addressPerson.get(address));
      }
    }
    if(matchPersons.isEmpty()) System.out.println(" keyword not found");
    else {
      List<Person> persons = new ArrayList<Person>(matchPersons);
      Collections.sort(persons);
      for(Person person:persons) {
        System.out.println(" " + person.getName());
        printPerson(person);
      }
    }
  }
  
  
}
