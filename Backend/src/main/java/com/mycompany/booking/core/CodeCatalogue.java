package com.mycompany.booking.core;

import com.mycompany.booking.utils.AbstractDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * All products
 *
 * @author hajo 
 * Modified for our project
 */
public final class CodeCatalogue extends AbstractDAO<Code, Long>
        implements ICodeCatalogue {

    private CodeCatalogue(EntityManagerFactory emf) {
        super(Code.class, emf);
    }

    // Factory method
    public static ICodeCatalogue newInstance(EntityManagerFactory emf) {
        return new CodeCatalogue(emf);
    }

    @Override
    public Object getByCode(String code) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT d from Code d WHERE d.code = :code", Code.class).setParameter("code", code);
        List<Code> p = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return p.get(0);
    }
    

    
    
   

}
