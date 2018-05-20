
package com.modelo;

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
    private int idProveedor;
    private int idInsumo;

    public Inventario() {
    }

    public Inventario(int idInventario, int cantidad, double precio, int estado, int idFinca, int idProveedor, int idInsumo) {
        this.idInventario = idInventario;
        this.cantidad = cantidad;
        this.precio = precio;
        this.estado = estado;
        this.idFinca = idFinca;
        this.idProveedor = idProveedor;
        this.idInsumo = idInsumo;
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

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }
    
    
}
