/*
 * calling Inherited Class Members
 */
 
class Fish {
  protected int size;
  private int age;
  
  public Fish(int age) {
    this.age = age;
  }
  
  public int getAge() {
    return age;
  }
}

public class Shark extends Fish {
  private int numberOfFins = 8;
  
  public Shark(int age) {
    super(age);
    this.size = 4;
  }
  
  public void displaySharkDetails() {
    System.out.println("Child and parent members called directly");
    System.out.println("1. Shark age  : " + getAge());
    System.out.println("1. Shark size : " + size + " meters long");
    System.out.println("1. Nb of fins : " + numberOfFins + " fins");
  
    System.out.println();
    System.out.println("Child and parent members called with \"this\"");
    System.out.println("2. Shark age  : " + this.getAge());
    System.out.println("2. Shark size : " + this.size + " meters long");
    System.out.println("2. Nb of fins : " + this.numberOfFins + " fins");
  
    System.out.println();
    System.out.println("Child members called with \"this\" and parent members called with \"super\"");
    System.out.println("3. Shark age  : " + super.getAge());
    System.out.println("3. Shark size : " + super.size + " meters long");
    //System.out.println("3. Nb of fins : " + super.numberOfFins + " fins"); // DOES NOT COMPILe : super can not be used for current class members
    System.out.println("3. Nb of fins : " + this.numberOfFins + " fins");
  }
  
  public static void main(String... args) {
    new Shark(19).displaySharkDetails();
  }
}