/*
 * Overriding a method
 *  1. same method signature
 *  2. child class method as accessible or more accessible than the parent class method
 *  3. child class method may not throw a checked exception that is new or broader than
 *     the class of any exception thrown in the parent class method
 *  4. if the methods returns a value, it must be the same or a subclass of the method
 *     in the parent class, known as covariant return types
 */

class DataException extends Exception {}

class Canine {
  public double getAverageWeight() {
    return 50;
  }
  
  protected double getHeight()  throws Exception {
    return 2;
  }
  
  protected int getAge() throws DataException {
    return 10;
  }
  
  public void displayCanineWeight()  {
    System.out.println("Canine weight = " + getAverageWeight());
  }
}

class Wolf extends Canine {
  public double getAverageWeight() {
    //return getAveragWeight(); // INFINITE LOOP
    return super.getAverageWeight() + 20;
  }
  
  public void displayWolfWeight() {
    System.out.println("Wolf weight = " + getAverageWeight());
  }
  
  //private double getAverageWeight() { // DOES NOT COMPILE : less accessible thant parent
  //  return 2;
  //}
  
  //public String getAverageWeight() { // DOES NOT COMPILE : different method signature
  //  return "2";
  //}
  
  //public double getAverageWeight() throws Exception { // DOES NOT COMPILE : new created exception
  //  return 2.0;
  //}
  
  protected double getHeight() throws DataException {
    return 3;
  }
  
  protected int getAge() {
    return 20;
  }
  
  //protected int getAge() throws Exception { // DOES NOT COMPILE : broader exception
  //  return 15;
  //}

}

public class MethodOverriding {
  public static void main(String... args) {
    Canine c = new Canine();
    Wolf w = new Wolf();
    System.out.println(c.getAverageWeight());
    System.out.println(w.getAverageWeight());
    c.displayCanineWeight(); // use original canine getAverageWeight() call
    w.displayCanineWeight(); // override getAverageWeight() call in parent with child method
    w.displayWolfWeight();
    
    try {
      System.out.println(new Canine().getHeight());
      System.out.println(new Wolf().getHeight());
      System.out.println(new Canine().getAge());
      System.out.println(new Wolf().getAge());
    }
    catch (Exception e) {
      System.out.println("Exception : " + e.getMessage());
    }
  }
}