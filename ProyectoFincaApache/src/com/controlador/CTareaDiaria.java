
package com.controlador;

import com.conexion.Conexion;
import com.modelo.Jornaleros;
import com.modelo.Tablones;
import com.modelo.TareaDiaria;
import com.modelo.Tareas;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Ernesto
 */
public class CTareaDiaria extends Conexion {
     public void mantenimientoTareaDiaria(int accion,TareaDiaria tareadiaria) throws Exception {
        try {
            this.conectar();
            //idTareaDiaria, fecha, estado, jornada, porcentajeRealizado, idTarea, idTablones, idJornalero
            String sql="CALL sp_tareadiaria(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);
            
            pre.setInt(2, tareadiaria.getIdTareaDiaria());
            pre.setString(3, tareadiaria.getFecha());
            pre.setInt(4, tareadiaria.getEstado());
            pre.setString(5, tareadiaria.getJornada());
            pre.setString(6, tareadiaria.getPorcentajeRealizado());
            pre.setInt(7, tareadiaria.getTarea().getIdTarea());
            pre.setInt(8, tareadiaria.getTablones().getIdTablones());
            pre.setInt(9, tareadiaria.getJornalero().getIdJornaleros());
            
            
            
            pre.executeUpdate();
        } catch(Exception e) {
           throw e; 
        } finally {
            this.desconectar();
        }
    }
    
    
    public List mostrarTareaDiaria() throws Exception {
        List listar=new ArrayList();
        ResultSet rs;
        
        try {
            this.conectar();
            String sql="CALL sp_tareadiaria(4,0,0,0,'','',0,0,0)";
            
            PreparedStatement pre=this.getCon().prepareCall(sql);
            rs=pre.executeQuery();
            while(rs.next()){
                Tareas tarea=new Tareas();
                tarea.setIdTarea(rs.getInt("idTarea"));
                
                Tablones tablon=new Tablones();
                tablon.setIdTablones(rs.getInt("idTablones"));
                
                Jornaleros jornalero=new Jornaleros();
                jornalero.setIdJornaleros(rs.getInt("idJornalero"));
                
                TareaDiaria td=new TareaDiaria();
                //idTareaDiaria, fecha, estado, jornada, porcentajeRealizado, idTarea, idTablones, idJornalero
                //p.setIdPago(res.getInt("idPagos"));
                td.setIdTareaDiaria(rs.getInt("idTareaDiaria"));
                td.setFecha(rs.getString("fecha"));
                td.setEstado(rs.getInt("estado"));
                td.setJornada(rs.getString("jornada"));
                td.setPorcentajeRealizado(rs.getString("porcentajeRealizado"));
                td.setTarea(tarea);
                td.setTablones(tablon);
                td.setJornalero(jornalero);
                
                
                listar.add(td);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            this.desconectar();
        }
                
        return listar;
    }
}