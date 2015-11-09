/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.cine.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alejandro
 */
@Entity
@Table(name = "cartelera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartelera.findAll", query = "SELECT c FROM Cartelera c"),
    @NamedQuery(name = "Cartelera.findByIdCARTELERA", query = "SELECT c FROM Cartelera c WHERE c.idCARTELERA = :idCARTELERA"),
    @NamedQuery(name = "Cartelera.findByDireccion", query = "SELECT c FROM Cartelera c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Cartelera.findByFechaInicio", query = "SELECT c FROM Cartelera c WHERE c.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Cartelera.findByFechaFin", query = "SELECT c FROM Cartelera c WHERE c.fechaFin = :fechaFin")})
public class Cartelera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCARTELERA")
    private Integer idCARTELERA;
    @Size(max = 100)
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "FechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Size(max = 45)
    @Column(name = "FechaFin")
    private String fechaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartelera")
    private List<Cartelerapelicula> cartelerapeliculaList;
    @OneToMany(mappedBy = "cartelera")
    private List<Cinema> cinemaList;

    public Cartelera() {
    }

    public Cartelera(Integer idCARTELERA) {
        this.idCARTELERA = idCARTELERA;
    }

    public Integer getIdCARTELERA() {
        return idCARTELERA;
    }

    public void setIdCARTELERA(Integer idCARTELERA) {
        this.idCARTELERA = idCARTELERA;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    @XmlTransient
    public List<Cartelerapelicula> getCartelerapeliculaList() {
        return cartelerapeliculaList;
    }

    public void setCartelerapeliculaList(List<Cartelerapelicula> cartelerapeliculaList) {
        this.cartelerapeliculaList = cartelerapeliculaList;
    }

    @XmlTransient
    public List<Cinema> getCinemaList() {
        return cinemaList;
    }

    public void setCinemaList(List<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCARTELERA != null ? idCARTELERA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartelera)) {
            return false;
        }
        Cartelera other = (Cartelera) object;
        if ((this.idCARTELERA == null && other.idCARTELERA != null) || (this.idCARTELERA != null && !this.idCARTELERA.equals(other.idCARTELERA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.cine.modelo.Cartelera[ idCARTELERA=" + idCARTELERA + " ]";
    }
    
}
