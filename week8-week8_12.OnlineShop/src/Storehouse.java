/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 *
 * @author lison
 */
public class Storehouse {
  private Map<String,Integer> productPrice;
  private Map<String,Integer> productStock;
  private static final int NUM_FOR_NULL = -99;
  
  public Storehouse() {
    productPrice = new HashMap<String, Integer>();
    productStock = new HashMap<String, Integer>();
  }
  
  public void addProduct(String product,int price,int stock) {
    productPrice.put(product,price);
    productStock.put(product,stock);
  }
  
  public int price(String product) {
    if(productPrice.containsKey(product)) return productPrice.get(product);
    return NUM_FOR_NULL;
  }
  
  public int stock(String product) {
    if(productStock.containsKey(product)) return productStock.get(product);
    return 0;
  }
  
  public boolean take(String product) {
    if(productStock.containsKey(product)) {
      if(productStock.get(product)>0) {
        productStock.put(product,productStock.get(product)-1);
        return true;
      }
    }
    return false;
  }
  
  public Set<String> products() {
    return productStock.keySet();
  }
}
