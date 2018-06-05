
package controlador;

import conexion.Conexion;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JComboBox;
import modelo.Envios;


/**
 *
 * @author Xavy
 */
public class ControlEnvios extends Conexion {
     public void mantenimientoEnvio(int accion,Envios env) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_envios(?,?,?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);
            pre.setString(2, env.getNombreEnvio());
            pre.setInt(3, env.getIdEnvios());
            pre.setString(4, env.getFechaEnvio());
            pre.setString(5, env.getNombreReceptor());
            pre.setInt(6, env.getIdFinca());
            pre.setString(7, "");
            pre.executeUpdate();
        } catch(Exception e) {
           throw e; 
        } finally {
            this.desconectar();
        }
    }
    
    public List mostrarEnvio(String buscar) throws Exception {
        List listarEnvio=new ArrayList();
        ResultSet res;
        String sql = "";
        try {
            this.conectar();
            if (!"".equals(buscar)) {
                sql = "CALL sp_envios(8,0,'"+buscar+"','','',0,'')";
            } else {
                sql = "CALL sp_envios(4,0,'','','',0,'')";
            }
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while(res.next()){
                Envios env =new Envios();
                env.setIdEnvios(res.getInt("idEnvios"));
                env.setNombreEnvio(res.getString("nombre"));
                env.setFechaEnvio(res.getString("fechaEnvio"));
                env.setNombreReceptor(res.getString("nombreReceptor"));
                env.setIdFinca(res.getInt("idFinca"));
                listarEnvio.add(env);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarEnvio;
    }
    // MOSTRAR FINCA PARA COMBO BOX
    public void mostrarFinca(JComboBox cmb) {
        ResultSet res;
        try {
            this.conectar();
            String sql = "CALL sp_envios(5,0,'','','',0,'')";
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
        int listarenvios;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_envios(6,0,'','','',0,'"+nombre+"')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            Envios en = new Envios();
            while(res.next()) {
                en.setIdEnvios(res.getInt("idFinca"));
            }            
            listarenvios=en.getIdFinca();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarenvios;
    }
    // OBTENER NOMBRE FINCA CON ID DE LA TABLA PARA MOSTRAR EN COMBO BOX
    public String mostrarNombreFinca(int id) throws Exception {
        String listarfinca;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_envios(7,0,'','','',"+id+",'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            Envios en = new Envios();
            while(res.next()) {
                en.setNombreFinca(res.getString("nombre"));
            }            
            listarfinca=en.getNombreFinca();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarfinca;
    }
}
