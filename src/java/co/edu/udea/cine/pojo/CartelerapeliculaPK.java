/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.cine.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author alejandro
 */
@Embeddable
public class CartelerapeliculaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idCARTELERAPELICULA")
    private int idCARTELERAPELICULA;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PELICULA_idPELICULA")
    private int pELICULAidPELICULA;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CARTELERA_idCARTELERA")
    private int cARTELERAidCARTELERA;

    public CartelerapeliculaPK() {
    }

    public CartelerapeliculaPK(int idCARTELERAPELICULA, int pELICULAidPELICULA, int cARTELERAidCARTELERA) {
        this.idCARTELERAPELICULA = idCARTELERAPELICULA;
        this.pELICULAidPELICULA = pELICULAidPELICULA;
        this.cARTELERAidCARTELERA = cARTELERAidCARTELERA;
    }

    public int getIdCARTELERAPELICULA() {
        return idCARTELERAPELICULA;
    }

    public void setIdCARTELERAPELICULA(int idCARTELERAPELICULA) {
        this.idCARTELERAPELICULA = idCARTELERAPELICULA;
    }

    public int getPELICULAidPELICULA() {
        return pELICULAidPELICULA;
    }

    public void setPELICULAidPELICULA(int pELICULAidPELICULA) {
        this.pELICULAidPELICULA = pELICULAidPELICULA;
    }

    public int getCARTELERAidCARTELERA() {
        return cARTELERAidCARTELERA;
    }

    public void setCARTELERAidCARTELERA(int cARTELERAidCARTELERA) {
        this.cARTELERAidCARTELERA = cARTELERAidCARTELERA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCARTELERAPELICULA;
        hash += (int) pELICULAidPELICULA;
        hash += (int) cARTELERAidCARTELERA;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartelerapeliculaPK)) {
            return false;
        }
        CartelerapeliculaPK other = (CartelerapeliculaPK) object;
        if (this.idCARTELERAPELICULA != other.idCARTELERAPELICULA) {
            return false;
        }
        if (this.pELICULAidPELICULA != other.pELICULAidPELICULA) {
            return false;
        }
        if (this.cARTELERAidCARTELERA != other.cARTELERAidCARTELERA) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.cine.modelo.CartelerapeliculaPK[ idCARTELERAPELICULA=" + idCARTELERAPELICULA + ", pELICULAidPELICULA=" + pELICULAidPELICULA + ", cARTELERAidCARTELERA=" + cARTELERAidCARTELERA + " ]";
    }
    
}
