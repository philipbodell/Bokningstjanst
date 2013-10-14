/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.ticketsystem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Patrik
 */
public class TicketCore<T> {
    
    private final static String pUnitName = "ticket_system";
    private EntityManagerFactory emf;

    public TicketCore() {
        emf = Persistence.createEntityManagerFactory(pUnitName);
    }

    public void add(T t) {

        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
} 
