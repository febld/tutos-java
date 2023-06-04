package chapitre2;

public class Operators {

  public static void main(String[] args) {

    //int x = 1.0;       // DON'T COMPILE
    //short y = 1921222; // DON'T COMPILE
    //int z = 9f;        // DON'T COMPILE
    
    short x = 10;
    short y = 4;
    short z = (short)(x * y);
    System.out.println(z);

    long u = 5;
    long v = (u=3);
    System.out.println(u);
    System.out.println(v);
  }
}
