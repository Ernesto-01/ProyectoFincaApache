/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Proveedor;

/**
 *
 * @author Alejandro
 */
public class CProveedor extends Conexion{
     public void mantenimientoProveedor(int accion,Proveedor pro) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_proveedores(?,?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);
            pre.setInt(2, pro.getIdProveedor());
            pre.setString(3, pro.getNombre());
            pre.setString(4, pro.getDireccion());
             pre.setString(5, pro.getTelefono());
            pre.setString(6, pro.getCorreo());
            pre.executeUpdate();
        } catch(Exception e) {
           throw e; 
        } finally {
            this.desconectar();
        }
    }
    
    public List mostrarProveedor() throws Exception {
        List listarProveedor=new ArrayList();
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_proveedores(4,0,'','','','')";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while(res.next()){
                Proveedor pro =new Proveedor();
                pro.setIdProveedor(res.getInt("idProveedor"));
                pro.setNombre(res.getString("nombre"));
                pro.setDireccion(res.getString("direccion"));
                 pro.setTelefono(res.getString("telefono"));
                  pro.setCorreo(res.getString("correo"));
                listarProveedor.add(pro);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarProveedor;
    }
}
