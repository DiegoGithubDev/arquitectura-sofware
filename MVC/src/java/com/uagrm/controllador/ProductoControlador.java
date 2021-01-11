/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uagrm.controllador;

import com.uagrm.modelo.ProductoModelo;
import com.uagrm.vista.ProductoVista;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LeoCL
 */
@WebServlet(name = "ProductoControlador", urlPatterns = {"/ProductoControlador"})
public class ProductoControlador extends HttpServlet {
    ProductoVista  productoVista;
    ProductoModelo productoModelo;
    
    public void listar(HttpServletRequest request, HttpServletResponse response){
        productoVista.actualizar(request, response);
    }
    
    public void crear(HttpServletRequest request, HttpServletResponse response){
        int codigo = Integer.parseInt( (request.getParameter("codigo")) ) ;
        String nombre = request.getParameter("nombre");
        int precio = Integer.parseInt( (request.getParameter("precio")) ) ;
        int codigo_categoria = Integer.parseInt( (request.getParameter("codigo_categoria")) );
        productoModelo.crear(codigo, nombre, precio, codigo_categoria);
        productoVista.actualizar(request, response);
    }
    
     public void modificar(HttpServletRequest request, HttpServletResponse response){
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nombre = request.getParameter("nombre");
        int precio =  Integer.parseInt(request.getParameter("precio"));
        int codigo_categoria = Integer.parseInt(request.getParameter("codigo_categoria"));
        productoModelo.modificar(codigo, nombre, precio, codigo_categoria);
        productoVista.actualizar(request, response);
    }
     public void redireccionar(HttpServletRequest request, HttpServletResponse response){
            // request.setAttribute("listaCategoria",listaCategorias);
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            String precio = request.getParameter("precio");
            String codigo_categoria = request.getParameter("codigo_categoria");
            System.out.println(""+codigo+" "+nombre+precio+codigo_categoria);
            request.setAttribute("codigo", codigo);
            request.setAttribute("nombre", nombre);
            request.setAttribute("precio", precio);
            request.setAttribute("codigo_categoria", codigo_categoria);
            productoVista.listarCategoria( request, response);
     }
     
     public void eliminar(HttpServletRequest request, HttpServletResponse response){
         
     }

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductoControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductoControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
       productoModelo = new ProductoModelo();
       productoVista = new ProductoVista();
       String accion = request.getParameter("accion");
        if ( accion == null){
           listar(request,response);
        }else if(accion.equals("crear")){
            crear(request, response);
        }else if( accion.equals("modificar") && request.getMethod().equals("GET")){
            redireccionar(request,response);
        }else if( accion.equals("modificar") && request.getMethod().equals("POST")){
            modificar(request,response);
        }else if( accion.equals("eliminar") ){
            eliminar(request,response);
        }
        
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
        doGet(request, response);
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
