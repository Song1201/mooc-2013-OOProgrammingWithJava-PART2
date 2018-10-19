package boxes;

public class Thing {

    private String name;
    private int weight;

    public Thing(String name, int weight) {

        this.name = name;
        if(weight<0) throw new IllegalArgumentException();
        this.weight = weight;
    }

    public Thing(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if(obj==null) return false;
    if(obj.getClass()!=getClass()) return false;
    Thing other =  (Thing)obj;
    return hashCode()==other.hashCode();
  }
  
  
    

}
