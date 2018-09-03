/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autosconcesionario.entity;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author W
 */
@Entity
@Table(name = "ventasgenerales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventasgenerales.findAll", query = "SELECT v FROM Ventasgenerales v")
    , @NamedQuery(name = "Ventasgenerales.findByCodigoVenta", query = "SELECT v FROM Ventasgenerales v WHERE v.codigoVenta = :codigoVenta")
    , @NamedQuery(name = "Ventasgenerales.findByFechaVenta", query = "SELECT v FROM Ventasgenerales v WHERE v.fechaVenta = :fechaVenta")})
public class Ventasgenerales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodigoVenta")
    private Integer codigoVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaVenta")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @JoinColumn(name = "ClienteDocumento", referencedColumnName = "Documento")
    @ManyToOne
    private Clientes clienteDocumento;
    @JoinColumn(name = "VehiculoCodigo", referencedColumnName = "Vin")
    @ManyToOne
    private Vehiculos vehiculoCodigo;

    public Ventasgenerales() {
    }

    public Ventasgenerales(Integer codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public Ventasgenerales(Integer codigoVenta, Date fechaVenta) {
        this.codigoVenta = codigoVenta;
        this.fechaVenta = fechaVenta;
    }

    public Integer getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(Integer codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Clientes getClienteDocumento() {
        return clienteDocumento;
    }

    public void setClienteDocumento(Clientes clienteDocumento) {
        this.clienteDocumento = clienteDocumento;
    }

    public Vehiculos getVehiculoCodigo() {
        return vehiculoCodigo;
    }

    public void setVehiculoCodigo(Vehiculos vehiculoCodigo) {
        this.vehiculoCodigo = vehiculoCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoVenta != null ? codigoVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventasgenerales)) {
            return false;
        }
        Ventasgenerales other = (Ventasgenerales) object;
        if ((this.codigoVenta == null && other.codigoVenta != null) || (this.codigoVenta != null && !this.codigoVenta.equals(other.codigoVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.autosconcesionario.entity.Ventasgenerales[ codigoVenta=" + codigoVenta + " ]";
    }
    
}
