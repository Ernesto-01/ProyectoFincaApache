
package com.modelo;

/**
 * Clase:Finca
 * Version:1.0
 * Fecha de creacion:13/5/2018
 * Fecha de modificación:13/5/2018
 * @author Ernesto Rosales
 */
public class Finca {
    //<editor-fold defaultstate="collapsed" desc="Vables globales">
    private int idFinca;
    private String nombre;
    private String direccion;
    private int tipoFinca;
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constrcutores">
    public Finca() {
    }

    public Finca(int idFinca, String nombre, String direccion, int tipoFinca) {
        this.idFinca = idFinca;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipoFinca = tipoFinca;
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ocultacion de datos">

    public int getIdFinca() {
        return idFinca;
    }

    public void setIdFinca(int idFinca) {
        this.idFinca = idFinca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTipoFinca() {
        return tipoFinca;
    }

    public void setTipoFinca(int tipoFinca) {
        this.tipoFinca = tipoFinca;
    }
    //</editor-fold>
    
}
