/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Alejandro
 */
public class Insumo {
    private int idInsumo;
    private String nombre;
    private String medida;
    private double cantidad;
    private int idTipoInsumo;

    public Insumo() {
    }

    public Insumo(int idInsumo, String nombre, String medida, double cantidad, int idTipoInsumo) {
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

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdTipoInsumo() {
        return idTipoInsumo;
    }

    public void setIdTipoInsumo(int idTipoInsumo) {
        this.idTipoInsumo = idTipoInsumo;
    }
   
}
