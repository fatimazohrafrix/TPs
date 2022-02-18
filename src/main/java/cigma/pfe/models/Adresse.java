package cigma.pfe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "TAdresses")
public class Adresse {

    public Adresse() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String avenue;

    @Column
    private String ville;

    @Column
    private String pays;

    @OneToOne(cascade = {CascadeType.PERSIST},mappedBy = "adresse")
    private Client client;
}
