package modelo;

/**
 *
 * @author herrj
 */
public class Tareas {
    
    private int idTarea;
    private String nombre;
    private String tipoTarea;

    public Tareas() {
    }

    public Tareas(int idTarea, String nombre, String tipoTarea) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.tipoTarea = tipoTarea;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoTarea() {
        return tipoTarea;
    }

    public void setTipoTarea(String tipoTarea) {
        this.tipoTarea = tipoTarea;
    }
    
}
