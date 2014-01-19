/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.booking.core;

import com.mycompany.booking.utils.AbstractDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Johan
 */
public final class ContactMessagesRegistry  extends AbstractDAO<ContactMessages, Long> implements IContactMessagesRegistry {

    public ContactMessagesRegistry(EntityManagerFactory emf) {
        super(ContactMessages.class, emf);
    }

    // Factory method
    public static ContactMessagesRegistry newInstance(EntityManagerFactory emf) {
        return new ContactMessagesRegistry(emf);
    }

    @Override
    public List<ContactMessages> getEmail(String mail) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT d from ContactMessages d WHERE d.email = :mail", Departure.class).setParameter("mail", mail);
        List<ContactMessages> p = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return p;
    }
    
    @Override
    public Object getById(Long id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT c from ContactMessages c WHERE c.id = :id", Departure.class).setParameter("id", id);
        List<ContactMessages> p = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return p.get(0);
    }
    
    @Override
    public Object getAll() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT c from ContactMessages c ", Departure.class);
        List<ContactMessages> p = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return p.get(0);
    }
    
}
