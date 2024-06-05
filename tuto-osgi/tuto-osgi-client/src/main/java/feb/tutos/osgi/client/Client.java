package feb.tutos.osgi.client;

import feb.tutos.osgi.service.definition.Accueil;
import org.osgi.framework.*;

public class Client implements BundleActivator, ServiceListener {

    private BundleContext contexte;
    private ServiceReference referenceService;

    @Override
    public void start(BundleContext contexte) throws Exception {
        this.contexte = contexte;
        try {
            contexte.addServiceListener( this, "(objectclass=" + Accueil.class.getName() + ")" );
        }
        catch ( InvalidSyntaxException e ) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop(BundleContext contexte) throws Exception {
        if ( referenceService != null ) {
            contexte.ungetService( referenceService );
        }
    }

    @Override
    public void serviceChanged(ServiceEvent evenementService) {
        int type = evenementService.getType();
        switch (type){
            case(ServiceEvent.REGISTERED):
                System.out.println( "Notification d’inscription du service." );
                referenceService = evenementService.getServiceReference();
                Accueil service = ( Accueil )( contexte.getService( referenceService ) );
                System.out.println( service.direBonjourA( "Toto" ) );
                break;
            case(ServiceEvent.UNREGISTERING):
                System.out.println( "Notification de désinscription du service." );
                contexte.ungetService( evenementService.getServiceReference() );
                break;
            default:
                break;
        }
    }
}
