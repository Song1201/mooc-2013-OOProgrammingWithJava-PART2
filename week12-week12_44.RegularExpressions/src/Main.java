
public class Main {

  public static void main(String[] args) {
    // write test code here
   
  }
  
  public static boolean isAWeekDay(String string) {
    return string.matches("mon|tue|wed|thu|fri|sat|sun");
  }
  
  public static boolean allVowels(String string) {
    return string.matches("(a|e|i|o|u|ä|ö)*");
  }
  
  public static boolean clockTime(String string) {
    if(string.matches("[0-9]{2}(:[0-5][0-9]){2}")) {
      int hour = Integer.parseInt(string.substring(0, 2));
      if(hour<24 && hour>=0) return true;
    }
    return false;
  }
}
