/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.exceptions.NonexistentEntityException;
import control.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Escola;
import model.Estudante;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.Vagas;
import model.VagasPK;

/**
 *
 * @author Rofino Chunga Jr
 */
public class VagasJpaController implements Serializable {

    public VagasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vagas vagas) throws PreexistingEntityException, Exception {
        if (vagas.getVagasPK() == null) {
            vagas.setVagasPK(new VagasPK());
        }
        if (vagas.getEstudanteList() == null) {
            vagas.setEstudanteList(new ArrayList<Estudante>());
        }
        vagas.getVagasPK().setIdEscola(vagas.getEscola().getIdEscola());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Escola escola = vagas.getEscola();
            if (escola != null) {
                escola = em.getReference(escola.getClass(), escola.getIdEscola());
                vagas.setEscola(escola);
            }
            List<Estudante> attachedEstudanteList = new ArrayList<Estudante>();
            for (Estudante estudanteListEstudanteToAttach : vagas.getEstudanteList()) {
                estudanteListEstudanteToAttach = em.getReference(estudanteListEstudanteToAttach.getClass(), estudanteListEstudanteToAttach.getIdEstudante());
                attachedEstudanteList.add(estudanteListEstudanteToAttach);
            }
            vagas.setEstudanteList(attachedEstudanteList);
            em.persist(vagas);
            if (escola != null) {
                escola.getVagasList().add(vagas);
                escola = em.merge(escola);
            }
            for (Estudante estudanteListEstudante : vagas.getEstudanteList()) {
                Vagas oldVagasOfEstudanteListEstudante = estudanteListEstudante.getVagas();
                estudanteListEstudante.setVagas(vagas);
                estudanteListEstudante = em.merge(estudanteListEstudante);
                if (oldVagasOfEstudanteListEstudante != null) {
                    oldVagasOfEstudanteListEstudante.getEstudanteList().remove(estudanteListEstudante);
                    oldVagasOfEstudanteListEstudante = em.merge(oldVagasOfEstudanteListEstudante);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVagas(vagas.getVagasPK()) != null) {
                throw new PreexistingEntityException("Vagas " + vagas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vagas vagas) throws NonexistentEntityException, Exception {
        vagas.getVagasPK().setIdEscola(vagas.getEscola().getIdEscola());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vagas persistentVagas = em.find(Vagas.class, vagas.getVagasPK());
            Escola escolaOld = persistentVagas.getEscola();
            Escola escolaNew = vagas.getEscola();
            List<Estudante> estudanteListOld = persistentVagas.getEstudanteList();
            List<Estudante> estudanteListNew = vagas.getEstudanteList();
            if (escolaNew != null) {
                escolaNew = em.getReference(escolaNew.getClass(), escolaNew.getIdEscola());
                vagas.setEscola(escolaNew);
            }
            List<Estudante> attachedEstudanteListNew = new ArrayList<Estudante>();
            for (Estudante estudanteListNewEstudanteToAttach : estudanteListNew) {
                estudanteListNewEstudanteToAttach = em.getReference(estudanteListNewEstudanteToAttach.getClass(), estudanteListNewEstudanteToAttach.getIdEstudante());
                attachedEstudanteListNew.add(estudanteListNewEstudanteToAttach);
            }
            estudanteListNew = attachedEstudanteListNew;
            vagas.setEstudanteList(estudanteListNew);
            vagas = em.merge(vagas);
            if (escolaOld != null && !escolaOld.equals(escolaNew)) {
                escolaOld.getVagasList().remove(vagas);
                escolaOld = em.merge(escolaOld);
            }
            if (escolaNew != null && !escolaNew.equals(escolaOld)) {
                escolaNew.getVagasList().add(vagas);
                escolaNew = em.merge(escolaNew);
            }
            for (Estudante estudanteListOldEstudante : estudanteListOld) {
                if (!estudanteListNew.contains(estudanteListOldEstudante)) {
                    estudanteListOldEstudante.setVagas(null);
                    estudanteListOldEstudante = em.merge(estudanteListOldEstudante);
                }
            }
            for (Estudante estudanteListNewEstudante : estudanteListNew) {
                if (!estudanteListOld.contains(estudanteListNewEstudante)) {
                    Vagas oldVagasOfEstudanteListNewEstudante = estudanteListNewEstudante.getVagas();
                    estudanteListNewEstudante.setVagas(vagas);
                    estudanteListNewEstudante = em.merge(estudanteListNewEstudante);
                    if (oldVagasOfEstudanteListNewEstudante != null && !oldVagasOfEstudanteListNewEstudante.equals(vagas)) {
                        oldVagasOfEstudanteListNewEstudante.getEstudanteList().remove(estudanteListNewEstudante);
                        oldVagasOfEstudanteListNewEstudante = em.merge(oldVagasOfEstudanteListNewEstudante);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                VagasPK id = vagas.getVagasPK();
                if (findVagas(id) == null) {
                    throw new NonexistentEntityException("The vagas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(VagasPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vagas vagas;
            try {
                vagas = em.getReference(Vagas.class, id);
                vagas.getVagasPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vagas with id " + id + " no longer exists.", enfe);
            }
            Escola escola = vagas.getEscola();
            if (escola != null) {
                escola.getVagasList().remove(vagas);
                escola = em.merge(escola);
            }
            List<Estudante> estudanteList = vagas.getEstudanteList();
            for (Estudante estudanteListEstudante : estudanteList) {
                estudanteListEstudante.setVagas(null);
                estudanteListEstudante = em.merge(estudanteListEstudante);
            }
            em.remove(vagas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vagas> findVagasEntities() {
        return findVagasEntities(true, -1, -1);
    }

    public List<Vagas> findVagasEntities(int maxResults, int firstResult) {
        return findVagasEntities(false, maxResults, firstResult);
    }

    private List<Vagas> findVagasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vagas.class));
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

    public Vagas findVagas(VagasPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vagas.class, id);
        } finally {
            em.close();
        }
    }

    public int getVagasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vagas> rt = cq.from(Vagas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
