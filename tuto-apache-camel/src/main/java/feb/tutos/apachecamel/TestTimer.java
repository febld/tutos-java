package feb.tutos.apachecamel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

public class TestTimer {

    public static void main(String[] args) throws Exception {
        Main camel = new Main();
        camel.configure().addRoutesBuilder( new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                from( "timer://foo?includeMetadata=true&period=1000" )
                        .setBody(simple( "bonjour à ${header.CamelTimerFiredTime}"))
                        .log( "--------" )
                        .log( "headers  : ${headers}")
                        .log( "headers  : TIMER_FIRED_TIME  = ${headers.CamelTimerFiredTime}")
                        .log( "property : CamelTimerCounter = ${exchangeProperty.CamelTimerCounter}")
                        .log( "body     : ${body}" )
                        .to( "file:sortie" );
            }
        });
        camel.run();
    }
}
