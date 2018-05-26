
package modelo;

/**
 *
 * @author Xavy
 */
public class Tablones {
    private int idTablones;
    private String nombre;
    private String sector;
    private int idFinca;

    public Tablones() {
    }

    public Tablones(int idTablones, String nombre, String sector, int idFinca) {
        this.idTablones = idTablones;
        this.nombre = nombre;
        this.sector = sector;
        this.idFinca = idFinca;
    }

    public int getIdTablones() {
        return idTablones;
    }

    public void setIdTablones(int idTablones) {
        this.idTablones = idTablones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public int getIdFinca() {
        return idFinca;
    }

    public void setIdFinca(int idFinca) {
        this.idFinca = idFinca;
    }

      
    
   
    
}
