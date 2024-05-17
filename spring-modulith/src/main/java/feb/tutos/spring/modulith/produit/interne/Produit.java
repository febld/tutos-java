package feb.tutos.spring.modulith.produit.interne;

import lombok.Getter;
import lombok.Setter;

public class Produit {

    @Getter @Setter private String nom;
    @Getter @Setter private String description;
    @Getter @Setter private int    prix;

    public Produit( String nom, String description, int prix ) {
        this.nom         = nom;
        this.description = description;
        this.prix        = prix;
    }
}
