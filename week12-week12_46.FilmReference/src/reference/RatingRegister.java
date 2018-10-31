/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;
import java.util.*;
import reference.domain.*;

/**
 *
 * @author lison
 */
public class RatingRegister {
  private Map<Film, List<Rating>> filmRatings;
  private Map<Person, Map<Film, Rating>> personalRatings;

  public RatingRegister() {
    filmRatings = new HashMap<Film,List<Rating>>();
    personalRatings = new HashMap<Person, Map<Film, Rating>>();
  }  
  
  public void addRating(Film film, Rating rating) {
    List<Rating> ratings = filmRatings.get(film);
    if(ratings==null) {
      ratings = new ArrayList<Rating>();
      ratings.add(rating);
      filmRatings.put(film, ratings);
    } else ratings.add(rating);
  }
  
  public List<Rating> getRatings(Film film) {
    return filmRatings.get(film);
  } 
  
  public Map<Film, List<Rating>> filmRatings() {
    return filmRatings;
  }
  
  public void addRating(Person person, Film film, Rating rating) {
    Map<Film, Rating> personalRating = personalRatings.get(person);
    // person hasn't rated any film.
    if(personalRating==null) {
      personalRating = new HashMap<Film, Rating>();
      personalRating.put(film, rating);
      personalRatings.put(person, personalRating);
      addRating(film, rating);
    } else {
      Rating ratingFromThePerson = personalRating.get(film);
      // Person has already rated this film
      if(ratingFromThePerson!=null) {
        filmRatings.get(film).remove(ratingFromThePerson);
      }
      personalRating.put(film, rating);
      addRating(film, rating);
    }
  }
  
  public Rating getRating(Person person, Film film) {
    Rating rating = personalRatings.get(person).get(film);
    if(rating==null) return Rating.NOT_WATCHED;
    return rating;
  }

  public Map<Film, Rating> getPersonalRatings(Person person) {
    Map<Film,Rating> ratingsFromSb = personalRatings.get(person); 
    if(ratingsFromSb==null) return new HashMap<Film,Rating>();
    return ratingsFromSb;
  }
  
  public List<Person> reviewers() {
    return new ArrayList(personalRatings.keySet());
  }
  
  public List<Film> films() {
    return new ArrayList(filmRatings.keySet());
  }
  
}
