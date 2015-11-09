/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.cine.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alejandro
 */
@Entity
@Table(name = "boleta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boleta.findAll", query = "SELECT b FROM Boleta b"),
    @NamedQuery(name = "Boleta.findByIdBOLETA", query = "SELECT b FROM Boleta b WHERE b.idBOLETA = :idBOLETA"),
    @NamedQuery(name = "Boleta.findByQr", query = "SELECT b FROM Boleta b WHERE b.qr = :qr"),
    @NamedQuery(name = "Boleta.findByReservada", query = "SELECT b FROM Boleta b WHERE b.reservada = :reservada")})
public class Boleta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBOLETA")
    private Integer idBOLETA;
    @Size(max = 25)
    @Column(name = "QR")
    private String qr;
    @Column(name = "Reservada")
    private Boolean reservada;
    @JoinColumn(name = "Funcion", referencedColumnName = "idFUNCION")
    @ManyToOne(optional = false)
    private Funcion funcion;
    @JoinColumn(name = "Precio_idPrecio", referencedColumnName = "idPrecio")
    @ManyToOne(optional = false)
    private Precio precioidPrecio;
    @JoinColumn(name = "Reserva", referencedColumnName = "idReserva")
    @ManyToOne(optional = false)
    private Reserva reserva;
    //@JoinColumn(name = "SILLA_Numero", referencedColumnName = "Numero")
    //@ManyToOne(optional = false)
    private Silla sILLANumero;

    public Boleta() {
    }

    public Boleta(Integer idBOLETA) {
        this.idBOLETA = idBOLETA;
    }

    public Integer getIdBOLETA() {
        return idBOLETA;
    }

    public void setIdBOLETA(Integer idBOLETA) {
        this.idBOLETA = idBOLETA;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public Boolean getReservada() {
        return reservada;
    }

    public void setReservada(Boolean reservada) {
        this.reservada = reservada;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public Precio getPrecioidPrecio() {
        return precioidPrecio;
    }

    public void setPrecioidPrecio(Precio precioidPrecio) {
        this.precioidPrecio = precioidPrecio;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Silla getSILLANumero() {
        return sILLANumero;
    }

    public void setSILLANumero(Silla sILLANumero) {
        this.sILLANumero = sILLANumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBOLETA != null ? idBOLETA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boleta)) {
            return false;
        }
        Boleta other = (Boleta) object;
        if ((this.idBOLETA == null && other.idBOLETA != null) || (this.idBOLETA != null && !this.idBOLETA.equals(other.idBOLETA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.cine.modelo.Boleta[ idBOLETA=" + idBOLETA + " ]";
    }
    
}
