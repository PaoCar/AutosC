/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autosconcesionario.ejb;

import com.autosconcesionario.entity.Ventasgenerales;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author W
 */
@Stateless
public class VentasgeneralesFacade extends AbstractFacade<Ventasgenerales> implements VentasgeneralesFacadeLocal {

    @PersistenceContext(unitName = "AutosConcesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentasgeneralesFacade() {
        super(Ventasgenerales.class);
    }
    
}
