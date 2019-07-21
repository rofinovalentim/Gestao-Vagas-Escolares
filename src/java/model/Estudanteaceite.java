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
import javax.persistence.Id;
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
@Table(name = "estudanteaceite", catalog = "sistema", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudanteaceite.findAll", query = "SELECT e FROM Estudanteaceite e"),
    @NamedQuery(name = "Estudanteaceite.findByIdEstudante", query = "SELECT e FROM Estudanteaceite e WHERE e.idEstudante = :idEstudante"),
    @NamedQuery(name = "Estudanteaceite.findByNomeEstudante", query = "SELECT e FROM Estudanteaceite e WHERE e.nomeEstudante = :nomeEstudante"),
    @NamedQuery(name = "Estudanteaceite.findByDataNascimento", query = "SELECT e FROM Estudanteaceite e WHERE e.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Estudanteaceite.findByEmail", query = "SELECT e FROM Estudanteaceite e WHERE e.email = :email"),
    @NamedQuery(name = "Estudanteaceite.findByTelefone", query = "SELECT e FROM Estudanteaceite e WHERE e.telefone = :telefone"),
    @NamedQuery(name = "Estudanteaceite.findByNrBI", query = "SELECT e FROM Estudanteaceite e WHERE e.nrBI = :nrBI"),
    @NamedQuery(name = "Estudanteaceite.findByGenero", query = "SELECT e FROM Estudanteaceite e WHERE e.genero = :genero"),
    @NamedQuery(name = "Estudanteaceite.findByEscola", query = "SELECT e FROM Estudanteaceite e WHERE e.escola = :escola"),
    @NamedQuery(name = "Estudanteaceite.findByClasse", query = "SELECT e FROM Estudanteaceite e WHERE e.classe = :classe")})
public class Estudanteaceite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
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
    @Column(name = "telefone")
    private Long telefone;
    @Column(name = "nrBI", length = 255)
    private String nrBI;
    @Column(name = "genero", length = 255)
    private String genero;
    @Column(name = "escola", length = 255)
    private String escola;
    @Column(name = "classe", length = 255)
    private String classe;

    public Estudanteaceite() {
    }

    public Estudanteaceite(Integer idEstudante) {
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

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getNrBI() {
        return nrBI;
    }

    public void setNrBI(String nrBI) {
        this.nrBI = nrBI;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
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
        if (!(object instanceof Estudanteaceite)) {
            return false;
        }
        Estudanteaceite other = (Estudanteaceite) object;
        if ((this.idEstudante == null && other.idEstudante != null) || (this.idEstudante != null && !this.idEstudante.equals(other.idEstudante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Estudanteaceite[ idEstudante=" + idEstudante + " ]";
    }
    
}
