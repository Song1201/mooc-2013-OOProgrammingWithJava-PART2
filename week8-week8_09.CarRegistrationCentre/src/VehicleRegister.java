/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
import java.util.ArrayList;
/**
 *
 * @author lison
 */
public class VehicleRegister {
  private HashMap<RegistrationPlate,String> plateOwner;
  
  public VehicleRegister() {
    plateOwner = new HashMap<RegistrationPlate, String>();
  }
  
  public boolean add(RegistrationPlate plate,String owner) {
    if(plateOwner.containsKey(plate)) return false;
    plateOwner.put(plate, owner);
    return true;
  }
  
  public String get(RegistrationPlate plate) {
    if(plateOwner.containsKey(plate)) return plateOwner.get(plate);
    return null;
  }
  
  public boolean delete(RegistrationPlate plate) {
    if(plateOwner.containsKey(plate)) {
      plateOwner.remove(plate);
      return true;
    }
    return false;
  }
  
  public void printRegistrationPlates() {
    for(RegistrationPlate plate:plateOwner.keySet()) {
      System.out.println(plate);
    }
  }
  
  public void printOwners() {
    ArrayList<String> printedOwners = new ArrayList<String>();
    for(String owner:plateOwner.values()) {
      if(!printedOwners.contains(owner)) {
        System.out.println(owner);
        printedOwners.add(owner);
      }
    }
  }
}
