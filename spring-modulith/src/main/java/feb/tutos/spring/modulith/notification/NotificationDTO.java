package feb.tutos.spring.modulith.notification;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class NotificationDTO {

    @Getter @Setter private Date   date;
    @Getter @Setter private String nomProduit;
    @Getter @Setter private String format;

    public NotificationDTO( Date date, String format, String nomProduit ) {
        this.date       = date;
        this.format     = format;
        this.nomProduit = nomProduit;
    }
}
