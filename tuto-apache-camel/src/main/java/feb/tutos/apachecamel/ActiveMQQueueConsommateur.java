package feb.tutos.apachecamel;

import jakarta.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class ActiveMQQueueConsommateur {

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
                from("activemq:queue:test" )
                        .log( "Traitement queue test" )
                        .delay( 2000 )
                        .to("stream:out");
            }
        });
        contexte.start();
        Thread.sleep(25000 );
        contexte.stop();
    }
}

