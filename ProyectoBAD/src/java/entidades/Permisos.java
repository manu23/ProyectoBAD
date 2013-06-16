/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "PERMISOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permisos.findAll", query = "SELECT p FROM Permisos p"),
    @NamedQuery(name = "Permisos.findByIdpermiso", query = "SELECT p FROM Permisos p WHERE p.idpermiso = :idpermiso"),
    @NamedQuery(name = "Permisos.findByTabla", query = "SELECT p FROM Permisos p WHERE p.tabla = :tabla"),
    @NamedQuery(name = "Permisos.findByCrear", query = "SELECT p FROM Permisos p WHERE p.crear = :crear"),
    @NamedQuery(name = "Permisos.findByLeer", query = "SELECT p FROM Permisos p WHERE p.leer = :leer"),
    @NamedQuery(name = "Permisos.findByActualizar", query = "SELECT p FROM Permisos p WHERE p.actualizar = :actualizar"),
    @NamedQuery(name = "Permisos.findByEliminar", query = "SELECT p FROM Permisos p WHERE p.eliminar = :eliminar")})
public class Permisos implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPERMISO")
    private BigDecimal idpermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TABLA")
    private String tabla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREAR")
    private BigInteger crear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LEER")
    private BigInteger leer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTUALIZAR")
    private BigInteger actualizar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ELIMINAR")
    private BigInteger eliminar;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Permisos() {
    }

    public Permisos(BigDecimal idpermiso) {
        this.idpermiso = idpermiso;
    }

    public Permisos(BigDecimal idpermiso, String tabla, BigInteger crear, BigInteger leer, BigInteger actualizar, BigInteger eliminar) {
        this.idpermiso = idpermiso;
        this.tabla = tabla;
        this.crear = crear;
        this.leer = leer;
        this.actualizar = actualizar;
        this.eliminar = eliminar;
    }

    public BigDecimal getIdpermiso() {
        return idpermiso;
    }

    public void setIdpermiso(BigDecimal idpermiso) {
        this.idpermiso = idpermiso;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public BigInteger getCrear() {
        return crear;
    }

    public void setCrear(BigInteger crear) {
        this.crear = crear;
    }

    public BigInteger getLeer() {
        return leer;
    }

    public void setLeer(BigInteger leer) {
        this.leer = leer;
    }

    public BigInteger getActualizar() {
        return actualizar;
    }

    public void setActualizar(BigInteger actualizar) {
        this.actualizar = actualizar;
    }

    public BigInteger getEliminar() {
        return eliminar;
    }

    public void setEliminar(BigInteger eliminar) {
        this.eliminar = eliminar;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpermiso != null ? idpermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permisos)) {
            return false;
        }
        Permisos other = (Permisos) object;
        if ((this.idpermiso == null && other.idpermiso != null) || (this.idpermiso != null && !this.idpermiso.equals(other.idpermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Permisos[ idpermiso=" + idpermiso + " ]";
    }
    
}
