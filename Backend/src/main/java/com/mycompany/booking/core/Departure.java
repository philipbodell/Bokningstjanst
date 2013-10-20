/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.booking.core;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author Philip och Johan
 */
@NamedQuery(name = "Departure.getAll",query = "SELECT d FROM Departure d")
@Entity
public class Departure extends AbstractEntity {

    private String type;
    
    private String departureLocation;
    private String destination;
    
    private Time departureTime;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date departureDate;
    
    private Time travelTime;

    public Departure() {
    }

    public Departure(String type, String departureLocation, String destination, Time depTime,Date depDate,Time travelTime){
        this.type = type;
        this.departureLocation = departureLocation;
        this.destination = destination;
        this.departureTime = depTime;
        this.departureDate = depDate;
        this.travelTime = travelTime;
    }    
    
    public String getType(){
        return type;
    }
    
    public String getDepartureLocation() {
        return departureLocation;
    }

    public String getDestination() {
        return destination;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Time getTravelTime(){
        return travelTime;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
