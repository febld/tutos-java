
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Chapter3Review {

  public static void main(String[] args) {
    //question2();
    //question5();
    //question6();
    //question10();
    //question11();
    //question13();
    //question15();
    //question19();
    question26();
    //question29();
    //question32();
  }
  
  private static void question2() {
    String s = "Hello";
    String t = new String(s);
    if ("Hello".equals(s)) System.out.println("one");
    if (t == s) System.out.println("two");
    if (t.equals(s)) System.out.println("three");
    if ("Hello" == s) System.out.println("four"); // "Hello" reference String object in String pool
    if ("Hello" == t) System.out.println("five");
  }
  
  private static void question5() {
    String s1 = "java";
    StringBuilder s2 = new StringBuilder("java");
    //if (s1==s2) System.out.println("1");      // DOES NOT COMPILE : == operands must be same type
    if (s1.equals(s2)) System.out.println("2");
    else System.out.println("3");
  }
  
  private static void question6() {
    String roar1 = "roar";
    StringBuilder roar2 = new StringBuilder("roar");
    new Chapter3Review().roar(roar1, roar2);
    System.out.println(roar1 + " " + roar2);
  }
  private static void roar(String roar1, StringBuilder roar2) {
    roar1.concat("!!!");
    roar2.append("???");
  }

  private static void question10() {
    String a = "";
    a += 2;
    a += 'c';
    a += false;
    if ( a == "2cfalse" ) System.out.println("==");
    if ( a.equals("2cfalse") ) System.out.println("equals");
  }
  
  private static void question11() {
    int total = 0;
    StringBuilder letters= new StringBuilder("abcdefg");
    total += letters.substring(1,2).length();
    total += letters.substring(6,6).length();
    total += letters.substring(6,5).length(); // Exception
  }
  
  private static void question13() {
    //StringBuilder b = "rumble"; // DOES NOT COMPILE : cannot assign String to StringBuilder
    StringBuilder b = new StringBuilder("rumble");
    b.append(4).deleteCharAt(3).delete(3, b.length() - 1);
    System.out.println(b);
  }
  
  private static void question15() {
    int[][] scores = new int[5][];
    Object[][][] cubbies = new Object[3][0][5];
    //String beans[] = new beans[5]; // DOES NOT COMPILE : beans is not a type
    java.util.Date[] dates[] = new java.util.Date[2][];
    //int[][] types = new int[];  // DOES NOT COMPILE : 1st dimension  missing
    //int[][] types = new int[4]; // DOES NOT COMPILE : incompatible types int[][] and int[]
    //int[][] java = new int[][]; // DOES NOT COMPILE : 1st dimension missing
    int[][] java = new int[3][];
  }
  
  private static void question19() {
    int[] a1 = { 1, 2, 5};
    int[] a2 = { 1, 2, 5};
    if (a1 == a2) System.out.println("a1 == a2");
    else System.out.println("a1 != a2");
    if (a1.equals(a2)) System.out.println("a1.equals(a2)");
    else System.out.println("a1 !equals a2");
    
    //ArrayList<int> list1 = new ArrayList<>(); // DOES NOT COMPILE : no ArrayList with primitive types
    ArrayList<Integer> list1 = new ArrayList<Integer>();
    list1.add(1);
    list1.add(2);
    list1.add(3);
     System.out.println("list1=" + list1.toString());
     
    ArrayList<Integer> list2 = new ArrayList<>();
    list2.add(1);
    list2.add(2);
    list2.add(3);
    System.out.println("list1=" + list1.toString());
    
    if (list1 == list2) System.out.println("list1==list2");
    if (list1.equals(list2)) System.out.println("list1.equals(list2)");
  }
  
  private static void question26() {
    List<Integer> ages = new ArrayList<>();
    ages.add(Integer.parseInt("5")); // parseInt returns primitive int 5, then auto boxed to Integer for "add()"
    ages.add(Integer.valueOf("6"));  // valueOf returns Integer 6
    ages.add(7);                     // int 7 is autoboxed to Integer 7
    ages.add(null);                  // no autoboxing as null is not an int
    
    // !!! NULL POINTER EXCEPTION when unboxing "null" to primitive int    
    //for (int age : ages) System.out.println(age);
    
    // OK if using wrapper type Integer :
     for (Integer age : ages) System.out.println(age);
  }
  
  private static void question29() {
    LocalDate date = LocalDate.parse("2018-04-30", DateTimeFormatter.ISO_LOCAL_DATE);
    date.plusDays(2);   // Dates are immutable. Use date = date.plusDays(..)
    date = date.plusDays(2);
    //date = date.plusHours(3); // THROWS EXCEPTION : plusHours() method not defined for Date (Time only)
    System.out.println(date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth());
  }
  
  private static void question32() {
    LocalDateTime d = LocalDateTime.of(2015, 5, 21, 11, 22, 33);
    Period p = Period.of(1, 2, 3);
    d = d.minus(p);
    DateTimeFormatter f = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
    DateTimeFormatter g = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
    System.out.println(d.format(f));
    System.out.println(d.format(g));
    
    Period p2 = Period.ofDays(1).ofYears(2); // !!! ONLY result of "ofYears(2)" is returned (Period does not allow chaining)
    d = d.minus(p2);
    System.out.println(d.format(g));
  }
  
}
