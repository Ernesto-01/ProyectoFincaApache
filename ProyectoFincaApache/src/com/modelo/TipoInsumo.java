
package com.modelo;

/**
 *
 * @author Alejandro
 */
public class TipoInsumo {
    private int idTipoInsumo;
    private String nombre;

    public TipoInsumo(int idTipoInsumo, String nombre) {
        this.idTipoInsumo = idTipoInsumo;
        this.nombre = nombre;
    }

    public int getIdTipoInsumo() {
        return idTipoInsumo;
    }

    public void setIdTipoInsumo(int idTipoInsumo) {
        this.idTipoInsumo = idTipoInsumo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
