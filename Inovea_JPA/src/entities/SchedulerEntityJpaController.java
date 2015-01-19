/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Oussama
 */
public class SchedulerEntityJpaController implements Serializable {

    public SchedulerEntityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SchedulerEntity schedulerEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(schedulerEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SchedulerEntity schedulerEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            schedulerEntity = em.merge(schedulerEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = schedulerEntity.getId();
                if (findSchedulerEntity(id) == null) {
                    throw new NonexistentEntityException("The schedulerEntity with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SchedulerEntity schedulerEntity;
            try {
                schedulerEntity = em.getReference(SchedulerEntity.class, id);
                schedulerEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The schedulerEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(schedulerEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SchedulerEntity> findSchedulerEntityEntities() {
        return findSchedulerEntityEntities(true, -1, -1);
    }

    public List<SchedulerEntity> findSchedulerEntityEntities(int maxResults, int firstResult) {
        return findSchedulerEntityEntities(false, maxResults, firstResult);
    }

    private List<SchedulerEntity> findSchedulerEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SchedulerEntity.class));
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

    public SchedulerEntity findSchedulerEntity(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SchedulerEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getSchedulerEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SchedulerEntity> rt = cq.from(SchedulerEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
