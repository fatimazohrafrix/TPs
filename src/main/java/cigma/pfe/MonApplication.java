package cigma.pfe;

import cigma.pfe.models.*;
import cigma.pfe.models.Client;
import cigma.pfe.presentation.ClientController;
import models.Client;
import models.Facture;
import org.apache.commons.collections.map.LinkedMap;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import presentation.ClientController;
import java.util.Arrays;
import java.util.List;
public class MonApplication {
    public static <Client> void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ClientController ctr = (ClientController) ctx.getBean("ctrl1");
        Client client = new Client("OMAR");
        CarteFidelio carteFidelio = new CarteFidelio("A29930489");
        carteFidelio.setClient(client);
        client.setCarteFidelio(carteFidelio);
        ctr.save(client);

        Facture facture = new Facture("facture1");
        List<Produit> produits = Arrays.asList(new Produit("produit1", 15), new
                Produit("produit2", 20));
        ctr.save(facture);

        Client client = new Client("OMAR");
        Adresse adresse = new adresse ("Av mohamed V","Ouarzazate","Maroc");
        adresse.setClient(client);
        client.setAdresse(adresse);
        ctr.save(client);

        //this line be  pointed on git


    }
}