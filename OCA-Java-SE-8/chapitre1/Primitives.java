
public class Primitives {

  public static void main(String[] args) {

    boolean bool = true; System.out.println(bool);

    //byte  by = 130;        System.out.println(by); // DO NOT COMPILE
    //short sh = 35000;      System.out.println(sh); // DO NOT COMPILE
    byte  by = 125;          System.out.println(by);
    short sh = 32767;        System.out.println(sh);
    int a = 123;             System.out.println(a);
    int b = 0123;            System.out.println(b);
    int c = 0x123;           System.out.println(c);
    int d = 0b11;            System.out.println(d);
    int e = 1_235_555;       System.out.println(e);
    int g = 123_55_55;       System.out.println(g);
    //long max = 3123456789; System.out.println(max); // DO NOT COMPILE
    long max = 3123456789L;  System.out.println(max);
    long f = 0x123_456_789L; System.out.println(f);
    long l4 = 123l;          System.out.println(l4);
    //long l5 = 123.0;       System.out.println(l5); // DOES NOT COMPILE : lossy conversion from double to long
    //long l6 = 123.0L;      System.out.println(l6); // DOES NOT COMPILE : ";" expected instead of "L"

    float  fl1 = 123.350f; System.out.println(fl1);
    float  fl2 = 124.350F; System.out.println(fl2);
    double db  = 125.350;  System.out.println(db);

    //char   ch = "Ç";   System.out.println(ch); // DO NOT COMPILE : "Ç" is String not char !!!
    char   ch = 'Ç';     System.out.println(ch);

    char x0 = 'x';      System.out.println(x0);
    byte x1 = 'x';      System.out.println(x1);
    short x2 = 'x';     System.out.println(x2);
    int x3 = 'x';       System.out.println(x3);
    long x4 = 'x';      System.out.println(x4);
    float x5 = 'x';     System.out.println(x5);
    double x6 = 'x';    System.out.println(x6);

    Byte    y1 = 'x';   System.out.println(y1);
    Short   y2 = 'x';   System.out.println(y2);
    //Integer y3 = 'x';   System.out.println(y3); // DOES NOT COMPILE : char cannot be converted to type
    //Long    y4 = 'x';   System.out.println(y4);
    //Float   y5 = 'x';   System.out.println(y5);
    //Double  y6 = 'x';   System.out.println(y6);
    
  }
}
