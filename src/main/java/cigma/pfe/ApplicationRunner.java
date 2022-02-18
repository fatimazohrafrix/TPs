package cigma.pfe;

import cigma.pfe.models.Client;
import cigma.pfe.models.Facture;
import cigma.pfe.presentation.ClientController;
import cigma.pfe.presentation.FactureController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class ApplicationRunner {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        ClientController ctr= (ClientController) ctx.getBean("ctrl1");
        Client client1 = new Client("Omar");
        Client client2 = new Client("Said");
        Client client3 = new Client("Ahmed");

        // Test1 => save 3 Clients
        client1=ctr.save(client1);
        client2=ctr.save(client2);
        client3=ctr.save(client3);

        // Test2 => getAll Clients before modify and remove
        ctr.getAll().stream().forEach(i-> System.out.println(i));

        // Test3 => getOne Client service
        System.out.println(ctr.getOne(1));

        // Test4 => modify Client service
        client1.setName("Hassan");
        ctr.modify(client1);

        // Test5 => remove Client service
        ctr.remove(2);

        // Test6 getAll Client after modify and remove
        ctr.getAll().stream().forEach(i-> System.out.println(i));

        // Test7 getByName Client
        ctr.getByName("Omar").stream().forEach(i-> System.out.println(i));

        // =============================== Facture test side ========================================

        FactureController ctr2= (FactureController) ctx.getBean("ctrl2");

        Facture facture1 = new Facture(new Date(System.currentTimeMillis()),1500.0,"facture1", client1);
        Facture facture2 = new Facture(new Date(System.currentTimeMillis()),2000.0,"facture2", client2);

        // Test 1 => save 2 Facture
        facture1 = ctr2.save(facture1);
        facture2 = ctr2.save(facture2);

        // Test 2 => getAll Factures before modify and remove
        ctr2.getAll().stream().forEach(i-> System.out.println(i));

        // Test 3 => getById Facture service
        System.out.println(ctr2.getById(1));

        // Test4 => modify Facture service
        facture1.setDescription("Facture 1 edited");
        ctr2.modify(facture1);

        // Test5 => remove facture service
        ctr2.removeById(2);

        // Test6 getAll facture after modify and remove
        ctr2.getAll().stream().forEach(i-> System.out.println(i));

        // Test7 getByDate facture
        ctr2.getByDate(new Date(2014,7,15)).stream().forEach(i-> System.out.println(i));

    }
}
