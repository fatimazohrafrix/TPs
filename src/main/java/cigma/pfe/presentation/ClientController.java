package cigma.pfe.presentation;

import cigma.pfe.models.Client;
import cigma.pfe.service.IClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller(value = "ctrl1")
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private IClientService service;

    @PostMapping("/create")
    public Client save(@RequestBody Client clt) {
        return service.save(clt);
    }
    @PutMapping("/update")
    public Client modify(@RequestBody Client clt){
        return service.modify(clt);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") long idClt) {
        service.remove(idClt);
    }

    @GetMapping("/{id}")
    public Client getOne(@PathVariable("id") long idClt) {
        return service.getOne(idClt);
    }
    @GetMapping("/all")
    public List<Client> getAll() {
        return service.getAll();
    }
    public List<Client> getByName(String name) {
        return service.getByName(name);
    }
}
