/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;
import java.util.*;
import reference.domain.*;
/**
 *
 * @author lison
 */
public class FilmComparator implements Comparator<Film>{
  private Map<Film,List<Rating>> filmRatings;
  
  public FilmComparator(Map<Film, List<Rating>> ratings) {
    filmRatings = ratings;
  }

  @Override
  public int compare(Film o1, Film o2) {
    return mean(filmRatings.get(o2)) - mean(filmRatings.get(o1));
  }
  
  private int mean(List<Rating> ratings) {
    int sum = 0;
    for(Rating rating:ratings) sum += rating.getValue();
    return sum/ratings.size();
  }
}
