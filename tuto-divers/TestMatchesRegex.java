
public class TestMatchesRegex {

    private static final String REGEX = "[^:]*(IdentiteMetierException|TiersMetierException|PreConditionException|TechniqueException):.*";
    private static final String BODY1 = "blablaTiersMetierException:taratata";
    private static final String BODY2 = "blablaIdentiteMetierExceptiontaratata";

    public static void main( String[] args ) {

        if ( BODY1.matches( REGEX ) ) {
            System.out.println( "OK body1 does match" );
        }
        if ( !BODY2.matches( REGEX ) ) {
            System.out.println( "OK body2 does not match" );
        }
    }
}
