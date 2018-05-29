
package controlador;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Tablones;

/**
 *
 * @author Xavy
 */
public class CTablones extends Conexion{
     public void mantenimientoTablon(int accion,Tablones pro) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_tablones(?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);
            pre.setInt(2, pro.getIdTablones());
            pre.setString(3, pro.getNombre());
            pre.setString(4, pro.getSector());
             pre.setInt(5, pro.getIdFinca());
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
            String sql="CALL sp_tablones(4,0,'','',0)";
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
}
