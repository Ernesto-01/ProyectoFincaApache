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
import javax.swing.JComboBox;
import modelo.TareaDiaria;

/**
 *
 * @author Alejandro
 */
public class ControlTareaDiaria  extends Conexion{
   public void mantenimientoTareaDiaria(int accion, TareaDiaria td) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_tareadiaria(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);
            pre.setInt(2, td.getIdTareaDiaria());
            pre.setString(3, td.getFecha());
            pre.setInt(4, td.getEstado());
            
            pre.setString(5, td.getJornada());
            pre.setString(6,  td.getPorcentajeRealizado());
            pre.setInt(7, td.getIdTarea());
            pre.setString(8, "");
            pre.setInt(9,  td.getIdTablones());
            pre.setString(10, "");
            pre.setInt(11, td.getIdJornalero());
            pre.setString(12,  "");
            pre.executeUpdate();
        } catch(Exception e) {
           throw e;
        } finally {
            this.desconectar();
        }
    }

    public List mostrarTareaDiaria(int buscar) throws Exception {
        List listarjornaleros=new ArrayList();
        ResultSet res;
        String sql="";
        try {
            this.conectar();
            if (buscar>0) {
                sql="CALL sp_tareadiaria(14,"+buscar+",0,0,'',0,'')";
            } else {
                sql="CALL sp_tareadiaria(4,0,'',0,'','',0,'',0,'',0,'')";
            }
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while(res.next()) {
                TareaDiaria td = new TareaDiaria();
                td.setIdTareaDiaria(res.getInt("idTareaDiaria"));
                td.setFecha(res.getString("fecha"));
                td.setEstado(res.getInt("estado"));
                td.setJornada(res.getString("jornada"));
                 td.setPorcentajeRealizado(res.getString("porcentajeRealizado"));
                td.setIdTarea(res.getInt("idTarea"));
                td.setIdTablones(res.getInt("idTablones"));
                td.setIdJornalero(res.getInt("idJornalero"));
               
                listarjornaleros.add(td);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarjornaleros;
    }
    // MOSTRAR Tarea PARA COMBO BOX
    public void mostrarTarea(JComboBox cmb) {
        ResultSet res;
        try {
            this.conectar();
            String sql = "CALL sp_tareadiaria(5,0,0,0,'',0,'')";
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
    public int mostrarIDTarea(String nombre) throws Exception {
        int listartarea;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_tareadiaria(6,0,0,0,'"+nombre+"',0,'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            TareaDiaria td = new TareaDiaria();
            while(res.next()) {
                td.setIdTarea(res.getInt("idTarea"));
                td.setNombreTarea(res.getString("nombre"));
            }            
            listartarea=td.getIdTarea();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listartarea;
    }
    // OBTENER NOMBRE INSUMO CON ID DE LA TABLA PARA MOSTRAR EN COMBO BOX
    public String mostrarNombreTarea(int id) throws Exception {
        String listartarea;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_tareadiaria(7,0,0,"+id+",'',0,'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            TareaDiaria td = new TareaDiaria();
            while(res.next()) {
                td.setIdTarea(res.getInt("idTarea"));
                td.setNombreTarea(res.getString("nombre"));
            }            
            listartarea=td.getNombreTarea();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listartarea;
    }
    // MOSTRAR Tablones PARA COMBO BOX
    public void mostrarTabones(JComboBox cmb) {
        ResultSet res;
        try {
            this.conectar();
            String sql = "CALL sp_tareadiaria(8,0,0,0,'',0,'')";
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
    // OBTENER id TABLON PARA INSERTAR
    public int mostrarIDTablon(String nombre) throws Exception {
        int listartablon;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_tareadiaria(9,0,0,0,'',0,'"+nombre+"')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            TareaDiaria td = new TareaDiaria();
            while(res.next()) {
                td.setIdTablones(res.getInt("idTabones"));
                td.setNombreTablon(res.getString("nombre"));
            }            
            listartablon=td.getIdTablones();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listartablon;
    }
    // OBTENER NOMBRE POR ID DE LA TABLA PARA MOSTRAR EN COMBO BOX
    public String mostrarNombreTablon(int id) throws Exception {
        String listartablon;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_tareadiaria(10,0,0,0,'',"+id+",'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            TareaDiaria td= new TareaDiaria();
            while(res.next()) {
                td.setIdTablones(res.getInt("idTablon"));
                td.setNombreTablon(res.getString("nombre"));
            }            
            listartablon=td.getNombreTablon();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listartablon;
    }
  
    
    // MOSTRAR Tarea PARA COMBO BOX
    public void mostrarJornalero(JComboBox cmb) {
        ResultSet res;
        try {
            this.conectar();
            String sql = "CALL sp_tareadiaria(5,0,0,0,'',0,'')";
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
    public int mostrarIDJornalero(String nombre) throws Exception {
        int listarjornalero;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_tareadiaria(6,0,0,0,'"+nombre+"',0,'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            TareaDiaria td = new TareaDiaria();
            while(res.next()) {
                td.setIdJornalero(res.getInt("idJornalero"));
                td.setNombreJornalero(res.getString("nombre"));
            }            
            listarjornalero=td.getIdTarea();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarjornalero;
    }
    // OBTENER NOMBRE INSUMO CON ID DE LA TABLA PARA MOSTRAR EN COMBO BOX
    public String mostrarNombreJornalero(int id) throws Exception {
        String listarjornalero;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_tareadiaria(7,0,0,"+id+",'',0,'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            TareaDiaria td = new TareaDiaria();
            while(res.next()) {
                td.setIdJornalero(res.getInt("idJornalero"));
                td.setNombreJornalero(res.getString("nombre"));
            }            
            listarjornalero=td.getNombreTarea();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarjornalero;
    }
    
}
