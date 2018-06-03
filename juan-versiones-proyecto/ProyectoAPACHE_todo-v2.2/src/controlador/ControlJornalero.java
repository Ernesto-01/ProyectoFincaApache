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
import modelo.Jornaleros;

/**
 *
 * @author Alejandro
 */
public class ControlJornalero extends Conexion{
    
     public void mantenimientoJornaleros(int accion, Jornaleros jo) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_jornaleros(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);
            pre.setInt(2, jo.getIdJornalero());
            pre.setString(3, jo.getNombre());
            pre.setString(4, jo.getApellido());
            pre.setInt(5, jo.getEdad());
            pre.setString(6, jo.getHorario());
            pre.setInt(7, jo.getEstado());
            pre.setString(8, jo.getDireccion());
            pre.setInt(9, jo.getIdPagos());
            pre.setDouble(10, 0);
            pre.executeUpdate();
        } catch(Exception e) {
           throw e;
        } finally {
            this.desconectar();
        }
    }

    public List mostrarJornaleros(String buscar) throws Exception {
        List listarjornaleros=new ArrayList();
        ResultSet res;
        String sql="";
        try {
            this.conectar();
            if (!"".equals(buscar)) {
                sql="CALL sp_jornaleros(8,0,'"+buscar+"','',0,'',0,'',0,0)";
            } else {
                sql="CALL sp_jornaleros(4,0,'','',0,'',0,'',0,0)";
            }
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while(res.next()) {
                Jornaleros jo = new Jornaleros();
                jo.setIdJornalero(res.getInt("idJornaleros"));
                jo.setNombre(res.getString("nombre"));
                jo.setApellido(res.getString("apellido"));
                jo.setEdad(res.getInt("edad"));
                
                jo.setHorario(res.getString("horario"));
                jo.setEstado(res.getInt("estado"));
                jo.setDireccion(res.getString("direccion"));
                jo.setIdPagos(res.getInt("idPagos"));
                listarjornaleros.add(jo);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarjornaleros;
    }
    // MOSTRAR PAGOS PARA COMBO BOX
    public void mostrarPagos(JComboBox cmb) {
        ResultSet res;
        try {
            this.conectar();
            String sql = "CALL sp_jornaleros(5,0,'','',0,'',0,'',0,0)";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while (res.next()) {
                cmb.addItem(res.getDouble("salarioDiario"));
            }
            res.close();
            this.desconectar();
        } catch (Exception e) {
            e.toString();
        }
    }
       // OBTENER ID DE PAGOS PARA INSERTAR
    public int mostrarIDPagos(double salario) throws Exception {
        int listarpagos;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_jornaleros(6,0,'','',0,'',0,'',0,"+salario+")";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            Jornaleros jo = new Jornaleros();
            while(res.next()) {
                jo.setIdPagos(res.getInt("idPagos"));
                //jo.setPagos(res.getString("salarioDiario"));
            }            
            listarpagos=jo.getIdPagos();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarpagos;
    }
    // OBTENER NOMBRE INSUMO CON ID DE LA TABLA PARA MOSTRAR EN COMBO BOX
    public double mostrarSalarioDiario(int id) throws Exception {
        double listarpagos;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_jornaleros(7,0,'','',0,'',0,'',"+id+",0)";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            Jornaleros jo = new Jornaleros();
            while(res.next()) {
                jo.setPagos(res.getDouble("salarioDiario"));
            }            
            listarpagos=jo.getPagos();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarpagos;
    }
    
    
    
}
