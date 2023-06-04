public class Remember {
  public static void think() throws Exception {
    throw new Exception();
  }
  public static void think2() throws Exception {
    //try { // DOES NOT COMPILE without either a catch or a finally
    //    throw new Exception();
    //}
  }
  public static void main(String... args) throws Exception {
    think();
  }
}
