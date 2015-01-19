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
public class CircuitEntityJpaController implements Serializable {

    public CircuitEntityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CircuitEntity circuitEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(circuitEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CircuitEntity circuitEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            circuitEntity = em.merge(circuitEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = circuitEntity.getId();
                if (findCircuitEntity(id) == null) {
                    throw new NonexistentEntityException("The circuitEntity with id " + id + " no longer exists.");
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
            CircuitEntity circuitEntity;
            try {
                circuitEntity = em.getReference(CircuitEntity.class, id);
                circuitEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The circuitEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(circuitEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CircuitEntity> findCircuitEntityEntities() {
        return findCircuitEntityEntities(true, -1, -1);
    }

    public List<CircuitEntity> findCircuitEntityEntities(int maxResults, int firstResult) {
        return findCircuitEntityEntities(false, maxResults, firstResult);
    }

    private List<CircuitEntity> findCircuitEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CircuitEntity.class));
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

    public CircuitEntity findCircuitEntity(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CircuitEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getCircuitEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CircuitEntity> rt = cq.from(CircuitEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
