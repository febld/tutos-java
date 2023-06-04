public class FinalLocalVariable {

    public static String play(int arg) {
        final String result;
        if ( arg < 3 ) {
            result = arg + " <  3";
        }
        else {
            result = arg + " >= 3";
        }
        //result = "2"; // DOES NOT COMPILE : might have been already assigned
        return result;
    }

    public String playInstance(int arg) {
        final String result;
        if ( arg < 3 ) {
            result = arg + " <  3";
        }
        else {
            result = arg + " >= 3";
        }
        //result = "5"; // DOES NOT COMPILE : might have been already assigned
        return result;
    }

    public static void main(String... args) {
        System.out.println("----- static -----");
        System.out.println(play(1));
        System.out.println(play(3));
        System.out.println(play(4));

        System.out.println("----- instance -----");
        FinalLocalVariable var = new FinalLocalVariable();
        System.out.println(var.playInstance(1));
        System.out.println(var.playInstance(3));
        System.out.println(var.playInstance(4));
    }
}
