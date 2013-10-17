
package com.mycompany.booking.core;

import com.mycompany.booking.utils.IDAO;
import java.util.List;

/**
 * Interface to product catalogue
 * @author hajo
 * Modified for our project
 */
public interface IDepartureCatalogue extends IDAO<Departure, Long> {

    public List<Departure> getByName(String name);
    
    public Departure getById(Long id);
    
    public List<Departure> getByType(String type);
    
    public List<Departure> getByDestination(String dest);
     
}