public class Identifiers {

    int Integer = 0;  // compilation OK
    //Integer int = 5; // DOES not compile : int is reserved keyword

    //String 1aaaa; // DOES NOT compile : digit cannot be first
    String $aaa_;
    String _XXX ;
    String _bbb2;
    String ddd$2_;

    //void 3method() {}  // DOES NOT compile : digit cannot be first
    void _method() {}
    void $method() {}
    void ab2_$xx() {}

    public static void main(String[] args) {
        new Identifiers();
    }
}
