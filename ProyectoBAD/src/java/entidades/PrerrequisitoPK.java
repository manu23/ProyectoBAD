/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mejia
 */
@Embeddable
public class PrerrequisitoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDPROPUESTA")
    private String idpropuesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "CODIGOMATERIA")
    private String codigomateria;

    public PrerrequisitoPK() {
    }

    public PrerrequisitoPK(String idpropuesta, String codigomateria) {
        this.idpropuesta = idpropuesta;
        this.codigomateria = codigomateria;
    }

    public String getIdpropuesta() {
        return idpropuesta;
    }

    public void setIdpropuesta(String idpropuesta) {
        this.idpropuesta = idpropuesta;
    }

    public String getCodigomateria() {
        return codigomateria;
    }

    public void setCodigomateria(String codigomateria) {
        this.codigomateria = codigomateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpropuesta != null ? idpropuesta.hashCode() : 0);
        hash += (codigomateria != null ? codigomateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrerrequisitoPK)) {
            return false;
        }
        PrerrequisitoPK other = (PrerrequisitoPK) object;
        if ((this.idpropuesta == null && other.idpropuesta != null) || (this.idpropuesta != null && !this.idpropuesta.equals(other.idpropuesta))) {
            return false;
        }
        if ((this.codigomateria == null && other.codigomateria != null) || (this.codigomateria != null && !this.codigomateria.equals(other.codigomateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "entidades.PrerrequisitoPK[ idpropuesta=" + idpropuesta + ", codigomateria=" + codigomateria + " ]";
         return codigomateria;
    }
    
}
