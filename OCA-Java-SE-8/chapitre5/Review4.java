class Rodent {
    protected static Integer chew() throws Exception {
        System.out.println("Rodent is chewing");
        return 1;
    }
}

public class Beaver extends Rodent {
    // DOES NOT COMPILE
    //   overriden method is static
    //   Number is not compatible with Integer
    public static Number chew() throws RuntimeException {
        System.out.println("Beaver is chewing on wood");
        return 2;
    }
}