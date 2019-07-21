/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Rofino Chunga Jr
 */
@Embeddable
public class VagasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idEscola", nullable = false)
    private int idEscola;
    @Basic(optional = false)
    @Column(name = "classe", nullable = false, length = 255)
    private String classe;

    public VagasPK() {
    }

    public VagasPK(int idEscola, String classe) {
        this.idEscola = idEscola;
        this.classe = classe;
    }

    public int getIdEscola() {
        return idEscola;
    }

    public void setIdEscola(int idEscola) {
        this.idEscola = idEscola;
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
        hash += (int) idEscola;
        hash += (classe != null ? classe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VagasPK)) {
            return false;
        }
        VagasPK other = (VagasPK) object;
        if (this.idEscola != other.idEscola) {
            return false;
        }
        if ((this.classe == null && other.classe != null) || (this.classe != null && !this.classe.equals(other.classe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.VagasPK[ idEscola=" + idEscola + ", classe=" + classe + " ]";
    }
    
}
