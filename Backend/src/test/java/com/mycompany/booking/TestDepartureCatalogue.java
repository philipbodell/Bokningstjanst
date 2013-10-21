/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.booking;

import com.mycompany.booking.core.Departure;
import com.mycompany.booking.core.DepartureCatalogue;
import com.mycompany.booking.core.IBooking;
import com.mycompany.booking.core.JPABookingFactory;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Philip and Johan
 */
public class TestDepartureCatalogue {            
    
    private IBooking booking;
    
    @Before
    public void before(){
        booking = JPABookingFactory.getBooking(Persistence.createEntityManagerFactory("booking_pu"));
    }
    
    @Test
    public void testAddDeparture(){
        DepartureCatalogue dc = (DepartureCatalogue) booking.getDepartureCatalogue();
        Departure d = new Departure();
        d.setDeparturelocation("Gothenburg");
        d.setDestination("Patriks Hus");
        d.setDeparturedate("2013-10-24");
        d.setDeparturetime("08:47");
        d.setType("Train");
        d.setPrice(700);
        d.setTraveltime("00:23");
        for(String s:dc.getDepartures()){
            System.out.println("INFO: "+ s);
        }
        dc.add(d);
    }
}
