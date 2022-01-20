package cigma.pfe.service;

import cigma.pfe.models.Client;
import cigma.pfe.dao.IClientDao;

import java.util.List;

public class ClientServiceImpl implements IClientService {
    IClientDao dao;

    public ClientServiceImpl() {
        System.out.println("Call ClientServiceImpl ....");
    }

    public ClientServiceImpl(IClientDao clientRepository) {
        System.out.println("Call ClientServiceImpl with ClientRepository param....");
        this.dao = clientRepository;
    }
//        ClientRepository clientRepository = new ClientRepositoryImpl();
    @Override
    public Client save(Client c) {
        System.out.println("Service Layer : ClientServiceImpl Level... ");
        return dao.save(c);
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
