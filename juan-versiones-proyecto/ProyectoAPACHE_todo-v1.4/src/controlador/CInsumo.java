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
import modelo.Insumo;


/**
 *
 * @author Alejandro
 */
public class CInsumo extends Conexion {
     public void mantenimientoInsumo(int accion,Insumo isu) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_insumos(?,?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);
            pre.setInt(2, isu.getIdInsumo());
            pre.setString(3, isu.getNombre());
            pre.setString(4, isu.getMedida());
             pre.setDouble(5, isu.getCantidad());
            pre.setInt(6, isu.getIdTipoInsumo());
            pre.executeUpdate();
        } catch(Exception e) {
           throw e; 
        } finally {
            this.desconectar();
        }
    }
    
    public List mostrarInsumo() throws Exception {
        List listarInsumo=new ArrayList();
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_insumos(4,0,'','',0,0)";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while(res.next()){
                Insumo isu =new Insumo();
                isu.setIdInsumo(res.getInt("idInsumo"));
                isu.setNombre(res.getString("nombre"));
                isu.setMedida(res.getString("medida"));
                 isu.setCantidad(res.getDouble("cantidad"));
                  isu.setIdTipoInsumo(res.getInt("idTipoInsumo"));
                listarInsumo.add(isu);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarInsumo;
    }
}
