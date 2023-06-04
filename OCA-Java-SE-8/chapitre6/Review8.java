public class Review8 {
    
    public int count() {
        int a = 0;
        int b = 0;
        try {
            return a/b;
        }
        catch (RuntimeException e) {
            return -1;
        }
        catch (ArithmeticException e) { // DOES NOT COMPILe : ArithmeticException never caught as child of RuntimeException
            return 0;
        }
        finally {
            System.out.print("done");
        }
    }

    public static void main(String... args) {
        new Review8().count();
    }
}