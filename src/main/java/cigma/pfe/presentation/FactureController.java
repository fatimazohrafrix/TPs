package cigma.pfe.presentation;


import cigma.pfe.models.Facture;
import cigma.pfe.service.IFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller(value = "ctrl2")
public class FactureController {

    @Autowired
    IFactureService serviceFDI;

//    public FactureController() {
//        System.out.println("Call FactureController ....");
//    }
//    public FactureController(IFactureService factureService) {
//        System.out.println("Call FactureController with factureService param....");
//        this.serviceFDI = factureService;
//    }

//    public void setFactureService(IFactureService factureService) {
//        this.serviceFDI = factureService;
//    }

    public Facture save(Facture f ){
        System.out.println("FactureController level...");
        return serviceFDI.save(f);
    }
    public void modify(Facture newFacture) {
        serviceFDI.modify(newFacture);
    }
    public void removeById(long id) {
        serviceFDI.removeById(id);
    }
    public Facture getById(long id) {
        return serviceFDI.getById(id);
    }
    public List<Facture> getAll() {
        return serviceFDI.getAll();
    }
    public List<Facture> getByDate(Date date) {
        return serviceFDI.getByDate(date);
    }
}
