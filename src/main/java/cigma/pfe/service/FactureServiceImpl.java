package cigma.pfe.service;


import cigma.pfe.dao.IFactureDao;
import cigma.pfe.models.Facture;

import java.util.List;

public class FactureServiceImpl implements IFactureService {
    IFactureDao dao;

    public FactureServiceImpl() {
        System.out.println("Call FactureServiceImpl ....");
    }

    public FactureServiceImpl(IFactureDao factureRepository) {
        System.out.println("Call FactureServiceImpl with FactureRepository param....");
        this.dao = factureRepository;
    }

    @Override
    public Facture save(Facture f) {
        System.out.println("Service Layer : FactureServiceImpl Level... ");
        return dao.save(f);
    }
    @Override
    public Facture modify(Facture newFacture) {
        return dao.update(newFacture);
    }
    @Override
    public void removeById(long id) {
        dao.deleteById(id);
    }

    @Override
    public Facture getById(long id) {
        return dao.findById(id);
    }

    @Override
    public List<Facture> getAll() {
        return dao.findAll();
    }
}
