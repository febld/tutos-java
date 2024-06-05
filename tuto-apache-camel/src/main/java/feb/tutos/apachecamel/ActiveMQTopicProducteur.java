package feb.tutos.apachecamel;

import jakarta.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import java.time.LocalDateTime;

public class ActiveMQTopicProducteur {

    public static void main( String[] args ) throws Exception {

        CamelContext contexte = new DefaultCamelContext();
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory( "tcp://localhost:61616" );
        contexte.addComponent("activemq", JmsComponent.jmsComponentAutoAcknowledge( connectionFactory ));
        contexte.addRoutes( new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                int i = 0;
                from("timer://foo?period=1000")
                        .to( "http://worldtimeapi.org/api/timezone/Europe/Paris" )
                        .log( "Envoi vers le topic" )
                        .to("activemq:topic:testTopic");
            }
        });
        contexte.start();
        Thread.sleep(100000 );
        contexte.stop();
    }
}

