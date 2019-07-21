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
import model.Role;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.TipoUsuario;
import model.User;

/**
 *
 * @author Rofino Chunga Jr
 */
public class TipoUsuarioJpaController implements Serializable {

    public TipoUsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoUsuario tipoUsuario) {
        if (tipoUsuario.getRoleList() == null) {
            tipoUsuario.setRoleList(new ArrayList<Role>());
        }
        if (tipoUsuario.getUserList() == null) {
            tipoUsuario.setUserList(new ArrayList<User>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Role> attachedRoleList = new ArrayList<Role>();
            for (Role roleListRoleToAttach : tipoUsuario.getRoleList()) {
                roleListRoleToAttach = em.getReference(roleListRoleToAttach.getClass(), roleListRoleToAttach.getRole());
                attachedRoleList.add(roleListRoleToAttach);
            }
            tipoUsuario.setRoleList(attachedRoleList);
            List<User> attachedUserList = new ArrayList<User>();
            for (User userListUserToAttach : tipoUsuario.getUserList()) {
                userListUserToAttach = em.getReference(userListUserToAttach.getClass(), userListUserToAttach.getUserName());
                attachedUserList.add(userListUserToAttach);
            }
            tipoUsuario.setUserList(attachedUserList);
            em.persist(tipoUsuario);
            for (Role roleListRole : tipoUsuario.getRoleList()) {
                roleListRole.getTipoUsuarioList().add(tipoUsuario);
                roleListRole = em.merge(roleListRole);
            }
            for (User userListUser : tipoUsuario.getUserList()) {
                TipoUsuario oldIdTipoOfUserListUser = userListUser.getIdTipo();
                userListUser.setIdTipo(tipoUsuario);
                userListUser = em.merge(userListUser);
                if (oldIdTipoOfUserListUser != null) {
                    oldIdTipoOfUserListUser.getUserList().remove(userListUser);
                    oldIdTipoOfUserListUser = em.merge(oldIdTipoOfUserListUser);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoUsuario tipoUsuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoUsuario persistentTipoUsuario = em.find(TipoUsuario.class, tipoUsuario.getIdTipo());
            List<Role> roleListOld = persistentTipoUsuario.getRoleList();
            List<Role> roleListNew = tipoUsuario.getRoleList();
            List<User> userListOld = persistentTipoUsuario.getUserList();
            List<User> userListNew = tipoUsuario.getUserList();
            List<Role> attachedRoleListNew = new ArrayList<Role>();
            for (Role roleListNewRoleToAttach : roleListNew) {
                roleListNewRoleToAttach = em.getReference(roleListNewRoleToAttach.getClass(), roleListNewRoleToAttach.getRole());
                attachedRoleListNew.add(roleListNewRoleToAttach);
            }
            roleListNew = attachedRoleListNew;
            tipoUsuario.setRoleList(roleListNew);
            List<User> attachedUserListNew = new ArrayList<User>();
            for (User userListNewUserToAttach : userListNew) {
                userListNewUserToAttach = em.getReference(userListNewUserToAttach.getClass(), userListNewUserToAttach.getUserName());
                attachedUserListNew.add(userListNewUserToAttach);
            }
            userListNew = attachedUserListNew;
            tipoUsuario.setUserList(userListNew);
            tipoUsuario = em.merge(tipoUsuario);
            for (Role roleListOldRole : roleListOld) {
                if (!roleListNew.contains(roleListOldRole)) {
                    roleListOldRole.getTipoUsuarioList().remove(tipoUsuario);
                    roleListOldRole = em.merge(roleListOldRole);
                }
            }
            for (Role roleListNewRole : roleListNew) {
                if (!roleListOld.contains(roleListNewRole)) {
                    roleListNewRole.getTipoUsuarioList().add(tipoUsuario);
                    roleListNewRole = em.merge(roleListNewRole);
                }
            }
            for (User userListOldUser : userListOld) {
                if (!userListNew.contains(userListOldUser)) {
                    userListOldUser.setIdTipo(null);
                    userListOldUser = em.merge(userListOldUser);
                }
            }
            for (User userListNewUser : userListNew) {
                if (!userListOld.contains(userListNewUser)) {
                    TipoUsuario oldIdTipoOfUserListNewUser = userListNewUser.getIdTipo();
                    userListNewUser.setIdTipo(tipoUsuario);
                    userListNewUser = em.merge(userListNewUser);
                    if (oldIdTipoOfUserListNewUser != null && !oldIdTipoOfUserListNewUser.equals(tipoUsuario)) {
                        oldIdTipoOfUserListNewUser.getUserList().remove(userListNewUser);
                        oldIdTipoOfUserListNewUser = em.merge(oldIdTipoOfUserListNewUser);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipoUsuario.getIdTipo();
                if (findTipoUsuario(id) == null) {
                    throw new NonexistentEntityException("The tipoUsuario with id " + id + " no longer exists.");
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
            TipoUsuario tipoUsuario;
            try {
                tipoUsuario = em.getReference(TipoUsuario.class, id);
                tipoUsuario.getIdTipo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoUsuario with id " + id + " no longer exists.", enfe);
            }
            List<Role> roleList = tipoUsuario.getRoleList();
            for (Role roleListRole : roleList) {
                roleListRole.getTipoUsuarioList().remove(tipoUsuario);
                roleListRole = em.merge(roleListRole);
            }
            List<User> userList = tipoUsuario.getUserList();
            for (User userListUser : userList) {
                userListUser.setIdTipo(null);
                userListUser = em.merge(userListUser);
            }
            em.remove(tipoUsuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoUsuario> findTipoUsuarioEntities() {
        return findTipoUsuarioEntities(true, -1, -1);
    }

    public List<TipoUsuario> findTipoUsuarioEntities(int maxResults, int firstResult) {
        return findTipoUsuarioEntities(false, maxResults, firstResult);
    }

    private List<TipoUsuario> findTipoUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoUsuario.class));
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

    public TipoUsuario findTipoUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoUsuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoUsuario> rt = cq.from(TipoUsuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
