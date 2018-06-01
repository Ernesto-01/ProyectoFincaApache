
package controlador;

import conexion.Conexion;
import java.sql.*;
import java.util.*;
import modelo.Jornaleros;
import modelo.Pagos;

/**
 *
 * @author Ernesto
 */
public class CJornalero extends Conexion{
      public void mantenimientoJornaleros(int accion,Jornaleros j) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_jornaleros(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);
            pre.setInt(2, j.getIdJornaleros());
            pre.setString(3, j.getNombre());
            pre.setString(4, j.getApellido());
            pre.setInt(5, j.getEdad());
            pre.setString(6, j.getHorario());
            pre.setInt(7, j.getEstado());
            pre.setString(8, j.getDireccion());
            pre.setInt(9, j.getPagos().getIdPago());
            pre.executeUpdate();
        } catch(Exception e) {
           throw e; 
        } finally {
            this.desconectar();
        }
    }
    
    
    public List mostrarJornaleros() throws Exception {
        List listar=new ArrayList();
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_jornaleros(4,0,'','',0,'',0,'',0)";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while(res.next()){
                Pagos p=new Pagos();             
                p.setIdPago(res.getInt("idPagos"));
                
                Jornaleros j =new Jornaleros(res.getInt("idJornaleros"),
                        res.getString("nombre"), res.getString("apellido"), res.getInt("edad"),
                        res.getString("horario"), res.getInt("estado"), res.getString("direccion"), p);
                
                
                
                listar.add(j);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listar;
    }
}
