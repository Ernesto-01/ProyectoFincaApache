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
public class Inventario {
    private int idInventario;
    private int cantidad;
    private double precio;
    private int estado;
    private int idFinca;
    private String nombreFinca;
    private int idProveedor;
    private String nombreProveedor;
    private int idInsumo;
    private String nombreInsumo;

    public Inventario() {
    }

    public Inventario(int idInventario, int cantidad, double precio, int estado, int idFinca, String nombreFinca, int idProveedor, String nombreProveedor, int idInsumo, String nombreInsumo) {
        this.idInventario = idInventario;
        this.cantidad = cantidad;
        this.precio = precio;
        this.estado = estado;
        this.idFinca = idFinca;
        this.nombreFinca = nombreFinca;
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.idInsumo = idInsumo;
        this.nombreInsumo = nombreInsumo;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdFinca() {
        return idFinca;
    }

    public void setIdFinca(int idFinca) {
        this.idFinca = idFinca;
    }

    public String getNombreFinca() {
        return nombreFinca;
    }

    public void setNombreFinca(String nombreFinca) {
        this.nombreFinca = nombreFinca;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }
    
}
