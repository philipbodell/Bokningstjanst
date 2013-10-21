
package com.mycompany.booking.core;

import com.mycompany.booking.utils.IDAO;
import java.util.Date;
import java.util.List;

/**
 * Interface to product catalogue
 * @author hajo
 * Modified for our project
 */
public interface IDepartureCatalogue extends IDAO<Departure, Long> {

    public Object getById(Long id);
    
    public List<Departure> getByType(String type);
    
    public List<String> getDestinations();
    
    public List<String> getDepartures();
    
    public List<Departure> getByDestination(String dest);
    
    public List<Departure> getAll();     
    
    public List<Departure> getMatchingDeparture(String departure, String destination);
}
