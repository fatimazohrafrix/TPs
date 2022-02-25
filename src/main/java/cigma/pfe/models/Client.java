package cigma.pfe.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

//@Getter
//@Setter
//@AllArgsConstructor
@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    @Column
    private String name;

    public Client() {}
    public Client(String name) {
        this.name = name;
    }

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
    private List<Facture> factures;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name="my_join_table_client_promotion",
        joinColumns = @JoinColumn(name = "client_fk", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "promotion_fk", referencedColumnName = "id")
    )
    private List<Promotion> promotions;

    @OneToOne(cascade = {CascadeType.PERSIST},mappedBy = "client")
    private CarteFidelio carteFidelio;

    @OneToOne(cascade = {CascadeType.PERSIST},mappedBy = "client")
    private Adresse adresse;

    @Override
    public String toString() {
        return "Client{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}