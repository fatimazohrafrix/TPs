package cigma.pfe.presentation;

import cigma.pfe.models.Client;
import cigma.pfe.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

public class ClientController {

    I@Controller("ctrl")
    public class ClientController {
        @Autowired
        private IClientService service;
        public void save(Client person) {
            service.save(person);
        }
        public ClientController() {
            System.out.println("creation bean controller");
        }
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
