/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "maneja")
@NamedQueries({
    @NamedQuery(name = "Maneja.findAll", query = "SELECT m FROM Maneja m")})
public class Maneja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_maneja")
    private Integer idManeja;
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idManeja")
    private List<Paquete> paqueteList;
    @JoinColumn(name = "id_operador", referencedColumnName = "id_operador")
    @ManyToOne(optional = false)
    private Operador idOperador;
    @JoinColumn(name = "id_camion", referencedColumnName = "id_camion")
    @ManyToOne(optional = false)
    private Camion idCamion;

    public Maneja() {
    }

    public Maneja(Integer idManeja) {
        this.idManeja = idManeja;
    }

    public Integer getIdManeja() {
        return idManeja;
    }

    public void setIdManeja(Integer idManeja) {
        this.idManeja = idManeja;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public List<Paquete> getPaqueteList() {
        return paqueteList;
    }

    public void setPaqueteList(List<Paquete> paqueteList) {
        this.paqueteList = paqueteList;
    }

    public Operador getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(Operador idOperador) {
        this.idOperador = idOperador;
    }

    public Camion getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(Camion idCamion) {
        this.idCamion = idCamion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idManeja != null ? idManeja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maneja)) {
            return false;
        }
        Maneja other = (Maneja) object;
        if ((this.idManeja == null && other.idManeja != null) || (this.idManeja != null && !this.idManeja.equals(other.idManeja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejemplohibernate.Maneja[ idManeja=" + idManeja + " ]";
    }
    
}
