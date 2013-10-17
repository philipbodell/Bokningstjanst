package com.mycompany.booking.core;

import com.mycompany.booking.utils.AbstractDAO;
import java.util.ArrayList;
import java.util.List;

/**
 * All customers
 *
 * @author hajo Details changed to fit our project
 *
 */
public final class CustomerRegistry
        extends AbstractDAO<Customer, Long> implements ICustomerRegistry {

    public CustomerRegistry(String puName) {
        super(Customer.class, puName);
    }

    // Factory method
    public static ICustomerRegistry newInstance(String puName) {
        return new CustomerRegistry(puName);
    }

    @Override
    public List<Customer> getByName(String name) {
        List<Customer> found = new ArrayList<Customer>();
        for (Customer c : getRange(0, getCount())) {
            if (c.getFname().equals(name) || c.getLname().equals(name)) {
                found.add(c);
            }
        }
        return found;
    }

    @Override
    public boolean authenticate(String name, String password) {
        for (Customer c : getRange(0, getCount())) {
            if (c.getUserName().equalsIgnoreCase(name)) {
                return c.getPass().equals(Encrypter.enCrypt(password));
            }
        }
        return false;
    }
}
