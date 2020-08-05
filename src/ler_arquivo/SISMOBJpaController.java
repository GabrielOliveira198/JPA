/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ler_arquivo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ler_arquivo.exceptions.NonexistentEntityException;

/**
 *
 * @author olive
 */
public class SISMOBJpaController implements Serializable {

    public SISMOBJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SISMOB SISMOB) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(SISMOB);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SISMOB SISMOB) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SISMOB = em.merge(SISMOB);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = SISMOB.getId();
                if (findSISMOB(id) == null) {
                    throw new NonexistentEntityException("The sISMOB with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SISMOB SISMOB;
            try {
                SISMOB = em.getReference(SISMOB.class, id);
                SISMOB.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The SISMOB with id " + id + " no longer exists.", enfe);
            }
            em.remove(SISMOB);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SISMOB> findSISMOBEntities() {
        return findSISMOBEntities(true, -1, -1);
    }

    public List<SISMOB> findSISMOBEntities(int maxResults, int firstResult) {
        return findSISMOBEntities(false, maxResults, firstResult);
    }

    private List<SISMOB> findSISMOBEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SISMOB.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public SISMOB findSISMOB(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SISMOB.class, id);
        } finally {
            em.close();
        }
    }

    public int getSISMOBCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SISMOB> rt = cq.from(SISMOB.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
