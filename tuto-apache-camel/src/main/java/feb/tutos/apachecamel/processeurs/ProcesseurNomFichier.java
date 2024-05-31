package feb.tutos.apachecamel.processeurs;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.springframework.stereotype.Component;

@Component
public class ProcesseurNomFichier implements Processor {
    @Override
    public void process(Exchange echange) throws Exception {
        String nomFichierOriginal = (String) echange.getIn().getHeader(Exchange.FILE_NAME, String.class);

        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        String nomFichierModifie = formatDate.format(date) + "-processeurNomFichier-" + nomFichierOriginal;
        echange.getIn().setHeader(Exchange.FILE_NAME, nomFichierModifie);
    }
}
