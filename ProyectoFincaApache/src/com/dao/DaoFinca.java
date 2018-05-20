
package com.dao;

import com.conexion.Conexion;
import com.modelo.Finca;
import java.util.*;
import java.sql.*;

/**
 * Clase:DaoFinca
 * Version:1.0
 * Fecha de creacion:13/5/2018
 * Fecha de modificación:13/5/2018
 * @author Ernesto Rosales
 */
public class DaoFinca extends Conexion{
    //<editor-fold defaultstate="collapsed" desc="insertar">
    public void incertarFinca(Finca f) throws Exception{
        this.conectar();
        try {
            String sql="insert into tbl_finca values(?,?,?,?)";
            PreparedStatement ps=this.getCon().prepareStatement(sql);
           
            ps.setInt(1, f.getIdFinca());
            ps.setString(2, f.getNombre());
            ps.setString(3, f.getDireccion());
            ps.setInt(4, f.getTipoFinca());
            
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error al insertar en Finca");
        }
        finally{
            this.desconectar();
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="eliminar">
    public void eliminarFinca(Finca f) throws Exception{
        this.conectar();
        try {
            String sql="delete from tbl_finca where idFinca=? ";
            PreparedStatement ps=this.getCon().prepareStatement(sql);
           
            ps.setInt(1, f.getIdFinca());
            
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar en Finca");
        }
        finally{
            this.desconectar();
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="modificar">
    public void modificarFinca(Finca f) throws Exception{
        this.conectar();
        try {
            
            String sql="update tbl_finca set nombre=?, direccion=?, tipoFinca=? where idFinca=? ";
            PreparedStatement ps=this.getCon().prepareStatement(sql);
           
            ps.setString(1, f.getNombre());
            ps.setString(2, f.getDireccion());
            ps.setInt(3, f.getTipoFinca());
            ps.setInt(4, f.getIdFinca());
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error al modificar en Finca");
        }
        finally{
            this.desconectar();
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Mostrar producto">
    public List mostrarFinca(){       
        this.conectar();
        Finca f;
        
        ResultSet rs;
        List listaFinca=new ArrayList<>();
        try {
            String sql="select * from tbl_finca";
            PreparedStatement ps=this.getCon().prepareStatement(sql);
            rs=ps.executeQuery();
            
            while (rs.next()) {     
                 f=new Finca(rs.getInt("idFinca"),
                                        rs.getString("nombre"),
                                        rs.getString("direccion"),
                                        rs.getInt("tipoFinca")
                                        );
               
                listaFinca.add(f);
               
                
            }
            
        } catch (SQLException e) {
            System.out.println("Error al mostrar en el DaoFinca");
        }finally{
            this.desconectar();
        }
        return listaFinca;
    }
        
//</editor-fold>
    
}
