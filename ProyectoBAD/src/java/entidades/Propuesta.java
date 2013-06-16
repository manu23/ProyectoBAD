/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mejia
 */
@Entity
@Table(name = "PROPUESTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propuesta.findAll", query = "SELECT p FROM Propuesta p"),
    @NamedQuery(name = "Propuesta.findByIdpropuesta", query = "SELECT p FROM Propuesta p WHERE p.idpropuesta = :idpropuesta"),
    @NamedQuery(name = "Propuesta.findByFechapropuesta", query = "SELECT p FROM Propuesta p WHERE p.fechapropuesta = :fechapropuesta"),
    @NamedQuery(name = "Propuesta.findByAprobadojefe", query = "SELECT p FROM Propuesta p WHERE p.aprobadojefe = :aprobadojefe"),
    @NamedQuery(name = "Propuesta.findByAprobadodirector", query = "SELECT p FROM Propuesta p WHERE p.aprobadodirector = :aprobadodirector"),
    @NamedQuery(name = "Propuesta.findByAprobadojunta", query = "SELECT p FROM Propuesta p WHERE p.aprobadojunta = :aprobadojunta")})
public class Propuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDPROPUESTA")
    private String idpropuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAPROPUESTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechapropuesta;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "DETALLE")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "JUSTIFICACION")
    private String justificacion;
    @Column(name = "APROBADOJEFE")
    private BigInteger aprobadojefe;
    @Column(name = "APROBADODIRECTOR")
    private BigInteger aprobadodirector;
    @Column(name = "APROBADOJUNTA")
    private BigInteger aprobadojunta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propuesta")
    private Collection<Materia> materiaCollection;
    @JoinColumn(name = "IDDOCENTE", referencedColumnName = "IDDOCENTE")
    @ManyToOne
    private Docente iddocente;
    @JoinColumns({
        @JoinColumn(name = "CAR_IDDOCENTE", referencedColumnName = "IDDOCENTE"),
        @JoinColumn(name = "IDDEPARTAMENTO", referencedColumnName = "IDDEPARTAMENTO"),
        @JoinColumn(name = "IDCARGO", referencedColumnName = "IDCARGO")})
    @ManyToOne
    private Cargo cargo;
    @OneToMany(mappedBy = "idpropuesta")
    private Collection<Recursos> recursosCollection;

    public Propuesta() {
    }

    public Propuesta(String idpropuesta) {
        this.idpropuesta = idpropuesta;
    }

    public Propuesta(String idpropuesta, Date fechapropuesta, String detalle, String justificacion) {
        this.idpropuesta = idpropuesta;
        this.fechapropuesta = fechapropuesta;
        this.detalle = detalle;
        this.justificacion = justificacion;
    }

    public String getIdpropuesta() {
        return idpropuesta;
    }

    public void setIdpropuesta(String idpropuesta) {
        this.idpropuesta = idpropuesta;
    }

    public Date getFechapropuesta() {
        return fechapropuesta;
    }

    public void setFechapropuesta(Date fechapropuesta) {
        this.fechapropuesta = fechapropuesta;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public BigInteger getAprobadojefe() {
        return aprobadojefe;
    }

    public void setAprobadojefe(BigInteger aprobadojefe) {
        this.aprobadojefe = aprobadojefe;
    }

    public BigInteger getAprobadodirector() {
        return aprobadodirector;
    }

    public void setAprobadodirector(BigInteger aprobadodirector) {
        this.aprobadodirector = aprobadodirector;
    }

    public BigInteger getAprobadojunta() {
        return aprobadojunta;
    }

    public void setAprobadojunta(BigInteger aprobadojunta) {
        this.aprobadojunta = aprobadojunta;
    }

    @XmlTransient
    public Collection<Materia> getMateriaCollection() {
        return materiaCollection;
    }

    public void setMateriaCollection(Collection<Materia> materiaCollection) {
        this.materiaCollection = materiaCollection;
    }

    public Docente getIddocente() {
        return iddocente;
    }

    public void setIddocente(Docente iddocente) {
        this.iddocente = iddocente;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @XmlTransient
    public Collection<Recursos> getRecursosCollection() {
        return recursosCollection;
    }

    public void setRecursosCollection(Collection<Recursos> recursosCollection) {
        this.recursosCollection = recursosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpropuesta != null ? idpropuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propuesta)) {
            return false;
        }
        Propuesta other = (Propuesta) object;
        if ((this.idpropuesta == null && other.idpropuesta != null) || (this.idpropuesta != null && !this.idpropuesta.equals(other.idpropuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Propuesta[ idpropuesta=" + idpropuesta + " ]";
    }
    
}
