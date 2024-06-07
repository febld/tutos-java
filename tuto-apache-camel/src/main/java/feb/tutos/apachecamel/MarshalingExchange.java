package feb.tutos.apachecamel;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;
import org.apache.camel.model.dataformat.JacksonXMLDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;


public class MarshalingExchange {

    public static void main(String[] args) throws Exception {
        Main camel = new Main();
        camel.configure().addRoutesBuilder( new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                from( "timer://foo?period=2000&repeatCount=3" )
                        .to( "http://worldtimeapi.org/api/timezone/Europe/Paris" )
                        .log( "body     : ${body}" )
                        .unmarshal().json( JsonLibrary.Jackson, WorldTimeApiResponse.class )
                        .to( "direct:canalMarshal" );

                from( "direct:canalMarshal" )
                        .marshal().jacksonXml(true)
                        .to( "file:tmp?filename=CanalMarshal-${date:now:yyyyMMddss}" );

            }
        });
        camel.run();
    }
}
