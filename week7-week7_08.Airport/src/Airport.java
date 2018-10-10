/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author lison
 */
public class Airport {
  private HashMap<String,Plane> idPlane;
  private ArrayList<Flight> flights;
  private Scanner reader;

  public Airport(Scanner reader) {
    idPlane = new HashMap<String, Plane>();
    flights = new ArrayList<Flight>();
    this.reader = reader; 
  }
  
  public void airportPanel() {
    System.out.println("Airport panel");
    System.out.println("--------------------");
    System.out.println("");
    while(true) {
      System.out.println("Choose operation:");
      System.out.println("[1] Add airplane");
      System.out.println("[2] Add flight");
      System.out.println("[x] Exit");
      String command = reader.nextLine();
      if(command.equals("x")) {
        System.out.println("");
        break;
      } else if(command.equals("1")) {
        addPlane();
      } else if(command.equals("2")) {
        addFlight();
      }
    }
  }
  
  private void addPlane() {
    System.out.print("Give plane ID: ");
    String id = reader.nextLine();
    System.out.print("Give plane capacity: ");
    int capacity = Integer.parseInt(reader.nextLine());
    idPlane.put(id, new Plane(id,capacity));
  }
  
  private void addFlight() {
    System.out.print("Give plane ID: ");
    String id = reader.nextLine();
    System.out.print("Give departure airport code: ");
    String departure = reader.nextLine();
    System.out.println("Give destination airport code: ");
    String destination = reader.nextLine();
    flights.add(new Flight(idPlane.get(id),departure,destination));
  }
  
  public void flightService() {
    System.out.println("Flight service");
    System.out.println("------------");
    System.out.println("");
    while(true) {
      System.out.println("Choose operation:");
      System.out.println("[1] Print planes\n[2] Print flights\n"
              + "[3] Print plane info\n[x] Quit");
      String command = reader.nextLine();
      if(command.equals("x")) {
        System.out.println("");
        break;
      } else if(command.equals("1")) printPlanes();
      else if(command.equals("2")) printFlights();
      else if(command.equals("3")) printPlaneInfo();
        
        
      }
  }
  
  // printPlane does not switch line for the convinience of printFlights
  private void printPlane(Plane plane) {
    System.out.print(plane.getId()+" ("+plane.getCapacity()+" ppl)");
  }
  
  private void printPlanes() {
    for(String key:idPlane.keySet()) {
      printPlane(idPlane.get(key));
      System.out.println("");
    }
  }
  
  private void printFlights() {
    for(Flight flight:flights) {
      printPlane(flight.getPlane());
      System.out.println(" ("+flight.getDeparture()+"-"+flight.getDestination()
      +")");
    }
    System.out.println("");
  }
  
  private void printPlaneInfo() {
    System.out.println("Give plane ID: ");
    String id = reader.nextLine();
    printPlane(idPlane.get(id));
    System.out.println("");
    System.out.println("");
  }

}
  

  

