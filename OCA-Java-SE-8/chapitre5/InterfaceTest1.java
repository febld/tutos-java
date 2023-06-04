/*
 *  INTERFACE DEFINITION
 *
 *  1) Interfaces cannot be instantiated directly
 *  2) An interface is not required to have any method
 *  3) An interface may not be marked as final
 *  4) All top-level interfaces are assumed to have public or default access.
 *     They are assumed to be abstract wether this keyword is used or not.
 *     Therefore, making a method private, protected or final will trigger a
 *     compiler error as it is incompatible with these assumptions.
 *  5) All non default methods in an interface are assumed to have modifiers
 *     abstract and public in their definition. Therefore, marking a method as
 *     private, protected or final will trigger compiler errors as these are
 *     incompatible with the abstract and public keywords.
 *
 *  The 4th rule does not apply to inner interfaces.
 *
 *
 *  INHERITING AN INTERFACE
 *
 *  1) An interface that extends another interface, as well as an abstract class
 *     that implements an interface, inherits all of the abstract methods as its
 *     own abstract methods.
 *  2) The first concrete class that implements an interface, or extends an
 *     abstract class that implements an interface, must provide an
 *     implementation for all of the inherited abstract methods.
 *
 *
 *  INTERFACES VARIABLES
 *
 *  1) Interface variables are assumed to be public, static, and final.
 *     Therefore, marking a variable as private or protected will trigger a
 *     compiler error, as will marking any variable as abstract
 *  2) The value of an interface variable must be set when it is declared since
 *     it is marked as final.
 *
 *
 *  DEFAULT INTERFACE METHODS
 *
 *  1) A default method may only be declared within an interface and not within
 *     a class or abstract class
 *  2) A default method must be marked with the default keyword. If a method is
 *     marked as default, it must provide a body.
 *  3) A default method is not assumed to be static, final, or abstract, as it
 *     may be used or overridden by a class that implements the interface.
 *  4) Like all methods in an interface, a default method is assumed to be
 *     public and will not compile if marked as private or protected
 *
 *
 *  STATIC INTERFACE METHODS
 *
 *  1) Like all methods in an interface, a static method is assumed to be public
 *     and will not compile if marked as private or protected
 *  2) To reference the static method, a reference to the name of the interface
 *     must be used.
 */

interface CanFly {                 // COMPILED AS :     abstract interface CanFly {
    void fly(int speed);           // COMPILED AS :     public abstract void fly(int speed);
    abstract void takeoff();       // COMPILED AS :     public abstract void takeoff();
    public abstract double dive(); // COMPILED AS IS
}

//private final interface CanCrawl {   // DOES NOT COMPILE : private not allowed, final can not be combined with interface
//  private void dig(int depth);       // DOES NOT COMPILE : private not allowed
//  protected abstract double depth(); // DOES NOT COMPILE : protected not allowed
//  public final void surface();       // DOES NOT COMPILE : final not allowed
//}


interface CanCrawl {
    public void dig(int depth);

    static int getDepth() {
        return 5;
    }

}

interface CanSwim {
    int MAX_DEPTH = 100;                       // COMPILED AS : public static final int MAX_DEPTH = 100;
    final static boolean UNDERWATER = true;    // COMPILED AS : public static final boolean UNDERWATER = true
    public static final String TYPE = "float"; // COMPILED AS IS

    //private int MAXIMUM_DEPTH = 100;               // DOES NOT COMPILE
    //protected abstract boolean UNDERWATER = false; // DOES NOT COMPILE
    //public static String TYPE;                     // DOES NOT COMPILE
}

//class InterfaceTest0 implements CanFly, CanCrawl {}  // DOES NOT COMPILE : abstract methods not overriden


public class InterfaceTest1 implements CanFly, CanCrawl {

    public void fly (int speed) {
    }
    public void takeoff() {
    }
    public double dive() {
        return 2.0;
    }
    public void dig(int depth) {
    }

    public void testStaticMethod() {
        //System.out.println("test static : " + getDepth()); // DOES NOT COMPILE : static method must be called with reference to interface
        System.out.println("test static : " + CanCrawl.getDepth());
    }

    public static void main(String[] args) {
        new InterfaceTest1().testStaticMethod();
    }
}