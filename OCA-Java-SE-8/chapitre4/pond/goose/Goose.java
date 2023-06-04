package pond.goose;

import pond.shore.Bird;

public class Goose extends Bird {

  public helpGooseSwim() {
    Goose other = new Goose;
    other.floatInWater;
    System.out.println(other.text);
  }
  
  public helpOtherGooseSwin() {
    Bird other = new Goose();
    other.floatInWater();           // DOES NOT COMPILE
    System.out.println(other.text); // DOES NOT COMPILE : different package and Bird not a subclass of Goose
  }
}