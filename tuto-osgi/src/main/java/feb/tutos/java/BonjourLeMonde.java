package feb.tutos.java;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class BonjourLeMonde implements BundleActivator {

    public void start( BundleContext context ) {
        System.out.println( "Bonjour le monde." );
    }

    public void stop( BundleContext context ) {
        System.out.println( "Au revoir le monde" );
    }
}
