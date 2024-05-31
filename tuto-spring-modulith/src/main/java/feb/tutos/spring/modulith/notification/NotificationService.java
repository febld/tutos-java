package feb.tutos.spring.modulith.notification;

import feb.tutos.spring.modulith.notification.interne.Notification;
import feb.tutos.spring.modulith.notification.interne.NotificationType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.springframework.modulith.ApplicationModuleListener;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger LOG = LoggerFactory.getLogger(NotificationService.class);

    public void creerNotification(Notification notification) {
        LOG.info("Notification par DÉPENDANCE reçue pour le produit : {} - {} - {}.",
        notification.getNomProduit(),
        notification.getFormat(),
        notification.getDate());
    }

    @Async
    @ApplicationModuleListener
    public void evenementNotification(NotificationDTO evenement) {
        Notification notification = dto2notification( evenement );
        LOG.info("Notification par ÉVÈNEMENT reçue pour le produit : {} - {} - {}.",
        notification.getNomProduit(),
        notification.getFormat(),
        notification.getDate());
    }

    private Notification dto2notification( NotificationDTO dto ) {
        Notification notification = new Notification();
        notification.setDate( dto.getDate() );
        notification.setNomProduit( dto.getNomProduit() );
        if ( dto.getFormat().equals( "TEL" )) {
            notification.setFormat( NotificationType.TEL );
        }
        if ( dto.getFormat().equals( "SMS" )) {
            notification.setFormat( NotificationType.SMS );
        }
        if ( dto.getFormat().equals( "COURRIEL" )) {
            notification.setFormat( NotificationType.COURRIEL );
        }
        return notification;
    }
}
