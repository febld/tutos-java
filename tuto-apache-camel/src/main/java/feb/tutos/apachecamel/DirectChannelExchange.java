package feb.tutos.apachecamel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

public class DirectChannelExchange {

    public static void main(String[] args) throws Exception {
        Main camel = new Main();
        camel.configure().addRoutesBuilder( new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                from( "timer://foo?period=10000&repeatCount=5" )
                        .to( "http://worldtimeapi.org/api/timezone/Europe/Paris" )
                        .log( "body 1 : ${body}" )
                        .to( "direct:monCanalDirect" );

                from( "direct:monCanalDirect" )
                        .log( "body 2 : ${body}" )
                        .to( "file:tmp?filename=CanalDirect-${date:now:yyyyMMddss}" );
            }
        });
        camel.run();
    }
}
