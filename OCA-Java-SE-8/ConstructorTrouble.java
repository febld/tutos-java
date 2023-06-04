class Big {
    public Big(boolean stilIn) {
        super();
    }
}

public class ConstructorTrouble extends Big {
    public ConstructorTrouble() {}           // DOES NOT COMPILE : constructor BIg cannot be applied to given types

    public ConstructorTrouble(int deep) {
        super(false);
        this();                              // DOES NOT COMPILE : call to this must be first statement in constructor
    }
}
