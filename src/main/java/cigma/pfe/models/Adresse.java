package cigma.pfe.models;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String avenue;
    String ville;
    String pays;

    @OneToOne(cascade = {CascadeType.PERSIST},mappedBy = "adresse")
       private Client client;

    public Adresse(){}

    public Adresse(String avenue, String ville, String pays){
        this.avenue = avenue;
        this.ville = ville;
        this.pays = pays;
    }

    public Adresse(String avenue, String ville, String pays, Client client){
        this.avenue = avenue;
        this.ville = ville;
        this.pays = pays;
        this.client = client;
    }


}
