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

class Primate {
    public boolean hasHair() {
        return true;
    }
}

interface HasTail {
    public boolean isTailStriped();
}

public class PolymorphismTest1 extends Primate implements HasTail {
    
    public boolean isTailStriped() {
        return false;
    }
    public int age = 10;

    public static void main(String... args) {
        PolymorphismTest1 p = new PolymorphismTest1();
        System.out.println(p.age);

        HasTail hasTail = p;
        System.out.println(hasTail.isTailStriped());
        //System.out.println(hasTail.age); // DOES NOT COMPILE : cannot find symbol age

        Primate primate = p;
        System.out.println(primate.hasHair());
        //System.out.println(primate.isTailStriped()); // DOES NOT COMPILE : cannot find symbol isTailStriped

    }
}