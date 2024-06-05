package feb.tutos.osgi.service.implementation;

import feb.tutos.osgi.service.definition.Accueil;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import java.util.Hashtable;

public class AccueilImpl implements Accueil, BundleActivator {

    private ServiceReference<Accueil> reference;
    private ServiceRegistration<Accueil> inscription;

    @Override
    public String direBonjourA(String nom) {
        return "Bonjour " + nom;
    }

    @Override
    public void start(BundleContext contexte) throws Exception {
        System.out.println( "Inscription du service." );
        inscription = contexte.registerService( Accueil.class, new AccueilImpl(), new Hashtable<String, String>() );
        reference = inscription.getReference();
    }

    @Override
    public void stop(BundleContext contexte) throws Exception {
        System.out.println( "Désinscription du service." );
        inscription.unregister();
    }
}
