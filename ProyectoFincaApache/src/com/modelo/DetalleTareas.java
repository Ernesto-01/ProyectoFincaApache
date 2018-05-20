
package com.modelo;

/**
 * Clase:DetalleTareas
 * Version:1.0
 * Fecha de creacion:20/5/2018
 * Fecha de modificación:20/5/2018
 * @author Ernesto Rosales
 */
public class DetalleTareas {
    private Jornaleros idJornalero;
    private TareaDiaria idTarea;

    public DetalleTareas() {
    }

    public DetalleTareas(Jornaleros idJornalero, TareaDiaria idTarea) {
        this.idJornalero = idJornalero;
        this.idTarea = idTarea;
    }

    public Jornaleros getIdJornalero() {
        return idJornalero;
    }

    public void setIdJornalero(Jornaleros idJornalero) {
        this.idJornalero = idJornalero;
    }

    public TareaDiaria getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(TareaDiaria idTarea) {
        this.idTarea = idTarea;
    }
    
    
}
