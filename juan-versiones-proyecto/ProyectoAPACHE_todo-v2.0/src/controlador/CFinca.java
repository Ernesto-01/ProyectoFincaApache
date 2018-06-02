
package controlador;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Finca;

/**
 *
 * @author Xavy
 */
public class CFinca extends Conexion{
     public void mantenimientoFinca(int accion,Finca pro) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_finca(?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);
            pre.setInt(2, pro.getIdFinca());
            pre.setString(3, pro.getNombre());
            pre.setString(4, pro.getDireccion());
             pre.setString(5, pro.getTipoFinca());
            pre.executeUpdate();
        } catch(Exception e) {
           throw e; 
        } finally {
            this.desconectar();
        }
    }
    
    public List mostrarFinca() throws Exception {
        List listarFinca=new ArrayList();
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_finca(4,0,'','','')";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while(res.next()){
                Finca pro =new Finca();
                pro.setIdFinca(res.getInt("idFinca"));
                pro.setNombre(res.getString("nombre"));
                pro.setDireccion(res.getString("direccion"));
                 pro.setTipoFinca(res.getString("tipoFinca"));
                listarFinca.add(pro);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listarFinca;
    }
}
