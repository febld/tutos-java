package feb.tutos.apachecamel.exemplesPatterns;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

public class PatternFilterExchange {

    public static void main(String[] args) throws Exception {
        Main camel = new Main();
        camel.configure().addRoutesBuilder( new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                from( "timer://foo?includeMetadata=true&period=1000" )
                        .setBody(simple( "bonjour ${exchangeProperty.CamelTimerCounter}"))
                        .log( ">>>>>>>>>>>>>>>>>>>>>>>" )
                        .log( "property : CamelTimerCounter = ${exchangeProperty.CamelTimerCounter}")
                        .log( "body 1   : ${body}" )
                        .to( "direct:monPatternFilter" );

                from( "direct:monPatternFilter" )
                        .log( "<<<<<<<<<<<<<<<<<<<<<<<")
                        .log( "property : CamelTimerCounter = ${exchangeProperty.CamelTimerCounter}")
                        .log( "body 2   : ${body}" )
                        .filter( body().isEqualTo( "bonjour 5"))
                        .log( "body filtered");
            }
        });
        camel.run();
    }
}
