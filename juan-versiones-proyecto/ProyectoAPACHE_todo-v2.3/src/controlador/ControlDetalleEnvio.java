
package controlador;

import conexion.Conexion;
import java.sql.*;
import java.util.*;
import javax.swing.JComboBox;
import modelo.DetalleEnvio;


/**
 *
 * @author xavy
 */
public class ControlDetalleEnvio extends Conexion{
     public void mantenimientoDetalleEnvio(int accion,DetalleEnvio dte) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_detalleenvio(?,?,?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);
            pre.setInt(2, dte.getIdDetalleEnvio());
            pre.setInt(3, dte.getCantidadEnvios());
            pre.setInt(4, dte.getIdEnvios());
            pre.setString(5, "");
            pre.setInt(6, dte.getIdInsumo());
            pre.setString(7, "");
         
            pre.executeUpdate();
        } catch(Exception e) {
           throw e; 
        } finally {
            this.desconectar();
        }
    }
    
    public List mostrarDetalleEnvio(int buscar) throws Exception {
        List listarDetalle=new ArrayList();
        ResultSet res;
        String sql = "";
        try {
            this.conectar();
            if (buscar>0) {
                sql="CALL sp_detalleenvio(11,"+buscar+",0,0,0,0,0)";
            } else {
                sql="CALL sp_detalleenvio(4,0,0,0,0,0,0)";
            }
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
    // MOSTRAR ENVIOS PARA COMBO BOX
    public void mostrarEnvios(JComboBox cmb) {
        ResultSet res;
        try {
            this.conectar();
            String sql = "CALL sp_detalleenvio(5,0,0,0,'',0,'')";
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
    // OBTENER ID DE ENVIO PARA INSERTAR
    public int mostrarIDEnvios(String nombre) throws Exception {
        int listarenvios;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_detalleenvio(6,0,0,0,'"+nombre+"',0,'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            DetalleEnvio de = new DetalleEnvio();
            while(res.next()) {
                de.setIdEnvios(res.getInt("idEnvios"));
            }            
            listarenvios=de.getIdEnvios();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarenvios;
    }
    // OBTENER NOMBRE ENVIO CON ID DE LA TABLA PARA MOSTRAR EN COMBO BOX
    public String mostrarNombreEnvio(int id) throws Exception {
        String listarenvio;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_detalleenvio(7,0,0,"+id+",'',0,'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            DetalleEnvio de = new DetalleEnvio();
            while(res.next()) {
                de.setNombreEnvios(res.getString("nombre"));
            }            
            listarenvio=de.getNombreEnvios();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarenvio;
    }
    // MOSTRAR INSUMO PARA COMBO BOX
    public void mostrarInsumo(JComboBox cmb) {
        ResultSet res;
        try {
            this.conectar();
            String sql = "CALL sp_detalleenvio(8,0,0,0,'',0,'')";
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
    // OBTENER ID DE INSUMO PARA INSERTAR
    public int mostrarIDInsumo(String nombre) throws Exception {
        int listarinsumo;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_detalleenvio(9,0,0,0,'',0,'"+nombre+"')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            DetalleEnvio de = new DetalleEnvio();
            while(res.next()) {
                de.setIdInsumo(res.getInt("idInsumo"));
            }            
            listarinsumo=de.getIdInsumo();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarinsumo;
    }
    // OBTENER NOMBRE INSUMO CON ID DE LA TABLA PARA MOSTRAR EN COMBO BOX
    public String mostrarNombreInsumos(int id) throws Exception {
        String listarenvio;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_detalleenvio(10,0,0,0,'',"+id+",'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            DetalleEnvio de = new DetalleEnvio();
            while(res.next()) {
                de.setNombreInsumo(res.getString("nombre"));
            }            
            listarenvio=de.getNombreInsumo();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarenvio;
    }
    
}
