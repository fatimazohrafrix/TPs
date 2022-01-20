package cigma.pfe.presentation;

import cigma.pfe.models.Client;
import cigma.pfe.service.IClientService;

import java.util.List;

public class ClientController {

    IClientService service;

    public ClientController() {
        System.out.println("Call ClientController ....");
    }
    public ClientController(IClientService clientService) {
        System.out.println("Call ClientController with clientService param....");
        this.service = clientService;
    }

    public void setClientService(IClientService clientService) {
        this.service = clientService;
    }

//    ClientService clientService = new ClientServiceImpl();
    public Client save(Client c ){
        System.out.println("ClientController level...");
        return service.save(c);
    }
    public void modify(Client newClient) {
        service.modify(newClient);
    }
    public void removeById(long id) {
        service.removeById(id);
    }
    public Client getById(long id) {
        return service.getById(id);
    }

    public List<Client> getAll() {
        return service.getAll();
    }
}
