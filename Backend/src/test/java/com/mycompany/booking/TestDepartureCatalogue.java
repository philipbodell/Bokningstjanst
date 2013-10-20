/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.booking;

import com.mycompany.booking.core.Departure;
import com.mycompany.booking.core.IBooking;
import com.mycompany.booking.core.IDepartureCatalogue;
import com.mycompany.booking.core.JPABookingFactory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ed
 */
public class TestDepartureCatalogue {
    
    static IBooking booking;
    final static String PU = "booking_pu";
    

    @Before // Run before each test
    public void before() {
        booking = JPABookingFactory.getBooking(PU);
    }
    
    @Test
    public void testGetAll(){
        IDepartureCatalogue dc = booking.getDepartureCatalogue();
        
        dc.add(new Departure("", "", "", null, null, null));
        for(Departure d: dc.getAll()){
            System.out.println(d.getDepartureLocation());
        }
        assertTrue(dc.getAll().size() >= 1);
    }
    
    @Test
    public void testGetByType(){
        
        IDepartureCatalogue dc = booking.getDepartureCatalogue();
        for(Departure d: dc.getAll()){
            System.out.println(d.getType());
        }
        
        assertTrue(dc.getByType("Train").size() >= 1);
    }
}
