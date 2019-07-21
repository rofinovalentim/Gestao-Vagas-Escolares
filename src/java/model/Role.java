/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rofino Chunga Jr
 */
@Entity
@Table(name = "role", catalog = "sistema", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findByRole", query = "SELECT r FROM Role r WHERE r.role = :role"),
    @NamedQuery(name = "Role.findByRecurso", query = "SELECT r FROM Role r WHERE r.recurso = :recurso")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "role", nullable = false, length = 255)
    private String role;
    @Column(name = "recurso", length = 255)
    private String recurso;
    @ManyToMany(mappedBy = "roleList", fetch = FetchType.LAZY)
    private List<TipoUsuario> tipoUsuarioList;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    @XmlTransient
    public List<TipoUsuario> getTipoUsuarioList() {
        return tipoUsuarioList;
    }

    public void setTipoUsuarioList(List<TipoUsuario> tipoUsuarioList) {
        this.tipoUsuarioList = tipoUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (role != null ? role.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.role == null && other.role != null) || (this.role != null && !this.role.equals(other.role))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Role[ role=" + role + " ]";
    }
    
}
