abstract class Bear {
    protected int sing;
    protected abstract int grunt();
    int sing() {
        return sing;
    }
}

public class Return2 extends Bear {

    int grunt() {               // DOES NOT COMPILE : default package private access weaker than protected
        sing() += 5;            // DOES NOT COMPILE : unexpected tyep (variable is required but found a value)
        return super.grunt()+1; // DOES NOT COMPILE : abstract method in Bear cannot be accessed directly
        return 10;              // --> 2nd return compiler error only appears when int grunt() is properly defined
    }

}
