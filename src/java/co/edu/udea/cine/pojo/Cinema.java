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
 * @author alejandro
 */
@Entity
@Table(name = "cinema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cinema.findAll", query = "SELECT c FROM Cinema c"),
    @NamedQuery(name = "Cinema.findByIdCINEMA", query = "SELECT c FROM Cinema c WHERE c.idCINEMA = :idCINEMA"),
    @NamedQuery(name = "Cinema.findByDireccion", query = "SELECT c FROM Cinema c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Cinema.findByNombre", query = "SELECT c FROM Cinema c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cinema.findByCiudad", query = "SELECT c FROM Cinema c WHERE c.ciudad = :ciudad"),
    @NamedQuery(name = "Cinema.findByPais", query = "SELECT c FROM Cinema c WHERE c.pais = :pais"),
    @NamedQuery(name = "Cinema.findByTelefono", query = "SELECT c FROM Cinema c WHERE c.telefono = :telefono")})
public class Cinema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "idCINEMA")
    private String idCINEMA;
    @Size(max = 50)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "Ciudad")
    private String ciudad;
    @Size(max = 45)
    @Column(name = "Pais")
    private String pais;
    @Size(max = 45)
    @Column(name = "Telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cINEMAidCINEMA")
    private List<Sala> salaList;
    @JoinColumn(name = "Cartelera", referencedColumnName = "idCARTELERA")
    @ManyToOne
    private Cartelera cartelera;
    @JoinColumn(name = "CINE_NIT", referencedColumnName = "NIT")
    @ManyToOne(optional = false)
    private Cine cineNit;

    public Cinema() {
    }

    public Cinema(String idCINEMA) {
        this.idCINEMA = idCINEMA;
    }

    public String getIdCINEMA() {
        return idCINEMA;
    }

    public void setIdCINEMA(String idCINEMA) {
        this.idCINEMA = idCINEMA;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<Sala> getSalaList() {
        return salaList;
    }

    public void setSalaList(List<Sala> salaList) {
        this.salaList = salaList;
    }

    public Cartelera getCartelera() {
        return cartelera;
    }

    public void setCartelera(Cartelera cartelera) {
        this.cartelera = cartelera;
    }

    public Cine getCineNit() {
        return cineNit;
    }

    public void setCineNit(Cine cineNit) {
        this.cineNit = cineNit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCINEMA != null ? idCINEMA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cinema)) {
            return false;
        }
        Cinema other = (Cinema) object;
        if ((this.idCINEMA == null && other.idCINEMA != null) || (this.idCINEMA != null && !this.idCINEMA.equals(other.idCINEMA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.cine.modelo.Cinema[ idCINEMA=" + idCINEMA + " ]";
    }
    
}
