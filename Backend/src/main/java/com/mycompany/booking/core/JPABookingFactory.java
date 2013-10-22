package com.mycompany.booking.core;

import javax.persistence.EntityManagerFactory;

/**
 * Static factory for Shops
 *
 * @author hajo
 * Details changed to fit our project
 */
public class JPABookingFactory {

    private JPABookingFactory() {
    }

    // If initTestData there will be some data to use
    public static IBooking getBooking(EntityManagerFactory emf) {
        JPABooking s = new JPABooking(emf);
        return s;
    }
}
