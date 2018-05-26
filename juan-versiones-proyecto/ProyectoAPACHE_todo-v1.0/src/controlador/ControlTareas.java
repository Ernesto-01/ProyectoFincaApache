package controlador;

import conexion.Conexion;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import modelo.Tareas;


/**
 * Nombre de la clase: ControlTareas
 * Versión: 
 * Copyright: herrj-ZPDA
 * Fecha: 05-23-2018 - 03:44:24 PM
 * @author JUAN ZEPEDA
 */

public class ControlTareas extends Conexion {

    public void mantenimientoTareas(int accion, Tareas ta) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_tareas(?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);
            pre.setInt(2, ta.getIdTarea());
            pre.setString(3, ta.getNombre());
            pre.setString(4, ta.getTipoTarea());
            pre.executeUpdate();
        } catch(Exception e) {
           throw e;
        } finally {
            this.desconectar();
        }
    }

    public List mostrarTareas() throws Exception {
        List listartarea=new ArrayList();
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_tareas(4,0,'','')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while(res.next()) {
                Tareas ta = new Tareas();
                ta.setIdTarea(res.getInt("idTarea"));
                ta.setNombre(res.getString("nombre"));
                ta.setTipoTarea(res.getString("tipoTarea"));
                listartarea.add(ta);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listartarea;
    }

}
