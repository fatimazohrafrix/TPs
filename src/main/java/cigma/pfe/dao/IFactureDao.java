package cigma.pfe.dao;

import cigma.pfe.models.Facture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IFactureDao extends CrudRepository<Facture,Long> {
}
