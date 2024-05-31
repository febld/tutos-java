package feb.tutos.spring.monolith;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.core.Violations;
import org.springframework.modulith.docs.Documenter;

import feb.tutos.spring.modulith.Application;

/**
 * Unit test for simple App.
 */
public class ApplicationTest 
{
    ApplicationModules modules = ApplicationModules.of( Application.class );

    @Test
    public void creerApplicationModuleModele() {
       modules.forEach( System.out::println );
    }

    @Test
    public void verifierStructureModulaire() {
      // exception car dépendances sur des types non exposés entre les modules
      Exception e = assertThrows( Violations.class, () -> {
        modules.verify();
      });
      System.out.println( "---------- violations messages ------------- " );
      System.out.println( e.getMessage() );
      System.out.println( "---------- violations messages ------------- " );
    }

    @Test
    public void creerDocumentationModule() {
      // création documentation modulith dans target/spring-modulith-docs
       new Documenter( modules ).writeDocumentation().writeIndividualModulesAsPlantUml();
    }

}
