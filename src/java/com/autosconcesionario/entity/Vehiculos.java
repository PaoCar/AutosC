/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autosconcesionario.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author W
 */
@Entity
@Table(name = "vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculos.findAll", query = "SELECT v FROM Vehiculos v")
    , @NamedQuery(name = "Vehiculos.findByVin", query = "SELECT v FROM Vehiculos v WHERE v.vin = :vin")
    , @NamedQuery(name = "Vehiculos.findByNombreVehiculo", query = "SELECT v FROM Vehiculos v WHERE v.nombreVehiculo = :nombreVehiculo")
    , @NamedQuery(name = "Vehiculos.findByModelo", query = "SELECT v FROM Vehiculos v WHERE v.modelo = :modelo")
    , @NamedQuery(name = "Vehiculos.findByColor", query = "SELECT v FROM Vehiculos v WHERE v.color = :color")
    , @NamedQuery(name = "Vehiculos.findByFabricante", query = "SELECT v FROM Vehiculos v WHERE v.fabricante = :fabricante")
    , @NamedQuery(name = "Vehiculos.findByImagen", query = "SELECT v FROM Vehiculos v WHERE v.imagen = :imagen")
    , @NamedQuery(name = "Vehiculos.findByPrecio", query = "SELECT v FROM Vehiculos v WHERE v.precio = :precio")})
public class Vehiculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Vin")
    private String vin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NombreVehiculo")
    private String nombreVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Color")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Fabricante")
    private String fabricante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Imagen")
    private String imagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO")
    private float precio;
    @OneToMany(mappedBy = "vehiculoCodigo")
    private List<Ventasgenerales> ventasgeneralesList;

    public Vehiculos() {
    }

    public Vehiculos(String vin) {
        this.vin = vin;
    }

    public Vehiculos(String vin, String nombreVehiculo, String modelo, String color, String fabricante, String imagen, float precio) {
        this.vin = vin;
        this.nombreVehiculo = nombreVehiculo;
        this.modelo = modelo;
        this.color = color;
        this.fabricante = fabricante;
        this.imagen = imagen;
        this.precio = precio;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getNombreVehiculo() {
        return nombreVehiculo;
    }

    public void setNombreVehiculo(String nombreVehiculo) {
        this.nombreVehiculo = nombreVehiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<Ventasgenerales> getVentasgeneralesList() {
        return ventasgeneralesList;
    }

    public void setVentasgeneralesList(List<Ventasgenerales> ventasgeneralesList) {
        this.ventasgeneralesList = ventasgeneralesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vin != null ? vin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculos)) {
            return false;
        }
        Vehiculos other = (Vehiculos) object;
        if ((this.vin == null && other.vin != null) || (this.vin != null && !this.vin.equals(other.vin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.autosconcesionario.entity.Vehiculos[ vin=" + vin + " ]";
    }
    
}
