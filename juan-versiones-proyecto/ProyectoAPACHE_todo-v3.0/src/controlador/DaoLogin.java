
package controlador;
import java.sql.*;
import java.util.*;
import conexion.Conexion;
import modelo.Login;
import modelo.Usuario;

/**
 *
 * @author Rodrigo
 */
public class DaoLogin extends Conexion{
  
   public ArrayList<Login> verificar(Login log) throws Exception
    {
        ResultSet rs;
        ArrayList<Login> datosLogin = new ArrayList();
        try
        {
            this.conectar();
            String sql=("select * from tbl_usuario where nickname='"+log.getNickname()+"' and pass=MD5('"+log.getPasswrd()+"');");
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            rs = pre.executeQuery();
            if(rs.next())
            {
                Login lo = new Login();           
                lo.setNickname(rs.getString("nickname"));
                lo.setPasswrd(rs.getString("pass"));  
                lo.setIdRol(rs.getInt("idRol"));
                datosLogin.add(lo);
            }
        }
        catch(Exception e){
        throw e;
        }
        return datosLogin;
    }
}
