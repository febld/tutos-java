public class OverloadingConstructor {

  private String color;
  private int weight;
  
  public OverloadingConstructor(int weight) { // 1st constructor
    /*
     * code duplication method
     */
    //this.weight = weight;
    //color = "brown";
    
    /*
     * call of 2nd constructor method
     */
    //WRONG CALL METHODS :
    //OverloadingConstructor(weight, "brown");     // DOES NOT COMPILE : constructor must be called with "new"
    //new OverloadingConstructor(weight, "brown"); // COMPILES but does not do what we want : an other instance is created
    
    //CORRECT CALL with this
    //System.out.println("BEFORE this(...) --> WILL NOT COMPILE");
    this(weight, "brown"); // constructor is called on same instance "this".
                           // !!! "this(...)" must be the first uncommented statement called
                           //     DOES NOT COMPILe if "this()" is not the first statement in constructor
  }
  
  public OverloadingConstructor(int weight, String color) { // 2d constructor
    this.weight = weight;
    this.color = color;
  }
  
  public static void main(String... args) {}
}