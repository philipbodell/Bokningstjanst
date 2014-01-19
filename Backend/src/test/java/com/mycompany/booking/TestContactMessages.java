/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.booking;

import static com.mycompany.booking.TestCompetitionCatalogue.booking;
import com.mycompany.booking.core.Competition;
import com.mycompany.booking.core.ContactMessages;
import com.mycompany.booking.core.IBooking;
import com.mycompany.booking.core.ICompetitionCatalogue;
import com.mycompany.booking.core.IContactMessagesRegistry;
import com.mycompany.booking.core.JPABookingFactory;
import javax.persistence.Persistence;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Johan
 */
public class TestContactMessages {
   

    static IBooking booking;
    final static String PU = "booking_pu";
    

    @Before // Run before each test
    public void before() {
        booking = JPABookingFactory.getBooking(Persistence.createEntityManagerFactory("booking_pu"));
        
    }
    
    @Test
    public void testAddMessage(){
        IContactMessagesRegistry cr = booking.getContactMessagesRegistry();
        System.out.println(cr.toString());
        //cr.remove(cr.getIdByEmail("p@b.se"));
        ContactMessages c1 = new ContactMessages("hej@hej.se","testlitesttesttest");
        cr.add(c1);
       
        assertTrue(true);
    }
}

