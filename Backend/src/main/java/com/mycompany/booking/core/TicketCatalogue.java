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
public final class TicketCatalogue extends AbstractDAO<Ticket, Long>
        implements ITicketCatalogue {

    private TicketCatalogue(String puName) {
        super(Ticket.class,puName);
    }

    // Factory method
    public static ITicketCatalogue newInstance(String puName) {
        return new TicketCatalogue(puName);
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
