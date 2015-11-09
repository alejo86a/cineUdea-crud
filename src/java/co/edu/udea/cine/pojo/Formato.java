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
@Table(name = "formato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formato.findAll", query = "SELECT f FROM Formato f"),
    @NamedQuery(name = "Formato.findByIdFORMATO", query = "SELECT f FROM Formato f WHERE f.idFORMATO = :idFORMATO"),
    @NamedQuery(name = "Formato.findByNombre", query = "SELECT f FROM Formato f WHERE f.nombre = :nombre")})
public class Formato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFORMATO")
    private Integer idFORMATO;
    @Size(max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formato")
    private List<Pelicula> peliculaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fORMATOidFORMATO")
    private List<Precio> precioList;

    public Formato() {
    }

    public Formato(Integer idFORMATO) {
        this.idFORMATO = idFORMATO;
    }

    public Integer getIdFORMATO() {
        return idFORMATO;
    }

    public void setIdFORMATO(Integer idFORMATO) {
        this.idFORMATO = idFORMATO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Pelicula> getPeliculaList() {
        return peliculaList;
    }

    public void setPeliculaList(List<Pelicula> peliculaList) {
        this.peliculaList = peliculaList;
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
        hash += (idFORMATO != null ? idFORMATO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formato)) {
            return false;
        }
        Formato other = (Formato) object;
        if ((this.idFORMATO == null && other.idFORMATO != null) || (this.idFORMATO != null && !this.idFORMATO.equals(other.idFORMATO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.cine.modelo.Formato[ idFORMATO=" + idFORMATO + " ]";
    }
    
}
