/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uagrm.vista;

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
public class CategoriaVista {
    
    public void listarCategoria(HttpServletRequest request, HttpServletResponse response, ArrayList< ArrayList<String> > listaCategorias){
        try {
            request.setAttribute("listaCategoria",listaCategorias); 
            request.getRequestDispatcher("Categoria/index.jsp").forward(request, response);
        } catch (ServletException | IOException ex ) {
            System.out.println(""+ex.getMessage());
            Logger.getLogger(CategoriaVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
