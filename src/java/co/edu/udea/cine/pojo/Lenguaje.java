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
@Table(name = "lenguaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lenguaje.findAll", query = "SELECT l FROM Lenguaje l"),
    @NamedQuery(name = "Lenguaje.findByIdLENGUAJE", query = "SELECT l FROM Lenguaje l WHERE l.idLENGUAJE = :idLENGUAJE"),
    @NamedQuery(name = "Lenguaje.findByNombre", query = "SELECT l FROM Lenguaje l WHERE l.nombre = :nombre")})
public class Lenguaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLENGUAJE")
    private Integer idLENGUAJE;
    @Size(max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lenguaje")
    private List<Pelicula> peliculaList;

    public Lenguaje() {
    }

    public Lenguaje(Integer idLENGUAJE) {
        this.idLENGUAJE = idLENGUAJE;
    }

    public Integer getIdLENGUAJE() {
        return idLENGUAJE;
    }

    public void setIdLENGUAJE(Integer idLENGUAJE) {
        this.idLENGUAJE = idLENGUAJE;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLENGUAJE != null ? idLENGUAJE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lenguaje)) {
            return false;
        }
        Lenguaje other = (Lenguaje) object;
        if ((this.idLENGUAJE == null && other.idLENGUAJE != null) || (this.idLENGUAJE != null && !this.idLENGUAJE.equals(other.idLENGUAJE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.cine.modelo.Lenguaje[ idLENGUAJE=" + idLENGUAJE + " ]";
    }
    
}
