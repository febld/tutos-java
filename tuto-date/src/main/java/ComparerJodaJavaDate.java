import org.joda.time.DateTime;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ComparerJodaJavaDate {

    private static final String date1 = "2016-03-19T24:00:00Z";

    private static final String formatICAL = "yyyyMMddTHHmmss";

    public static void main(String[] args) {

        //ZonedDateTime zdtDate1 = ZonedDateTime.of( 2016, 03, 19, 24, 00, 00, 0, ZoneId.of( "Europe/Paris") );
        //System.out.println( "zdtDate1 = " + zdtDate1);

        DateTime jodaDateTime1 = DateTime.parse( date1 );
        System.out.println( "jodaDateTime1 = " + jodaDateTime1);
    }
}
