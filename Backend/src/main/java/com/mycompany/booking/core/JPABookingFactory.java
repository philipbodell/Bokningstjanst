package com.mycompany.booking.core;

/**
 * Static factory for Shops
 *
 * @author hajo
 */
public class JPABookingFactory {

    private JPABookingFactory() {
    }

    // If initTestData there will be some data to use
    public static IBooking getBooking(String persistenceUnitName) {
        JPABooking s = new JPABooking(persistenceUnitName);
        return s;
    }

    // If we have no database we can use this
    private static void initTestData(JPABooking booking) {

        // Add new data
        booking.getTicketCatalogue().add(new Ticket("Tåg","Göteborg", "Lerum", 20));
        
        /*
        booking.getCustomerRegistry().add(new Customer(new Address("aaa", 1, "aaa"),
                "arne", "arnesson", "arne@gmail.com"));
        booking.getCustomerRegistry().add(new Customer(new Address("bbbb", 2, "bbb"),
                "berit", "beritsson", "berit@gmail.com"));
        booking.getCustomerRegistry().add(new Customer(new Address("ccc", 3, "ccc"),
                "cecilia", "cecilia", "cecila@gmail.com"));

        Customer c = booking.getCustomerRegistry().getByName("arne").get(0);
        c.addTicketToCart(booking.getTicketCatalogue().getByName("banana").get(0));
        c.addTicketToCart(booking.getTicketCatalogue().getByName("apple").get(0));
        c.addTicketToCart(booking.getTicketCatalogue().getByName("pear").get(0));

        booking.getOrderBook().add(new PurchaseOrder(c, c.getCart().getAsOrderItems()));
*/
    }
}
