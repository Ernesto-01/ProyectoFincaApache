
package com.controlador;

import com.conexion.Conexion;
import java.sql.*;
import java.util.*;
import com.modelo.Pagos;

/**
 *
 * @author Ernesto
 */
public class CPagos extends Conexion {
    public void mantenimientoPago(int accion,Pagos p) throws Exception {
        try {
            this.conectar();
            String sql="CALL sp_pagos(?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, accion);
            pre.setInt(2, p.getIdPago());
            pre.setDouble(3, p.getSalario());
            pre.executeUpdate();
        } catch(Exception e) {
           throw e; 
        } finally {
            this.desconectar();
        }
    }
    
    
    public List mostrarProveedor() throws Exception {
        List listar=new ArrayList();
        ResultSet res;
        
        try {
            this.conectar();
            String sql="CALL sp_pagos(4,0,0)";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res=pre.executeQuery();
            while(res.next()){
                Pagos p =new Pagos();
                p.setIdPago(res.getInt("idPagos"));
                p.setSalario(res.getDouble("salarioDiario"));
                listar.add(p);
                
            }
        } catch(Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
                
        return listar;
    }
}
