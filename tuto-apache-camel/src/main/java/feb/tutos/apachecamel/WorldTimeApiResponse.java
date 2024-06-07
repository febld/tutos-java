package feb.tutos.apachecamel;


import lombok.Getter;
import lombok.Setter;

/**
 * Classe encapsulant la réponse JSON d’une requête au serveur http://worldtimeapi.org/api/timezone/Europe/Paris
 * Exemple :
 * { "abbreviation":"CEST",
 *   "client_ip":"176.157.138.21",
 *   "datetime":"2024-06-07T12:38:00.244074+02:00",
 *   "day_of_week":5,
 *   "day_of_year":159,
 *   "dst":true,
 *   "dst_from":"2024-03-31T01:00:00+00:00",
 *   "dst_offset":3600,
 *   "dst_until":"2024-10-27T01:00:00+00:00",
 *   "raw_offset":3600,
 *   "timezone":"Europe/Paris",
 *   "unixtime":1717756680,
 *   "utc_datetime":"2024-06-07T10:38:00.244074+00:00",
 *   "utc_offset":"+02:00",
 *   "week_number":23
 *   }
 */
@Getter
@Setter
public class WorldTimeApiResponse {

        private String abbreviation;       //ex: "CEST"
        private String client_ip;           //ex: "10.1.15.13"
        private String datetime;           //ex: "2024-06-06T12:23:17.770976+02:00"
        private int day_of_week;             //ex:   4
        private int day_of_year;             //ex: 158
        private boolean dst;               //ex: true
        private String dst_from;            //ex: "2024-03-31T01:00:00+00:00"
        private int dst_offset;             //ex: 3600   (1 heure)
        private String dst_until;           //ex: "2024-10-27T01:00:00+00:00"
        private int raw_offset;             //ex: 3600
        private String timezone;           //ex: "Europe/Paris"
        private long unixtime;             //ex: 1717669397
        private String utc_datetime;        //ex: "2024-06-06T10:23:17.770976+00:00"
        private String utc_offset;          //ex: "+02:00"
        private int week_number;            // ex: 23
}
