package assessment;

import java.util.List;
import java.util.ArrayList;

public class Main {

  public static void main (String[] args) {

    /*
     * assessment 2
     */
    System.out.println("----- assessment 2 -----");
    String s1 = "Java";
    String s2 = "Java";
    StringBuilder sb1 = new StringBuilder();
    sb1.append("Ja").append("va");
    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));
    System.out.println(sb1.toString() == s1);
    System.out.println(sb1.toString().equals(s1));

    /*
     *
     */
    assessment5();
    assessment6();
    assessment7();
  }

  public static void assessment7() {

    System.out.println("----- assessment 7 -----");

    int[] array = {6,9,8};
    List<Integer> list = new ArrayList<>();
    list.add(array[0]);
    list.add(array[2]);
    list.set(1, array[1]);
    list.remove(0);
    System.out.println(array);
    System.out.println(list);
  }

  public static void assessment5() {

    System.out.println("----- assessment 5 -----");

    System.out.print("a");
    try {
      System.out.print("b");
      throw new IllegalArgumentException();
    } catch (RuntimeException e) {
      System.out.print("c");
    } finally {
      System.out.print("d");
    }
    System.out.print("e");

    System.out.println("");
  }

  public static void assessment6() {
    System.out.println("----- assessment 6 -----");
    int[] array = {6,9,8};
    List<Integer> list = new ArrayList<>();
    list.add(array[0]);
    list.add(array[2]);
    list.set(1, array[1]);
    list.remove(0);
    System.out.println(list);

    System.out.println("");
  }
}
