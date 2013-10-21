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
    
    public List<Ticket> getAll(){
        return getEntityManager().createNamedQuery("Ticket.getAll",Ticket.class).getResultList();
    }
    
    @Override
    public Ticket getById(Long id){
        return find(id);
    }  
    
    @Override
    public List<Ticket> getByType(String type){
        return getEntityManager().createQuery("SELECT t FROM Ticket t WHERE t.type = :type",Ticket.class)
                .setParameter("type", type).getResultList();
    }
    
    @Override
    public List<Ticket> getByDestination(String destination){
        return getEntityManager().createQuery("SELECT t FROM Ticket t WHERE t.destination = :destination",Ticket.class)
                .setParameter("destination", destination).getResultList();
    }

    @Override
    public List<Ticket> getByDeparture(String departurelocation) {
        return getEntityManager().createQuery("SELECT t FROM Ticket t WHERE t.departurelocation = :departurelocation",Ticket.class)
                .setParameter("departurelocation", departurelocation).getResultList();
    }

    public List<Ticket> getByCustomerId(Long customerid) {
        return getEntityManager().createQuery("SELECT t FROM Ticket t WHERE t.customerid = :customerid",Ticket.class)
                .setParameter("customerid", customerid).getResultList();    
    }
}
