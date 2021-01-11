/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uagrm.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LeoCL
 */
public class ProductoModelo {
    int codigo;
    String nombre;
    int precio;
    int codigo_categoria;

    public ArrayList<ArrayList<String>> listar() {
        Conexion con= new Conexion();
        String sql = "SELECT * FROM producto;" ;
        con.abrirConexion();
        con.precompilarSQL(sql);
        con.ejecutarSQL();
        con.cerrarConexion();
       return convertirToLista(con.getResultadoConsulta());
    }
    
    
    public ArrayList<ArrayList<String>> listarProducto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void crear(int codigo, String nombre, int precio, int codigo_categoria){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.codigo_categoria = codigo_categoria;
        Conexion con = new Conexion();
        String sql = "INSERT INTO producto (codigo,nombre,precio,codigo_categoria) VALUES ('"+this.codigo+"','"+this.nombre+"','"+this.precio+"','"+this.codigo_categoria+"');" ;
        con.abrirConexion();
        con.creteStament();
        con.ejecutarSQL(sql);
    }
    
    public void modificar(int codigo, String nombre, int precio, int codigo_categoria){
        System.out.println("modelo->"+codigo+nombre);
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio= precio;
        this.codigo_categoria = codigo_categoria;
        String sql = " UPDATE producto SET  nombre='"+this.nombre+"', precio='"+this.precio+"', codigo_categoria='"+this.codigo_categoria+"'  WHERE codigo='"+this.codigo+"' "  ;
        Conexion con = new Conexion();
        con.abrirConexion();
        con.creteStament();
        con.ejecutarSQL(sql);

    }
    
    public void eliminar(){
        
    }
    public ArrayList< ArrayList<String> > convertirToLista(ResultSet tablaDatos){
        ArrayList< ArrayList<String> > listaProducto ;
         listaProducto = new ArrayList<>();
        try {
            while (tablaDatos.next()) {
                ArrayList<String> sublist= new ArrayList<>();
                sublist.add( tablaDatos.getString("codigo") );
                sublist.add( tablaDatos.getString("nombre"));
                sublist.add( tablaDatos.getString("precio"));
                sublist.add( tablaDatos.getString("codigo_categoria"));
                System.out.println("sublista"+sublist   );
                listaProducto.add(sublist);  
            }
            return listaProducto;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
     
}
