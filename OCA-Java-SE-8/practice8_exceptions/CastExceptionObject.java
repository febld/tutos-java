

public class CastExceptionObject {

  public static void main(String... args) {
    final Object exception = new Exception();
    final Exception data = (RuntimeException)exception; // THROWS ClassCastException at runtime
    System.out.print(data);
  }
}
