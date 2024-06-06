package feb.tutos.apachecamel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HttpExchange {

    public static void main(String[] args) throws Exception {
        Main camel = new Main();
        camel.configure().addRoutesBuilder( new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                from( "timer://foo?period=2000&repeatCount=3" )
                        .to( "http://worldtimeapi.org/api/timezone/Europe/Paris" )
                        .log( "body     : ${body}" )
                        .to( "file:sortieHttp?filename=worldtimeapi-${date:now:yyyyMMddss}" );
            }
        });
        camel.run();
    }
}
