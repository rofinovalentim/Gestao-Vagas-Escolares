/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rofino Chunga Jr
 */
@Entity
@Table(name = "estudante", catalog = "sistema", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudante.findAll", query = "SELECT e FROM Estudante e"),
    @NamedQuery(name = "Estudante.findByIdEstudante", query = "SELECT e FROM Estudante e WHERE e.idEstudante = :idEstudante"),
    @NamedQuery(name = "Estudante.findByNomeEstudante", query = "SELECT e FROM Estudante e WHERE e.nomeEstudante = :nomeEstudante"),
    @NamedQuery(name = "Estudante.findByDataNascimento", query = "SELECT e FROM Estudante e WHERE e.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Estudante.findByEmail", query = "SELECT e FROM Estudante e WHERE e.email = :email"),
    @NamedQuery(name = "Estudante.findByNrBI", query = "SELECT e FROM Estudante e WHERE e.nrBI = :nrBI"),
    @NamedQuery(name = "Estudante.findByTelefone", query = "SELECT e FROM Estudante e WHERE e.telefone = :telefone")})
public class Estudante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstudante", nullable = false)
    private Integer idEstudante;
    @Column(name = "nomeEstudante", length = 255)
    private String nomeEstudante;
    @Column(name = "dataNascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "email", length = 255)
    private String email;
    @Column(name = "nrBI", length = 255)
    private String nrBI;
    @Column(name = "telefone")
    private Integer telefone;
    @JoinColumn(name = "idGenero", referencedColumnName = "idGenero")
    @ManyToOne(fetch = FetchType.LAZY)
    private Genero idGenero;
    @JoinColumns({
        @JoinColumn(name = "idEscola", referencedColumnName = "idEscola"),
        @JoinColumn(name = "classe", referencedColumnName = "classe")})
    @ManyToOne(fetch = FetchType.LAZY)
    private Vagas vagas;

    public Estudante() {
    }

    public Estudante(Integer idEstudante) {
        this.idEstudante = idEstudante;
    }

    public Integer getIdEstudante() {
        return idEstudante;
    }

    public void setIdEstudante(Integer idEstudante) {
        this.idEstudante = idEstudante;
    }

    public String getNomeEstudante() {
        return nomeEstudante;
    }

    public void setNomeEstudante(String nomeEstudante) {
        this.nomeEstudante = nomeEstudante;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNrBI() {
        return nrBI;
    }

    public void setNrBI(String nrBI) {
        this.nrBI = nrBI;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Genero getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Genero idGenero) {
        this.idGenero = idGenero;
    }

    public Vagas getVagas() {
        return vagas;
    }

    public void setVagas(Vagas vagas) {
        this.vagas = vagas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudante != null ? idEstudante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudante)) {
            return false;
        }
        Estudante other = (Estudante) object;
        if ((this.idEstudante == null && other.idEstudante != null) || (this.idEstudante != null && !this.idEstudante.equals(other.idEstudante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Estudante[ idEstudante=" + idEstudante + " ]";
    }
    
}
