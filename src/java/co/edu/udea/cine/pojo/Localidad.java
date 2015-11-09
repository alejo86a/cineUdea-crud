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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alejandro
 */
@Entity
@Table(name = "localidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localidad.findAll", query = "SELECT l FROM Localidad l"),
    @NamedQuery(name = "Localidad.findByIdlocalidad", query = "SELECT l FROM Localidad l WHERE l.idlocalidad = :idlocalidad"),
    @NamedQuery(name = "Localidad.findBySitio", query = "SELECT l FROM Localidad l WHERE l.sitio = :sitio")})
public class Localidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlocalidad")
    private Integer idlocalidad;
    @Size(max = 45)
    @Column(name = "Sitio")
    private String sitio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localidadIdlocalidad")
    private List<Silla> sillaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localidadIdlocalidad")
    private List<Precio> precioList;

    public Localidad() {
    }

    public Localidad(Integer idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    public Integer getIdlocalidad() {
        return idlocalidad;
    }

    public void setIdlocalidad(Integer idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    @XmlTransient
    public List<Silla> getSillaList() {
        return sillaList;
    }

    public void setSillaList(List<Silla> sillaList) {
        this.sillaList = sillaList;
    }

    @XmlTransient
    public List<Precio> getPrecioList() {
        return precioList;
    }

    public void setPrecioList(List<Precio> precioList) {
        this.precioList = precioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlocalidad != null ? idlocalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidad)) {
            return false;
        }
        Localidad other = (Localidad) object;
        if ((this.idlocalidad == null && other.idlocalidad != null) || (this.idlocalidad != null && !this.idlocalidad.equals(other.idlocalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.cine.modelo.Localidad[ idlocalidad=" + idlocalidad + " ]";
    }

}
