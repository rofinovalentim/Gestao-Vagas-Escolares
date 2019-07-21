/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Estudante;
import model.Genero;
import model.Vagas;

/**
 *
 * @author Rofino Chunga Jr
 */
public class EstudanteJpaController implements Serializable {

    public EstudanteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estudante estudante) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Genero idGenero = estudante.getIdGenero();
            if (idGenero != null) {
                idGenero = em.getReference(idGenero.getClass(), idGenero.getIdGenero());
                estudante.setIdGenero(idGenero);
            }
            Vagas vagas = estudante.getVagas();
            if (vagas != null) {
                vagas = em.getReference(vagas.getClass(), vagas.getVagasPK());
                estudante.setVagas(vagas);
            }
            em.persist(estudante);
            if (idGenero != null) {
                idGenero.getEstudanteList().add(estudante);
                idGenero = em.merge(idGenero);
            }
            if (vagas != null) {
                vagas.getEstudanteList().add(estudante);
                vagas = em.merge(vagas);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estudante estudante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudante persistentEstudante = em.find(Estudante.class, estudante.getIdEstudante());
            Genero idGeneroOld = persistentEstudante.getIdGenero();
            Genero idGeneroNew = estudante.getIdGenero();
            Vagas vagasOld = persistentEstudante.getVagas();
            Vagas vagasNew = estudante.getVagas();
            if (idGeneroNew != null) {
                idGeneroNew = em.getReference(idGeneroNew.getClass(), idGeneroNew.getIdGenero());
                estudante.setIdGenero(idGeneroNew);
            }
            if (vagasNew != null) {
                vagasNew = em.getReference(vagasNew.getClass(), vagasNew.getVagasPK());
                estudante.setVagas(vagasNew);
            }
            estudante = em.merge(estudante);
            if (idGeneroOld != null && !idGeneroOld.equals(idGeneroNew)) {
                idGeneroOld.getEstudanteList().remove(estudante);
                idGeneroOld = em.merge(idGeneroOld);
            }
            if (idGeneroNew != null && !idGeneroNew.equals(idGeneroOld)) {
                idGeneroNew.getEstudanteList().add(estudante);
                idGeneroNew = em.merge(idGeneroNew);
            }
            if (vagasOld != null && !vagasOld.equals(vagasNew)) {
                vagasOld.getEstudanteList().remove(estudante);
                vagasOld = em.merge(vagasOld);
            }
            if (vagasNew != null && !vagasNew.equals(vagasOld)) {
                vagasNew.getEstudanteList().add(estudante);
                vagasNew = em.merge(vagasNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = estudante.getIdEstudante();
                if (findEstudante(id) == null) {
                    throw new NonexistentEntityException("The estudante with id " + id + " no longer exists.");
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
            Estudante estudante;
            try {
                estudante = em.getReference(Estudante.class, id);
                estudante.getIdEstudante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estudante with id " + id + " no longer exists.", enfe);
            }
            Genero idGenero = estudante.getIdGenero();
            if (idGenero != null) {
                idGenero.getEstudanteList().remove(estudante);
                idGenero = em.merge(idGenero);
            }
            Vagas vagas = estudante.getVagas();
            if (vagas != null) {
                vagas.getEstudanteList().remove(estudante);
                vagas = em.merge(vagas);
            }
            em.remove(estudante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estudante> findEstudanteEntities() {
        return findEstudanteEntities(true, -1, -1);
    }

    public List<Estudante> findEstudanteEntities(int maxResults, int firstResult) {
        return findEstudanteEntities(false, maxResults, firstResult);
    }

    private List<Estudante> findEstudanteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estudante.class));
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

    public Estudante findEstudante(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estudante.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstudanteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estudante> rt = cq.from(Estudante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Estudante> buscarEstudante(String nome) {
        EntityManager em = getEntityManager();
        String name = "%" + nome + "%";
        try {
            Query query = em.createQuery(
                    "from Estudante estudante where estudante.nomeEstudante like :name");
            query.setParameter("name", name);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}
