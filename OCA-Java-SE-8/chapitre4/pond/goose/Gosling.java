package pond.goose;

import pond.shore.Bird;  // Bird is in a different package

public class Gosling extends Bird {  // create subclass
  public void swim() {
    floatInWater();            // calling protected member
    System.out.println(text);  // calling protected member
  }
}
