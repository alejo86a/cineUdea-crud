/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.cine.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "silla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Silla.findAll", query = "SELECT s FROM Silla s"),
    @NamedQuery(name = "Silla.findByNumero", query = "SELECT s FROM Silla s WHERE s.sillaPK.numero = :numero"),
    @NamedQuery(name = "Silla.findByFila", query = "SELECT s FROM Silla s WHERE s.sillaPK.fila = :fila"),
    @NamedQuery(name = "Silla.findByDisponible", query = "SELECT s FROM Silla s WHERE s.disponible = :disponible"),
    @NamedQuery(name = "Silla.findBySALAidSALA", query = "SELECT s FROM Silla s WHERE s.sillaPK.sALAidSALA = :sALAidSALA")})
public class Silla implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SillaPK sillaPK;
    @Column(name = "Disponible")
    private Boolean disponible;
    @JoinColumn(name = "SALA_idSALA", referencedColumnName = "idSALA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sala sala;
    @JoinColumn(name = "localidad_idlocalidad", referencedColumnName = "idlocalidad")
    @ManyToOne(optional = false)
    private Localidad localidadIdlocalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sILLANumero")
    private List<Boleta> boletaList;

    public Silla() {
    }

    public Silla(SillaPK sillaPK) {
        this.sillaPK = sillaPK;
    }

    public Silla(int numero, String fila, int sALAidSALA) {
        this.sillaPK = new SillaPK(numero, fila, sALAidSALA);
    }

    public SillaPK getSillaPK() {
        return sillaPK;
    }

    public void setSillaPK(SillaPK sillaPK) {
        this.sillaPK = sillaPK;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
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
        hash += (sillaPK != null ? sillaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Silla)) {
            return false;
        }
        Silla other = (Silla) object;
        if ((this.sillaPK == null && other.sillaPK != null) || (this.sillaPK != null && !this.sillaPK.equals(other.sillaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.cine.modelo.Silla[ sillaPK=" + sillaPK + " ]";
    }
    
}
