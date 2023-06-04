
public class StaticInitialization {
  
  private static final int NUM_SECONDS_PER_HOUR;
  
  private static int one;
  
  private static final int two;
  private static final int three = 3;
  //private static final int four;      // DOES NOT COMPILED : not initialized in source
  
  static {
    int numSecondsPerMinute = 60;
    int numMinutesPerHour = 60;
    NUM_SECONDS_PER_HOUR = numSecondsPerMinute * numMinutesPerHour;
    System.out.println("static:" + NUM_SECONDS_PER_HOUR);
    
    one = 1;
    two = 2;
    //three = 3; // DOES NOT COMPILE : can not assign again a final variable
    //two = 4;   // DOES NOT COMPILE : can not assign again a final variable
    
  }
  
  public static void main(String[] args) {
    System.out.println("main:" + NUM_SECONDS_PER_HOUR);
  }
}