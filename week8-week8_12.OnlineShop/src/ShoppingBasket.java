/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author lison
 */
public class ShoppingBasket {
  private Map<String,Purchase> cart;

  public ShoppingBasket() {
    cart = new HashMap<String,Purchase>();
  }
  
  public void add(String product,int price) {
    if(cart.containsKey(product)) {
      cart.get(product).increaseAmount();
    } else cart.put(product,new Purchase(product, 1, price));
  }
  
  public int price() {
    int totalPrice = 0;
    for(Purchase purchase:cart.values()) totalPrice += purchase.price();
    return totalPrice;
  }
  
  public void print() {
    for(String product:cart.keySet()) {
      System.out.println(product + ": " + cart.get(product).getAmount());
    }
  }
  
}
