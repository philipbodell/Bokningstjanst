package com.mycompany.booking.core;

import com.mycompany.booking.core.Departure;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-20T13:16:20")
@StaticMetamodel(Ticket.class)
public class Ticket_ extends AbstractEntity_ {

    public static volatile SingularAttribute<Ticket, Long> id;
    public static volatile SingularAttribute<Ticket, Departure> departure;
    public static volatile SingularAttribute<Ticket, Double> ticketPrice;

}