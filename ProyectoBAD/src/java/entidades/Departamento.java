/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "DEPARTAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByIddepartamento", query = "SELECT d FROM Departamento d WHERE d.iddepartamento = :iddepartamento"),
    @NamedQuery(name = "Departamento.findByNombredepartamento", query = "SELECT d FROM Departamento d WHERE d.nombredepartamento = :nombredepartamento"),
    @NamedQuery(name = "Departamento.findByDescripciondepartamento", query = "SELECT d FROM Departamento d WHERE d.descripciondepartamento = :descripciondepartamento")})
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDDEPARTAMENTO")
    private String iddepartamento;
    @Size(max = 150)
    @Column(name = "NOMBREDEPARTAMENTO")
    private String nombredepartamento;
    @Size(max = 500)
    @Column(name = "DESCRIPCIONDEPARTAMENTO")
    private String descripciondepartamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamento")
    private Collection<Cargo> cargoCollection;
    @OneToMany(mappedBy = "iddepartamento")
    private Collection<Docente> docenteCollection;

    public Departamento() {
    }

    public Departamento(String iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(String iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getNombredepartamento() {
        return nombredepartamento;
    }

    public void setNombredepartamento(String nombredepartamento) {
        this.nombredepartamento = nombredepartamento;
    }

    public String getDescripciondepartamento() {
        return descripciondepartamento;
    }

    public void setDescripciondepartamento(String descripciondepartamento) {
        this.descripciondepartamento = descripciondepartamento;
    }

    @XmlTransient
    public Collection<Cargo> getCargoCollection() {
        return cargoCollection;
    }

    public void setCargoCollection(Collection<Cargo> cargoCollection) {
        this.cargoCollection = cargoCollection;
    }

    @XmlTransient
    public Collection<Docente> getDocenteCollection() {
        return docenteCollection;
    }

    public void setDocenteCollection(Collection<Docente> docenteCollection) {
        this.docenteCollection = docenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddepartamento != null ? iddepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.iddepartamento == null && other.iddepartamento != null) || (this.iddepartamento != null && !this.iddepartamento.equals(other.iddepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Departamento[ iddepartamento=" + iddepartamento + " ]";
    }
    
}
