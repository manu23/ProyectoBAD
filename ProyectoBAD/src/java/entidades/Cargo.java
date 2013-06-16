/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mejia
 */
@Entity
@Table(name = "CARGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
    @NamedQuery(name = "Cargo.findByIddocente", query = "SELECT c FROM Cargo c WHERE c.cargoPK.iddocente = :iddocente"),
    @NamedQuery(name = "Cargo.findByIddepartamento", query = "SELECT c FROM Cargo c WHERE c.cargoPK.iddepartamento = :iddepartamento"),
    @NamedQuery(name = "Cargo.findByIdcargo", query = "SELECT c FROM Cargo c WHERE c.cargoPK.idcargo = :idcargo"),
    @NamedQuery(name = "Cargo.findByNombrecargo", query = "SELECT c FROM Cargo c WHERE c.nombrecargo = :nombrecargo"),
    @NamedQuery(name = "Cargo.findByFechainiciocargo", query = "SELECT c FROM Cargo c WHERE c.fechainiciocargo = :fechainiciocargo"),
    @NamedQuery(name = "Cargo.findByFechafincargo", query = "SELECT c FROM Cargo c WHERE c.fechafincargo = :fechafincargo")})
public class Cargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CargoPK cargoPK;
    @Size(max = 150)
    @Column(name = "NOMBRECARGO")
    private String nombrecargo;
    @Column(name = "FECHAINICIOCARGO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainiciocargo;
    @Column(name = "FECHAFINCARGO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafincargo;
    @JoinColumn(name = "IDDOCENTE", referencedColumnName = "IDDOCENTE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Docente docente;
    @JoinColumn(name = "IDDEPARTAMENTO", referencedColumnName = "IDDEPARTAMENTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Departamento departamento;
    @OneToMany(mappedBy = "cargo")
    private Collection<Propuesta> propuestaCollection;

    public Cargo() {
    }

    public Cargo(CargoPK cargoPK) {
        this.cargoPK = cargoPK;
    }

    public Cargo(String iddocente, String iddepartamento, String idcargo) {
        this.cargoPK = new CargoPK(iddocente, iddepartamento, idcargo);
    }

    public CargoPK getCargoPK() {
        return cargoPK;
    }

    public void setCargoPK(CargoPK cargoPK) {
        this.cargoPK = cargoPK;
    }

    public String getNombrecargo() {
        return nombrecargo;
    }

    public void setNombrecargo(String nombrecargo) {
        this.nombrecargo = nombrecargo;
    }

    public Date getFechainiciocargo() {
        return fechainiciocargo;
    }

    public void setFechainiciocargo(Date fechainiciocargo) {
        this.fechainiciocargo = fechainiciocargo;
    }

    public Date getFechafincargo() {
        return fechafincargo;
    }

    public void setFechafincargo(Date fechafincargo) {
        this.fechafincargo = fechafincargo;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @XmlTransient
    public Collection<Propuesta> getPropuestaCollection() {
        return propuestaCollection;
    }

    public void setPropuestaCollection(Collection<Propuesta> propuestaCollection) {
        this.propuestaCollection = propuestaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cargoPK != null ? cargoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.cargoPK == null && other.cargoPK != null) || (this.cargoPK != null && !this.cargoPK.equals(other.cargoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cargo[ cargoPK=" + cargoPK + " ]";
    }
    
}
