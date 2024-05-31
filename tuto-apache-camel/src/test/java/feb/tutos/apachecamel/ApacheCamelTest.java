package feb.tutos.apachecamel;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.awaitility.Awaitility;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import feb.tutos.apachecamel.processeurs.ProcesseurNomFichier;
import feb.tutos.apachecamel.UtilitairesFichiers;

@CamelSpringBootTest
public class ApacheCamelTest {
    private static final long DUREE_MILLIS    = 10000;
    private static final String DOSSIER_SRC1  = "src/test/dossiers/source1";
    private static final String DOSSIER_SRC2  = "src/test/dossiers/source2";
    private static final String DOSSIER_SRC3  = "src/test/dossiers/source3";
    private static final String DOSSIER_DST1  = "src/test/dossiers/destination1";
    private static final String DOSSIER_DST2  = "src/test/dossiers/destination2";
    private static final String DOSSIER_DST3M = "src/test/dossiers/destination3majuscule";
    private static final String DOSSIER_DST3m = "src/test/dossiers/destination3minuscule";
    private static final String FICHIER_A    = "FichierA.txt";
    private static final String FICHIER_B    = "FichierB.txt";
    private static final String URI_PREFIX   = "file://";

    private static final List<String> LISTE_AAAA = Arrays.asList( new String[] { "1:AAAA", "2:AaAaA", "3:aaaaa" } );
    private static final List<String> LISTE_BBBB = Arrays.asList( new String[] { "1:BBBB", "2:BbBbB", "3:bbbbb" } );

    private static final Date date = new Date();
    private static final SimpleDateFormat formatDate = new SimpleDateFormat( "yyyy-MM-dd" );

    @BeforeAll
    public static void init() {

        List<String> dossiersSRC = Arrays.asList( new String[] { DOSSIER_SRC1, DOSSIER_SRC2, DOSSIER_SRC3 } );
        List<String> dossiersTous = Arrays.asList( new String[] { DOSSIER_SRC1, DOSSIER_SRC2, DOSSIER_SRC3, DOSSIER_DST1, DOSSIER_DST2, DOSSIER_DST3M, DOSSIER_DST3m } );
        
        System.out.println( "DEBUG dossier travail = " + Paths.get("").toAbsolutePath() );

        /*
         * Vidage sources & destinations
         */
        for ( String dossier : dossiersTous ) {
            try {
                Files.walk( Paths.get( dossier ) )
                    .sorted( Comparator.reverseOrder() )
                    .peek( s -> System.out.println( "DEBUG delete : " + s ) )
                    .map( Path::toFile )
                    .forEach( File::delete );
            }
            catch ( Exception e ) {
                System.out.println( "ERREUR nettoyage destinations : " + e.toString() );
            }
            try {
                System.out.println( "DEBUG création dossier : " + dossier );
                Files.createDirectories( Paths.get( dossier ) );
            }
            catch ( IOException e ) {
                System.out.println( "ERREUR création dossier : " + e.toString() );
            }
        }

        /*
         * Création fichiers sources
         */
        for ( String dossier : dossiersSRC ) {
            //try {
            //    UtilitairesFichiers.creerFichier(new URI(URI_SRC + "/" + FICHIER_A));
            //    UtilitairesFichiers.creerFichier(new URI(URI_SRC + "/" + FICHIER_B));
            //}
            //catch (URISyntaxException e) {
            //    System.out.println("ERREUR création URI : " + e.getMessage());
            //}
            Path pathA = UtilitairesFichiers.creerFichier(dossier, FICHIER_A);
            System.out.println( "DEBUG création fichier : " + pathA );
            if ( pathA != null ) {
                UtilitairesFichiers.ecrireLigne( pathA, new ArrayList<String>( LISTE_AAAA ) );
            }
            Path pathB = UtilitairesFichiers.creerFichier(dossier, FICHIER_B);
            System.out.println( "DEBUG création fichier : " + pathB );
            if ( pathB != null ) {
                UtilitairesFichiers.ecrireLigne( pathB, new ArrayList<String>( LISTE_BBBB ) );
            }
        }
    }

