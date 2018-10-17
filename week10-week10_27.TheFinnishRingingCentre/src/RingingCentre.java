/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author lison
 */
public class RingingCentre {
  private Map<Bird, List<String>> birdPlace;

  public RingingCentre() {
    birdPlace = new HashMap<Bird, List<String>>();
  }
   
  public void observe(Bird bird, String place) {
    if(birdPlace.containsKey(bird)) birdPlace.get(bird).add(place);
   
    else {
      List<String> places = new ArrayList<String>();
      places.add(place);
      birdPlace.put(bird, places);
    }
  }
  
  public void observations(Bird bird) {
    System.out.print(bird.getLatinName() + " (" + bird.getRingingYear() + 
            ") observations: ");
    if(birdPlace.containsKey(bird)) {
      List<String> places = birdPlace.get(bird);
      System.out.println(places.size());
      for(String place:places) System.out.println(place);
    } else System.out.println("0");
  }
}
