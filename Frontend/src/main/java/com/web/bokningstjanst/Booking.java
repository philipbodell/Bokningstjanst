

package com.web.bokningstjanst;

import com.mycompany.booking.core.IBooking;
import com.mycompany.booking.core.ICustomerRegistry;
import com.mycompany.booking.core.IDepartureCatalogue;
import com.mycompany.booking.core.ITicketCatalogue;
import com.mycompany.booking.core.JPABookingFactory;

public enum Booking{

    INSTANCE;
    private final IBooking b;

    private Booking() {
        b = JPABookingFactory.getBooking("booking_pu");
    }

    public ITicketCatalogue getTicketCatalogue() {
        return b.getTicketCatalogue();
    }

    public ICustomerRegistry getCustomerRegistry() {
        return b.getCustomerRegistry();
    }
    
    public synchronized IDepartureCatalogue getDepartureCatalogue(){
        return b.getDepartureCatalogue();
    }
}
