
public class Football {
  public static void main(String... args) {
    try {
      System.out.print('A');
      throw new RuntimeException("out of bounds!");
    }
    catch (ArrayIndexOutOfBoundsException aioobe) {
      System.out.print('B');
      //throw t; // DOES not COMPILE : t not declared
    }
    finally {
      System.out.print('C');
    }
  }
}
