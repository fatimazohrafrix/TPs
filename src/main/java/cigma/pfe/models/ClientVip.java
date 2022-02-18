package cigma.pfe.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
@Entity
@Data
@PrimaryKeyJoinColumn(name="vip_id")
public class ClientVip extends Client{
    public ClientVip() {}
    private String preferences;
    public ClientVip(String name, String preferences) {
        super(name);
        this.preferences = preferences;
    }
}