package feb.tutos.spring.modulith.produit;

import java.util.Date;
import org.springframework.stereotype.Service;

import feb.tutos.spring.modulith.notification.interne.Notification;
import feb.tutos.spring.modulith.notification.interne.NotificationType;
import feb.tutos.spring.modulith.notification.NotificationService;
import feb.tutos.spring.modulith.produit.interne.Produit;

@Service
public class ProduitService {

    private final NotificationService notificationService;

    public ProduitService( NotificationService notificationService ) {
        this.notificationService = notificationService;
    }

    public void creer( Produit produit ) {
        notificationService.creerNotification( new Notification( new Date(), NotificationType.SMS, produit.getNom() ));
    }
}
