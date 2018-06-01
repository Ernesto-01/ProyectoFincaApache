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
import modelo.TipoInsumo;


/**
 *
 * @author Alejandro
 */
public class CTipoInsumo extends Conexion{
     public void mantenimientoTipoInsumo(int accion,TipoInsumo tii) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_tipoinsumo(?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);
            pre.setInt(2, tii.getIdTipoInsumo());
            pre.setString(3, tii.getNombre());
         
            pre.executeUpdate();
        } catch(Exception e) {
           throw e; 
        } finally {
            this.desconectar();
        }
    }
    
    public List mostrarTipoInsumo() throws Exception {
        List listarTipo=new ArrayList();
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_tipoinsumo(4,0,'')";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while(res.next()){
               TipoInsumo tii=new TipoInsumo();
                tii.setIdTipoInsumo(res.getInt("idTipoInsumo"));
                tii.setNombre(res.getString("nombre"));
                
                listarTipo.add(tii);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarTipo;
    }
}
