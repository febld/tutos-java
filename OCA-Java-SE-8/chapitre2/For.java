public class For {

    public static void main(String... args) {

        int x = 0;

        for( int i = 0; i<3 ; i++ ) {
            System.out.println("begin  i = " + i);
            System.out.println("middle x = " + x);
            x++;
            System.out.println("end    i = " + i);
            System.out.println();
        }
    }
}
