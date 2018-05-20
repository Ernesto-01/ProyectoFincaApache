
package com.modelo;

/**
 *
 * @author Alejandro
 */
public class Isumo {
    private int idInsumo;
    private String nombre;
    private String medida;
    private int cantidad;
    private int idTipoInsumo;

    public Isumo() {
    }

    public Isumo(int idInsumo, String nombre, String medida, int cantidad, int idTipoInsumo) {
        this.idInsumo = idInsumo;
        this.nombre = nombre;
        this.medida = medida;
        this.cantidad = cantidad;
        this.idTipoInsumo = idTipoInsumo;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdTipoInsumo() {
        return idTipoInsumo;
    }

    public void setIdTipoInsumo(int idTipoInsumo) {
        this.idTipoInsumo = idTipoInsumo;
    }
   
}
