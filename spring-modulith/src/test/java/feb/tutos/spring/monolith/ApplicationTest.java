package feb.tutos.spring.monolith;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
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
       modules.verify();
    }

    @Test
    public void creerDocumentationModule() {
       new Documenter( modules ).writeDocumentation().writeIndividualModulesAsPlantUml();
    }

}
