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

/**
 *
 * @author santos
 */
public class DaoUsuario extends Conexion{
   
   
    
     public void mantenimientoUsuario(int accion,Usuario usu) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_usuario(?,?,?,?,?,?,?,?,?,?)";
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
            pre.executeUpdate();
        } catch(Exception e) {
           throw e; 
        } finally {
            this.desconectar();
        }
    }
    
    public List mostrarUsuario() throws Exception {
        List listarusuario=new ArrayList();
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_usuario(4,0,'','','','',0,0,'',0)";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while(res.next()){
                                    
                   Usuario usu=new Usuario();
        usu.setIdUsuario(res.getInt("idUsuario"));       
        usu.setNombre(res.getString("nombre"));
        usu.setApellido(res.getString("apellido"));  
        usu.setNickname(res.getString("nickname"));
        usu.setPassword(res.getString("password"));
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
    
}
