/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mejia
 */
@Entity
@Table(name = "RECURSOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recursos.findAll", query = "SELECT r FROM Recursos r"),
    @NamedQuery(name = "Recursos.findByIdrecursos", query = "SELECT r FROM Recursos r WHERE r.idrecursos = :idrecursos"),
    @NamedQuery(name = "Recursos.findByNombrerecursos", query = "SELECT r FROM Recursos r WHERE r.nombrerecursos = :nombrerecursos")})
public class Recursos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDRECURSOS")
    private String idrecursos;
    @Size(max = 150)
    @Column(name = "NOMBRERECURSOS")
    private String nombrerecursos;
    @Lob
    @Column(name = "DESCRIPCIONRECURSOS")
    private String descripcionrecursos;
    @JoinColumn(name = "IDPROPUESTA", referencedColumnName = "IDPROPUESTA")
    @ManyToOne
    private Propuesta idpropuesta;

    public Recursos() {
    }

    public Recursos(String idrecursos) {
        this.idrecursos = idrecursos;
    }

    public String getIdrecursos() {
        return idrecursos;
    }

    public void setIdrecursos(String idrecursos) {
        this.idrecursos = idrecursos;
    }

    public String getNombrerecursos() {
        return nombrerecursos;
    }

    public void setNombrerecursos(String nombrerecursos) {
        this.nombrerecursos = nombrerecursos;
    }

    public String getDescripcionrecursos() {
        return descripcionrecursos;
    }

    public void setDescripcionrecursos(String descripcionrecursos) {
        this.descripcionrecursos = descripcionrecursos;
    }

    public Propuesta getIdpropuesta() {
        return idpropuesta;
    }

    public void setIdpropuesta(Propuesta idpropuesta) {
        this.idpropuesta = idpropuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrecursos != null ? idrecursos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recursos)) {
            return false;
        }
        Recursos other = (Recursos) object;
        if ((this.idrecursos == null && other.idrecursos != null) || (this.idrecursos != null && !this.idrecursos.equals(other.idrecursos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Recursos[ idrecursos=" + idrecursos + " ]";
    }
    
}
