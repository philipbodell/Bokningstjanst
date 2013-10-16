package com.mycompany.booking.core;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Shop is a container for other containers
 * NOTE: Uses Java 1.7
 *
 * @author hajo
 */
public class JPABooking implements IBooking {

    private ITicketCatalogue ticketCatalogue;
    private ICustomerRegistry customerRegistry;
   

    public JPABooking(String puName) {
        Logger.getAnonymousLogger().log(Level.INFO, "Booking alive {0}", this.hashCode());
        ticketCatalogue = TicketCatalogue.newInstance(puName);
        customerRegistry = CustomerRegistry.newInstance(puName);
    }

    @Override
    public ITicketCatalogue getTicketCatalogue() {
        return ticketCatalogue;
    }
    
    @Override
    public ICustomerRegistry getCustomerRegistry(){
        return customerRegistry;
    }
}
