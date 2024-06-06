package feb.tutos.apachecamel.exemplesPatterns;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

public class PatternSplitterExchange {

    public static void main(String[] args) throws Exception {
        Main camel = new Main();
        camel.configure().addRoutesBuilder( new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                from( "timer://foo?includeMetadata=true&period=1000" )
                        .setBody(simple( "bonjour ${exchangeProperty.CamelTimerCounter}"))
                        .log( ">>>>>>>>>>>>>>>>>>>>>>>" )
                        .log( "property  : CamelTimerCounter = ${exchangeProperty.CamelTimerCounter}")
                        .log( "body 1    : ${body}" )
                        .to( "direct:monPatternSplitter" );

                from( "direct:monPatternSplitter" )
                        .log( "<<<<<<<<<<<<<<<<<<<<<<<")
                        .log( "property  : CamelTimerCounter = ${exchangeProperty.CamelTimerCounter}")
                        .log( "body 2    : ${body}" )
                        .split( body().tokenize( "o" )).log( "body split : ${body}" )
                        .end()
                        //.log( "split size: " + constant( header(Exchange.SPLIT_SIZE)))
                        .log( "body      : ${body}")
                        .end();
            }
        });
        camel.run();
    }
}
