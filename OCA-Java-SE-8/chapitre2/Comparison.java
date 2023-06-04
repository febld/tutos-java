public class Comparison {

    public static void main(String... args) {

        int x = 0;
        Integer y = null;
        String s = null;

        System.out.println("x = " + x);
        System.out.println("y = " + y);                   // RUNTIME --> OK
        System.out.println("s = " + s);                   // RUNTIME --> OK

        if ( x == y ) System.out.println("1 : equal");    // RUNTIME --> NullPointerException
        else System.out.println("1 : differ");

        //if ( s == x ) System.out.println("2 : equal"); // DOES NOT COMPILE : incomparable types : String and int
        //else System.out.println("2 : differ");
        
    }
}
