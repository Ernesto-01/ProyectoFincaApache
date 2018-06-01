package conexion;

import java.sql.*;


/**
 * Nombre de la clase: Conexion
 * Versión: 
 * Copyright: herrj-ZPDA
 * Fecha: 05-23-2018 - 03:24:20 PM
 * @author JUAN ZEPEDA
 */

public class Conexion {
    
    private Connection con;

    public Conexion() {
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public void conectar() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/finca?user=root&password=");
        } catch(Exception e) {
            throw e;
        }
    }
    
    public void desconectar() throws Exception {
        try {
            if(con!=null){
                if(con.isClosed()==false){
                    con.close();
                }
            }
        } catch(Exception e) {
            throw e;
        }
    }

}
