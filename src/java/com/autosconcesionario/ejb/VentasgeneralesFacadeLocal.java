/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autosconcesionario.ejb;

import com.autosconcesionario.entity.Ventasgenerales;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author W
 */
@Local
public interface VentasgeneralesFacadeLocal {

    void create(Ventasgenerales ventasgenerales);

    void edit(Ventasgenerales ventasgenerales);

    void remove(Ventasgenerales ventasgenerales);

    Ventasgenerales find(Object id);

    List<Ventasgenerales> findAll();

    List<Ventasgenerales> findRange(int[] range);

    int count();
    
}
