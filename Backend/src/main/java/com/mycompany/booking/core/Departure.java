/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.booking.core;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
*
* @author ed
*/
@Entity
public class Departure extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "DEPARTURELOCATION")
    private String departurelocation;
    @Column(name = "DESTINATION")
    private String destination;
    @Column(name = "DEPARTUREDATE")
    private String departuredate;
    @Column(name = "DEPARTURETIME")
    private String departuretime;
    @Column(name = "TRAVELTIME")
    private String traveltime;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "PRICE")
    private int price;
    public Departure() {
    }

    public Departure(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeparturedate() {
        return departuredate;
    }

    public void setDeparturedate(String departuredate) {
        this.departuredate = departuredate;
    }

    public String getDeparturelocation() {
        return departurelocation;
    }

    public void setDeparturelocation(String departurelocation) {
        this.departurelocation = departurelocation;
    }

    public String getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(String departuretime) {
        this.departuretime = departuretime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTraveltime() {
        return traveltime;
    }

    public void setTraveltime(String traveltime) {
        this.traveltime = traveltime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    public int getPrice(){
        return price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departure)) {
            return false;
        }
        Departure other = (Departure) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.booking.core.Departure[ id=" + id + " ]";
    }
    
}