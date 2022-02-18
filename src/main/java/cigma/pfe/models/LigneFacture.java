package cigma.pfe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "TLigneFacture")
public class LigneFacture {

    @EmbeddedId
    LigneFactureKey id;

    @ManyToOne
    @MapsId("factureId")
    @JoinColumn(name = "facture_id")
    Facture facture;

    @ManyToOne
    @MapsId("produitId")
    @JoinColumn(name = "produit_id")
    Produit produit;

    int qte;

    public LigneFacture() {}
}
