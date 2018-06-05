
package controlador;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import modelo.Tablones;

/**
 *
 * @author Xavy
 */
public class CTablones extends Conexion{
     public void mantenimientoTablon(int accion,Tablones pro) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_tablones(?,?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);
            pre.setInt(2, pro.getIdTablones());
            pre.setString(3, pro.getNombre());
            pre.setString(4, pro.getSector());
             pre.setInt(5, pro.getIdFinca());
             pre.setString(6, "");
            pre.executeUpdate();
        } catch(Exception e) {
           throw e; 
        } finally {
            this.desconectar();
        }
    }
    
    public List mostrarTablones() throws Exception {
        List listarTablon=new ArrayList();
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_tablones(4,0,'','',0,'')";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while(res.next()){
                Tablones pro =new Tablones();
                pro.setIdTablones(res.getInt("idTablones"));
                pro.setNombre(res.getString("nombre"));
                pro.setSector(res.getString("sector"));
                 pro.setIdFinca(res.getInt("idFinca"));
                listarTablon.add(pro);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return listarTablon;
    }
    
    
    
    // MOSTRAR tablon PARA COMBO BOX
    public void mostrarTablon(JComboBox cmb) {
        ResultSet res;
        try {
            this.conectar();
            String sql = "CALL sp_tablones(5,0,'','',0,'')";
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
    // OBTENER ID DE tablon PARA INSERTAR
    public int mostrarIDTablones(String nombre) throws Exception {
        int listartablon;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_tablones(6,0,'','',0,'"+nombre+"')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            Tablones ta = new Tablones();
            while(res.next()) {
                ta.setIdFinca(res.getInt("idFinca"));
               // ta.setNombreInsumo(res.getString("nombre"));
            }            
            listartablon=ta.getIdFinca();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listartablon;
    }
    // OBTENER NOMBRE tablon CON ID DE LA TABLA PARA MOSTRAR EN COMBO BOX
    public String mostrarNombreInsumos(int id) throws Exception {
        String listartablon;
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_tablones(6,0,'','',"+id+",'')";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res=pre.executeQuery();            
            Tablones ta = new Tablones();
            while(res.next()) {
                //iu.setIdInsumo(res.getInt("idInsumo"));
                ta.setNombreFinca(res.getString("nombre"));
            }            
            listartablon=ta.getNombreFinca();
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listartablon;
    }
}
