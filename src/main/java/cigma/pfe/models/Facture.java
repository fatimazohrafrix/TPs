package cigma.pfe.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//@Getter
//@Setter
//@AllArgsConstructor
@Data
@Entity
public class Facture {

    public Facture() {}

    public Facture(Date date, Double amount, String description, Client client) {
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.client = client;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private Date date;

    @Column
    private Double amount;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name="LigneFacture",
            joinColumns = @JoinColumn(name = "facture_fk", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "produit_fk", referencedColumnName = "id")
    )
    private List<Produit> produits;

    @Override
    public String toString() {
        return "Facture{" +
            "id=" + id +
            ", date='" + date + '\'' +
                ", amount='" + amount + '\'' +
                ", description='" + description + '\'' +
            '}';
    }
}