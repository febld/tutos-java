class Animal {
  private int age;
  public Animal(int age) {
    super();
    this.age = age;
    System.out.println("Animal created. Age = " + this.age);
    //super(); // DOES NOT COMPILE : must be first statement
  }
}

public class Zebra extends Animal {
  
  String name;
  
  public Zebra(int age) {
    super(age);
  }
  
  public Zebra() {
    this(4);
  }
  
  public Zebra(String s) {
    super(4);
    this.name = s;
  }
  
  public static void main(String... args) {
    Zebra z1 = new Zebra();
    Zebra z2 = new Zebra(5);
    Zebra z3 = new Zebra("toto");
  }
}