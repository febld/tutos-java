package feb.tutos.spring.modulith.notification.interne;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class Notification {

    @Getter @Setter private Date             date;
    @Getter @Setter private String           nomProduit;
    @Getter @Setter private NotificationType format;

    public Notification( Date date, NotificationType format, String nomProduit ) {
        this.date       = date;
        this.format     = format;
        this.nomProduit = nomProduit;
    }
}
