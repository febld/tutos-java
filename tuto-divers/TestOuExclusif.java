public class TestOuExclusif {

    public static void main( String[] args ) {
        if ( true ^ true ) {
            System.out.println( "true ^ true" );
        }
        if ( true ^ false ) {
            System.out.println( "true ^ false" );
        }
        if ( false ^ true ) {
            System.out.println( "false ^ true" );
        }
        if ( false ^ false ) {
            System.out.println( "false ^ false" );
        }
    }
}
