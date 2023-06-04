import java.util.List;
//import static java.util.Arrays;       // DOES NOT COMPILE : only members
//static import java.util.Arrays.*;     // DOES NOT COMPILe : bad syntax. Use "import static ..."

//import static java.util.Arrays.asList;  // STATIC import with specific member
import static java.util.Arrays.*;         // STATIC import with wildcard

public class StaticImports {

  public static void main(String... args) {
    List<String> list = asList("one", "two");  // no use of : Arrays.asList(...)
    System.out.println(list.get(1));
    
    Arrays.asList("one"); // DOES NOT COMPILe : java.util.Arrays class not imported
  }
}