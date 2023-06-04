
public class OverloadingMethods {

  public static void main(String... args) {
    
    fly(new int[] {1, 2, 3});        // can call array version method
    flyVarArgs(new int[] {1, 2, 3}); // can call vararg version
    
    //fly(1, 2, 3); // DOES NOT COMPILE : can not call array version -> fly(int, int, int) not found
    flyVarArgs(1, 2, 3);
  }
  
  /*
   * Overloading
   *
   * Different method signature with :
   *                  same name but
   *                  different parameters (type, number)
   *
   * Can also be different (but irrelevant to overloading)
   *    access modifiers
   *    specifiers (static, ..)
   *    return types
   *    exception
   */
  public void fly(int numMiles) { System.out.println("int"); }
  public void fly(short numFeet) { System.out.println("short"); }
  public boolean fly() { System.out.println("empty args (return boolean)"); return false; }
  void fly(int numMiles, short numFeet) { System.out.println("int, short"); }
  public void fly(short numFeet, int numMiles) throws Exception { System.out.println("short, int"); }
  
  //public int fly(int numMiles2) {}         // DOES NOT COMPILE : fly(int) already defined
  //public static void fly(int numMiles3) {} // DOES NOT COMPILE : fly(int) already defined
  
  /*
   * Array and Varargs
   */
  public static void fly(int[] lengths) { System.out.println("array:" + lengths.length); }
  //public void fly(int... lengths) {} // DOES NOT COMPILE : array and varargs are considered the same type
  
  public static void flyVarArgs(int... lengths) { System.out.println("flyVarArgs:" + lengths.length); }
}