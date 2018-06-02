
package modelo;

/**
 *
 * @author Xavy
 */
public class Envios {
    private int idEnvios;
    private String nombreEnvio;
    private String fechaEnvio;
    private String nombreReceptor;
    private int idFinca;
    private String nombreFinca;

    public Envios() {
    }

    public Envios(int idEnvios, String nombreEnvio, String fechaEnvio, String nombreReceptor, int idFinca, String nombreFinca) {
        this.idEnvios = idEnvios;
        this.nombreEnvio = nombreEnvio;
        this.fechaEnvio = fechaEnvio;
        this.nombreReceptor = nombreReceptor;
        this.idFinca = idFinca;
        this.nombreFinca = nombreFinca;
    }

    public int getIdEnvios() {
        return idEnvios;
    }

    public void setIdEnvios(int idEnvios) {
        this.idEnvios = idEnvios;
    }

    public String getNombreEnvio() {
        return nombreEnvio;
    }

    public void setNombreEnvio(String nombreEnvio) {
        this.nombreEnvio = nombreEnvio;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getNombreReceptor() {
        return nombreReceptor;
    }

    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
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
}
