
public class RegistrationPlate {
  // don't change the code which is already given to you

  // ATTENTION: the object variable types are final, meaning that their value cannot be changed!
  private final String regCode;
  private final String country;

  public RegistrationPlate(String country, String regCode) {
    this.regCode = regCode;
    this.country = country;
  }

  @Override
  public String toString() {
    return country + " " + regCode;
  }
  
  @Override
  public boolean equals(Object object) {
    if(object==null) return false;
    if(getClass()!=object.getClass()) return false;
    RegistrationPlate compared = (RegistrationPlate) object;
    if(regCode.equals(compared.regCode) && country.equals(compared.country)) {
      return true;
    } else return false;
  }
  
  @Override
  public int hashCode() {
    if(regCode==null) return 35;
    return (regCode+country).hashCode();
  }

}
