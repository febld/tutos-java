package pond.swan;

import pond.shore.Bird;

public class Swan extends Bird {

  public void swim() {
    floatInWater();           // inheritance : package access to super class
    System.out.println(text); // inheritance : package access to super class
  }
  
  public void helpOtherSwanSwim() {
    Swan other = new Swan();
    other.floatInWater();           // rule for the reference type "Swan" : package access to super class
    System.out.println(other.text); // rule for the reference type "Swan" : package access to super class
  }
  
  public void helpOtherBirdSwim() {
    Bird other = new Bird();
    other.floatInWater();           // DOES NOT COMPILE : rule for the reference type "Bird" : not a subclass
    System.out.println(other.text); // DOES NOT COMPILE : rule for the reference type "Bird" : not a subclass
  }
}