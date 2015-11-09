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
import javax.persistence.Lob;
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
@Table(name = "pelicula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p"),
    @NamedQuery(name = "Pelicula.findByIdPELICULA", query = "SELECT p FROM Pelicula p WHERE p.idPELICULA = :idPELICULA"),
    @NamedQuery(name = "Pelicula.findByNombre", query = "SELECT p FROM Pelicula p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Pelicula.findByTrailer", query = "SELECT p FROM Pelicula p WHERE p.trailer = :trailer"),
    @NamedQuery(name = "Pelicula.findByPais", query = "SELECT p FROM Pelicula p WHERE p.pais = :pais"),
    @NamedQuery(name = "Pelicula.findByDirector", query = "SELECT p FROM Pelicula p WHERE p.director = :director"),
    @NamedQuery(name = "Pelicula.findByReparto", query = "SELECT p FROM Pelicula p WHERE p.reparto = :reparto")})
public class Pelicula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPELICULA")
    private Integer idPELICULA;
    @Size(max = 100)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "Trailer")
    private String trailer;
    @Lob
    @Column(name = "Imagen")
    private byte[] imagen;
    @Size(max = 45)
    @Column(name = "Pais")
    private String pais;
    @Size(max = 45)
    @Column(name = "Director")
    private String director;
    @Size(max = 45)
    @Column(name = "Reparto")
    private String reparto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pelicula")
    private List<Cartelerapelicula> cartelerapeliculaList;
    @JoinColumn(name = "Censura", referencedColumnName = "idClasificacion")
    @ManyToOne(optional = false)
    private Clasificacion censura;
    @JoinColumn(name = "Formato", referencedColumnName = "idFORMATO")
    @ManyToOne(optional = false)
    private Formato formato;
    @JoinColumn(name = "Genero_idGenero", referencedColumnName = "idGenero")
    @ManyToOne(optional = false)
    private Genero generoidGenero;
    @JoinColumn(name = "Lenguaje", referencedColumnName = "idLENGUAJE")
    @ManyToOne(optional = false)
    private Lenguaje lenguaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pELICULAidPELICULA")
    private List<Funcion> funcionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pelicula")
    private List<Comentarios> comentariosList;

    public Pelicula() {
    }

    public Pelicula(Integer idPELICULA) {
        this.idPELICULA = idPELICULA;
    }

    public Integer getIdPELICULA() {
        return idPELICULA;
    }

    public void setIdPELICULA(Integer idPELICULA) {
        this.idPELICULA = idPELICULA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    @XmlTransient
    public List<Cartelerapelicula> getCartelerapeliculaList() {
        return cartelerapeliculaList;
    }

    public void setCartelerapeliculaList(List<Cartelerapelicula> cartelerapeliculaList) {
        this.cartelerapeliculaList = cartelerapeliculaList;
    }

    public Clasificacion getCensura() {
        return censura;
    }

    public void setCensura(Clasificacion censura) {
        this.censura = censura;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public Genero getGeneroidGenero() {
        return generoidGenero;
    }

    public void setGeneroidGenero(Genero generoidGenero) {
        this.generoidGenero = generoidGenero;
    }

    public Lenguaje getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(Lenguaje lenguaje) {
        this.lenguaje = lenguaje;
    }

    @XmlTransient
    public List<Funcion> getFuncionList() {
        return funcionList;
    }

    public void setFuncionList(List<Funcion> funcionList) {
        this.funcionList = funcionList;
    }

    @XmlTransient
    public List<Comentarios> getComentariosList() {
        return comentariosList;
    }

    public void setComentariosList(List<Comentarios> comentariosList) {
        this.comentariosList = comentariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPELICULA != null ? idPELICULA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelicula)) {
            return false;
        }
        Pelicula other = (Pelicula) object;
        if ((this.idPELICULA == null && other.idPELICULA != null) || (this.idPELICULA != null && !this.idPELICULA.equals(other.idPELICULA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.cine.modelo.Pelicula[ idPELICULA=" + idPELICULA + " ]";
    }
    
}
