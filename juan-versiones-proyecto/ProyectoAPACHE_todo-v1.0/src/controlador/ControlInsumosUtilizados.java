package controlador;

import conexion.Conexion;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
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
            String sql="CALL sp_insumosutilizados(?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);
            pre.setInt(2, iu.getIdInsumoUtilizados());
            pre.setInt(3, iu.getCantidadUtilizada());
            pre.setInt(4, iu.getIdInsumo());
            pre.setInt(5, iu.getIdTareaDiaria());
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
            String sql="CALL sp_insumosutilizados(4,0,0,0,0)";
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

}
