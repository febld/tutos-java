package feb.tutos.apachecamel;

import jakarta.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import java.time.LocalDateTime;

public class ActiveMQQueueProducteur {

    public static void main( String[] args ) throws Exception {

//        Main camel = new Main();
//        camel.configure().addRoutesBuilder( new RouteBuilder() {
//
//            @Override
//            public void configure() throws Exception {
//                from("timer://foo?period=1000")
//                        .setBody(simple("Bonjour activeMQ à ${header.firedTime}"))
//                        .to("activemq:queue:test");
//            }
//        });
//        camel.run();
        CamelContext contexte = new DefaultCamelContext();
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory( "tcp://localhost:61616" );
        contexte.addComponent("activemq", JmsComponent.jmsComponentAutoAcknowledge( connectionFactory ));
        contexte.addRoutes( new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                int i = 0;
                from("timer://foo?period=1000")
                        .setBody( simple(String.format( "Bonjour activeMQ %s", LocalDateTime.now() ) ) )
                        .to("activemq:queue:test");
            }
        });
        contexte.start();
        Thread.sleep(10000 );
        contexte.stop();
    }
}

