/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "camion")
@NamedQueries({
    @NamedQuery(name = "Camion.findAll", query = "SELECT c FROM Camion c")})
public class Camion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_camion")
    private Integer idCamion;
    @Basic(optional = false)
    @Column(name = "numero_carro")
    private int numeroCarro;
    @Basic(optional = false)
    @Column(name = "numero_placas")
    private String numeroPlacas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "capacidad")
    private Double capacidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCamion")
    private List<Maneja> manejaList;

    public Camion() {
    }

    public Camion(Integer idCamion) {
        this.idCamion = idCamion;
    }

    public Camion(Integer idCamion, int numeroCarro, String numeroPlacas, Double capacidad) {
        this.idCamion = idCamion;
        this.numeroCarro = numeroCarro;
        this.numeroPlacas = numeroPlacas;
        this.capacidad = capacidad;
    }

    public Integer getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(Integer idCamion) {
        this.idCamion = idCamion;
    }

    public int getNumeroCarro() {
        return numeroCarro;
    }

    public void setNumeroCarro(int numeroCarro) {
        this.numeroCarro = numeroCarro;
    }

    public String getNumeroPlacas() {
        return numeroPlacas;
    }

    public void setNumeroPlacas(String numeroPlacas) {
        this.numeroPlacas = numeroPlacas;
    }

    public Double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }

    public List<Maneja> getManejaList() {
        return manejaList;
    }

    public void setManejaList(List<Maneja> manejaList) {
        this.manejaList = manejaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCamion != null ? idCamion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camion)) {
            return false;
        }
        Camion other = (Camion) object;
        if ((this.idCamion == null && other.idCamion != null) || (this.idCamion != null && !this.idCamion.equals(other.idCamion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ idCamion=" + idCamion + " ]"+"[ numeroCarro="+numeroCarro+"] "+"[ NumeroPlacas= "+numeroPlacas+"]"+"[ Capacidad="+capacidad.toString()+"]";
    }
    
}
