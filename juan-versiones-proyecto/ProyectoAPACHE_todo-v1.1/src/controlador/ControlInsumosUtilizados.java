package controlador;

import conexion.Conexion;
import java.sql.*;
import java.util.*;
import javax.swing.JComboBox;
import modelo.InsumosUtilizados;


/**
 * Nombre de la clase: ControlInsumosUtilizados
 * Versión: 
 * Copyright: herrj-ZPDA
 * Fecha: 05-23-2018 - 05:22:45 PM
 * @author JUAN ZEPEDA
 */

public class ControlInsumosUtilizados extends Conexion {

    public void mantenimientoInsumosUtilizados(int accion, InsumosUtilizados iu) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_insumosutilizados(?,?,?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);
            pre.setInt(2, iu.getIdInsumoUtilizados());
            pre.setInt(3, iu.getCantidadUtilizada());
            pre.setInt(4, iu.getIdInsumo());
            pre.setString(5, "");
            pre.setInt(6, iu.getIdTareaDiaria());
            pre.setString(7, "");
            pre.executeUpdate();
        } catch(Exception e) {
           throw e;
        } finally {
            this.desconectar();
        }
    }

    public List mostrarInsumosUtilizados() throws Exception {
        List listarinsumosutilizados=new ArrayList();
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_insumosutilizados(4,0,0,0,'',0,'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while(res.next()) {
                InsumosUtilizados iu = new InsumosUtilizados();
                iu.setIdInsumoUtilizados(res.getInt("idInsumoUtilizados"));
                iu.setCantidadUtilizada(res.getInt("cantidadUtilizada"));
                iu.setIdInsumo(res.getInt("idInsumo"));
                iu.setIdTareaDiaria(res.getInt("idTareaDiaria"));
                listarinsumosutilizados.add(iu);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarinsumosutilizados;
    }
    
    public void mostrarInsumos(JComboBox cmb) {
        ResultSet res;
        try {
            this.conectar();
            String sql = "CALL sp_insumosutilizados(5,0,0,0,'',0,'')";
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
    
    public int mostrarIDInsumos(String nombre) throws Exception {
        int listarinsumos;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_insumosutilizados(6,0,0,0,'"+nombre+"',0,'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            InsumosUtilizados iu = new InsumosUtilizados();
            while(res.next()) {
                iu.setIdInsumo(res.getInt("idInsumo"));
                iu.setNombreInsumo(res.getString("nombre"));
            }            
            listarinsumos=iu.getIdInsumo();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarinsumos;
    }
    
    public String mostrarNombreInsumos(int id) throws Exception {
        String listarinsumos;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_insumosutilizados(7,0,0,"+id+",'',0,'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            InsumosUtilizados iu = new InsumosUtilizados();
            while(res.next()) {
                iu.setIdInsumo(res.getInt("idInsumo"));
                iu.setNombreInsumo(res.getString("nombre"));
            }            
            listarinsumos=iu.getNombreInsumo();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarinsumos;
    }
    
    public void mostrarTareaDiaria(JComboBox cmb) {
        ResultSet res;
        try {
            this.conectar();
            String sql = "CALL sp_insumosutilizados(8,0,0,0,'',0,'')";
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
    
    public int mostrarIDTareaDia(String nombre) throws Exception {
        int listartareadia;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_insumosutilizados(9,0,0,0,'',0,'"+nombre+"')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            InsumosUtilizados iu = new InsumosUtilizados();
            while(res.next()) {
                iu.setIdTareaDiaria(res.getInt("idTareaDiaria"));
                iu.setNombreTarea(res.getString("nombre"));
            }            
            listartareadia=iu.getIdTareaDiaria();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listartareadia;
    }
    
    public String mostrarNombreTareaDia(int id) throws Exception {
        String listartareadia;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_insumosutilizados(10,0,0,0,'',"+id+",'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            InsumosUtilizados iu = new InsumosUtilizados();
            while(res.next()) {
                iu.setIdTareaDiaria(res.getInt("idTareaDiaria"));
                iu.setNombreTarea(res.getString("nombre"));
            }            
            listartareadia=iu.getNombreTarea();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listartareadia;
    }

}
