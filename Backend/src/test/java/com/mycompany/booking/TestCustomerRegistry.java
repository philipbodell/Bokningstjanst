/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.booking;

import static com.mycompany.booking.TestCustomerRegistry.booking;
import com.mycompany.booking.core.Customer;
import com.mycompany.booking.core.IBooking;
import com.mycompany.booking.core.ICustomerRegistry;
import com.mycompany.booking.core.JPABookingFactory;
import java.util.ArrayList;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Philip
 */
public class TestCustomerRegistry {

    static IBooking booking;
    final static String PU = "booking_pu";
    

    @Before // Run before each test
    public void before() {
        booking = JPABookingFactory.getBooking(Persistence.createEntityManagerFactory("booking_pu"));
        
    }
    
    @Test
    public void testAddCustomer(){
        ICustomerRegistry cr = booking.getCustomerRegistry();
        System.out.println(cr.toString());
        cr.remove(cr.getIdByEmail("p@b.se"));
        Customer c1 = new Customer("Philip","Bodell","1234","900703","p@b.se");
        cr.add(c1);
       
        assertTrue(cr.getByMail("p@b.se").get(0).equals(c1));
    }
}
