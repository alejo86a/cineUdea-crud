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
import javax.validation.constraints.Size;

/**
 *
 * @author alejandro
 */
@Embeddable
public class SillaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Numero")
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Fila")
    private String fila;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALA_idSALA")
    private int sALAidSALA;

    public SillaPK() {
    }

    public SillaPK(int numero, String fila, int sALAidSALA) {
        this.numero = numero;
        this.fila = fila;
        this.sALAidSALA = sALAidSALA;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getSALAidSALA() {
        return sALAidSALA;
    }

    public void setSALAidSALA(int sALAidSALA) {
        this.sALAidSALA = sALAidSALA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numero;
        hash += (fila != null ? fila.hashCode() : 0);
        hash += (int) sALAidSALA;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SillaPK)) {
            return false;
        }
        SillaPK other = (SillaPK) object;
        if (this.numero != other.numero) {
            return false;
        }
        if ((this.fila == null && other.fila != null) || (this.fila != null && !this.fila.equals(other.fila))) {
            return false;
        }
        if (this.sALAidSALA != other.sALAidSALA) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.cine.modelo.SillaPK[ numero=" + numero + ", fila=" + fila + ", sALAidSALA=" + sALAidSALA + " ]";
    }
    
}
