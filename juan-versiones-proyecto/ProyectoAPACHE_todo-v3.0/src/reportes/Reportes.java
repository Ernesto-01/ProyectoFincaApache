/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Alejandro
 */
public class Reportes extends Conexion{
    
     public String generarDetalleEnvio()
    {
    Connection cn;
    String resultado=null;
        try {
            this.conectar();
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/finca?user=root&password=");
             JasperReport rp=(JasperReport)JRLoader.loadObject(getClass().getResource("/reportes/rDetalleEnvio.jasper"));
             JasperPrint pr=JasperFillManager.fillReport(rp,null,cn);    //fillReport(rp, null,cn);
             JasperViewer view=new JasperViewer(pr,false);
             view.setVisible(true);
             resultado="reporte generado exitosamente";
             
        } catch (Exception e) {
        resultado=e.toString();
        }
        return resultado;
    
    }
      public String generarEnvios()
    {
    Connection cn;
    String resultado=null;
        try {
            this.conectar();
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/finca?user=root&password=");
             JasperReport rp=(JasperReport)JRLoader.loadObject(getClass().getResource("/reportes/rEnvios.jasper"));
             JasperPrint pr=JasperFillManager.fillReport(rp,null,cn);    //fillReport(rp, null,cn);
             JasperViewer view=new JasperViewer(pr,false);
             view.setVisible(true);
             resultado="reporte generado exitosamente";
             
        } catch (Exception e) {
        resultado=e.toString();
        }
        return resultado;
    
    }
       public String generarInsumo()
    {
    Connection cn;
    String resultado=null;
        try {
            this.conectar();
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/finca?user=root&password=");
             JasperReport rp=(JasperReport)JRLoader.loadObject(getClass().getResource("/reportes/rInsumo.jasper"));
             JasperPrint pr=JasperFillManager.fillReport(rp,null,cn);    //fillReport(rp, null,cn);
             JasperViewer view=new JasperViewer(pr,false);
             view.setVisible(true);
             resultado="reporte generado exitosamente";
             
        } catch (Exception e) {
        resultado=e.toString();
        }
        return resultado;
    
    }
        public String generarIsumosU()
    {
    Connection cn;
    String resultado=null;
        try {
            this.conectar();
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/finca?user=root&password=");
             JasperReport rp=(JasperReport)JRLoader.loadObject(getClass().getResource("/reportes/rInsumosUtilizados.jasper"));
             JasperPrint pr=JasperFillManager.fillReport(rp,null,cn);    //fillReport(rp, null,cn);
             JasperViewer view=new JasperViewer(pr,false);
             view.setVisible(true);
             resultado="reporte generado exitosamente";
             
        } catch (Exception e) {
        resultado=e.toString();
        }
        return resultado;
    
    }
         public String generarInventario()
    {
    Connection cn;
    String resultado=null;
        try {
            this.conectar();
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/finca?user=root&password=");
             JasperReport rp=(JasperReport)JRLoader.loadObject(getClass().getResource("/reportes/rInventario.jasper"));
             JasperPrint pr=JasperFillManager.fillReport(rp,null,cn);    //fillReport(rp, null,cn);
             JasperViewer view=new JasperViewer(pr,false);
             view.setVisible(true);
             resultado="reporte generado exitosamente";
             
        } catch (Exception e) {
        resultado=e.toString();
        }
        return resultado;
    
    }
          public String generarJornalero()
    {
    Connection cn;
    String resultado=null;
        try {
            this.conectar();
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/finca?user=root&password=");
             JasperReport rp=(JasperReport)JRLoader.loadObject(getClass().getResource("/reportes/rJornaleros.jasper"));
             JasperPrint pr=JasperFillManager.fillReport(rp,null,cn);    //fillReport(rp, null,cn);
             JasperViewer view=new JasperViewer(pr,false);
             view.setVisible(true);
             resultado="reporte generado exitosamente";
             
        } catch (Exception e) {
        resultado=e.toString();
        }
        return resultado;
    
    }
           public String generarTD()
    {
    Connection cn;
    String resultado=null;
        try {
            this.conectar();
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/finca?user=root&password=");
             JasperReport rp=(JasperReport)JRLoader.loadObject(getClass().getResource("/reportes/rTareaDiaria.jasper"));
             JasperPrint pr=JasperFillManager.fillReport(rp,null,cn);    //fillReport(rp, null,cn);
             JasperViewer view=new JasperViewer(pr,false);
             view.setVisible(true);
             resultado="reporte generado exitosamente";
             
        } catch (Exception e) {
        resultado=e.toString();
        }
        return resultado;
    
    }
          
            
}
