package com.mycompany.booking.core;

import com.mycompany.booking.utils.AbstractDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * All customers
 *
 * @author hajo Details changed to fit our project
 *
 */
public final class CustomerRegistry
        extends AbstractDAO<Customer, Long> implements ICustomerRegistry {

    public CustomerRegistry(EntityManagerFactory emf) {
        super(Customer.class, emf);
    }

    // Factory method
    public static ICustomerRegistry newInstance(EntityManagerFactory emf) {
        return new CustomerRegistry(emf);
    }

    @Override
    public List<Customer> getByName(String name) {
       EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT d from Customer d WHERE d.fname = :name", Departure.class).setParameter("name", name);
        List<Customer> p = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return p;
    }

    @Override
    public boolean authenticate(String name, String password) {
        for (Customer c : getRange(0, getCount())) {
            if (c.getEmail().equalsIgnoreCase(name)) {
                return c.getPassword().equals(Encrypter.enCrypt(password));
            }
        }
        return false;
    }
}
