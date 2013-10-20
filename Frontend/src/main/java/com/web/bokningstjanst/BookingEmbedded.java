/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.bokningstjanst;

import com.mycompany.booking.core.IDepartureCatalogue;
import com.mycompany.booking.core.JPABookingFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ed
 */
public class BookingEmbedded {
    public IDepartureCatalogue getDepartureCatalogue(){
       return JPABookingFactory.getBooking(Persistence.createEntityManagerFactory("test")).getDepartureCatalogue();
    }
}
