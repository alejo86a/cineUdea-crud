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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alejandro
 */
@Entity
@Table(name = "funcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcion.findAll", query = "SELECT f FROM Funcion f"),
    @NamedQuery(name = "Funcion.findByIdFUNCION", query = "SELECT f FROM Funcion f WHERE f.idFUNCION = :idFUNCION"),
    @NamedQuery(name = "Funcion.findByFecha", query = "SELECT f FROM Funcion f WHERE f.fecha = :fecha")})
public class Funcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFUNCION")
    private Integer idFUNCION;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcion")
    private List<Boleta> boletaList;
    @JoinColumn(name = "PELICULA_idPELICULA", referencedColumnName = "idPELICULA")
    @ManyToOne(optional = false)
    private Pelicula pELICULAidPELICULA;
    @JoinColumn(name = "PROGRAMACION_idProgramacion", referencedColumnName = "idProgramacion")
    @ManyToOne
    private Programacion pROGRAMACIONidProgramacion;

    public Funcion() {
    }

    public Funcion(Integer idFUNCION) {
        this.idFUNCION = idFUNCION;
    }

    public Integer getIdFUNCION() {
        return idFUNCION;
    }

    public void setIdFUNCION(Integer idFUNCION) {
        this.idFUNCION = idFUNCION;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<Boleta> getBoletaList() {
        return boletaList;
    }

    public void setBoletaList(List<Boleta> boletaList) {
        this.boletaList = boletaList;
    }

    public Pelicula getPELICULAidPELICULA() {
        return pELICULAidPELICULA;
    }

    public void setPELICULAidPELICULA(Pelicula pELICULAidPELICULA) {
        this.pELICULAidPELICULA = pELICULAidPELICULA;
    }

    public Programacion getPROGRAMACIONidProgramacion() {
        return pROGRAMACIONidProgramacion;
    }

    public void setPROGRAMACIONidProgramacion(Programacion pROGRAMACIONidProgramacion) {
        this.pROGRAMACIONidProgramacion = pROGRAMACIONidProgramacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFUNCION != null ? idFUNCION.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcion)) {
            return false;
        }
        Funcion other = (Funcion) object;
        if ((this.idFUNCION == null && other.idFUNCION != null) || (this.idFUNCION != null && !this.idFUNCION.equals(other.idFUNCION))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.cine.modelo.Funcion[ idFUNCION=" + idFUNCION + " ]";
    }
    
}
