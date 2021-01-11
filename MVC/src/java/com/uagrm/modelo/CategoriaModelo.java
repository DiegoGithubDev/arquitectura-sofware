/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uagrm.modelo;

import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class CategoriaModelo {
    int codigo;
    String nombre;
    
    public CategoriaModelo(){
    
    }
    
    public ArrayList< ArrayList<String> > listarCategoria(){
        Conexion con= new Conexion();
        String sql = "SELECT * FROM categoria;" ;
        con.abrirConexion();
        con.precompilarSQL(sql);
        con.ejecutarSQL();
        con.cerrarConexion();
       return con.convertirToLista(con.getResultadoConsulta()); 
    }
    
    public ArrayList< ArrayList<String> > listar(){
        Conexion con= new Conexion();
        String sql = "SELECT * FROM categoria;" ;
        con.abrirConexion();
        con.precompilarSQL(sql);
        con.ejecutarSQL();
        con.cerrarConexion();
       return con.convertirToLista(con.getResultadoConsulta()); 
    }
    public ArrayList< ArrayList<String> > listarCategoria(int id){
        ArrayList< ArrayList<String> > listaResponsables= new ArrayList<>();
        return listaResponsables;
    }

    public void crear(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        Conexion con = new Conexion();
        String sql = "INSERT INTO categoria (codigo,nombre) VALUES ('"+this.codigo+"','"+this.nombre+"');" ;
        con.abrirConexion();
        con.creteStament();
        con.ejecutarSQL(sql);
    }
    
    public void modificar(int codigo, String nombre){
        System.out.println("modelo->"+codigo+nombre);
        this.codigo = codigo;
        this.nombre = nombre;
        String sql = " UPDATE categoria SET  nombre='"+this.nombre+"'  WHERE codigo='"+this.codigo+"' "  ;
        Conexion con = new Conexion();
        con.abrirConexion();
        con.creteStament();
        con.ejecutarSQL(sql);
    
    }
    
    public void eliminar(int codigo){
        this.codigo = codigo;
        String sql = "DELETE from categoria where codigo = '"+this.codigo+"';";
        Conexion con = new Conexion();
        con.abrirConexion();
        con.creteStament();
        con.ejecutarSQL(sql);
        
    }
    
    
}
