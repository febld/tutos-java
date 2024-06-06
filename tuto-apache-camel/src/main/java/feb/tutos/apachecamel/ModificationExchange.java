package feb.tutos.apachecamel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ModificationExchange {

    public static void main(String[] args) throws Exception {
        Main camel = new Main();
        camel.configure().addRoutesBuilder( new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                from( "timer://foo?period=1000&repeatCount=3" )
                        .setHeader( "monHeader", constant( "uneChaine" ) )
                        .setHeader( "maintenant", constant(LocalDateTime.now() ))
                        .setProperty( "maPropriete", constant( "propt" ))
                        .setHeader("monHeaderCalc", simple( "${headers.monHeader}Concat" ))
                        .setHeader( "demainCalc", simple( "${date:now+24h:yyyy-MM-dd}" ))   // calcul date + formattage
                        .setBody( constant(IntStream.rangeClosed( 1, 10 ).boxed().collect( Collectors.toList() )))
                        //.setBody(simple( "bonjour à ${headers.firedTime}"))
                        .log( "--------------------------------------")
                        .log( "property : maPropriete = ${exchangeProperty.maPropriete}" )
                        .log( "headers  : ${headers}" )
                        .log( "headers  : taille monHeader = ${headers.monHeader.length}" )
                        .log( "headers  : headerInconnu = ${headers?.headerInconnu}" )                // le ? évite la NullPointerException
                        .log( "body     : ${body}" )
                        .log( "body     : taille = ${body.size}" )                                    // "body.size" si liste, "body.length" si chaine
                        .log( "body     : valeur 1er=${body[0]}, 5eme=${body[4]}");
                        //.to( "file:sortieModificationExchange" );
            }
        });
        camel.run();
    }
}
