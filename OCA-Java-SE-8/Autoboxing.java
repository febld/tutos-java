//import java.util.Integer;
//import java.util.Short;

public class Autoboxing {

    public static void wrapper2primitive() {
        System.out.println("wrapper2primitive");
        int   i1 = new Integer(1);
        short s1 = new Short((short) 2);
        byte  b1 = new Byte((byte) 4);
        int   i2 = new Integer("8");
        short s2 = new Short("16");
        byte  b2 = new Byte("32");
        System.out.println(i1 + s1 + b1 + i2 + s2 + b2);
    }

    public static void primitive2wrapper() {
        System.out.println("primitive2wrapper");
        Integer i = 2;
        Short   s = 3;
        System.out.println(i + s);
    }

    public static void main(String... args) {
        wrapper2primitive();
        primitive2wrapper();
    }
}
