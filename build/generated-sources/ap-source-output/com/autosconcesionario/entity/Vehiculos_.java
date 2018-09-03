package com.autosconcesionario.entity;

import com.autosconcesionario.entity.Ventasgenerales;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-03T16:50:53")
@StaticMetamodel(Vehiculos.class)
public class Vehiculos_ { 

    public static volatile ListAttribute<Vehiculos, Ventasgenerales> ventasgeneralesList;
    public static volatile SingularAttribute<Vehiculos, Float> precio;
    public static volatile SingularAttribute<Vehiculos, String> color;
    public static volatile SingularAttribute<Vehiculos, String> nombreVehiculo;
    public static volatile SingularAttribute<Vehiculos, String> imagen;
    public static volatile SingularAttribute<Vehiculos, String> vin;
    public static volatile SingularAttribute<Vehiculos, String> fabricante;
    public static volatile SingularAttribute<Vehiculos, String> modelo;

}