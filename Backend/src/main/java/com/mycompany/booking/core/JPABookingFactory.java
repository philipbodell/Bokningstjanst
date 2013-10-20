package com.mycompany.booking.core;

/**
 * Static factory for Shops
 *
 * @author hajo
 * Modified for our project
 */
public class JPABookingFactory {

    private JPABookingFactory() {
    }

    // If initTestData there will be some data to use
    public static IBooking getBooking(String persistenceUnitName) {
        JPABooking s = new JPABooking(persistenceUnitName);
        initTestData(s);
        return s;
    }

    // If we have no database we can use this
    private static void initTestData(JPABooking booking) {

        // Add new data
        booking.getCustomerRegistry().add(new Customer("arne", "arnesson","arne", "1234", "6112032314", "arne@arne.arne"));
        booking.getCustomerRegistry().add(new Customer("Björn", "Magasinsson","Coolbitch", "ilovehorses", "9712031567", "björne@magasin.pung"));
        booking.getCustomerRegistry().add(new Customer("Sven", "Svensson","xxvitmakt", "ponny", "8507178573", "coolboii@hotmail.com"));

        Customer c = booking.getCustomerRegistry().getByName("arne").get(0);
        
        c.addTicketToCart(booking.getTicketCatalogue().getByName("båt").get(0));
        c.addTicketToCart(booking.getTicketCatalogue().getByName("tåg").get(0));
        c.addTicketToCart(booking.getTicketCatalogue().getByName("hest").get(0));

        //booking.getTicketCatalogue().add(new Ticket(c, c.getCart().getAsOrderItems()));

    }
}