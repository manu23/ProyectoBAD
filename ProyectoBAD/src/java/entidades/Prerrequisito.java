/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mejia
 */
@Entity
@Table(name = "PRERREQUISITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prerrequisito.findAll", query = "SELECT p FROM Prerrequisito p"),
    @NamedQuery(name = "Prerrequisito.findByIdpropuesta", query = "SELECT p FROM Prerrequisito p WHERE p.prerrequisitoPK.idpropuesta = :idpropuesta"),
    @NamedQuery(name = "Prerrequisito.findByCodigomateria", query = "SELECT p FROM Prerrequisito p WHERE p.prerrequisitoPK.codigomateria = :codigomateria"),
    @NamedQuery(name = "Prerrequisito.findByNombreprerrequisito", query = "SELECT p FROM Prerrequisito p WHERE p.nombreprerrequisito = :nombreprerrequisito"),
    @NamedQuery(name = "Prerrequisito.existePrerrequisito", query = "SELECT p FROM Prerrequisito p WHERE p.prerrequisitoPK.codigomateria = :codigomateria AND p.nombreprerrequisito = :nombreprerrequisito")})
public class Prerrequisito implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrerrequisitoPK prerrequisitoPK;
    @Size(max = 50)
    @Column(name = "NOMBREPRERREQUISITO")
    private String nombreprerrequisito;
    @JoinColumns({
        @JoinColumn(name = "IDPROPUESTA", referencedColumnName = "IDPROPUESTA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOMATERIA", referencedColumnName = "CODIGOMATERIA", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Materia materia;

    public Prerrequisito() {
    }

    public Prerrequisito(PrerrequisitoPK prerrequisitoPK) {
        this.prerrequisitoPK = prerrequisitoPK;
    }

    public Prerrequisito(String idpropuesta, String codigomateria) {
        this.prerrequisitoPK = new PrerrequisitoPK(idpropuesta, codigomateria);
    }

    public PrerrequisitoPK getPrerrequisitoPK() {
        return prerrequisitoPK;
    }

    public void setPrerrequisitoPK(PrerrequisitoPK prerrequisitoPK) {
        this.prerrequisitoPK = prerrequisitoPK;
    }

    public String getNombreprerrequisito() {
        return nombreprerrequisito;
    }

    public void setNombreprerrequisito(String nombreprerrequisito) {
        this.nombreprerrequisito = nombreprerrequisito;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prerrequisitoPK != null ? prerrequisitoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prerrequisito)) {
            return false;
        }
        Prerrequisito other = (Prerrequisito) object;
        if ((this.prerrequisitoPK == null && other.prerrequisitoPK != null) || (this.prerrequisitoPK != null && !this.prerrequisitoPK.equals(other.prerrequisitoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Prerrequisito[ prerrequisitoPK=" + prerrequisitoPK + " ]";
    }
    
}
