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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sala")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sala.findAll", query = "SELECT s FROM Sala s"),
    @NamedQuery(name = "Sala.findByIdSALA", query = "SELECT s FROM Sala s WHERE s.idSALA = :idSALA"),
    @NamedQuery(name = "Sala.findByCodigo", query = "SELECT s FROM Sala s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "Sala.findByNumeroSala", query = "SELECT s FROM Sala s WHERE s.numeroSala = :numeroSala"),
    @NamedQuery(name = "Sala.findBySALAcol", query = "SELECT s FROM Sala s WHERE s.sALAcol = :sALAcol")})
public class Sala implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSALA")
    private Integer idSALA;
    @Size(max = 45)
    @Column(name = "Codigo")
    private String codigo;
    @Column(name = "numeroSala")
    private Integer numeroSala;
    @Size(max = 45)
    @Column(name = "SALAcol")
    private String sALAcol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sala")
    private List<Silla> sillaList;
    @JoinColumn(name = "CINEMA_idCINEMA", referencedColumnName = "idCINEMA")
    @ManyToOne(optional = false)
    private Cinema cINEMAidCINEMA;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sALAidSALA")
    private List<Programacion> programacionList;

    public Sala() {
    }

    public Sala(Integer idSALA) {
        this.idSALA = idSALA;
    }

    public Integer getIdSALA() {
        return idSALA;
    }

    public void setIdSALA(Integer idSALA) {
        this.idSALA = idSALA;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(Integer numeroSala) {
        this.numeroSala = numeroSala;
    }

    public String getSALAcol() {
        return sALAcol;
    }

    public void setSALAcol(String sALAcol) {
        this.sALAcol = sALAcol;
    }

    @XmlTransient
    public List<Silla> getSillaList() {
        return sillaList;
    }

    public void setSillaList(List<Silla> sillaList) {
        this.sillaList = sillaList;
    }

    public Cinema getCINEMAidCINEMA() {
        return cINEMAidCINEMA;
    }

    public void setCINEMAidCINEMA(Cinema cINEMAidCINEMA) {
        this.cINEMAidCINEMA = cINEMAidCINEMA;
    }

    @XmlTransient
    public List<Programacion> getProgramacionList() {
        return programacionList;
    }

    public void setProgramacionList(List<Programacion> programacionList) {
        this.programacionList = programacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSALA != null ? idSALA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sala)) {
            return false;
        }
        Sala other = (Sala) object;
        if ((this.idSALA == null && other.idSALA != null) || (this.idSALA != null && !this.idSALA.equals(other.idSALA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.cine.modelo.Sala[ idSALA=" + idSALA + " ]";
    }
    
}
