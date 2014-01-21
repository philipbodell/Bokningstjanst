/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.booking;

import static com.mycompany.booking.TestCustomerRegistry.booking;
import com.mycompany.booking.core.Code;
import com.mycompany.booking.core.Customer;
import com.mycompany.booking.core.Departure;
import com.mycompany.booking.core.IBooking;
import com.mycompany.booking.core.JPABooking;
import com.mycompany.booking.core.JPABookingFactory;
import javax.persistence.Persistence;
import org.junit.Test;

/**
 *
 * @author Dator
 */
public class TestData {
    
    @Test
    public void TestData(){
        
        IBooking booking = JPABookingFactory.getBooking(Persistence.createEntityManagerFactory("booking_pu"));
        
        booking.getCodeCatalogue().add(new Code("QWE", 20));
        booking.getCodeCatalogue().add(new Code("WER", 10));
        booking.getCodeCatalogue().add(new Code("ERT", 30));
        booking.getCodeCatalogue().add(new Code("RTY", 40));
        
        booking.getCustomerRegistry().add(new Customer("Jacob", "Engdahl", "qwe", "9104041232", "jacob@wow.com"));
        booking.getCustomerRegistry().add(new Customer("Peter", "Hamilton", "123", "5405115434", "peter@such.com"));
        booking.getCustomerRegistry().add(new Customer("Björn", "Svensson", "zxc", "7610108732", "yeah@indeed.com"));
        booking.getCustomerRegistry().add(new Customer("Ivar", "Andersson", "asd", "8708127632", "qwer@doge.com"));
        
        booking.getDepartureCatalogue().add(new Departure("Göteborg", "Stockholm", "20140604","12:30","02:56","Train",450));
        booking.getDepartureCatalogue().add(new Departure("Landvetter", "Paris", "20140207","07:25","03:36","Plane",1245));
        booking.getDepartureCatalogue().add(new Departure("Öland", "Gotland", "20140402","13:37","00:56","Boat",125));
        booking.getDepartureCatalogue().add(new Departure("Kalmar", "Umeå", "20140525","04:45","6:47","Train",545));
        
        
        booking.getCodeCatalogue().remove((long)452);
        
    }
    
}
