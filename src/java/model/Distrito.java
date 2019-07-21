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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rofino Chunga Jr
 */
@Entity
@Table(name = "distrito", catalog = "sistema", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distrito.findAll", query = "SELECT d FROM Distrito d"),
    @NamedQuery(name = "Distrito.findByIdDistrito", query = "SELECT d FROM Distrito d WHERE d.idDistrito = :idDistrito"),
    @NamedQuery(name = "Distrito.findByNomeDestrito", query = "SELECT d FROM Distrito d WHERE d.nomeDestrito = :nomeDestrito"),
    @NamedQuery(name = "Distrito.findByProvincia", query = "SELECT d FROM Distrito d WHERE d.provincia = :provincia")})
public class Distrito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDistrito", nullable = false)
    private Integer idDistrito;
    @Column(name = "nomeDestrito", length = 255)
    private String nomeDestrito;
    @Column(name = "provincia", length = 255)
    private String provincia;
    @OneToMany(mappedBy = "iddistrito", fetch = FetchType.LAZY)
    private List<Escola> escolaList;

    public Distrito() {
    }

    public Distrito(Integer idDistrito) {
        this.idDistrito = idDistrito;
    }

    public Integer getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Integer idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getNomeDestrito() {
        return nomeDestrito;
    }

    public void setNomeDestrito(String nomeDestrito) {
        this.nomeDestrito = nomeDestrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @XmlTransient
    public List<Escola> getEscolaList() {
        return escolaList;
    }

    public void setEscolaList(List<Escola> escolaList) {
        this.escolaList = escolaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDistrito != null ? idDistrito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distrito)) {
            return false;
        }
        Distrito other = (Distrito) object;
        if ((this.idDistrito == null && other.idDistrito != null) || (this.idDistrito != null && !this.idDistrito.equals(other.idDistrito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Distrito[ idDistrito=" + idDistrito + " ]";
    }
   
    
    
}
