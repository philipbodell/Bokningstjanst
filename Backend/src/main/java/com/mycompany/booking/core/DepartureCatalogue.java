package com.mycompany.booking.core;

import com.mycompany.booking.utils.AbstractDAO;
import java.util.HashSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * All products
 *
 * @author hajo Modified for our project
 */
public final class DepartureCatalogue extends AbstractDAO<Departure, Long>
        implements IDepartureCatalogue {

    private DepartureCatalogue(EntityManagerFactory emf) {
        super(Departure.class, emf);
    }

    // Factory method
    public static IDepartureCatalogue newInstance(EntityManagerFactory emf) {
        return new DepartureCatalogue(emf);
    }

    @Override
    public List<Departure> getAll() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT d from Departure d", Departure.class);
        List<Departure> p = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return p;
    }

    @Override
    public Object getById(Long id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT d from Departure d WHERE d.id = :id", Departure.class).setParameter("id", id);
        List<Departure> p = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return p.get(0);

    }

    @Override
    public List<Departure> getByType(String type) {
        return getEntityManager().createQuery("SELECT p FROM Departure p WHERE p.type = :type", Departure.class)
                .setParameter("type", type).getResultList();
    }

    @Override
    public List<String> getDepartures() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT d.departurelocation from Departure d", Departure.class);
        List<String> p = q.getResultList();
        HashSet hs = new HashSet();
        hs.addAll(p);
        p.clear();
        p.addAll(hs);
        em.getTransaction().commit();
        em.close();
        return p;
    }
    
    @Override
    public List<String> getDestinations() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT d.destination from Departure d", Departure.class);
        List<String> p = q.getResultList();
        HashSet hs = new HashSet();
        hs.addAll(p);
        p.clear();
        p.addAll(hs);
        em.getTransaction().commit();
        em.close();
        return p;
    }

    @Override
    public List<Departure> getByDestination(String dest) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT d from Departure d WHERE d.destination = :destination", Departure.class).setParameter("destination", dest);
        List<Departure> p = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return p;
    }

    @Override
    public List<Departure> getMatchingDeparture(String departurelocation, String destination) {
        return getEntityManager().createQuery(
                "SELECT p FROM Departure p WHERE p.departurelocation=:departurelocation AND p.destination=:destination", Departure.class)
                .setParameter("departurelocation", departurelocation)
                .setParameter("destination", destination)
                .getResultList();

    }
}
