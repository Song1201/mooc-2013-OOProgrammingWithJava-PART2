/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;
import java.util.*;
import reference.domain.*;
import reference.comparator.*;
/**
 *
 * @author lison
 */
public class Reference {
  private RatingRegister ratings;

  public Reference(RatingRegister ratings) {
    this.ratings = ratings;
  }
  
  public Film recommendFilm(Person person) {
    // The person hasn't rated any film.
    if(!ratings.reviewers().contains(person)) return recommendWithoutTaste();
    if(watchedAllFilms(person)) return null;
    Person similarOne = findMostSimilar(person);
    if(similarOne==null) return recommendWithoutTaste();
    Film toRecommend = null;
    Map<Film,Rating> ratingsFromSimilarOne = 
            ratings.getPersonalRatings(similarOne);
    Set<Film> watched = ratings.getPersonalRatings(person).keySet();
    Rating bestRating = Rating.NEUTRAL;
    for(Film film:ratingsFromSimilarOne.keySet()) {
      if(ratingsFromSimilarOne.get(film).getValue()>bestRating.getValue() &&
              !watched.contains(film)) {
        toRecommend = film;
        bestRating = ratingsFromSimilarOne.get(film);
      }
    }
    return toRecommend;
  }
  
  private Film recommendWithoutTaste() {
    FilmComparator filmComparator = new FilmComparator(ratings.filmRatings());
    List<Film> films = new ArrayList<Film>(ratings.films());
    Collections.sort(films,filmComparator);
    return films.get(0);    
  }
  
  private Person findMostSimilar(Person person) {
    int maxSimilarity = 0;
    // If no similar other person is found, return null.
    Person mostSimilar = null;
    for(Person other:ratings.reviewers()) {
      if(other==person) continue;
      int similarity = computeSimilarity(person,other);
      if(similarity>maxSimilarity) {
        maxSimilarity = similarity;
        mostSimilar = other;
      }
    }
    return mostSimilar;
  }
  
  private int computeSimilarity(Person person, Person other) {
    int similarity = 0;
    for(Map.Entry<Film,Rating> rating:
            ratings.getPersonalRatings(person).entrySet()) {
      Film film = rating.getKey();
      Rating othersRating = ratings.getRating(other, film);
      similarity += rating.getValue().getValue()*othersRating.getValue();
    }
    return similarity;
  }
  
  private boolean watchedAllFilms(Person person) {
    for(Film film:ratings.films()) {
      if(!ratings.getPersonalRatings(person).containsKey(film)) return false;
    }
    return true;
  }
}