    /*
     * Test Routes Apache Camel définies avec JavaDSL
     */
    @Test
    public void JavaDSLRouteTest() throws Exception {

        System.out.println( "DEBUG Test 1 : JavaDSL Route" );

        Path fichierDestinationA = Paths.get( DOSSIER_DST1, formatDate.format( date ) + "-processeurNomFichier-" + FICHIER_A );
        Path fichierDestinationB = Paths.get( DOSSIER_DST1, formatDate.format( date ) + "-processeurNomFichier-" + FICHIER_B );

        CamelContext contexteCamel = new DefaultCamelContext();
        contexteCamel.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from( URI_PREFIX + DOSSIER_SRC1 + "?delete=true" )
                    .process( new ProcesseurNomFichier() )
                    .to( URI_PREFIX + DOSSIER_DST1 );
            }
        });
        contexteCamel.start();

        Awaitility.await().atMost(DUREE_MILLIS, TimeUnit.MILLISECONDS).untilAsserted(() -> {
            assertTrue( Files.exists( fichierDestinationA ), fichierDestinationA + " n'existe pas (test JavaDSL)" );
            assertTrue( Files.exists( fichierDestinationB ), fichierDestinationB + " n'existe pas (test JavaDSL)" );
        });
        contexteCamel.stop();
    }

    /*
     * Test Routes Apache Camel définies avec SpringDSL + javaDSL
     */
    @Test
    public void SpringAndJavaDSLRouteTest() throws Exception {

        System.out.println( "DEBUG Test 2 : SpringDSL et JavaDSL Route" );

        Path destA = Paths.get( DOSSIER_DST2, formatDate.format( date ) + "-processeurNomFichier-" + FICHIER_A );
        Path destB = Paths.get( DOSSIER_DST2, formatDate.format( date ) + "-processeurNomFichier-" + FICHIER_B );

        ClassPathXmlApplicationContext contexteApplicationXMl = new ClassPathXmlApplicationContext( "spring-camel-springDSL-and-javaDSL.xml" );

        Awaitility.await().atMost(DUREE_MILLIS, TimeUnit.MILLISECONDS).untilAsserted(() -> {
            assertTrue( Files.exists( destA ), destA + " n'existe pas (test SpringAndJavaDSL)" );
            assertTrue( Files.exists( destA ), destB + " n'existe pas (test SpringAndJavaDSL)" );
        });
        contexteApplicationXMl.stop();
    }

    /*
     * Test Routes Apache Camel définies avec SpringDSL uniquement
     */
    @Test
    public void SpringDSLRouteTest() throws Exception {

        System.out.println( "DEBUG Test 3 : SpringDSL Route" );

        Path destination3MA = Paths.get( DOSSIER_DST3M, FICHIER_A );
        Path destination3MB = Paths.get( DOSSIER_DST3M, FICHIER_B );
        Path destination3mA = Paths.get( DOSSIER_DST3m, FICHIER_A );
        Path destination3mB = Paths.get( DOSSIER_DST3m, FICHIER_B );

        ClassPathXmlApplicationContext contexteApplicationXML = new ClassPathXmlApplicationContext( "spring-camel-springDSL.xml" );

        Awaitility.await().atMost(DUREE_MILLIS, TimeUnit.MILLISECONDS).untilAsserted(() -> {
            assertTrue( Files.exists( destination3MA ), destination3MA + " n'existe pas (test SpringDSL)" );
            assertTrue( Files.exists( destination3MB ), destination3MB + " n'existe pas (test SpringDSL)" );
            assertTrue( Files.exists( destination3mA ), destination3mA + " n'existe pas (test SpringDSL)" );
            assertTrue( Files.exists( destination3mB ), destination3mB + " n'existe pas (test SpringDSL)" );
            List<String> contenu3MA = Files.readAllLines( destination3MA );
            List<String> contenu3MB = Files.readAllLines( destination3MB );
            List<String> contenu3mA = Files.readAllLines( destination3mA );
            List<String> contenu3mB = Files.readAllLines( destination3mB );
            assertEquals( "1:AAAA",   contenu3MA.get(0) );
            assertEquals( "2:AAAAA",  contenu3MA.get(1) );
            assertEquals( "3:AAAAA",  contenu3MA.get(2) );
            assertEquals( "1:BBBB",   contenu3MB.get(0) );
            assertEquals( "2:BBBBB",  contenu3MB.get(1) );
            assertEquals( "3:BBBBB",  contenu3MB.get(2) );
            assertEquals( "1:aaaa",   contenu3mA.get(0) );
            assertEquals( "2:aaaaa",  contenu3mA.get(1) );
            assertEquals( "3:aaaaa",  contenu3mA.get(2) );
            assertEquals( "1:bbbb",   contenu3mB.get(0) );
            assertEquals( "2:bbbbb",  contenu3mB.get(1) );
            assertEquals( "3:bbbbb",  contenu3mB.get(2) );
        });
    }
}
