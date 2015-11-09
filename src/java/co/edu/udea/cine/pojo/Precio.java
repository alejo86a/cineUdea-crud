/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.cine.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alejandro
 */
@Entity
@Table(name = "precio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Precio.findAll", query = "SELECT p FROM Precio p"),
    @NamedQuery(name = "Precio.findByIdPrecio", query = "SELECT p FROM Precio p WHERE p.idPrecio = :idPrecio"),
    @NamedQuery(name = "Precio.findByPrecioDinero", query = "SELECT p FROM Precio p WHERE p.precioDinero = :precioDinero"),
    @NamedQuery(name = "Precio.findByPrecioPuntos", query = "SELECT p FROM Precio p WHERE p.precioPuntos = :precioPuntos")})
public class Precio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPrecio")
    private Integer idPrecio;
    @Column(name = "PrecioDinero")
    private Integer precioDinero;
    @Column(name = "PrecioPuntos")
    private Integer precioPuntos;
    @JoinColumn(name = "FORMATO_idFORMATO", referencedColumnName = "idFORMATO")
    @ManyToOne(optional = false)
    private Formato fORMATOidFORMATO;
    @JoinColumn(name = "localidad_idlocalidad", referencedColumnName = "idlocalidad")
    @ManyToOne(optional = false)
    private Localidad localidadIdlocalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "precioidPrecio")
    private List<Boleta> boletaList;

    public Precio() {
    }

    public Precio(Integer idPrecio) {
        this.idPrecio = idPrecio;
    }

    public Integer getIdPrecio() {
        return idPrecio;
    }

    public void setIdPrecio(Integer idPrecio) {
        this.idPrecio = idPrecio;
    }

    public Integer getPrecioDinero() {
        return precioDinero;
    }

    public void setPrecioDinero(Integer precioDinero) {
        this.precioDinero = precioDinero;
    }

    public Integer getPrecioPuntos() {
        return precioPuntos;
    }

    public void setPrecioPuntos(Integer precioPuntos) {
        this.precioPuntos = precioPuntos;
    }

    public Formato getFORMATOidFORMATO() {
        return fORMATOidFORMATO;
    }

    public void setFORMATOidFORMATO(Formato fORMATOidFORMATO) {
        this.fORMATOidFORMATO = fORMATOidFORMATO;
    }

    public Localidad getLocalidadIdlocalidad() {
        return localidadIdlocalidad;
    }

    public void setLocalidadIdlocalidad(Localidad localidadIdlocalidad) {
        this.localidadIdlocalidad = localidadIdlocalidad;
    }

    @XmlTransient
    public List<Boleta> getBoletaList() {
        return boletaList;
    }

    public void setBoletaList(List<Boleta> boletaList) {
        this.boletaList = boletaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrecio != null ? idPrecio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Precio)) {
            return false;
        }
        Precio other = (Precio) object;
        if ((this.idPrecio == null && other.idPrecio != null) || (this.idPrecio != null && !this.idPrecio.equals(other.idPrecio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.cine.modelo.Precio[ idPrecio=" + idPrecio + " ]";
    }
    
}
