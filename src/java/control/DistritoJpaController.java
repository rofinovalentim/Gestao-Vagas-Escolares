/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Escola;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.Distrito;

/**
 *
 * @author Rofino Chunga Jr
 */
public class DistritoJpaController implements Serializable {

    public DistritoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Distrito distrito) {
        if (distrito.getEscolaList() == null) {
            distrito.setEscolaList(new ArrayList<Escola>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Escola> attachedEscolaList = new ArrayList<Escola>();
            for (Escola escolaListEscolaToAttach : distrito.getEscolaList()) {
                escolaListEscolaToAttach = em.getReference(escolaListEscolaToAttach.getClass(), escolaListEscolaToAttach.getIdEscola());
                attachedEscolaList.add(escolaListEscolaToAttach);
            }
            distrito.setEscolaList(attachedEscolaList);
            em.persist(distrito);
            for (Escola escolaListEscola : distrito.getEscolaList()) {
                Distrito oldIddistritoOfEscolaListEscola = escolaListEscola.getIddistrito();
                escolaListEscola.setIddistrito(distrito);
                escolaListEscola = em.merge(escolaListEscola);
                if (oldIddistritoOfEscolaListEscola != null) {
                    oldIddistritoOfEscolaListEscola.getEscolaList().remove(escolaListEscola);
                    oldIddistritoOfEscolaListEscola = em.merge(oldIddistritoOfEscolaListEscola);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Distrito distrito) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Distrito persistentDistrito = em.find(Distrito.class, distrito.getIdDistrito());
            List<Escola> escolaListOld = persistentDistrito.getEscolaList();
            List<Escola> escolaListNew = distrito.getEscolaList();
            List<Escola> attachedEscolaListNew = new ArrayList<Escola>();
            for (Escola escolaListNewEscolaToAttach : escolaListNew) {
                escolaListNewEscolaToAttach = em.getReference(escolaListNewEscolaToAttach.getClass(), escolaListNewEscolaToAttach.getIdEscola());
                attachedEscolaListNew.add(escolaListNewEscolaToAttach);
            }
            escolaListNew = attachedEscolaListNew;
            distrito.setEscolaList(escolaListNew);
            distrito = em.merge(distrito);
            for (Escola escolaListOldEscola : escolaListOld) {
                if (!escolaListNew.contains(escolaListOldEscola)) {
                    escolaListOldEscola.setIddistrito(null);
                    escolaListOldEscola = em.merge(escolaListOldEscola);
                }
            }
            for (Escola escolaListNewEscola : escolaListNew) {
                if (!escolaListOld.contains(escolaListNewEscola)) {
                    Distrito oldIddistritoOfEscolaListNewEscola = escolaListNewEscola.getIddistrito();
                    escolaListNewEscola.setIddistrito(distrito);
                    escolaListNewEscola = em.merge(escolaListNewEscola);
                    if (oldIddistritoOfEscolaListNewEscola != null && !oldIddistritoOfEscolaListNewEscola.equals(distrito)) {
                        oldIddistritoOfEscolaListNewEscola.getEscolaList().remove(escolaListNewEscola);
                        oldIddistritoOfEscolaListNewEscola = em.merge(oldIddistritoOfEscolaListNewEscola);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = distrito.getIdDistrito();
                if (findDistrito(id) == null) {
                    throw new NonexistentEntityException("The distrito with id " + id + " no longer exists.");
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
            Distrito distrito;
            try {
                distrito = em.getReference(Distrito.class, id);
                distrito.getIdDistrito();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The distrito with id " + id + " no longer exists.", enfe);
            }
            List<Escola> escolaList = distrito.getEscolaList();
            for (Escola escolaListEscola : escolaList) {
                escolaListEscola.setIddistrito(null);
                escolaListEscola = em.merge(escolaListEscola);
            }
            em.remove(distrito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Distrito> findDistritoEntities() {
        return findDistritoEntities(true, -1, -1);
    }

    public List<Distrito> findDistritoEntities(int maxResults, int firstResult) {
        return findDistritoEntities(false, maxResults, firstResult);
    }

    private List<Distrito> findDistritoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            //CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            //cq.select(cq.from(Distrito.class));
            Query q = em.createQuery("select distrito from Distrito distrito order by distrito.nomeDestrito asc");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Distrito findDistrito(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Distrito.class, id);
        } finally {
            em.close();
        }
    }

    public int getDistritoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Distrito> rt = cq.from(Distrito.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
     public List<Distrito> buscarDistrito(String nome) {
        EntityManager em = getEntityManager();
        String name = "%" + nome + "%";
        try {
            Query query = em.createQuery(
                    "from Distrito distrito where distrito.nomeDestrito like :name");
            query.setParameter("name", name);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
}
