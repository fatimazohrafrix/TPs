package cigma.pfe.service;


import cigma.pfe.dao.IFactureDao;
import cigma.pfe.models.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class FactureServiceImpl implements IFactureService {

    @Autowired
    IFactureDao dao;

    public FactureServiceImpl() {
        System.out.println("Call FactureServiceImpl ....");
    }

    @Override
    @Transactional
    public Facture save(Facture f) {
        System.out.println("Service Layer : FactureServiceImpl Level... ");
        return dao.save(f);
    }
    @Override
    @Transactional
    public Facture modify(Facture newFacture) {
        Facture oldFct = dao.findById(newFacture.getId()).get();
        oldFct.setDescription(newFacture.getDescription());
        return dao.save(oldFct);
    }

    @Override
    @Transactional
    public void removeById(long id) {
        dao.deleteById(id);
    }

    @Override
    public Facture getById(long id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Facture> getAll() {
        return (List<Facture>)dao.findAll();
    }

    @Override
    public List<Facture> getByDate(Date date) {
//        return dao.findByDate(date);
        return null;
    }
}
