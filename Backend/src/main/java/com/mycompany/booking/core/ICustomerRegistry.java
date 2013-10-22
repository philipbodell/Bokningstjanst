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
    
    public Object getById(Long id);
   
    public List<Customer> getByMail(String email);
    
    public String getUserPassword(String email);   
    
    String getLnameByEmail(String email);
    
    String getFnameByEmail(String email);

    boolean authenticate(String name, String password);

    Long getIdByEmail(String email);

    //public Customer getByEmail(String email);
}
    

