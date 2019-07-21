/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "vagas", catalog = "sistema", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vagas.findAll", query = "SELECT v FROM Vagas v"),
    @NamedQuery(name = "Vagas.findByIdEscola", query = "SELECT v FROM Vagas v WHERE v.vagasPK.idEscola = :idEscola"),
    @NamedQuery(name = "Vagas.findByClasse", query = "SELECT v FROM Vagas v WHERE v.vagasPK.classe = :classe"),
    @NamedQuery(name = "Vagas.findByNrVagas", query = "SELECT v FROM Vagas v WHERE v.nrVagas = :nrVagas")})
public class Vagas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VagasPK vagasPK;
    @Column(name = "nrVagas")
    private Integer nrVagas;
    @JoinColumn(name = "idEscola", referencedColumnName = "idEscola", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Escola escola;
    @OneToMany(mappedBy = "vagas", fetch = FetchType.LAZY)
    private List<Estudante> estudanteList;

    public Vagas() {
    }

    public Vagas(VagasPK vagasPK) {
        this.vagasPK = vagasPK;
    }

    public Vagas(int idEscola, String classe) {
        this.vagasPK = new VagasPK(idEscola, classe);
    }

    public VagasPK getVagasPK() {
        return vagasPK;
    }

    public void setVagasPK(VagasPK vagasPK) {
        this.vagasPK = vagasPK;
    }

    public Integer getNrVagas() {
        return nrVagas;
    }

    public void setNrVagas(Integer nrVagas) {
        this.nrVagas = nrVagas;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    @XmlTransient
    public List<Estudante> getEstudanteList() {
        return estudanteList;
    }

    public void setEstudanteList(List<Estudante> estudanteList) {
        this.estudanteList = estudanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vagasPK != null ? vagasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vagas)) {
            return false;
        }
        Vagas other = (Vagas) object;
        if ((this.vagasPK == null && other.vagasPK != null) || (this.vagasPK != null && !this.vagasPK.equals(other.vagasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vagas[ vagasPK=" + vagasPK + " ]";
    }
    
}
