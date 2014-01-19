/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.booking.core;

/**
 *
 * @author hajo
 * Details changed to fit our project
 */
public interface IBooking {
    
    public ITicketCatalogue getTicketCatalogue();
    
    public ICustomerRegistry getCustomerRegistry();
    
    public IDepartureCatalogue getDepartureCatalogue();
    
    public ICodeCatalogue getCodeCatalogue();
}
