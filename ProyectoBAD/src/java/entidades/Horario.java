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
import javax.persistence.JoinColumns;
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
@Table(name = "HORARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h"),
    @NamedQuery(name = "Horario.findByIdhorario", query = "SELECT h FROM Horario h WHERE h.idhorario = :idhorario"),
    @NamedQuery(name = "Horario.findByDia", query = "SELECT h FROM Horario h WHERE h.dia = :dia"),
    @NamedQuery(name = "Horario.findByHorainicio", query = "SELECT h FROM Horario h WHERE h.horainicio = :horainicio"),
    @NamedQuery(name = "Horario.findByHorafin", query = "SELECT h FROM Horario h WHERE h.horafin = :horafin")})
public class Horario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "IDHORARIO")
    private String idhorario;
    @Size(max = 15)
    @Column(name = "DIA")
    private String dia;
    @Size(max = 10)
    @Column(name = "HORAINICIO")
    private String horainicio;
    @Size(max = 10)
    @Column(name = "HORAFIN")
    private String horafin;
    @JoinColumns({
        @JoinColumn(name = "IDPROPUESTA", referencedColumnName = "IDPROPUESTA"),
        @JoinColumn(name = "CODIGOMATERIA", referencedColumnName = "CODIGOMATERIA")})
    @ManyToOne
    private Materia materia;
    @JoinColumn(name = "IDLOCAL", referencedColumnName = "IDLOCAL")
    @ManyToOne
    private Local idlocal;

    public Horario() {
    }

    public Horario(String idhorario) {
        this.idhorario = idhorario;
    }

    public String getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(String idhorario) {
        this.idhorario = idhorario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getHorafin() {
        return horafin;
    }

    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Local getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(Local idlocal) {
        this.idlocal = idlocal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhorario != null ? idhorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.idhorario == null && other.idhorario != null) || (this.idhorario != null && !this.idhorario.equals(other.idhorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Horario[ idhorario=" + idhorario + " ]";
    }
    
}
