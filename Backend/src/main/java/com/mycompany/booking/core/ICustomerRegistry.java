package com.mycompany.booking.core;

;
import com.mycompany.booking.utils.IDAO;
import java.util.List;

/**
 * Interface to customer registry
 * @author hajo
 */
public interface ICustomerRegistry extends IDAO<Customer, Long> {

    List<Customer> getByName(String name);
    
    boolean authenticate(String name, String password);
    
}

