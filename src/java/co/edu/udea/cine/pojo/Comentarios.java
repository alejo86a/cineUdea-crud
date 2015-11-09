/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.cine.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alejandro
 */
@Entity
@Table(name = "comentarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentarios.findAll", query = "SELECT c FROM Comentarios c"),
    @NamedQuery(name = "Comentarios.findByIdCOMENTARIO", query = "SELECT c FROM Comentarios c WHERE c.idCOMENTARIO = :idCOMENTARIO"),
    @NamedQuery(name = "Comentarios.findByComentario", query = "SELECT c FROM Comentarios c WHERE c.comentario = :comentario"),
    @NamedQuery(name = "Comentarios.findByAutor", query = "SELECT c FROM Comentarios c WHERE c.autor = :autor"),
    @NamedQuery(name = "Comentarios.findByFecha", query = "SELECT c FROM Comentarios c WHERE c.fecha = :fecha")})
public class Comentarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCOMENTARIO")
    private Integer idCOMENTARIO;
    @Size(max = 300)
    @Column(name = "Comentario")
    private String comentario;
    @Size(max = 75)
    @Column(name = "Autor")
    private String autor;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "PELICULA", referencedColumnName = "idPELICULA")
    @ManyToOne(optional = false)
    private Pelicula pelicula;

    public Comentarios() {
    }

    public Comentarios(Integer idCOMENTARIO) {
        this.idCOMENTARIO = idCOMENTARIO;
    }

    public Integer getIdCOMENTARIO() {
        return idCOMENTARIO;
    }

    public void setIdCOMENTARIO(Integer idCOMENTARIO) {
        this.idCOMENTARIO = idCOMENTARIO;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        hash += (idCOMENTARIO != null ? idCOMENTARIO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentarios)) {
            return false;
        }
        Comentarios other = (Comentarios) object;
        if ((this.idCOMENTARIO == null && other.idCOMENTARIO != null) || (this.idCOMENTARIO != null && !this.idCOMENTARIO.equals(other.idCOMENTARIO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.cine.modelo.Comentarios[ idCOMENTARIO=" + idCOMENTARIO + " ]";
    }
    
}
