
public class Bird {

  private String name;
  private String latinName;
  private int ringingYear;

  public Bird(String name, String latinName, int ringingYear) {
    this.name = name;
    this.latinName = latinName;
    this.ringingYear = ringingYear;
  }

  @Override
  public String toString() {
    return this.latinName + " (" + this.ringingYear + ")";
  }

  @Override
  public boolean equals(Object obj) {
    if(obj==null) return false;
    if(obj.getClass()!=getClass()) return false;
    Bird other = (Bird)obj;
    return hashCode()==other.hashCode();
  }

  @Override
  public int hashCode() {
    return (latinName + ringingYear).hashCode();
  }

  public String getLatinName() {
    return latinName;
  }

  public int getRingingYear() {
    return ringingYear;
  }

}
