/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uagrm.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Conexion {
    String server;
    String database;
    String user;
    String password;
    String driver  ;
    PreparedStatement declaracionSQL;
    Connection conexionDB;
    ResultSet resultadoConsulta;
    Statement statement;
    
    public Conexion(){
        this.driver = "jdbc:postgresql://";
        this.server = "localhost:5432/";
        this.database = "venta";
        this.user = "diego";
        this.password = "DiegoArquitectura";
        this.declaracionSQL = null ;
        this.conexionDB = null ;
        this.resultadoConsulta =null;
        this.statement =null;
        
        
    }
    
    public void abrirConexion(){
         System.out.println("metodo abrir conexion");
        try {
            Class.forName("org.postgresql.Driver");
            this.conexionDB = DriverManager
                    .getConnection( this.driver+this.server+this.database,this.user,this.password);
            System.out.println("Opened database successfully");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
    }
    
    public void cerrarConexion(){
      
        try {
            this.declaracionSQL.close();
            this.conexionDB.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public  void precompilarSQL(String sql) { 
        try {
            PreparedStatement  getPrecompiled = null;
            getPrecompiled = this.conexionDB.prepareStatement(sql);
            this.declaracionSQL = getPrecompiled;
        } catch (SQLException ex) {
            System.out.println("erro precopilarSQL2"+ex.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public void creteStament(){
        try {
            this.statement = this.conexionDB.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    public void  ejecutarSQL() {
        try {
            ResultSet getConsulta = null;
            getConsulta = this.declaracionSQL.executeQuery();
            this.resultadoConsulta = getConsulta;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public void  ejecutarSQL( String sql) {
        try {
            this.statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void abrirConexion2() {
       
        try {
            Class.forName("org.postgresql.Driver");
            this.conexionDB = DriverManager
                    .getConnection( this.driver+this.server+this.database,this.user,this.password);
            System.out.println("Opened database successfully");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
    }
    
    public ResultSet getResultadoConsulta(){
        return this.resultadoConsulta;
    }
    
    public ArrayList< ArrayList<String> > convertirToLista(ResultSet tablaDatos){
         ArrayList< ArrayList<String> > listaResponsable ;
         listaResponsable = new ArrayList<>();
        try {
            while (tablaDatos.next()) {
                ArrayList<String> sublist= new ArrayList<>();
                sublist.add( tablaDatos.getString("codigo") );
                sublist.add( tablaDatos.getString("nombre"));
                System.out.println("sublista"+sublist   );
                listaResponsable.add(sublist);  
            }
            return listaResponsable;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
