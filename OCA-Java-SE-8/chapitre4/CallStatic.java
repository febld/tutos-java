
public class CallStatic {

  public static void main(String[] args) {
    Koala k = new Koala();
    System.out.println(k.count); //1 
    k = null;
    System.out.println(k.count); // 1 : compilator use the type of the reference instead of the object itself
    
    Koala.count = 4;
    System.out.println(Koala.count); // 4
    Koala k1 = new Koala();
    System.out.println(Koala.count); // 5
    Koala k2 = new Koala();
    System.out.println(Koala.count); // 6
    k1.count = 7;
    System.out.println(Koala.count); // 7
    k2.count = 5;
    System.out.println(Koala.count); // 5
    
  }
   
}

public class Koala {
  public static int count = 0; // static variable
  
  public Koala() {
    count++;
  }
  
  public static void printCount() {
    System.out.println(count);
  }
}