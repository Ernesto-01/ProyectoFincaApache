
package modelo;

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
    private Tablones tablones;
    private Jornaleros jornalero;

    public TareaDiaria() {
    }

    public TareaDiaria(int idTareaDiaria, String fecha, int estado, String jornada, String porcentajeRealizado, Tareas tarea, Tablones tablones, Jornaleros jornalero) {
        this.idTareaDiaria = idTareaDiaria;
        this.fecha = fecha;
        this.estado = estado;
        this.jornada = jornada;
        this.porcentajeRealizado = porcentajeRealizado;
        this.tarea = tarea;
        this.tablones = tablones;
        this.jornalero = jornalero;
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

    public Tablones getTablones() {
        return tablones;
    }

    public void setTablones(Tablones tablones) {
        this.tablones = tablones;
    }

    public Jornaleros getJornalero() {
        return jornalero;
    }

    public void setJornalero(Jornaleros jornalero) {
        this.jornalero = jornalero;
    }

        
    
    
}
