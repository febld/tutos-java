/*
 * Redeclaring private methods
 */
 
class Camel {
  private String getNumberOfHumps() {
    return "Undefined";
  }
}

class BactrianCamel extends Camel {
  private int getNumberOfHumps() {
    return 2;
  }
  
  public void displayHumps() {
    System.out.println("Child Humps = " + getNumberOfHumps());
    System.out.println("Child Humps = " + this.getNumberOfHumps());
    //System.out.println("Parent humps = " + super.getNumberOfHumps()); // DOES NOT COMPILE
  }
}

public class RedeclaringPrivateMethod {

  public static void main(String... args) {
    new BactrianCamel().displayHumps();
  }
}