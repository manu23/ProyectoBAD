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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "DOCENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d"),
    @NamedQuery(name = "Docente.findByIddocente", query = "SELECT d FROM Docente d WHERE d.iddocente = :iddocente"),
    @NamedQuery(name = "Docente.findByNombredocente", query = "SELECT d FROM Docente d WHERE d.nombredocente = :nombredocente"),
    @NamedQuery(name = "Docente.findByApellidodocente", query = "SELECT d FROM Docente d WHERE d.apellidodocente = :apellidodocente"),
    @NamedQuery(name = "Docente.findByEspecialidad", query = "SELECT d FROM Docente d WHERE d.especialidad = :especialidad"),
    @NamedQuery(name = "Docente.findByCargo", query = "SELECT d FROM Docente d WHERE d.cargo = :cargo"),
    @NamedQuery(name = "Docente.findByEmail", query = "SELECT d FROM Docente d WHERE d.email = :email")})
public class Docente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "IDDOCENTE")
    private String iddocente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBREDOCENTE")
    private String nombredocente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "APELLIDODOCENTE")
    private String apellidodocente;
    @Size(max = 300)
    @Column(name = "ESPECIALIDAD")
    private String especialidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CARGO")
    private String cargo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(mappedBy = "iddocente")
    private Collection<Materia> materiaCollection;
    @OneToMany(mappedBy = "iddocente")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docente")
    private Collection<Cargo> cargoCollection;
    @JoinColumn(name = "IDDEPARTAMENTO", referencedColumnName = "IDDEPARTAMENTO")
    @ManyToOne
    private Departamento iddepartamento;
    @OneToMany(mappedBy = "iddocente")
    private Collection<Propuesta> propuestaCollection;

    public Docente() {
    }

    public Docente(String iddocente) {
        this.iddocente = iddocente;
    }

    public Docente(String iddocente, String nombredocente, String apellidodocente, String cargo, String email) {
        this.iddocente = iddocente;
        this.nombredocente = nombredocente;
        this.apellidodocente = apellidodocente;
        this.cargo = cargo;
        this.email = email;
    }

    public String getIddocente() {
        return iddocente;
    }

    public void setIddocente(String iddocente) {
        this.iddocente = iddocente;
    }

    public String getNombredocente() {
        return nombredocente;
    }

    public void setNombredocente(String nombredocente) {
        this.nombredocente = nombredocente;
    }

    public String getApellidodocente() {
        return apellidodocente;
    }

    public void setApellidodocente(String apellidodocente) {
        this.apellidodocente = apellidodocente;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Materia> getMateriaCollection() {
        return materiaCollection;
    }

    public void setMateriaCollection(Collection<Materia> materiaCollection) {
        this.materiaCollection = materiaCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Cargo> getCargoCollection() {
        return cargoCollection;
    }

    public void setCargoCollection(Collection<Cargo> cargoCollection) {
        this.cargoCollection = cargoCollection;
    }

    public Departamento getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(Departamento iddepartamento) {
        this.iddepartamento = iddepartamento;
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
        hash += (iddocente != null ? iddocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.iddocente == null && other.iddocente != null) || (this.iddocente != null && !this.iddocente.equals(other.iddocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Docente[ iddocente=" + iddocente + " ]";
    }
    
}
