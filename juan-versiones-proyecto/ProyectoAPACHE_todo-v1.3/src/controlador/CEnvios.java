
package controlador;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Envios;


/**
 *
 * @author Xavy
 */
public class CEnvios extends Conexion {
     public void mantenimientoEnvio(int accion,Envios env) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_envios(?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);
            pre.setInt(2, env.getIdEnvios());
            pre.setString(3, env.getFechaEnvio());
            pre.setString(4, env.getNombreReceptor());
            pre.setInt(5, env.getIdFinca());
            pre.executeUpdate();
        } catch(Exception e) {
           throw e; 
        } finally {
            this.desconectar();
        }
    }
    
    public List mostrarEnvio() throws Exception {
        List listarEnvio=new ArrayList();
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_envios(4,0,'','',0)";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while(res.next()){
                Envios env =new Envios();
                env.setIdEnvios(res.getInt("idEnvios"));
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
}
