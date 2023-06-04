/*
 * Constructors compiler enhancements
 */

class Mammal {
  public Mammal(int age) {
  }
}

public class Elephant extends Mammal {
  // DOES NOT COMPILE if no constructor because compiler adds default constructor with no args : 
  // public Elephant() {
  //   super(); // should call with an int args : super(10)
  // }
}