/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uagrm.vista;

import com.uagrm.modelo.CategoriaModelo;
import com.uagrm.modelo.ProductoModelo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diego
 */
public class ProductoVista {
    ProductoModelo  productoModelo; 
    CategoriaModelo categoriaModelo;
    
    public ProductoVista(){
         productoModelo = new ProductoModelo();
         categoriaModelo = new CategoriaModelo();
    } 
    
    public void actualizar(HttpServletRequest request, HttpServletResponse response){  
        try {

            ArrayList< ArrayList<String> > listaProducto = productoModelo.listar();
             ArrayList< ArrayList<String> > listaCategoria = categoriaModelo.listar();
            request.setAttribute("listaCategoria",listaCategoria); 
            request.setAttribute("listaProducto",listaProducto); 
            request.getRequestDispatcher("Producto/index.jsp").forward(request, response);
        } catch (ServletException | IOException ex ) {
            System.out.println(""+ex.getMessage());
            Logger.getLogger(CategoriaVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void listarCategoria(HttpServletRequest request, HttpServletResponse response){
        try {
            ArrayList< ArrayList<String> > listaCategoria = categoriaModelo.listar();
            request.setAttribute("listaCategoria",listaCategoria);
            request.getRequestDispatcher("Producto/modificar.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ProductoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
    
    
}
