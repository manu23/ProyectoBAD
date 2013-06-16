/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mejia
 */
@Entity
@Table(name = "MATERIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m"),
    @NamedQuery(name = "Materia.findByIdpropuesta", query = "SELECT m FROM Materia m WHERE m.materiaPK.idpropuesta = :idpropuesta"),
    @NamedQuery(name = "Materia.findByCodigomateria", query = "SELECT m FROM Materia m WHERE m.materiaPK.codigomateria = :codigomateria"),
    @NamedQuery(name = "Materia.findByNombremateria", query = "SELECT m FROM Materia m WHERE m.nombremateria = :nombremateria"),
    @NamedQuery(name = "Materia.findByUv", query = "SELECT m FROM Materia m WHERE m.uv = :uv"),
    @NamedQuery(name = "Materia.findByCicloimparte", query = "SELECT m FROM Materia m WHERE m.cicloimparte = :cicloimparte"),
    @NamedQuery(name = "Materia.findByTipomateria", query = "SELECT m FROM Materia m WHERE m.tipomateria = :tipomateria"),
    @NamedQuery(name = "Materia.findByNumhorasprac", query = "SELECT m FROM Materia m WHERE m.numhorasprac = :numhorasprac"),
    @NamedQuery(name = "Materia.findByNumhorasteo", query = "SELECT m FROM Materia m WHERE m.numhorasteo = :numhorasteo")})
public class Materia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MateriaPK materiaPK;
    @Size(max = 50)
    @Column(name = "NOMBREMATERIA")
    private String nombremateria;
    @Column(name = "UV")
    private BigInteger uv;
    @Column(name = "CICLOIMPARTE")
    private BigInteger cicloimparte;
    @Size(max = 15)
    @Column(name = "TIPOMATERIA")
    private String tipomateria;
    @Column(name = "NUMHORASPRAC")
    private BigInteger numhorasprac;
    @Column(name = "NUMHORASTEO")
    private BigInteger numhorasteo;
    @OneToMany(mappedBy = "materia")
    private Collection<Horario> horarioCollection;
    @JoinColumn(name = "IDPROPUESTA", referencedColumnName = "IDPROPUESTA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Propuesta propuesta;
    @JoinColumn(name = "IDPENSUM", referencedColumnName = "IDPENSUM")
    @ManyToOne
    private Pensum idpensum;
    @JoinColumn(name = "IDDOCENTE", referencedColumnName = "IDDOCENTE")
    @ManyToOne
    private Docente iddocente;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "materia")
    private Prerrequisito prerrequisito;

    public Materia() {
    }

    public Materia(MateriaPK materiaPK) {
        this.materiaPK = materiaPK;
    }

    public Materia(String idpropuesta, String codigomateria) {
        this.materiaPK = new MateriaPK(idpropuesta, codigomateria);
    }

    public MateriaPK getMateriaPK() {
        return materiaPK;
    }

    public void setMateriaPK(MateriaPK materiaPK) {
        this.materiaPK = materiaPK;
    }

    public String getNombremateria() {
        return nombremateria;
    }

    public void setNombremateria(String nombremateria) {
        this.nombremateria = nombremateria;
    }

    public BigInteger getUv() {
        return uv;
    }

    public void setUv(BigInteger uv) {
        this.uv = uv;
    }

    public BigInteger getCicloimparte() {
        return cicloimparte;
    }

    public void setCicloimparte(BigInteger cicloimparte) {
        this.cicloimparte = cicloimparte;
    }

    public String getTipomateria() {
        return tipomateria;
    }

    public void setTipomateria(String tipomateria) {
        this.tipomateria = tipomateria;
    }

    public BigInteger getNumhorasprac() {
        return numhorasprac;
    }

    public void setNumhorasprac(BigInteger numhorasprac) {
        this.numhorasprac = numhorasprac;
    }

    public BigInteger getNumhorasteo() {
        return numhorasteo;
    }

    public void setNumhorasteo(BigInteger numhorasteo) {
        this.numhorasteo = numhorasteo;
    }

    @XmlTransient
    public Collection<Horario> getHorarioCollection() {
        return horarioCollection;
    }

    public void setHorarioCollection(Collection<Horario> horarioCollection) {
        this.horarioCollection = horarioCollection;
    }

    public Propuesta getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(Propuesta propuesta) {
        this.propuesta = propuesta;
    }

    public Pensum getIdpensum() {
        return idpensum;
    }

    public void setIdpensum(Pensum idpensum) {
        this.idpensum = idpensum;
    }

    public Docente getIddocente() {
        return iddocente;
    }

    public void setIddocente(Docente iddocente) {
        this.iddocente = iddocente;
    }

    public Prerrequisito getPrerrequisito() {
        return prerrequisito;
    }

    public void setPrerrequisito(Prerrequisito prerrequisito) {
        this.prerrequisito = prerrequisito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materiaPK != null ? materiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.materiaPK == null && other.materiaPK != null) || (this.materiaPK != null && !this.materiaPK.equals(other.materiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Materia[ materiaPK=" + materiaPK + " ]";
    }
    
}
