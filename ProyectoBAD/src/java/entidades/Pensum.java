/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mejia
 */
@Entity
@Table(name = "PENSUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pensum.findAll", query = "SELECT p FROM Pensum p"),
    @NamedQuery(name = "Pensum.findByIdpensum", query = "SELECT p FROM Pensum p WHERE p.idpensum = :idpensum"),
    @NamedQuery(name = "Pensum.findByNombrecarrera", query = "SELECT p FROM Pensum p WHERE p.nombrecarrera = :nombrecarrera"),
    @NamedQuery(name = "Pensum.findByAnioaprobacion", query = "SELECT p FROM Pensum p WHERE p.anioaprobacion = :anioaprobacion")})
public class Pensum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDPENSUM")
    private String idpensum;
    @Size(max = 100)
    @Column(name = "NOMBRECARRERA")
    private String nombrecarrera;
    @Column(name = "ANIOAPROBACION")
    private BigInteger anioaprobacion;
    @OneToMany(mappedBy = "idpensum")
    private Collection<Materia> materiaCollection;

    public Pensum() {
    }

    public Pensum(String idpensum) {
        this.idpensum = idpensum;
    }

    public String getIdpensum() {
        return idpensum;
    }

    public void setIdpensum(String idpensum) {
        this.idpensum = idpensum;
    }

    public String getNombrecarrera() {
        return nombrecarrera;
    }

    public void setNombrecarrera(String nombrecarrera) {
        this.nombrecarrera = nombrecarrera;
    }

    public BigInteger getAnioaprobacion() {
        return anioaprobacion;
    }

    public void setAnioaprobacion(BigInteger anioaprobacion) {
        this.anioaprobacion = anioaprobacion;
    }

    @XmlTransient
    public Collection<Materia> getMateriaCollection() {
        return materiaCollection;
    }

    public void setMateriaCollection(Collection<Materia> materiaCollection) {
        this.materiaCollection = materiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpensum != null ? idpensum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pensum)) {
            return false;
        }
        Pensum other = (Pensum) object;
        if ((this.idpensum == null && other.idpensum != null) || (this.idpensum != null && !this.idpensum.equals(other.idpensum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Pensum[ idpensum=" + idpensum + " ]";
    }
    
}
