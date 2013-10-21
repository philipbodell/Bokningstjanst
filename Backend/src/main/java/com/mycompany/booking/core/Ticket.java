package com.mycompany.booking.core;

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
    
    private String departurelocation;
    private String destination;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date traveldate;
    private String traveltime;
    private double ticketprice;
    private String type;
    private Long customerid;
   
    
    public Ticket() {
    }

    public Ticket(String departurelocation, String destination, Date traveldate, String traveltime, double ticketprice, String type, Long customerid) {
        this.departurelocation  = departurelocation;
        this.destination = destination;
        this.traveldate = traveldate;
        this.traveltime = traveltime;
        this.ticketprice = ticketprice;
        this.type = type;
        this.customerid = customerid;
    }

    public String getDeparturelocation() {
        return departurelocation;
    }
    
    public String getDestination(){
        return destination;
    }
    
    public Date getTraveldate(){
        return traveldate;
    }
    
    public String getTraveltime(){
        return traveltime;
    }
    
    public double getTicketprice() {
        return ticketprice;
    }
    
    public String getType(){
        return type;
    }
    
    public Long getCustomerid(){
        return customerid;
    }
     
    @Override
    public String toString() {
        //TODO hej
        return "Ticket: "+id;
    }      
}
