/****
 * ABSTRACT classes
 *
 *  1) Abstract classes cannot be instantiated directly.
 *  2) Abstract classes may be defined with any number including Zero,
 *     of abstract and non abstract methods.
 *  3) Abstract classes may not be marked as private, protected or final.
 *  4) An abstract class that extends another abstract class inherits all of its
 *     abstract methods as its own abstract methods.
 *  5) The first concrete class that extends an abstract class must provide an
 *     implementation for all of the inherited abstract methods.
 *
 *
 * ABSTRACT methods
 *
 *  1) Abstract methods may only be defined in abstract classes.
 *  2) Abstract methods may not be declared as private, protected or final
 *  3) Abstract methods must not provide a method body/implementation in the
 *     abstract class for which it is declared.
 *  4) Implementing an abstract method in a subclass follows the same rules for
 *     overriding a method. For example, the name and signature must be the same,
 *     and the visibility of the method in the subclass must be at least as
 *     accessible as the method in the parent class.
 */

abstract class Animal {

  protected int age;

  public void eat() {
    System.out.println("Abstract animal is eating");
  }

  public abstract String getName();

  //public abstract void swim() {}   // DOES NOT COMPILE : abstract method can not have a body

  //public abstract int getAge() {  // DOES NOT COMPILE : abstract method cannot have a body
  //  return 10;
  //}

  //public abstract final void chew(); // DOES NOT COMPILE : cannot combine abstract and final

  //private abstract void chew(); // DOES NOT COMPILE : cannot combine abstract and private

}

public class AbstractClassTest1 extends Animal {

  //public abstract void peck(); // DOES NOT COMPILE

  public String getName() {
    return "AbstractClass1";
  }

  public static void main(String... args) {
    System.out.println(new AbstractClass1().getName());
  }

}