package cigma.pfe.service;

import cigma.pfe.models.Client;
import cigma.pfe.models.Facture;

import java.util.Date;
import java.util.List;

public interface IFactureService {

    Facture save(Facture f);
    Facture modify(Facture newFacture);
    void removeById(long id);
    Facture getById(long id);
    List<Facture> getByDate(Date date);
    List<Facture> getAll();
}
