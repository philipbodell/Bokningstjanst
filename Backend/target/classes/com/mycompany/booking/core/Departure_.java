package com.mycompany.booking.core;

import java.sql.Time;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-20T13:16:20")
@StaticMetamodel(Departure.class)
public class Departure_ extends AbstractEntity_ {

    public static volatile SingularAttribute<Departure, Time> travelTime;
    public static volatile SingularAttribute<Departure, Date> departureDate;
    public static volatile SingularAttribute<Departure, Time> departureTime;
    public static volatile SingularAttribute<Departure, String> departureLocation;
    public static volatile SingularAttribute<Departure, String> type;
    public static volatile SingularAttribute<Departure, String> destination;

}