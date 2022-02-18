package cigma.pfe;

import cigma.pfe.models.CarteFidelio;
import cigma.pfe.models.Facture;
import cigma.pfe.models.Promotion;
import cigma.pfe.presentation.ClientController;
import cigma.pfe.models.Client;
import cigma.pfe.presentation.FactureController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MonApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ClientController ctrl = (ClientController) context.getBean("controller");

        Client client = new Client("OMAR");
        List<Facture> factures = Arrays.asList(
            new Facture(new Date(System.currentTimeMillis()),1500.0,"facture1", client),
            new Facture(new Date(System.currentTimeMillis()),2000.0,"facture2", client)
        );
        client.setFactures(factures);

        List<Promotion> promotions=Arrays.asList(
            new Promotion("remise 10%"),
            new Promotion("solde 40%")
        );
        client.setPromotions(promotions);

        CarteFidelio carteFidelio = new CarteFidelio("A29930489");
        carteFidelio.setClient(client);
        client.setCarteFidelio(carteFidelio);
        ctrl.save(client);
    }
}
