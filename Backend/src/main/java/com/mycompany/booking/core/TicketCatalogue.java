package com.mycompany.booking.core;

import com.mycompany.booking.utils.AbstractDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * All products
 *
 * @author hajo
 * Modified for our project
 */
public final class TicketCatalogue extends AbstractDAO<Ticket, Long>
        implements ITicketCatalogue {

    private TicketCatalogue(EntityManagerFactory emf) {
        super(Ticket.class,emf);
    }

    // Factory method
    public static ITicketCatalogue newInstance(EntityManagerFactory emf) {
        return new TicketCatalogue(emf);
    }

    @Override
    public List<Ticket> getByName(String name) {
      
        return getEntityManager().createQuery("SELECT p FROM Ticket p WHERE p.name = :name",Ticket.class)
                .setParameter("name", name).getResultList();
    }
    
    public List<Ticket> getAll(){
        EntityManager em = getEntityManager();
        return em.createNamedQuery("Ticket.getAll",Ticket.class).getResultList();
    }
    
    @Override
    public Ticket getById(Long id){
        return find(id);
        
    }  
    
    @Override
    public List<Ticket> getByType(String type){
        return getEntityManager().createQuery("SELECT p FROM Ticket p WHERE p.type = :type",Ticket.class)
                .setParameter("type", type).getResultList();
    }
    
    @Override
    public List<Ticket> getByDestination(String dest){
        return getEntityManager().createQuery("SELECT p FROM Ticket p WHERE p.destination = :destination",Ticket.class)
                .setParameter("destination", dest).getResultList();
    }
    
    public List<Ticket> getByAny(String name, Long id){
         return getEntityManager().createQuery(
                 "SELECT p FROM Ticket p WHERE p.name '"+name+"'OR p.id'"+id+"'",Ticket.class)
                .getResultList();
    }
}
