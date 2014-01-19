/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.booking;

import static com.mycompany.booking.TestCustomerRegistry.booking;
import com.mycompany.booking.core.Competition;
import com.mycompany.booking.core.Customer;
import com.mycompany.booking.core.IBooking;
import com.mycompany.booking.core.ICompetitionCatalogue;
import com.mycompany.booking.core.ICustomerRegistry;
import com.mycompany.booking.core.JPABookingFactory;
import javax.persistence.Persistence;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Johan
 */
public class TestCompetitionCatalogue {
   

    static IBooking booking;
    final static String PU = "booking_pu";
    

    @Before // Run before each test
    public void before() {
        booking = JPABookingFactory.getBooking(Persistence.createEntityManagerFactory("booking_pu"));
        
    }
    
    @Test
    public void testAddCompetition(){
        ICompetitionCatalogue cr = booking.getCompetitionCatalogue();
        System.out.println(cr.toString());
        //cr.remove(cr.getIdByEmail("p@b.se"));
        Competition c1 = new Competition("Philip","Bodell","1234","p@b.se","23");
        cr.add(c1);
       
        assertTrue(cr.getByMail("p@b.se").get(0).equals(c1));
    }
}

