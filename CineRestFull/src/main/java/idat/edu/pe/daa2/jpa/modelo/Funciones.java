/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.edu.pe.daa2.jpa.modelo;

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
import javax.xml.bind.annotation.XmlRootElement;



/**
 *
 * @author man
 */
@Entity
@Table(name = "funciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funciones.findAll", query = "SELECT f FROM Funciones f")
    , @NamedQuery(name = "Funciones.findByIdFunciones", query = "SELECT f FROM Funciones f WHERE f.idFunciones = :idFunciones")
    , @NamedQuery(name = "Funciones.findByHoraInicio", query = "SELECT f FROM Funciones f WHERE f.horaInicio = :horaInicio")
    , @NamedQuery(name = "Funciones.findByHoraFin", query = "SELECT f FROM Funciones f WHERE f.horaFin = :horaFin")
    , @NamedQuery(name = "Funciones.findByPrecio", query = "SELECT f FROM Funciones f WHERE f.precio = :precio")})
public class Funciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFunciones")
    private Integer idFunciones;
    @Basic(optional = false)
    @Column(name = "horaInicio")
    private String horaInicio;
    @Basic(optional = false)
    @Column(name = "horaFin")
    private String horaFin;
    @Basic(optional = false)
    @Column(name = "precio")
    private String precio;
    @JoinColumn(name = "pelicula", referencedColumnName = "idPelicula")
    @ManyToOne(optional = false)
    private Pelicula pelicula;
    @JoinColumn(name = "sala", referencedColumnName = "idSala")
    @ManyToOne(optional = false)
    private Sala sala;

    public Funciones() {
    }

    public Funciones(Integer idFunciones) {
        this.idFunciones = idFunciones;
    }

    public Funciones(Integer idFunciones, String horaInicio, String horaFin, String precio) {
        this.idFunciones = idFunciones;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.precio = precio;
    }

    public Integer getIdFunciones() {
        return idFunciones;
    }

    public void setIdFunciones(Integer idFunciones) {
        this.idFunciones = idFunciones;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFunciones != null ? idFunciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funciones)) {
            return false;
        }
        Funciones other = (Funciones) object;
        if ((this.idFunciones == null && other.idFunciones != null) || (this.idFunciones != null && !this.idFunciones.equals(other.idFunciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Funciones[ idFunciones=" + idFunciones + " ]";
    }
    
}
