/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autosconcesionario.ejb;

import com.autosconcesionario.entity.Clientes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author W
 */
@Stateless
public class ClientesFacade extends AbstractFacade<Clientes> implements ClientesFacadeLocal {

    @PersistenceContext(unitName = "AutosConcesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientesFacade() {
        super(Clientes.class);
    }

    @Override
    public void InsertarCliente(final String Documento, String Nombre, String Apellidos, String Correo, String Telefono) {
        //em.createQuery("INSERT INTO clientes(Documento, Nombres, Apellidos, Correo, Telefono) values()");
//        Query query = "insert into clientes values(?,?,?,?,?)";
//        em.createNativeQuery(query).setParameter(1, Documento);
//        em.createNativeQuery(query).setParameter(2, Nombre);
//        em.createNativeQuery(query).setParameter(3, Apellidos);
//        em.createNativeQuery(query).setParameter(4, Correo);
//        em.createNativeQuery(query).setParameter(5, Telefono);
//        System.out.println(Documento);
//        System.out.println(Nombre);
//
//        em.createQuery("insert into clientes values(?,?,?,?,?)");
//        query
        Query query= em.createNamedQuery("INSERT INTO clientes(Documento, Nombres, Apellidos, Correo, Telefono)" + "values(?,?,?,?,?)");
        query.setParameter(1, Documento);
        query.setParameter(2, Nombre);
        query.setParameter(3, Apellidos);
        query.setParameter(4, Correo);
        query.setParameter(5, Telefono);
        
        query.executeUpdate();

            
    }

}
