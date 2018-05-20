
package com.modelo;

/**
 * Clase:TareaDiaria
 * Version:1.0
 * Fecha de creacion:20/5/2018
 * Fecha de modificación:20/5/2018
 * @author Ernesto Rosales
 */
public class TareaDiaria {
    private int idTareaDiaria;
    private String fecha;
    private int estado;
    private String jornada;
    private String porcentajeRealizado;
    private Tareas tarea;
    private TareaDiaria tareaDiaria;

    public TareaDiaria() {
    }

    public TareaDiaria(int idTareaDiaria, String fecha, int estado, String jornada, String porcentajeRealizado, Tareas tarea, TareaDiaria tareaDiaria) {
        this.idTareaDiaria = idTareaDiaria;
        this.fecha = fecha;
        this.estado = estado;
        this.jornada = jornada;
        this.porcentajeRealizado = porcentajeRealizado;
        this.tarea = tarea;
        this.tareaDiaria = tareaDiaria;
    }

    public int getIdTareaDiaria() {
        return idTareaDiaria;
    }

    public void setIdTareaDiaria(int idTareaDiaria) {
        this.idTareaDiaria = idTareaDiaria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getPorcentajeRealizado() {
        return porcentajeRealizado;
    }

    public void setPorcentajeRealizado(String porcentajeRealizado) {
        this.porcentajeRealizado = porcentajeRealizado;
    }

    public Tareas getTarea() {
        return tarea;
    }

    public void setTarea(Tareas tarea) {
        this.tarea = tarea;
    }

    public TareaDiaria getTareaDiaria() {
        return tareaDiaria;
    }

    public void setTareaDiaria(TareaDiaria tareaDiaria) {
        this.tareaDiaria = tareaDiaria;
    }

    
    
    
    
}
