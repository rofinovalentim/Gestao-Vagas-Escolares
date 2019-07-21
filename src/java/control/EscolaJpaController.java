/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.exceptions.IllegalOrphanException;
import control.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Distrito;
import model.Vagas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.Escola;

/**
 *
 * @author Rofino Chunga Jr
 */
public class EscolaJpaController implements Serializable {

    public EscolaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Escola escola) {
        if (escola.getVagasList() == null) {
            escola.setVagasList(new ArrayList<Vagas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Distrito iddistrito = escola.getIddistrito();
            if (iddistrito != null) {
                iddistrito = em.getReference(iddistrito.getClass(), iddistrito.getIdDistrito());
                escola.setIddistrito(iddistrito);
            }
            List<Vagas> attachedVagasList = new ArrayList<Vagas>();
            for (Vagas vagasListVagasToAttach : escola.getVagasList()) {
                vagasListVagasToAttach = em.getReference(vagasListVagasToAttach.getClass(), vagasListVagasToAttach.getVagasPK());
                attachedVagasList.add(vagasListVagasToAttach);
            }
            escola.setVagasList(attachedVagasList);
            em.persist(escola);
            if (iddistrito != null) {
                iddistrito.getEscolaList().add(escola);
                iddistrito = em.merge(iddistrito);
            }
            for (Vagas vagasListVagas : escola.getVagasList()) {
                Escola oldEscolaOfVagasListVagas = vagasListVagas.getEscola();
                vagasListVagas.setEscola(escola);
                vagasListVagas = em.merge(vagasListVagas);
                if (oldEscolaOfVagasListVagas != null) {
                    oldEscolaOfVagasListVagas.getVagasList().remove(vagasListVagas);
                    oldEscolaOfVagasListVagas = em.merge(oldEscolaOfVagasListVagas);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Escola escola) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Escola persistentEscola = em.find(Escola.class, escola.getIdEscola());
            Distrito iddistritoOld = persistentEscola.getIddistrito();
            Distrito iddistritoNew = escola.getIddistrito();
            List<Vagas> vagasListOld = persistentEscola.getVagasList();
            List<Vagas> vagasListNew = escola.getVagasList();
            List<String> illegalOrphanMessages = null;
            for (Vagas vagasListOldVagas : vagasListOld) {
                if (!vagasListNew.contains(vagasListOldVagas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Vagas " + vagasListOldVagas + " since its escola field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (iddistritoNew != null) {
                iddistritoNew = em.getReference(iddistritoNew.getClass(), iddistritoNew.getIdDistrito());
                escola.setIddistrito(iddistritoNew);
            }
            List<Vagas> attachedVagasListNew = new ArrayList<Vagas>();
            for (Vagas vagasListNewVagasToAttach : vagasListNew) {
                vagasListNewVagasToAttach = em.getReference(vagasListNewVagasToAttach.getClass(), vagasListNewVagasToAttach.getVagasPK());
                attachedVagasListNew.add(vagasListNewVagasToAttach);
            }
            vagasListNew = attachedVagasListNew;
            escola.setVagasList(vagasListNew);
            escola = em.merge(escola);
            if (iddistritoOld != null && !iddistritoOld.equals(iddistritoNew)) {
                iddistritoOld.getEscolaList().remove(escola);
                iddistritoOld = em.merge(iddistritoOld);
            }
            if (iddistritoNew != null && !iddistritoNew.equals(iddistritoOld)) {
                iddistritoNew.getEscolaList().add(escola);
                iddistritoNew = em.merge(iddistritoNew);
            }
            for (Vagas vagasListNewVagas : vagasListNew) {
                if (!vagasListOld.contains(vagasListNewVagas)) {
                    Escola oldEscolaOfVagasListNewVagas = vagasListNewVagas.getEscola();
                    vagasListNewVagas.setEscola(escola);
                    vagasListNewVagas = em.merge(vagasListNewVagas);
                    if (oldEscolaOfVagasListNewVagas != null && !oldEscolaOfVagasListNewVagas.equals(escola)) {
                        oldEscolaOfVagasListNewVagas.getVagasList().remove(vagasListNewVagas);
                        oldEscolaOfVagasListNewVagas = em.merge(oldEscolaOfVagasListNewVagas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = escola.getIdEscola();
                if (findEscola(id) == null) {
                    throw new NonexistentEntityException("The escola with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Escola escola;
            try {
                escola = em.getReference(Escola.class, id);
                escola.getIdEscola();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The escola with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Vagas> vagasListOrphanCheck = escola.getVagasList();
            for (Vagas vagasListOrphanCheckVagas : vagasListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Escola (" + escola + ") cannot be destroyed since the Vagas " + vagasListOrphanCheckVagas + " in its vagasList field has a non-nullable escola field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Distrito iddistrito = escola.getIddistrito();
            if (iddistrito != null) {
                iddistrito.getEscolaList().remove(escola);
                iddistrito = em.merge(iddistrito);
            }
            em.remove(escola);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Escola> findEscolaEntities() {
        return findEscolaEntities(true, -1, -1);
    }

    public List<Escola> findEscolaEntities(int maxResults, int firstResult) {
        return findEscolaEntities(false, maxResults, firstResult);
    }

    private List<Escola> findEscolaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Escola.class));
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

    public Escola findEscola(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Escola.class, id);
        } finally {
            em.close();
        }
    }

    public int getEscolaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Escola> rt = cq.from(Escola.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Escola> buscarEscola(String nome) {
        EntityManager em = getEntityManager();
        String name = "%" + nome + "%";
        try {
            Query query = em.createQuery(
                    "from Escola escola where escola.nomeEscola like :name");
            query.setParameter("name", name);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
