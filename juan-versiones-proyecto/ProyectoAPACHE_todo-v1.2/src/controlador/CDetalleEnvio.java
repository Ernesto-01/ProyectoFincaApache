
package controlador;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.DetalleEnvio;


/**
 *
 * @author xavy
 */
public class CDetalleEnvio extends Conexion{
     public void mantenimientoDetalleEnvio(int accion,DetalleEnvio dte) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_detalleenvio(?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);
            pre.setInt(2, dte.getIdDetalleEnvio());
            pre.setInt(3, dte.getCantidadEnvios());
            pre.setInt(4, dte.getIdEnvios());
            pre.setInt(5, dte.getIdInsumo());
         
            pre.executeUpdate();
        } catch(Exception e) {
           throw e; 
        } finally {
            this.desconectar();
        }
    }
    
    public List mostrarDetalleEnvio() throws Exception {
        List listarDetalle=new ArrayList();
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_detalleenvio(4,0,0,0,0)";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while(res.next()){
               DetalleEnvio dte=new DetalleEnvio();
                dte.setIdDetalleEnvio(res.getInt("idDetalleEnvio"));
                dte.setCantidadEnvios(res.getInt("cantidadEnvios"));
                dte.setIdEnvios(res.getInt("idEnvios"));
                dte.setIdInsumo(res.getInt("idInsumo"));
                listarDetalle.add(dte);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarDetalle;
    }
}
