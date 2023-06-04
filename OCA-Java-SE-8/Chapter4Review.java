public class Chapter4Review {

  private static final String question13_leftRope;
  private static final String question13_rightRope;
  //private static final String question13_bench; // DO NOT COMPILe : not ititialied in the default constructor
  private static final String question13_name = "name";
  static {
    question13_leftRope = "left";
    question13_rightRope = "right";
  }
  static {
    //question13_name = "name";       // DO NOT COMPILE : final variable cannot be reassigned
    //question13_rightRope = "right"; // DO NOT COMPILE : final variable already assigned
  }
  
  public static void main(String[] args) {
    //question5();
    //question13_bench = "bench"; // DO NOT COMPILE : final variable cannot be assigned here
    question17();
  }
  
  private static void question5() {
    // howMany();                   // DO NOT COMPILE : cannot be applied to given types, required boolean, boolean[]
    howMany(true);
    howMany(true, true);
    howMany(true, true, true);
    //howMany(true, {true});        // DO NOT COMPILE : parsing individual files failed
    //howMany(true, {true, true});  // idem
    howMany(true, new boolean[] {true});
    howMany(true, new boolean[] {true, true});
    howMany(true, new boolean[2]);
  }
  private static int howMany(boolean b, boolean... b2) {
    System.out.println(b2.length);
    return b2.length;
  }
  
  private static void question17() {
    StringBuilder s1 = new StringBuilder("s1");
    StringBuilder s2 = new StringBuilder("s2");
    StringBuilder s3 = work17(s1, s2);
    System.out.println("s1 = " + s1);
    System.out.println("s2 = " + s2);
    System.out.println("s3 = " + s3);
  }
  private static StringBuilder work17(StringBuilder a, StringBuilder b) {
    a = new StringBuilder("a");
    b.append("b");
    return a;
  }
  
  
}