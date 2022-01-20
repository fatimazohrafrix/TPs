package cigma.pfe.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.mapping.List;

import javax.persistence.*;
@Entity
@Getter
@Setter
@ToString
public class Facture<Client> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double amount;
    private String description;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Facture() {
    }

    public Facture(double amount, String description, Client client) {
        this.amount = amount;
        this.description = description;
        this.client = client;

    }

    public Facture(String facture1) {
    }

    public class Facture1<Produit> {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private double amount;
        private String description;

        @ManyToOne(cascade = {CascadeType.PERSIST},mappedBy = "produit")
        private List produits;

        public <produit> Facture1(double amount, String description, Produit list produits) {
            super();
            this.amount = amount;
            this.description = description;
            this.produits = produits;
        }


    }
}