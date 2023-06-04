public class Review9 {
    
    public void start() {
        try {
            System.out.print("Starting up ");
            throw new Exception();
        }
        catch (Exception e) {
            System.out.print("Problem ");
            System.exit(0);
        }
        finally {  // NEVER EXECUTED
            System.out.print("Shutting down");
        }
    }

    public static void main(String[] args) {
        new Review9().start();
    }
}