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
 *CompetitionCatalogue
 */
public final class CompetitionCatalogue
        extends AbstractDAO<Competition, Long> implements ICompetitionCatalogue {

    public CompetitionCatalogue(EntityManagerFactory emf) {
        super(Competition.class, emf);
    }

    // Factory method
    public static CompetitionCatalogue newInstance(EntityManagerFactory emf) {
        return new CompetitionCatalogue(emf);
    }

    @Override
    public List<Competition> getByName(String name) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT d from Competition d WHERE d.fname = :name", Departure.class).setParameter("name", name);
        List<Competition> p = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return p;
    }
    
    @Override
    public Object getById(Long id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT c from Competition c WHERE c.id = :id", Departure.class).setParameter("id", id);
        List<Competition> p = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return p.get(0);
    }
    
    @Override
    public List<Competition> getByMail(String email) {
       EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT c from Competition c WHERE c.email = :email", Departure.class).setParameter("email", email);
        List<Competition> p = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return p;
        
    }

    
    @Override
    public String getLnameByEmail(String email) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT c.lname from Competition c WHERE c.email = :email", Departure.class).setParameter("email", email);
        String p = (String)q.getResultList().get(0);
        em.getTransaction().commit();
        em.close();
        return p;
    }

    @Override
    public String getFnameByEmail(String email) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT c.fname from Competition c WHERE c.email = :email", Departure.class).setParameter("email", email);
        String p = (String)q.getResultList().get(0);
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