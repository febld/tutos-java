class Mammal {
    public Mammal(int age) {
        System.out.print("Mammal");
    }
}

public class Platypus extends Mammal {
    public Platypus() { // DOES NOT COMPILE : no super() default constructor in Mammal
        System.out.print("Platypus");
    }

    public static void main(String[] args) {
        new Mammal(5);
    }
}