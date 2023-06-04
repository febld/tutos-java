
public class PassingDataAmongMethods {

  public static void main(String... args) {
    
    /**********************************
     * Java is "pass-by-value" language
     */
    
    // primitive type
    int num = 4;
    newNumber(num);
    System.out.println(num); // 4 
    
    // reference type
    String name = "Webby";
    speak(name);
    System.out.println(name); // Webby
    
    // method call on parameter
    StringBuilder name2 = new StringBuilder("Webby");
    speak(name2);
    System.out.println(name2); // WebbySparky
    
    /***************************************************
     * Java returns a copy of the primitive or reference
     */
    int number = 1;                        // 1
    String letters = "abc";                // abc
    number(number);                        // 1 (returned value 2 is ignored
    letters = letters(letters);            // abcd
    System.out.println(number + letters);  // 1abcd
  }
  
  // variable assignment to the passed parameter (primitive type)
  public static void newNumber(int num) {
    num = 8;
  }
  
  // variable assignment to the passed parameter (reference type)
  public static void speak(String name) {
    name = "Sparky";
  }
  
  // method call on the passed parameter
  public static void speak(StringBuilder s) {
    s.append("Sparky");
  }
  
  // returns a copy of a primitive
  public static int number(int number) {
    number++;
    return number;
  }
  
  // returns a copy of a reference
  public static String letters(String letters) {
    letters += "d";
    return letters;
  }
}