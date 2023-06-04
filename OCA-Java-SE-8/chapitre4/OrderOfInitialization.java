
public class OrderOfInitializationSimple {

  private String name="Torchie";                     // instance variable declaration
  { System.out.println(name); }                      // instance initializer
  private static int COUNT = 0;                      // static variable  declaration
  static { System.out.println(COUNT); }              // static initializer
  static { COUNT += 10; System.out.println(COUNT); } // static initializer
  
  public OrderOfInitializationSimple() {
    System.out.println("constructor simple");
  }
}

public class OrderOfInitializationComplex {

  private String name = "TorchieComplex";  // instance variable declaration
  { System.out.println(name); }            // instance initializer
  private static int COUNT = 0;            // static variable declaration
  static { System.out.println(COUNT); }    // static initializer
  { COUNT++; System.out.println(COUNT); }  // instance initializer
  
  public OrderOfInitializationComplex() {
    System.out.println("constructor complex");
  }
}

public class OrderOfInitializationHard {
  static { add(2); }                                           // static initializer
  static void add(int num) { System.out.print(num + "  "); } // static method
  OrderOfInitializationHard() { add(5); }                      // constructor
  static { add(4); }                                           // static initializer
  { add(6); }                                                  // instance initializer
  static { new OrderOfInitializationHard(); }                  // static initializer
  { add(8); }                                                  // instance initializer
}

public class OrderOfInitialization {
  public static void main(String... args) {
    System.out.println("main : simple call");
    OrderOfInitializationSimple init = new OrderOfInitializationSimple();
    
    System.out.println("\nmain : complex call");
    new OrderOfInitializationComplex();
    
    System.out.println("\nmain : hard call");
    new OrderOfInitializationHard(); // will output : "2  4  6  8  5  6  8  5"
  }
}