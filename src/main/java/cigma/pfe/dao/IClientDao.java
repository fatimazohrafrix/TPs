package cigma.pfe.dao;

import cigma.pfe.models.Client;

import java.util.List;

public interface IClientDao {
    Client save(Client c);
    Client update(Client newClient);
    void deleteById(long idClient);
    Client findById(long idClient);
    List<Client> findAll();
}
