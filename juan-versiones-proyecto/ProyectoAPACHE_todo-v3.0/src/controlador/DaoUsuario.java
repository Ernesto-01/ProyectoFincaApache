/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author santos
 */
public class DaoUsuario extends Conexion{
   
   
    
     public void mantenimientoUsuario(int accion,Usuario usu) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_usuario(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);                                
            pre.setInt(2, usu.getIdUsuario());
            pre.setString(3, usu.getNombre());
            pre.setString(4, usu.getApellido());
            pre.setString(5, usu.getNickname());
            pre.setString(6, usu.getPassword());
            pre.setInt(7, usu.getEdad());
            pre.setInt(8, usu.getEstado());
            pre.setString(9, usu.getCorreo());
            pre.setInt(10, usu.getIdRol());    
            pre.setString(11, "");
            pre.executeUpdate();
        } catch(Exception e) {
           throw e; 
        } finally {
            this.desconectar();
        }
    }
    
    public List mostrarUsuario(int buscar) throws Exception {
        List listarusuario=new ArrayList();
        ResultSet res;
        
        try {
            this.conectar();
            String sql="";
            
             if (buscar>0) {
                sql="CALL sp_usuario(11,0,'"+buscar+"','','','',0,0,'',0,'')";
            } else {
               sql="CALL sp_usuario(4,0,'','','','',0,0,'',0,'')";
            }
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while(res.next()){
                                    
                   Usuario usu=new Usuario();
        usu.setIdUsuario(res.getInt("idUsuario"));       
        usu.setNombre(res.getString("nombre"));
        usu.setApellido(res.getString("apellido"));  
        usu.setNickname(res.getString("nickname"));
        usu.setPassword(res.getString("pass"));
        usu.setEdad(res.getInt("edad"));
        usu.setEstado(res.getInt("estado"));
        usu.setCorreo(res.getString("correo"));
        usu.setIdRol(res.getInt("idRol"));                     
                listarusuario.add(usu);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarusuario;
    }
    
      // MOSTRAR ROL PARA COMBO BOX
    public void mostrarRol(JComboBox cmb) {
        ResultSet res;
        try {
            this.conectar();
            String sql = "CALL sp_usuario(5,0,'','','','',0,0,'',0,'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while (res.next()) {
                cmb.addItem(res.getString("nombre"));
            }
            res.close();
            this.desconectar();
        } catch (Exception e) {
            e.toString();
        }
    }
       // OBTENER ID DE rol PARA INSERTAR
    public int mostrarIDRol(String nombre) throws Exception {
        int listarrol;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_usuario(6,0,'','','','',0,0,'',0,'"+nombre+"')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            Usuario us = new Usuario();
            while(res.next()) {
                us.setIdRol(res.getInt("idRol"));
                //us.setPagos(res.getString("salarioDiario"));
            }            
            listarrol=us.getIdRol();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarrol;
    }
    // OBTENER NOMBRE INSUMO CON ID DE LA TABLA PARA MOSTRAR EN COMBO BOX
    public String mostrarNombreRol(int id) throws Exception {
        String listarrol;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_usuario(7,0,'','','','',0,0,'',"+id+",'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            Usuario us = new Usuario();
            while(res.next()) {
               // us.setIdRol(res.getInt("idRol"));
                      
                us.setNombreRol(res.getString("nombre"));
            }            
            listarrol=us.getNombreRol();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarrol;
    }
    
    
}
