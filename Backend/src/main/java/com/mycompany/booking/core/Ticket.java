package com.mycompany.booking.core;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 * A Ticket
 * @author hajo
 * Details changed to match our project
 */
//@NamedQuery(destination="Ticket.getAll",query="SELECT t FROM Ticket t")
@Entity
public class Ticket extends AbstractEntity {
    
    @OneToOne
    private Departure departure;
    private double ticketPrice;
   
    
    public Ticket() {
    }

    public Ticket(Departure departure, double ticketPrice) {
        this.departure  = departure;
        this.ticketPrice = ticketPrice;
    }

    public Ticket(Long id, Departure departure, double ticketPrice) {
        super(id);
        this.departure = departure;
        this.ticketPrice = ticketPrice;
    }

    public Departure getDeparture() {
        return departure;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
     
    @Override
    public String toString() {
        //TODO hej

        return "Product{" + "id=" + getId() + ", departure=" + departure + ", ticketPrice=" + ticketPrice + '}';
    }      
}
