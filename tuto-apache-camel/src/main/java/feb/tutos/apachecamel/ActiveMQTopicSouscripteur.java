package feb.tutos.apachecamel;

import jakarta.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class ActiveMQTopicSouscripteur {

    public static void main( String[] args ) throws Exception {

        CamelContext contexte = new DefaultCamelContext();
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory( "tcp://localhost:61616" );
        contexte.addComponent("activemq", JmsComponent.jmsComponentAutoAcknowledge( connectionFactory ));
        contexte.addRoutes( new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                from("activemq:topic:testTopic" )
                        .log( "Reception testTopic" )
                        .to("file:tmp?filename=TestTopic-${date:now:yyyyMMdd-HHmmssSSS}" );
            }
        });
        contexte.start();
        Thread.sleep(5000 );
        contexte.stop();
    }
}

