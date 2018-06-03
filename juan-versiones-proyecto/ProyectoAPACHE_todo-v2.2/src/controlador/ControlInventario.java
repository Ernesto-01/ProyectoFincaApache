/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import java.sql.*;
import java.util.*;
import javax.swing.JComboBox;
import modelo.Inventario;


/**
 *
 * @author Alejandro
 */
public class ControlInventario extends Conexion {
         public void mantenimientoInventario(int accion,Inventario inv) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_inventario(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);
            pre.setInt(2, inv.getIdInventario());
            pre.setInt(3, inv.getCantidad());
            pre.setDouble(4, inv.getPrecio());
            pre.setInt(5, inv.getEstado());
            pre.setInt(6, inv.getIdFinca());
            pre.setString(7, inv.getNombreFinca());
            pre.setInt(8, inv.getIdProveedor());
            pre.setString(9, inv.getNombreProveedor());
            pre.setInt(10, inv.getIdInsumo());
            pre.setString(11, inv.getNombreInsumo());
            pre.executeUpdate();
        } catch(Exception e) {
           throw e; 
        } finally {
            this.desconectar();
        }
    }
    
    public List mostrarInventario(int buscar) throws Exception {
        List listarInventario=new ArrayList();
        ResultSet res;
        String sql="";
        try {
            this.conectar();
            if (buscar>0) {
                sql = "CALL sp_inventario(14,"+buscar+",0,0,0,0,'',0,'',0,'')";
            } else {
                sql="CALL sp_inventario(4,0,0,0,0,0,'',0,'',0,'')";
            }
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
    // MOSTRAR FINCA PARA COMBO BOX
    public void mostrarFinca(JComboBox cmb) {
        ResultSet res;
        try {
            this.conectar();
            String sql = "CALL sp_inventario(5,0,0,0,0,0,'',0,'',0,'')";
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
    // OBTENER ID DE FINCA PARA INSERTAR
    public int mostrarIDFinca(String nombre) throws Exception {
        int listarfinca;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_inventario(6,0,0,0,0,0,'"+nombre+"',0,'',0,'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            Inventario in = new Inventario();
            while(res.next()) {
                in.setIdFinca(res.getInt("idFinca"));
            }            
            listarfinca=in.getIdFinca();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarfinca;
    }
    // OBTENER NOMBRE FINCA CON ID DE LA TABLA PARA MOSTRAR EN COMBO BOX
    public String mostrarNombreFinca(int id) throws Exception {
        String listarfinca;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_inventario(7,0,0,0,0,"+id+",'',0,'',0,'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            Inventario in = new Inventario();
            while(res.next()) {
                in.setNombreFinca(res.getString("nombre"));
            }            
            listarfinca=in.getNombreFinca();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarfinca;
    }
    // MOSTRAR PROVEEDOR PARA COMBO BOX
    public void mostrarProveedor(JComboBox cmb) {
        ResultSet res;
        try {
            this.conectar();
            String sql = "CALL sp_inventario(8,0,0,0,0,0,'',0,'',0,'')";
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
    // OBTENER ID DE PROVEEDOR PARA INSERTAR
    public int mostrarIDProveedor(String nombre) throws Exception {
        int listarproveedor;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_inventario(9,0,0,0,0,0,'',0,'"+nombre+"',0,'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            Inventario in = new Inventario();
            while(res.next()) {
                in.setIdProveedor(res.getInt("idProveedor"));
            }            
            listarproveedor=in.getIdProveedor();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarproveedor;
    }
    // OBTENER NOMBRE PROVEEDOR CON ID DE LA TABLA PARA MOSTRAR EN COMBO BOX
    public String mostrarNombreProveedor(int id) throws Exception {
        String listarproveedor;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_inventario(10,0,0,0,0,0,'',"+id+",'',0,'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            Inventario in = new Inventario();
            while(res.next()) {
                in.setNombreProveedor(res.getString("nombre"));
            }            
            listarproveedor=in.getNombreProveedor();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarproveedor;
    }
    // MOSTRAR INSUMOS PARA COMBO BOX
    public void mostrarInsumos(JComboBox cmb) {
        ResultSet res;
        try {
            this.conectar();
            String sql = "CALL sp_inventario(11,0,0,0,0,0,'',0,'',0,'')";
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
    public int mostrarIDInsumos(String nombre) throws Exception {
        int listarinsumos;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_inventario(12,0,0,0,0,0,'',0,'',0,'"+nombre+"')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            Inventario in = new Inventario();
            while(res.next()) {
                in.setIdInsumo(res.getInt("idInsumo"));
            }            
            listarinsumos=in.getIdInsumo();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarinsumos;
    }
    // OBTENER NOMBRE INSUMO CON ID DE LA TABLA PARA MOSTRAR EN COMBO BOX
    public String mostrarNombreInsumos(int id) throws Exception {
        String listarinsumos;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_inventario(13,0,0,0,0,0,'',0,'',"+id+",'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            Inventario in = new Inventario();
            while(res.next()) {
                in.setNombreInsumo(res.getString("nombre"));
            }            
            listarinsumos=in.getNombreInsumo();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarinsumos;
    }
}
