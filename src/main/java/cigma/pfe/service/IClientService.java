package cigma.pfe.service;

import cigma.pfe.models.Client;

import java.util.List;

public interface IClientService {
    Client save(Client c);
    Client modify(Client newClient);
    void removeById(long id);
    Client getById(long id);
    List<Client> getAll();
}
