package cigma.pfe.models;

import javax.persistence.CascadeType;
import javax.persistence.*;

import lombok.Data;
import org.hibernate.mapping.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String name;
    public Client(String name) {
        this.name = name;
      }
    public class Client() {
    }
    }
public class client<String, Promotion> {
    @OneToOne(cascade = {CascadeType.PERSIST},mappedBy = "client")
    private CarteFidelio carteFidelio;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
    private List factures;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name="my_join_table_client_promotion",
            joinColumns = @JoinColumn(name = "client_fk",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn (name = "promotion_fk",referencedColumnName = "id"))
    private List promotions;

    @OneToOne(cascade = {CascadeType.PERSIST},mappedBy = "client")
    private CarteFidelio carteFidelio;

    public void Client(String name) {
        this.name = name;
    }

    public void Client(String name, List factures) {
        super();
        this.name = name;
        this.factures = factures;
    }
    //...
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Promotion> promotions;
//...

    @OneToOne(cascade = {CascadeType.PERSIST},mappedBy = "client")
    private Adresse adresse;
    public void Client(String name, Adresse adresse) {
        this.name = name;
        this.adresse = adresse;
    }



}
