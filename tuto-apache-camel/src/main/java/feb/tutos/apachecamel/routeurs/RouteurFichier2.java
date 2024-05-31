package feb.tutos.apachecamel.routeurs;


import feb.tutos.apachecamel.processeurs.ProcesseurNomFichier;

import org.apache.camel.builder.RouteBuilder;

import org.springframework.stereotype.Component;

@Component
public class RouteurFichier2 extends RouteBuilder {

    private static final String DOSSIER_SRC = "src/test/dossiers/source2";
    private static final String DOSSIER_DST = "src/test/dossiers/destination2";

    @Override
    public void configure() throws Exception {
        from("file://" + DOSSIER_SRC + "?delete=true")
            .process(new ProcesseurNomFichier())
            .to("file://" + DOSSIER_DST);
    }
}

