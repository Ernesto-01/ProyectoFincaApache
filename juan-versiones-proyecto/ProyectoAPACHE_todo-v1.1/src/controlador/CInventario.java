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
import modelo.Inventario;


/**
 *
 * @author Alejandro
 */
public class CInventario extends Conexion {
         public void mantenimientoInventario(int accion,Inventario inv) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_inventario(?,?,?,?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);
            pre.setInt(2, inv.getIdInventario());
            pre.setInt(3, inv.getCantidad());
            pre.setDouble(4, inv.getPrecio());
            pre.setInt(5, inv.getEstado());
            pre.setInt(6, inv.getIdFinca());
             pre.setInt(7, inv.getIdProveedor());
            pre.setInt(8, inv.getIdInsumo());
            pre.executeUpdate();
        } catch(Exception e) {
           throw e; 
        } finally {
            this.desconectar();
        }
    }
    
    public List mostrarInventario() throws Exception {
        List listarInventario=new ArrayList();
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_inventario(4,0,0,0,0,0,0,0)";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while(res.next()){
                Inventario inv =new Inventario();
                inv.setIdInventario(res.getInt("idInventario"));
                inv.setCantidad(res.getInt("cantidad"));
                inv.setPrecio(res.getDouble("precio"));
                 inv.setEstado(res.getInt("estado"));
                  inv.setIdFinca(res.getInt("idFinca"));
                  inv.setIdProveedor(res.getInt("idProveedor"));
                   inv.setIdInsumo(res.getInt("idInsumo"));
                listarInventario.add(inv);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarInventario;
    }
}
