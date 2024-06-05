package feb.tutos.apachecamel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.FixedHostPortGenericContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.HostPortWaitStrategy;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class ActiveMQTest {

    public static CamelContext contexte = new DefaultCamelContext();

    @Container
    public static GenericContainer activemq = new FixedHostPortGenericContainer( "rmohr/activemq" )
            .withFixedExposedPort( 61616, 61616 )
            .waitingFor( new HostPortWaitStrategy() );

    @Test
    public void test() throws Exception {
        contexte.start();

        contexte.stop();
    }

}
