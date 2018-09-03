/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autosconcesionario.ejb;

import com.autosconcesionario.entity.Clientes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author W
 */
@Local
public interface ClientesFacadeLocal {

    void create(Clientes clientes);

    void edit(Clientes clientes);

    void remove(Clientes clientes);

    Clientes find(Object id);

    List<Clientes> findAll();

    List<Clientes> findRange(int[] range);

    int count();

    void InsertarCliente(final String Documento,  String Nombre, String Apellidos, String correo, String Telefono);
    
}
