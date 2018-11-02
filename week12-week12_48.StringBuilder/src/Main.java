
public class Main {

  public static void main(String[] args) {
    int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(build(t));
  }

  public static String build(int[] t) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{\n");
    int LINE_LENGTH = 4;
    for(int i=0;i<t.length-1;i++) {
      stringBuilder.append(" " + t[i] + ",");
      if((i+1)%LINE_LENGTH==0) stringBuilder.append("\n");
    }
    stringBuilder.append(" ").append(t[t.length-1]).append("\n}\n");
    
    return stringBuilder.toString();
  }
}
