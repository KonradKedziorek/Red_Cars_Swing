package Controllers;

import Models.Car;
import Models.Client;
import Models.Person;
import Models.Rent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ClientController {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<Client> searchClientById(long id){
        List<Client> clients = em.createQuery("select c from Client c where c.id = :id")
                .setParameter("id", id)
                .getResultList();
        return clients;
    }

    public void addClient(String driverLicense, Person person, Rent rent){
        em.getTransaction().begin();
        Client client = new Client();
        client.setDriversLicenseNumber(driverLicense);
        client.setPerson(person);
        client.setRent(rent);
        em.merge(client);
        em.getTransaction().commit();
    }

    public void deleteClientById(long id){
        em.getTransaction().begin();
        em.remove(searchClientById(id));
        em.getTransaction().commit();
    }

    public void deleteClient(Client client){
        em.getTransaction().begin();
        em.remove(client);
        em.getTransaction().commit();
    }

    public List<Client> searchClientByPesel(String pesel){
        List<Client> clients = em.createQuery("select c from Client c join c.person p where p.pesel like :pesel")
                .setParameter("pesel", pesel)
                .getResultList();
        return clients;
    }

}