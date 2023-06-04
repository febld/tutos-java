package chapitre1;

//import java.nio.*;  // NOT GOOD : * only matches class names
import java.nio.file.*; // GOOD

public class InputImports {
    public void read(Files files) {
       Paths.get("name");
    }

  public static void main(String[] args) {}
}
