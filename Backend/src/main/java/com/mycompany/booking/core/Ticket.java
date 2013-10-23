package com.mycompany.booking.core;

import javax.persistence.Entity;

/**
 * A Ticket
 * @author hajo
 * Details changed to match our project
 */
@Entity
public class Ticket extends AbstractEntity {
    
    private String departurelocation;
    private String destination;
    private String traveldate;
    private String traveltime;
    private int ticketprice;
    private String type;
    private Long customerid;
   
    
    public Ticket() {
    }

    public Ticket(String departurelocation, String destination, String traveldate, String traveltime, String type,int ticketprice,  Long customerid) {
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
    
    public String getTraveldate(){
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
        return "Ticket: "+id;
    }      
}
