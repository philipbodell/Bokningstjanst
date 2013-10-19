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
        return getEntityManager()
                .createQuery("SELECT p FROM Departure p WHERE p.type = :type",Departure.class)
                .setParameter("type", type).getResultList();
    }
    
    @Override
    public List<Departure> getByDestination(String dest){
        return getEntityManager()
                .createQuery("SELECT p FROM Departure p WHERE p.destination = :destination",Departure.class)
                .setParameter("destination", dest).getResultList();
    }
    
    @Override
    public List<Departure> getByDepartureLocation(String depLocation){
        return getEntityManager()
                .createQuery("SELECT p FROM Departure p WHERE p.departureLocation= :departureLocation",Departure.class)
                .setParameter("departureLocation", depLocation).getResultList();
    }
    
    @Override
    public List<Departure> getByDepartureLocationAndDestination(String depLocation, String dest){
        return getEntityManager().createQuery("SELECT p FROM Departure p WHERE p.departureLocation = :departureLocation AND p.dest = :dest ",Departure.class)
                .setParameter("departureLocation", depLocation)
                .setParameter("destination", dest)
                .getResultList();

    }
    
    @Override
    public List<Departure> getAllDepartureLocations(){
         return getEntityManager().createNamedQuery("Departure.getAll",Departure.class).getResultList();
    }
/*
    public List<Departure> getByAny(String na, Long id){
         return getEntityManager().createQuery(
                 "SELECT p FROM Departure p WHERE p.name '"+name+"'OR p.id'"+id+"'",Departure.class)
                .getResultList();
    }
*/
}
