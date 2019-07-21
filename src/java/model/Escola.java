/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "escola", catalog = "sistema", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escola.findAll", query = "SELECT e FROM Escola e"),
    @NamedQuery(name = "Escola.findByIdEscola", query = "SELECT e FROM Escola e WHERE e.idEscola = :idEscola"),
    @NamedQuery(name = "Escola.findByNomeEscola", query = "SELECT e FROM Escola e WHERE e.nomeEscola = :nomeEscola"),
    @NamedQuery(name = "Escola.findByEndereco", query = "SELECT e FROM Escola e WHERE e.endereco = :endereco"),
    @NamedQuery(name = "Escola.findByTelefone", query = "SELECT e FROM Escola e WHERE e.telefone = :telefone"),
    @NamedQuery(name = "Escola.findByEmail", query = "SELECT e FROM Escola e WHERE e.email = :email")})
public class Escola implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEscola", nullable = false)
    private Integer idEscola;
    @Column(name = "nomeEscola", length = 255)
    private String nomeEscola;
    @Column(name = "endereco", length = 255)
    private String endereco;
    @Column(name = "telefone")
    private Integer telefone;
    @Column(name = "email", length = 255)
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escola", fetch = FetchType.LAZY)
    private List<Vagas> vagasList;
    @JoinColumn(name = "iddistrito", referencedColumnName = "idDistrito")
    @ManyToOne(fetch = FetchType.LAZY)
    private Distrito iddistrito;

    public Escola() {
    }

    public Escola(Integer idEscola) {
        this.idEscola = idEscola;
    }

    public Integer getIdEscola() {
        return idEscola;
    }

    public void setIdEscola(Integer idEscola) {
        this.idEscola = idEscola;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Vagas> getVagasList() {
        return vagasList;
    }

    public void setVagasList(List<Vagas> vagasList) {
        this.vagasList = vagasList;
    }

    public Distrito getIddistrito() {
        return iddistrito;
    }

    public void setIddistrito(Distrito iddistrito) {
        this.iddistrito = iddistrito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEscola != null ? idEscola.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escola)) {
            return false;
        }
        Escola other = (Escola) object;
        if ((this.idEscola == null && other.idEscola != null) || (this.idEscola != null && !this.idEscola.equals(other.idEscola))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Escola[ idEscola=" + idEscola + " ]";
    }
    
}
