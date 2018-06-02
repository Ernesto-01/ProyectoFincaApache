
package modelo;

/**
 *
 * @author Xavy
 */
public class Finca {
    private int idFinca;
    private String nombre;
    private String direccion;
    private String tipoFinca;

    public Finca() {
    }

    public Finca(int idFinca, String nombre, String direccion, String tipoFinca) {
        this.idFinca = idFinca;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipoFinca = tipoFinca;
    }

    public int getIdFinca() {
        return idFinca;
    }

    public void setIdFinca(int idFinca) {
        this.idFinca = idFinca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoFinca() {
        return tipoFinca;
    }

    public void setTipoFinca(String tipoFinca) {
        this.tipoFinca = tipoFinca;
    }

    
    
}
