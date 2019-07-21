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
import model.TipoUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.Role;

/**
 *
 * @author Rofino Chunga Jr
 */
public class RoleJpaController implements Serializable {

    public RoleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Role role) throws PreexistingEntityException, Exception {
        if (role.getTipoUsuarioList() == null) {
            role.setTipoUsuarioList(new ArrayList<TipoUsuario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<TipoUsuario> attachedTipoUsuarioList = new ArrayList<TipoUsuario>();
            for (TipoUsuario tipoUsuarioListTipoUsuarioToAttach : role.getTipoUsuarioList()) {
                tipoUsuarioListTipoUsuarioToAttach = em.getReference(tipoUsuarioListTipoUsuarioToAttach.getClass(), tipoUsuarioListTipoUsuarioToAttach.getIdTipo());
                attachedTipoUsuarioList.add(tipoUsuarioListTipoUsuarioToAttach);
            }
            role.setTipoUsuarioList(attachedTipoUsuarioList);
            em.persist(role);
            for (TipoUsuario tipoUsuarioListTipoUsuario : role.getTipoUsuarioList()) {
                tipoUsuarioListTipoUsuario.getRoleList().add(role);
                tipoUsuarioListTipoUsuario = em.merge(tipoUsuarioListTipoUsuario);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRole(role.getRole()) != null) {
                throw new PreexistingEntityException("Role " + role + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Role role) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Role persistentRole = em.find(Role.class, role.getRole());
            List<TipoUsuario> tipoUsuarioListOld = persistentRole.getTipoUsuarioList();
            List<TipoUsuario> tipoUsuarioListNew = role.getTipoUsuarioList();
            List<TipoUsuario> attachedTipoUsuarioListNew = new ArrayList<TipoUsuario>();
            for (TipoUsuario tipoUsuarioListNewTipoUsuarioToAttach : tipoUsuarioListNew) {
                tipoUsuarioListNewTipoUsuarioToAttach = em.getReference(tipoUsuarioListNewTipoUsuarioToAttach.getClass(), tipoUsuarioListNewTipoUsuarioToAttach.getIdTipo());
                attachedTipoUsuarioListNew.add(tipoUsuarioListNewTipoUsuarioToAttach);
            }
            tipoUsuarioListNew = attachedTipoUsuarioListNew;
            role.setTipoUsuarioList(tipoUsuarioListNew);
            role = em.merge(role);
            for (TipoUsuario tipoUsuarioListOldTipoUsuario : tipoUsuarioListOld) {
                if (!tipoUsuarioListNew.contains(tipoUsuarioListOldTipoUsuario)) {
                    tipoUsuarioListOldTipoUsuario.getRoleList().remove(role);
                    tipoUsuarioListOldTipoUsuario = em.merge(tipoUsuarioListOldTipoUsuario);
                }
            }
            for (TipoUsuario tipoUsuarioListNewTipoUsuario : tipoUsuarioListNew) {
                if (!tipoUsuarioListOld.contains(tipoUsuarioListNewTipoUsuario)) {
                    tipoUsuarioListNewTipoUsuario.getRoleList().add(role);
                    tipoUsuarioListNewTipoUsuario = em.merge(tipoUsuarioListNewTipoUsuario);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = role.getRole();
                if (findRole(id) == null) {
                    throw new NonexistentEntityException("The role with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Role role;
            try {
                role = em.getReference(Role.class, id);
                role.getRole();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The role with id " + id + " no longer exists.", enfe);
            }
            List<TipoUsuario> tipoUsuarioList = role.getTipoUsuarioList();
            for (TipoUsuario tipoUsuarioListTipoUsuario : tipoUsuarioList) {
                tipoUsuarioListTipoUsuario.getRoleList().remove(role);
                tipoUsuarioListTipoUsuario = em.merge(tipoUsuarioListTipoUsuario);
            }
            em.remove(role);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Role> findRoleEntities() {
        return findRoleEntities(true, -1, -1);
    }

    public List<Role> findRoleEntities(int maxResults, int firstResult) {
        return findRoleEntities(false, maxResults, firstResult);
    }

    private List<Role> findRoleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Role.class));
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

    public Role findRole(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Role.class, id);
        } finally {
            em.close();
        }
    }

    public int getRoleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Role> rt = cq.from(Role.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
