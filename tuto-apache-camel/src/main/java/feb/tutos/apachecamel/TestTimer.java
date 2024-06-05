package feb.tutos.apachecamel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

public class TestTimer {

    public static void main(String[] args) throws Exception {
        Main camel = new Main();
        camel.configure().addRoutesBuilder( new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                from( "timer://foo?period=1000" )
                        .setBody(simple( "bonjour à ${header.firedTime}"))
                        .to( "file:sortie" );
            }
        });
        camel.run();
    }
}
