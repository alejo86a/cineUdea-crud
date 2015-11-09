/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.cine.pojo;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alejandro
 */
@Entity
@Table(name = "cartelerapelicula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartelerapelicula.findAll", query = "SELECT c FROM Cartelerapelicula c"),
    @NamedQuery(name = "Cartelerapelicula.findByIdCARTELERAPELICULA", query = "SELECT c FROM Cartelerapelicula c WHERE c.cartelerapeliculaPK.idCARTELERAPELICULA = :idCARTELERAPELICULA"),
    @NamedQuery(name = "Cartelerapelicula.findByPELICULAidPELICULA", query = "SELECT c FROM Cartelerapelicula c WHERE c.cartelerapeliculaPK.pELICULAidPELICULA = :pELICULAidPELICULA"),
    @NamedQuery(name = "Cartelerapelicula.findByCARTELERAidCARTELERA", query = "SELECT c FROM Cartelerapelicula c WHERE c.cartelerapeliculaPK.cARTELERAidCARTELERA = :cARTELERAidCARTELERA")})
public class Cartelerapelicula implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CartelerapeliculaPK cartelerapeliculaPK;
    @JoinColumn(name = "CARTELERA_idCARTELERA", referencedColumnName = "idCARTELERA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cartelera cartelera;
    @JoinColumn(name = "PELICULA_idPELICULA", referencedColumnName = "idPELICULA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pelicula pelicula;

    public Cartelerapelicula() {
    }

    public Cartelerapelicula(CartelerapeliculaPK cartelerapeliculaPK) {
        this.cartelerapeliculaPK = cartelerapeliculaPK;
    }

    public Cartelerapelicula(int idCARTELERAPELICULA, int pELICULAidPELICULA, int cARTELERAidCARTELERA) {
        this.cartelerapeliculaPK = new CartelerapeliculaPK(idCARTELERAPELICULA, pELICULAidPELICULA, cARTELERAidCARTELERA);
    }

    public CartelerapeliculaPK getCartelerapeliculaPK() {
        return cartelerapeliculaPK;
    }

    public void setCartelerapeliculaPK(CartelerapeliculaPK cartelerapeliculaPK) {
        this.cartelerapeliculaPK = cartelerapeliculaPK;
    }

    public Cartelera getCartelera() {
        return cartelera;
    }

    public void setCartelera(Cartelera cartelera) {
        this.cartelera = cartelera;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartelerapeliculaPK != null ? cartelerapeliculaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartelerapelicula)) {
            return false;
        }
        Cartelerapelicula other = (Cartelerapelicula) object;
        if ((this.cartelerapeliculaPK == null && other.cartelerapeliculaPK != null) || (this.cartelerapeliculaPK != null && !this.cartelerapeliculaPK.equals(other.cartelerapeliculaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.cine.modelo.Cartelerapelicula[ cartelerapeliculaPK=" + cartelerapeliculaPK + " ]";
    }
    
}
