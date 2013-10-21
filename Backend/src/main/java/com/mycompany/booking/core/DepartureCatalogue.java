package com.mycompany.booking.core;

import com.mycompany.booking.utils.AbstractDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * All products
 *
 * @author hajo
 * Modified for our project
 */
public final class DepartureCatalogue extends AbstractDAO<Departure, Long>
        implements IDepartureCatalogue {

    private DepartureCatalogue(EntityManagerFactory emf) {
        super(Departure.class,emf);
    }

    // Factory method
    public static IDepartureCatalogue newInstance(EntityManagerFactory emf) {
        return new DepartureCatalogue(emf);
    }

    @Override
    public List<Departure> getByName(String name) {
      
        return getEntityManager().createQuery("SELECT p FROM Departure p WHERE p.name = :name",Departure.class)
                .setParameter("name", name).getResultList();
    }
    
    @Override
    public List<Departure> getAll(){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT d from Departure d",Departure.class);
        List<Departure> p = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return p;
    }
    
    @Override
    public List<Departure> getDummy(){
        ArrayList<Departure> tmp = new ArrayList<Departure>();
        //tmp.addAll(getAll());
        return tmp;
    }
    
    @Override
    public Departure getById(Long id){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT d from Departure d WHERE d.id = :destination",Departure.class).setParameter("destination", id);
        List<Departure> p = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return p.get(0);
        
    }  
    
    @Override
    public List<Departure> getByType(String type){
        return getEntityManager().createQuery("SELECT p FROM Departure p WHERE p.type = :type",Departure.class)
                .setParameter("type", type).getResultList();
    }
    
    @Override
    public List<Departure> getByDestination(String dest){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT d from Departure d WHERE d.destination = :destination",Departure.class).setParameter("destination", dest);
        List<Departure> p = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return p;
    }
    
    public List<Departure> getByAny(String name, Long id){
         return getEntityManager().createQuery(
                 "SELECT p FROM Departure p WHERE p.name '"+name+"'OR p.id'"+id+"'",Departure.class)
                .getResultList();
    }
    public List<Departure> getMatchingDeparture(String departurelocation, String destination){
         return getEntityManager().createQuery(
                 "SELECT p FROM Departure p WHERE p.departurelocation=:departurelocation AND p.destination=:destination AND p.departuredate>=:currentdate",Departure.class)
                .setParameter("departurelocation", departurelocation)
                .setParameter("destination", destination)
                .getResultList();
         
    }
}
