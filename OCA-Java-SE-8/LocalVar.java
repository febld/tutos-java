public class LocalVar {

    public static void main(String ... args) {
        String name = "Desiree";
        int _number = 694;
        boolean profit$$$;

        System.out.println(name + " won. " + _number + " profit ? " + profit$$$);  // DOES NOT COMPILE : profit$$$ might fot have been initialized
    }
}
