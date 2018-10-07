
public class Main {

  public static void main(String[] Container) {
    Container container = new Container(1000);
    addSuitcasesFullOfBricks(container);
    System.out.println(container);
  }

  public static void addSuitcasesFullOfBricks(Container container) {
    // adding 100 suitcases with one brick in each
    int numSuitcases = 100;
    int containerWeightLimit = 1000;
    int brickWeight = 1;
    for(int i = 0;i<numSuitcases;i++) {
      Suitcase suitcase = new Suitcase(containerWeightLimit);
      suitcase.addThing(new Thing("Brick",brickWeight));
      container.addSuitcase(suitcase);
      brickWeight++;
    }
  }
}
