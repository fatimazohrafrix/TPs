package cigma.pfe.service;

import cigma.pfe.models.Client;
import cigma.pfe.dao.IClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    private IClientDao dao;

    public  ClientServiceImpl() {System.out.println("Call ClientServiceImpl ....");}
    @Override
    @Transactional
    public Client save(Client clt) {
        return dao.save(clt);
    }

    @Override
    @Transactional
    public Client modify(Client newClt) {
        Client oldClt = dao.findById(newClt.getId());
        oldClt.setName(newClt.getName());
        return dao.save(oldClt);
    }

    @Override
    @Transactional
    public void remove(long idClt) {
        dao.deleteById(idClt);
    }

    @Override
    public Client getOne(long idClt) {
        return dao.findById(idClt);
    }

    @Override
    public List<Client> getAll() {
        return (List<Client>) dao.findAll();
    }

    @Override
    public List<Client> getByName(String name) {
        return (List<Client>) dao.findByName(name);
    }
}