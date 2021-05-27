/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;



/**
 *
 * @author man
 */
@Entity
@Table(name = "sala")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sala.findAll", query = "SELECT s FROM Sala s")
    , @NamedQuery(name = "Sala.findByIdSala", query = "SELECT s FROM Sala s WHERE s.idSala = :idSala")
    , @NamedQuery(name = "Sala.findByNombre", query = "SELECT s FROM Sala s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Sala.findByCapacidad", query = "SELECT s FROM Sala s WHERE s.capacidad = :capacidad")})
public class Sala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSala")
    private Integer idSala;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "capacidad")
    private Integer capacidad; 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sala",fetch=FetchType.LAZY)
    @JsonBackReference(value="sala_func")
    private List<Funciones> funcionesList;
    @JoinColumn(name = "sede", referencedColumnName = "idSede")
    @ManyToOne(optional = false)
    private Sede sede;

    public Sala() {
    }

    public Sala(Integer idSala) {
        this.idSala = idSala;
    }

    public Sala(Integer idSala, String nombre) {
        this.idSala = idSala;
        this.nombre = nombre;
    }

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    @XmlTransient
    public List<Funciones> getFuncionesList() {
        return funcionesList;
    }

    public void setFuncionesList(List<Funciones> funcionesList) {
        this.funcionesList = funcionesList;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSala != null ? idSala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sala)) {
            return false;
        }
        Sala other = (Sala) object;
        if ((this.idSala == null && other.idSala != null) || (this.idSala != null && !this.idSala.equals(other.idSala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Sala[ idSala=" + idSala + " ]";
    }
    
}
