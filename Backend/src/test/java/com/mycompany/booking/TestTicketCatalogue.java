package com.mycompany.booking;

import com.mycompany.booking.core.Departure;
import com.mycompany.booking.core.IBooking;
import com.mycompany.booking.core.ITicketCatalogue;
import com.mycompany.booking.core.JPABookingFactory;
import com.mycompany.booking.core.Ticket;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Test for Ticket catalog.
 *
 * NOTES: - Possible to run with embedded Derby (no server needed) - Possible to
 * run with server and create tables
 *
 * NOTE: Must have Table generation Strategy to Create (or Drop and Create)
 * NOTE: equals and hashCode can (should) possible be implemented in some other
 * way, though no common accepted way..
 *
 * @author hajo
 * Edited to fit our project
 */
public class TestTicketCatalogue {

    static IBooking booking;
    final static String PU = "booking_pu";
    

    @Before // Run before each test
    public void before() {
        booking = JPABookingFactory.getBooking(Persistence.createEntityManagerFactory(PU));  
    }

    @Test
    public void testGetRange() {
        ITicketCatalogue tc = booking.getTicketCatalogue();

        for (int i = 0; i < 10; i++) {
            tc.add(new Ticket("DepartureTest","DestinationTest","2013-05-12", "08:02", "Train",240,Long.valueOf(i)));
        }
        List<Ticket> ps = tc.getRange(0, 2);
        assertTrue(ps.size() == 2);
    }

    

    @Test
    public void testGetByDestination() {
        ITicketCatalogue tc = booking.getTicketCatalogue();
        Ticket p = new Ticket("DepartureTest","DestinationTest","2013-05-12", "08:02", "Train",240,(long)12);
        tc.add(p);
        List<Ticket> ps = tc.getByDestination("DestinationTest");
        assertTrue(ps.size() >= 1);
    }
    
    //@After
    public void after(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q2 = em.createNativeQuery("DELETE FROM APP.TICKET");
        q2.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
