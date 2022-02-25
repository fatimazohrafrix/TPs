package cigma.pfe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Embeddable
public class LigneFactureKey implements Serializable {
    @Column(name = "facture_id")
    long factureId;

    @Column(name = "produit_id")
    long produitId;

    public LigneFactureKey() {}
}
