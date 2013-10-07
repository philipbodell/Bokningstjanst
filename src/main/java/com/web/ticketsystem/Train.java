/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.ticketsystem;

import javax.persistence.Entity;

@Entity
public class Train extends TicketEntity {

    private String destination;
    private String depatureDate;
    private String depatureTime;
    private String destinationReturn;
    private String depatureDateReturn;
    private String depatureTimeReturn;

    public Train() {
    }

    public Train(String destination, String depatureDate, String depatureTime,
            String destinationReturn, String depatureDateReturn, String depatureTimeReturn) {

        this.depatureDate = depatureDate;
        this.depatureDateReturn = depatureDateReturn;
        this.depatureTime = depatureTime;
        this.depatureTimeReturn = depatureTimeReturn;
        this.destination = destination;
        this.destinationReturn = destinationReturn;
    

    
}
    public String getFepatureDate() {
        return depatureDate;
    }

    public String getDepatureDateReturn() {
        return depatureDateReturn;
    }
    
       public String getDepatureTime() {
        return depatureTime;
    }
       
          public String getDepatureTimeReturn() {
        return depatureTimeReturn;
    }
          
             public String getDestination() {
        return destination;
    }
             
                public String getdDstinationReturn() {
        return destinationReturn;
    }
}
