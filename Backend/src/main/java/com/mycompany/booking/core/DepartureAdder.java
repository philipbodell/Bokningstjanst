/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.booking.core;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author ed
 */
public class DepartureAdder {

    static IBooking booking;
    final static String PU = "booking_pu";
    
    public void persistDepartures(String departures) {
        String[] s = departures.split(",");
        booking = JPABookingFactory.getBooking(PU);  
        for (int i = 0; i < s.length; i = i + 10) {
            System.out.println(s[9]);
            Time tmpTime = new Time(Integer.valueOf(s[3+i]),Integer.valueOf(s[4+i]),0);
            Date tmpDate = new Date(Integer.valueOf(s[5+i])-1900,Integer.valueOf(s[6+i]),Integer.valueOf(s[7+i]));
            System.out.println(tmpTime.toString() + " " +tmpDate.toString());
            Departure d = new Departure(s[0+i],s[1+i],s[2+i],tmpTime,tmpDate,new Time(Integer.valueOf(s[8+i]),Integer.valueOf(s[9+i]),0));
            System.out.println(d);
            booking.getDepartureCatalogue().add(d);
        }

    }
}
