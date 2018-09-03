/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autosconcesionario.servlet;

import com.autosconcesionario.ejb.ClientesFacadeLocal;
import com.autosconcesionario.ejb.VehiculosFacadeLocal;
import com.autosconcesionario.ejb.VentasgeneralesFacadeLocal;
import com.autosconcesionario.entity.Clientes;
import com.autosconcesionario.entity.Vehiculos;
import com.autosconcesionario.entity.Ventasgenerales;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cesar Benavidez
 */
public class ControllerServlet extends HttpServlet {
        @EJB
    private VentasgeneralesFacadeLocal ventasgeneralesFacade;
    @EJB
    private VehiculosFacadeLocal vehiculoFacade;
    @EJB
    
    
    
    private ClientesFacadeLocal clientesFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
          
            String action =request.getParameter("action");
            String url="listaVentas.jsp";
            
          
            
             if("clientes".equals(action))
             {
                 url="clientes.jsp";
                 Clientes cliente=new Clientes();
                 cliente.setDocumento(request.getParameter("documento"));
                 cliente.setNombres(request.getParameter("nombres"));
                 cliente.setApellidos(request.getParameter("apellidos"));
                 cliente.setCorreo(request.getParameter("correo"));
                 cliente.setTelefono(request.getParameter("telefono"));
                 clientesFacade.create(cliente);
             }
             else if("vehiculos".equals(action))
             {
                 url="vehiculos.jsp";
                 Vehiculos vehiculo=new Vehiculos();
                 vehiculo.setNombreVehiculo(request.getParameter("nombreVehiculos"));
                 vehiculo.setModelo(request.getParameter("modelo"));
                 vehiculo.setColor(request.getParameter("color"));
                 vehiculo.setFabricante(request.getParameter("marca"));
                 vehiculo.setImagen("imagen");
                 vehiculoFacade.create(vehiculo);   
             }
             
             else if("ventas".equals(action))
             {
                 url="Ventas.jsp";
                 Ventasgenerales ventas=new Ventasgenerales();
                 String fecha=request.getParameter("fechaVenta");                 
                  DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
//            fechaDate = formato.
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
                 
                 ventas.setFechaVenta(fechaDate);
                 
                 Clientes cliente=new Clientes();
                 cliente.setDocumento(request.getParameter("cliente"));                 
                 Vehiculos vehiculo=new Vehiculos();
                 vehiculo.setVin(request.getParameter("vehiculo"));
                 ventas.setClienteDocumento(cliente);
                 ventas.setVehiculoCodigo(vehiculo);
                 ventasgeneralesFacade.create(ventas);
             }
             else if("listaVentas".equals(action))
             {
                 //List<Ventasgenerales>findAll=ventasgeneralesFacade.findAll();
                 //request.getSession().setAttribute("ventas",findAll);                
                 //url="listaVentas.jsp";
                 
                 
                List<Ventasgenerales> findAll =ventasgeneralesFacade.findAll();
                request.getSession().setAttribute("ventas",findAll);
                url="listaVentas.jsp";
             }
             response.sendRedirect(url);
        }
        
        finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
