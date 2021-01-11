/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uagrm.controllador;

import com.uagrm.modelo.CategoriaModelo;
import com.uagrm.vista.CategoriaVista;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diego
 */
@WebServlet(name = "CategoriaControlador", urlPatterns = {"/CategoriaControlador"})
public class CategoriaControlador extends HttpServlet {
    
    CategoriaModelo categoriaModel;
    CategoriaVista categoriaVista;
    
    public void listarCategorias(HttpServletRequest request, HttpServletResponse response){
        categoriaVista.listarCategoria(request, response, categoriaModel.listarCategoria());
    }
    public void crear(HttpServletRequest request, HttpServletResponse response){
        int codigo = Integer.parseInt( (request.getParameter("codigo")) ) ;
        String nombre = request.getParameter("nombre");
        categoriaModel.crear(codigo,nombre);
        ArrayList<ArrayList<String>> listaCategorias = categoriaModel.listarCategoria();
        categoriaVista.listarCategoria(request, response, listaCategorias);  
    }
    public void redireccionar(HttpServletRequest request, HttpServletResponse response){
        try {
            // request.setAttribute("listaCategoria",listaCategorias);
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            System.out.println(""+codigo+" "+nombre);
            request.setAttribute("codigo", codigo);
            request.setAttribute("nombre", nombre);
            request.getRequestDispatcher("Categoria/modificar.jsp").forward(request, response);   
        } catch (ServletException  | IOException ex) {
            Logger.getLogger(CategoriaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificar(HttpServletRequest request, HttpServletResponse response){
        int codigo = Integer.parseInt( request.getParameter("codigo") );
        String nombre = request.getParameter("nombre");
        System.out.println("controlador"+codigo+nombre);
        categoriaModel.modificar(codigo, nombre);
        ArrayList<ArrayList<String>> listaCategorias = categoriaModel.listarCategoria();
        categoriaVista.listarCategoria(request, response, listaCategorias);
        
    }
    public void eliminar(HttpServletRequest request, HttpServletResponse response){
        int codigo = Integer.parseInt( request.getParameter("codigo") );
        categoriaModel.eliminar(codigo);
        ArrayList<ArrayList<String>> listaCategorias = categoriaModel.listarCategoria();
        categoriaVista.listarCategoria(request, response, listaCategorias);
        
    }
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Categoria</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Categoria at " + request.getContextPath() + "</h1>");
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
       categoriaModel = new CategoriaModelo();
       categoriaVista = new CategoriaVista();
       String accion = request.getParameter("accion");
        if ( accion == null){
           listarCategorias(request,response);
        }else if(accion.equals("crear")){
            crear(request, response);
        }else if( accion.equals("modificar") && request.getMethod().equals("GET")){
            redireccionar(request,response);
        }else if( accion.equals("modificar") && request.getMethod().equals("POST")){
            modificar(request,response);
        }else if( accion.equals("eliminar") ){
            eliminar(request,response);
        }
       // dispatcher.forward(request, response);
         
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
       // processRequest(request, response);
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
