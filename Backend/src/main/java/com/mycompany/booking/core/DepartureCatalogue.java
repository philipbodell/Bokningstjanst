package com.mycompany.booking.core;

import com.mycompany.booking.utils.AbstractDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * All products
 *
 * @author hajo Modified for our project
 */
public final class DepartureCatalogue extends AbstractDAO<Departure, Long>
        implements IDepartureCatalogue {

    @PersistenceContext(unitName = "booking_pu")
    private EntityManager em1;
    
    private DepartureCatalogue(String puName) {
        super(Departure.class, puName);
    }

    // Factory method
    public static IDepartureCatalogue newInstance(String puName) {
        return new DepartureCatalogue(puName);
    }

    @Override
    public ArrayList<Departure> getDummy() {
        ArrayList<Departure> josef = new ArrayList<Departure>();
        josef.add(new Departure("heåj", "", "", null, null, null));
        
        josef.add(new Departure("heåj", "derp", "", null, null, null));
        return josef;
    }
    

    @Override
    public List<Departure> getAll() {
       
        return getEntityManager().createNamedQuery("Departure.getAll",Departure.class).getResultList();
        
    }

    @Override
    public Departure getById(Long id) {
        return find(id);

    }

    @Override
    public List<Departure> getByType(String type) {
        System.out.println("getBytype");
        return getEntityManager().createQuery("SELECT d FROM Departure d WHERE d.type = :type", Departure.class)
                .setParameter("type", type).getResultList();
    }

    @Override
    public List<Departure> getByDestination(String dest) {
        return getEntityManager().createQuery("SELECT d FROM Departure d WHERE d.destination = :destination", Departure.class)
                .setParameter("destination", dest).getResultList();
    }

    public List<Departure> getByAny(String name, Long id) {
        return getEntityManager().createQuery(
                "SELECT d FROM Departure d WHERE d.name '" + name + "'OR d.id'" + id + "'", Departure.class)
                .getResultList();
    }
}
