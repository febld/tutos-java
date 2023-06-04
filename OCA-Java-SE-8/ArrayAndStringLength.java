public class ArrayAndStringLength {

    public static void seasons(String... names) {
        int a = names.length;
        int s = names[2].length();
        System.out.println("a = " + a);
        System.out.println("s = " + s);
        System.out.println(names[s]);    // ArrayIndexOutOfBoundsException
    }

    public static void main(String... args) {
        seasons("Summer", "Fall", "Winter", "Spring");
    }
}
