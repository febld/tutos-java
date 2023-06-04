/*
 * Hiding static method
 *  1. same method signature
 *  2. child class method at least as accessible or more accessible than the parent class method
 *  3. child class method may not throw a checked exception that is new or broader than
 *     the class of any exception thrown in the parent class method
 *  4. if the methods returns a value, it must be the same or a subclass of the method
 *     in the parent class, known as covariant return types
 *  5. the child class method must be marked as "static" if it is marked as "static" in
 *     the parent class (method hiding). Likewise, the method must not be marked as "static" in
 *     the child class if it is not marked as "static" in the parent classs (method overriding).
 */

/* ----- */
class Bear {
  public static void eat() {
    System.out.println("Bear is eating");
  }
  
  public static void sneeze() {
    System.out.println("Bear is sneezing");
  }
  
  public void hibernate() {
    System.out.println("Bear is hibernating");
  }
  
  public void displayBearEating() {
    System.out.println("Bear eat method : ");
    eat();
  }
}

/* ----- */
class Panda extends Bear {
  public static void eat() {
    System.out.println("Panda bear is chewing");
  }
  
  //public void sneeze() { // DOES NOT COMPILE
  //  System.out.println("Panda bear sneezes");
  //}
  
  //public static void hibernate() { // DOES NOT COMPILE
  //  System.out.println("Panda bear is going to sleep");
  //}
  
  public void displayPandaEating() {
    System.out.println("Panda eat method : ");
    eat();
  }
}

/* ----- */
public class MethodHiding {
  public static void main(String[] args) {
    Panda p = new Panda();
    p.eat();
    p.displayBearEating(); // static method "eat" is hidden but not overriden in parent
    p.displayPandaEating();
  }
}
