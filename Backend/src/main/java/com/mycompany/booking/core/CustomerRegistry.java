package com.mycompany.booking.core;

import com.mycompany.booking.utils.AbstractDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * All customers
 *
 * @author hajo 
 * Details changed to fit our project
 *
 */
public final class CustomerRegistry
        extends AbstractDAO<Customer, Long> implements ICustomerRegistry {

    public CustomerRegistry(EntityManagerFactory emf) {
        super(Customer.class, emf);
    }

    // Factory method
    public static ICustomerRegistry newInstance(EntityManagerFactory emf) {
        return new CustomerRegistry(emf);
    }

    @Override
    public List<Customer> getByName(String name) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT d from Customer d WHERE d.fname = :name", Departure.class).setParameter("name", name);
        List<Customer> p = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return p;
    }
    
    @Override
    public Object getById(Long id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT c from Customer c WHERE c.id = :id", Departure.class).setParameter("id", id);
        List<Departure> p = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return p.get(0);
    }
    
    @Override
    public List<Customer> getByMail(String email) {
       EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT c from Customer c WHERE c.email = :email", Departure.class).setParameter("email", email);
        List<Customer> p = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return p;
        
    }
    
    @Override
    public String getUserPassword(String email) {
       EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT c.password from Customer c WHERE c.email = :email", Departure.class).setParameter("email", email);
        String p = (String)q.getResultList().get(0);
        em.getTransaction().commit();
        em.close();
        return p;
    }
    
    @Override
    public String getLnameByEmail(String email) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT c.lname from Customer c WHERE c.email = :email", Departure.class).setParameter("email", email);
        String p = (String)q.getResultList().get(0);
        em.getTransaction().commit();
        em.close();
        return p;
    }

    @Override
    public String getFnameByEmail(String email) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT c.fname from Customer c WHERE c.email = :email", Departure.class).setParameter("email", email);
        String p = (String)q.getResultList().get(0);
        em.getTransaction().commit();
        em.close();
        return p;   
    }

    @Override
    public boolean authenticate(String email, String password) {
        if(getByMail(email).size()<1){
            return false;
        }else if(getUserPassword(email).equals(password)){
            return true;
        }
        return false;
    }

    @Override
    public Long getIdByEmail(String email) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT c.id from Customer c WHERE c.email = :email", Departure.class).setParameter("email", email);
        Long p = (Long) q.getResultList().get(0);
        em.getTransaction().commit();
        em.close();
        return p;
    }
    
    /*@Override
    public Customer getByEmail(String email){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT c from Customer c WHERE c.email = :email", Departure.class).setParameter("email", email);
        Customer c = (Customer)q.getResultList().get(0);
        em.getTransaction().commit();
        em.close();
        return c;
    */
}
