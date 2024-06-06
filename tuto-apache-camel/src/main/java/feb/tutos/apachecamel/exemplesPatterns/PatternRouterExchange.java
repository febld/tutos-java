package feb.tutos.apachecamel.exemplesPatterns;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

public class PatternRouterExchange {

    public static void main(String[] args) throws Exception {
        Main camel = new Main();
        camel.configure().addRoutesBuilder( new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                from( "timer://foo?includeMetadata=true&period=1000" )
                        .setBody(simple( "bonjour à ${header.CamelTimerFiredTime}"))
                        .log( ">>>>>>>>>>>>>>>>>>>>>>>" )
                        .log( "property : CamelTimerCounter = ${exchangeProperty.CamelTimerCounter}")
                        .log( "body 1   : ${body}" )
                        .to( "direct:monPatternRouter" );

                from( "direct:monPatternRouter" )
                        .log( "<<<<<<<<<<<<<<<<<<<<<<<")
                        .log( "property : CamelTimerCounter = ${exchangeProperty.CamelTimerCounter}")
                        .log( "body 2   : ${body}" )
                        .choice()
                        .when( simple( "${exchangeProperty.CamelTimerCounter} < 5")).log( "===> INFÉRIEUR à 5" )
                        .when( simple( "${exchangeProperty.CamelTimerCounter} == 5")).log( "===> ÉGAL à 5" )
                        .when( simple( "${exchangeProperty.CamelTimerCounter} > 5")).log( "===> SUPÉRIEUR à 5" );
            }
        });
        camel.run();
    }
}
