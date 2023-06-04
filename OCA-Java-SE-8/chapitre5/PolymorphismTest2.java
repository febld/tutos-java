/*
 *  POLYMORPHISM
 *
 *
 *  OBJECTS vs REFERENCES
 *
 *  1) The type of the object determines which properties exist within the
 *     object in memory.
 *  2) The type of reference to the object determines which methods and
 *     variables are accessible to the Java program.
 *
 *
 *  CASTING RULES
 *
 *  1) Casting an object from a subclass to a superclass doesn't require
 *     an explicit cast
 *  2) Casting an object from a superclass to a subclass requires
 *     an explicit cast.
 *  3) The compiler will not allow casts to unrelated types.
 *  4) Even when the code compiles without issue, an exceeption may be thrown
 *     at runtime if the object being cast is not actually an instance of that
 *     class.
 */

class Reptile {
    public String getName() {
        return "Reptile";
    }
}

class Alligator extends Reptile {
    public String getName() {
        return "Alligator";
    }
}

class Crocodile extends Reptile {
    public String getName() {
        return "Crocodile";
    }
}

public class PolymorphismTest2 {

    public static void feed(Reptile reptile) {
        System.out.println("Feeding : " + reptile.getName());
    }

    public static void main(String... args) {
        feed(new Alligator());
        feed(new Crocodile());
        feed(new Reptile());

    }
}