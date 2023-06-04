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
    public abstract String getName();
}

abstract class BigCat extends Animal {

    public String getName() {
        return "BigCat";
    }

    public abstract void roar();
}

public class AbstractClassTest3 extends BigCat {
    //public String getName() {
    //  return "ConcreteClass2 : Lion";
    //}

    public void roar() {
        System.out.println("ConcreteClass2 : the lion lets out a loud ROAR");
    }

    public static void main(String[] args) {
        ConcreteClass2 cc = new ConcreteClass2();
        System.out.println(cc.getName());
        cc.roar();
    }
}