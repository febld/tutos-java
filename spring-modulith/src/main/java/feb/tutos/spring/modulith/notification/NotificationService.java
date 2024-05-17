package feb.tutos.spring.modulith.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import feb.tutos.spring.modulith.notification.interne.Notification;

@Service
public class NotificationService {

    private static final Logger LOG = LoggerFactory.getLogger(NotificationService.class);

    public void creerNotification(Notification notification) {
        LOG.info("Notification reçue pour le produit {} à la date {} par {}.",
        notification.getNomProduit(),
        notification.getDate(),
        notification.getFormat());
    }
}
