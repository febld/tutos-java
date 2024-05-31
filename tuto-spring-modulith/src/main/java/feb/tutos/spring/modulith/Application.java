package feb.tutos.spring.modulith;

import feb.tutos.spring.modulith.produit.interne.Produit;
import feb.tutos.spring.modulith.produit.ProduitService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *
 */
@EnableAsync
@SpringBootApplication
//@EnableAutoConfiguration(exclude = { JobRunrAutoConfiguration.class })
@EnableAutoConfiguration
public class Application {

    public static void main( String[] args )
    {
        System.out.println( "Hello modulith app!" );
        SpringApplication.run( Application.class, args).getBean(ProduitService.class).creer( new Produit( "feb", "course", 25 ));
    }
}
