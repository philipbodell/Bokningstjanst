/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.booking.core;

/**
 *
 * @author ed
 */
public interface IBooking {
    public ITicketCatalogue getTicketCatalogue();
    public ICustomerRegistry getCustomerRegistry();
    public IDepartureCatalogue getDepartureCatalogue();
}
