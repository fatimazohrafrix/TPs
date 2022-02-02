package cigma.pfe.service;

import cigma.pfe.models.Client;
import cigma.pfe.dao.IClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {
    @Autowired
    private IClientDao dao;
    public ClientServiceImpl() {
        System.out.println("creation bean service");
    }
    @Override
    public void save(Client c) {
        dao.save(c);
    }
}
    @Override
    public Client modify(Client newClient) {
        return dao.update(newClient);
    }
    @Override
    public void removeById(long id) {
        dao.deleteById(id);
    }

    @Override
    public Client getById(long id) {
        return dao.findById(id);
    }

    @Override
    public List<Client> getAll() {
        return dao.findAll();
    }
}
