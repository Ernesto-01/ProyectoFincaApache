/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import modelo.Rol;
import modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santos
 */
public class DaoRol extends Conexion{
   
   
    
     public void mantenimientoRol(int accion,Rol rol) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_rol(?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);                                
            pre.setInt(2, rol.getIdRol());
            pre.setString(3, rol.getNombre());                    
            pre.executeUpdate();
        } catch(Exception e) {
           throw e; 
        } finally {
            this.desconectar();
        }
    }
    
    public List mostrarRol() throws Exception {
        List listarRol=new ArrayList();
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_rol(4,0,'')";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while(res.next()){
                                    
                   Rol rol=new Rol();
        rol.setIdRol(res.getInt("idRol"));       
        rol.setNombre(res.getString("nombre"));
        
                
                listarRol.add(rol);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarRol;
    }
    
}
