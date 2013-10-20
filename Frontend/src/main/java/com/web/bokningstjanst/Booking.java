

package com.web.bokningstjanst;

import com.mycompany.booking.core.IBooking;
import com.mycompany.booking.core.ICustomerRegistry;
import com.mycompany.booking.core.IDepartureCatalogue;
import com.mycompany.booking.core.ITicketCatalogue;
import com.mycompany.booking.core.JPABookingFactory;
import javax.persistence.Persistence;

public enum Booking {

    INSTANCE;
    private final IBooking b;
    
    
    private Booking() {
        b = JPABookingFactory.getBooking(Persistence.createEntityManagerFactory("test"));
    }

    public ITicketCatalogue getTicketCatalogue() {
        return b.getTicketCatalogue();
    }
    
    public IDepartureCatalogue getDepartureCatalogue() {
        return b.getDepartureCatalogue();
    }

    public ICustomerRegistry getCustomerRegistry() {
        return b.getCustomerRegistry();
    }
}
