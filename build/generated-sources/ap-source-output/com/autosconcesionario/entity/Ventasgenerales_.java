package com.autosconcesionario.entity;

import com.autosconcesionario.entity.Clientes;
import com.autosconcesionario.entity.Vehiculos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-03T16:50:53")
@StaticMetamodel(Ventasgenerales.class)
public class Ventasgenerales_ { 

    public static volatile SingularAttribute<Ventasgenerales, Integer> codigoVenta;
    public static volatile SingularAttribute<Ventasgenerales, Clientes> clienteDocumento;
    public static volatile SingularAttribute<Ventasgenerales, Vehiculos> vehiculoCodigo;
    public static volatile SingularAttribute<Ventasgenerales, Date> fechaVenta;

}