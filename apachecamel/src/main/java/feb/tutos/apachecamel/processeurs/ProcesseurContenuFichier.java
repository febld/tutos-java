package feb.tutos.apachecamel.processeurs;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.springframework.stereotype.Component;

@Component
public class ProcesseurContenuFichier implements Processor {
    @Override
    public void process(Exchange echange) throws Exception {
        String contenuOriginal = ( String ) echange.getIn().getBody( String.class );
        String contenuMajuscule = contenuOriginal.toUpperCase();

        echange.getIn().setBody( contenuMajuscule );
    }
}
