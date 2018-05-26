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
public class TipoInsumo {
    private int idTipoInsumo;
    private String nombre;

    public TipoInsumo() {
    }

    
    
    
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
