interface Herbivore {
    int amount = 10;                // ASSUMED "public static final" in interface
    public static void eatGrass();  // DOES NOT COMPILE : static must have a body
    public int chew() {             // DOES NOT COMPILE : assumed abstract and abstract method cannot have a body
        return 13;
    }
}

public class Review8 implements Herbivore { // DOES NOT COMPILE : must override chew() method
    
    public static void main(String[] args) {
        new Review5();
    }
}