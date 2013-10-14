package com.mycompany.booking.utils;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * A container for entities, base class for OrderBook, ProductCatalogue,
 * CustomerRegistry The fundamental common operations are here (CRUD).
 *
 * T is type for items in container K is type of id (primary key)
 *
 * @author hajo
 */
public abstract class AbstractDAO<T, K>
        implements IDAO<T, K> {

    private EntityManagerFactory emf;
    private final Class<T> clazz;

    protected AbstractDAO(Class<T> clazz, String puName) {
        this.clazz = clazz;
        emf = Persistence.createEntityManagerFactory(puName);
    }

    protected EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    @Override
    public void add(T t) {
        EntityManager em = null;
        try {
            // Create ...
            em = emf.createEntityManager();
            // Must handle transaction, this is application managed 
            // transaction (RESOURCE_LOCAL)
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
//            ExceptionHandler.handle(ex);
        } finally {
            if (em != null) {
                em.close();  // ... and destroy
            }
        }
    }

    @Override
    public void remove(K id) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            T t = em.getReference(clazz, id);
            em.remove(t);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public T find(K id) {
        EntityManager em = emf.createEntityManager();
        return em.find(clazz, id);
    }

    @Override
    public T update(T t) {
        EntityManager em = null;
        T tmp = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            tmp = em.merge(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return tmp;
    }

    @Override
    public List<T> getRange(int first, int nItems) {
        EntityManager em = emf.createEntityManager();
        List<T> found = new ArrayList<T>();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(clazz));
            Query q = em.createQuery(cq);
            q.setMaxResults(nItems);
            q.setFirstResult(first);
            found.addAll(q.getResultList());
        } catch (Exception ex) {
        } finally {
            em.close();
        }
        return found;
    }

    @Override
    public int getCount() {
        EntityManager em = emf.createEntityManager();
        int count = -1;
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<T> rt = cq.from(clazz);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            count = ((Long) q.getSingleResult()).intValue();
        } catch (Exception ex) {
        } finally {
            em.close();
        }
        return count;
    }

    public boolean contains(K price) {
        EntityManager em = emf.createEntityManager();
        return em.contains(price);
    }
}
