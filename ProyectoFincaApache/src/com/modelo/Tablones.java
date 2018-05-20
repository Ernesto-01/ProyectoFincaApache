
package com.modelo;

/**
 * Clase:Tablones
 * Version:1.0
 * Fecha de creacion:20/5/2018
 * Fecha de modificación:20/5/2018
 * @author Ernesto Rosales
 */
public class Tablones {
    private int idTablones;
    private String nombre;
    private String sector;
    private Finca finca;

    public Tablones() {
    }

    public Tablones(int idTablones, String nombre, String sector, Finca finca) {
        this.idTablones = idTablones;
        this.nombre = nombre;
        this.sector = sector;
        this.finca = finca;
    }

    public int getIdTablones() {
        return idTablones;
    }

    public void setIdTablones(int idTablones) {
        this.idTablones = idTablones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Finca getFinca() {
        return finca;
    }

    public void setFinca(Finca finca) {
        this.finca = finca;
    }
    
    
}
