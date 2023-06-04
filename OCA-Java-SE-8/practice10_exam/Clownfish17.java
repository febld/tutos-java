class BubbleException extends Exception {}

class Fish {
    Fish getFish() throws BubbleException {        // Checked exception declared in parent
        throw new RuntimeException("fish!");
    }
}

public final class Clownfish17 extends Fish {

    public final Clownfish17 getFish() {          // NO Checked exception declared in child
        throw new RuntimeException("clown!");
    }

    public static void main(String[] bubbles) {
        final Fish f = new Clownfish17();
        f.getFish();                             // DOES NOT COMPILE : Bubble exception must be caught or declared
                                                 //     because f is a "Fish" reference that declares a Bubble exception
                                                 //     even if the real object is a ClownFish17 and the getFish()
                                                 //     does not declare a BubbleException
        System.out.println("swim!");
    }
}
