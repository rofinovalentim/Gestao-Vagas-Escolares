/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.exceptions.NonexistentEntityException;
import control.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Estudanteaceite;

/**
 *
 * @author Rofino Chunga Jr
 */
public class EstudanteaceiteJpaController implements Serializable {

    public EstudanteaceiteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estudanteaceite estudanteaceite) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(estudanteaceite);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEstudanteaceite(estudanteaceite.getIdEstudante()) != null) {
                throw new PreexistingEntityException("Estudanteaceite " + estudanteaceite + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estudanteaceite estudanteaceite) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            estudanteaceite = em.merge(estudanteaceite);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = estudanteaceite.getIdEstudante();
                if (findEstudanteaceite(id) == null) {
                    throw new NonexistentEntityException("The estudanteaceite with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudanteaceite estudanteaceite;
            try {
                estudanteaceite = em.getReference(Estudanteaceite.class, id);
                estudanteaceite.getIdEstudante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estudanteaceite with id " + id + " no longer exists.", enfe);
            }
            em.remove(estudanteaceite);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estudanteaceite> findEstudanteaceiteEntities() {
        return findEstudanteaceiteEntities(true, -1, -1);
    }

    public List<Estudanteaceite> findEstudanteaceiteEntities(int maxResults, int firstResult) {
        return findEstudanteaceiteEntities(false, maxResults, firstResult);
    }

    private List<Estudanteaceite> findEstudanteaceiteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estudanteaceite.class));
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

    public Estudanteaceite findEstudanteaceite(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estudanteaceite.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstudanteaceiteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estudanteaceite> rt = cq.from(Estudanteaceite.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Estudanteaceite> buscarEstudante(String nome) {
        EntityManager em = getEntityManager();
        String name = "%" + nome + "%";
        try {
            Query query = em.createQuery(
                    "from Estudanteaceite estudante where estudante.nomeEstudante like :name");
            query.setParameter("name", name);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
