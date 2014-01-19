package com.mycompany.booking.core;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

/**
 * 
 * Shop is a container for other containers
 * NOTE: Uses Java 1.7
 *
 * @author hajo
 * Modified for our project
 */
public class JPABooking implements IBooking {

    private ITicketCatalogue ticketCatalogue;
    private ICustomerRegistry customerRegistry;
    private IDepartureCatalogue departureCatalogue;
    private ICompetitionCatalogue competitionCatalogue;
   

    public JPABooking(EntityManagerFactory emf) {
        Logger.getAnonymousLogger().log(Level.INFO, "Booing alive {0}", this.hashCode());
        ticketCatalogue = TicketCatalogue.newInstance(emf);
        customerRegistry = CustomerRegistry.newInstance(emf);
        departureCatalogue =DepartureCatalogue.newInstance(emf);
        competitionCatalogue =CompetitionCatalogue.newInstance(emf);
    }

    @Override
    public ITicketCatalogue getTicketCatalogue() {
        return ticketCatalogue;
    }
    
    @Override
    public ICustomerRegistry getCustomerRegistry(){
        return customerRegistry;
    }
    
    @Override
    public IDepartureCatalogue getDepartureCatalogue(){
        return departureCatalogue;
    }
    @Override
    public ICompetitionCatalogue getCompetitionCatalogue(){
        return competitionCatalogue;
    }
}
