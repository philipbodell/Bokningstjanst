package com.mycompany.booking.core;

import com.mycompany.booking.utils.AbstractDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * All products
 *
 * @author hajo
 * Modified for our project
 */
public final class DepartureCatalogue extends AbstractDAO<Departure, Long>
        implements IDepartureCatalogue {

    private DepartureCatalogue(String puName) {
        super(Departure.class,puName);
    }

    // Factory method
    public static IDepartureCatalogue newInstance(String puName) {
        return new DepartureCatalogue(puName);
    }

    @Override
    public List<Departure> getByName(String name) {
      
        return getEntityManager().createQuery("SELECT p FROM Departure p WHERE p.name = :name",Departure.class)
                .setParameter("name", name).getResultList();
    }
    
    public List<Departure> getAll(){
        EntityManager em = getEntityManager();
        return em.createNamedQuery("Departure.getAll",Departure.class).getResultList();
    }
    
    @Override
    public Departure getById(Long id){
        return find(id);
        
    }  
    
    @Override
    public List<Departure> getByType(String type){
        return getEntityManager().createQuery("SELECT p FROM Departure p WHERE p.type = :type",Departure.class)
                .setParameter("type", type).getResultList();
    }
    
    @Override
    public List<Departure> getByDestination(String dest){
        return getEntityManager().createQuery("SELECT p FROM Departure p WHERE p.destination = :destination",Departure.class)
                .setParameter("destination", dest).getResultList();
    }
    
    public List<Departure> getByAny(String name, Long id){
         return getEntityManager().createQuery(
                 "SELECT p FROM Departure p WHERE p.name '"+name+"'OR p.id'"+id+"'",Departure.class)
                .getResultList();
    }
}
