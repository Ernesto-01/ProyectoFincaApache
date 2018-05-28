/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase:Conexion
 * Version:1.0
 * Fecha de creacion:13/5/2018
 * Fecha de modificación:13/05/2018
 * @author Ernesto Rosales
 */
public class Conexion {
    
    //<editor-fold defaultstate="collapsed" desc="varialbes globales">
    Connection con;
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructores">
    public Conexion() {
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getter y setter">
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodos">
   public void conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/finca2018", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void desconectar(){
        try {
            if(con!=null){
                if(con.isClosed()==false){
                    con.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//</editor-fold>
    
}
