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
public class CargoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "IDDOCENTE")
    private String iddocente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDDEPARTAMENTO")
    private String iddepartamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDCARGO")
    private String idcargo;

    public CargoPK() {
    }

    public CargoPK(String iddocente, String iddepartamento, String idcargo) {
        this.iddocente = iddocente;
        this.iddepartamento = iddepartamento;
        this.idcargo = idcargo;
    }

    public String getIddocente() {
        return iddocente;
    }

    public void setIddocente(String iddocente) {
        this.iddocente = iddocente;
    }

    public String getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(String iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(String idcargo) {
        this.idcargo = idcargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddocente != null ? iddocente.hashCode() : 0);
        hash += (iddepartamento != null ? iddepartamento.hashCode() : 0);
        hash += (idcargo != null ? idcargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargoPK)) {
            return false;
        }
        CargoPK other = (CargoPK) object;
        if ((this.iddocente == null && other.iddocente != null) || (this.iddocente != null && !this.iddocente.equals(other.iddocente))) {
            return false;
        }
        if ((this.iddepartamento == null && other.iddepartamento != null) || (this.iddepartamento != null && !this.iddepartamento.equals(other.iddepartamento))) {
            return false;
        }
        if ((this.idcargo == null && other.idcargo != null) || (this.idcargo != null && !this.idcargo.equals(other.idcargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CargoPK[ iddocente=" + iddocente + ", iddepartamento=" + iddepartamento + ", idcargo=" + idcargo + " ]";
    }
    
}
