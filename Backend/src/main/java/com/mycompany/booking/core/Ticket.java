package com.mycompany.booking.core;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;

/**
 * A Ticket
 * @author hajo
 * Details changed to match our project
 */
//@NamedQuery(destination="Ticket.getAll",query="SELECT t FROM Ticket t")
@Entity
public class Ticket extends AbstractEntity {
    
   // @OneToMany(mappedBy="product",cascade={CascadeType.REMOVE})
  //  private List<OrderItem> orderItemList;
    private String ticketType;
    private String destination;
    private String departureLocation;
    private Time departureTime;
    private Time travelTime;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date departureDate;
    private double ticketPrice;

    public Ticket() {
    }

    public Ticket(String ticketType, String destination, String departureLocation, double ticketPrice) {
        this.ticketType = ticketType;
        this.destination = destination;
        this.departureLocation = departureLocation;
        this.ticketPrice = ticketPrice;
    }

    public Ticket(Long id, String destination, double ticketPrice) {
        super(id);
        this.destination = destination;
        this.ticketPrice = ticketPrice;
    }

    public String getDestination() {
        return destination;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
     
    @Override
    public String toString() {
        return "Product{" + "id=" + getId() + ", destination=" + destination + ", ticketPrice=" + ticketPrice + '}';
    }      
}
