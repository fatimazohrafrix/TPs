package cigma.pfe.dao;

import cigma.pfe.models.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

    @Repository
    public class ClientDaoImpl<Client> implements IClientDao {
        @PersistenceContext
        private EntityManager entitymanager;
        @Override
        public void save(Client client) {
            entitymanager.persist(client);
        }
        public ClientDaoImpl() {
            System.out.println("creation bean dao");
        }
    }

    @Override
    public Client update(Client newClient) {
        em.getTransaction().begin();
        Client currentClient = em.find(Client.class, newClient.getId());
        currentClient.setName(newClient.getName());
        em.persist(currentClient);
        em.getTransaction().commit();
        return null;
    }

    @Override
    public void deleteById(long idClient) {
        em.getTransaction().begin();
        Client clientInDataBase = em.find(Client.class,idClient);
        em.remove(clientInDataBase);
        em.getTransaction().commit();
    }

    @Override
    public Client findById(long idClient) {
        return em.find(Client.class,idClient);
    }

    @Override
    public List<Client> findAll() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Client> criteria = builder.createQuery(Client.class);
        criteria.from(Client.class);
        List<Client> clientList = em.createQuery(criteria).getResultList();

        return clientList;
    }
}
