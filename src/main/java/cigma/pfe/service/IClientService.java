package cigma.pfe.service;

import cigma.pfe.models.Client;

import java.util.List;

public interface IClientService {
    Client save(Client clt);
    Client modify(Client clt);
    void remove(long idClt);
    Client getOne(long idClt);
    List<Client> getByName(String name);
    List<Client> getAll();
}
