package com.mycompany.booking.core;

import com.mycompany.booking.utils.AbstractDAO;
import java.util.List;
import java.util.logging.Logger;
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
        if(p.isEmpty()){
            return null;
        }
        
        //Logger logger = Logger.getLogger(getClass().getName());
        //ogger.severe(p.get(0).toString());
        
        return p.get(0);
    }
    
    @Override
    public long getIdByCode(String code) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT d.id from Code d WHERE d.code = :code", Code.class).setParameter("code", code);
                    Logger logger = Logger.getLogger(getClass().getName());
        List<Long> p = q.getResultList();
        em.getTransaction().commit();
        em.close();
        if(p.isEmpty()){
            logger.severe("no code found for "+code);
            return 0;
        }
        logger.severe(p.get(0).toString());
        return p.get(0);
    }
    
   

}
