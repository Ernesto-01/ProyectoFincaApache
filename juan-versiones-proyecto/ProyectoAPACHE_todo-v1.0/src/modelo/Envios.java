
package modelo;

/**
 *
 * @author Xavy
 */
public class Envios {
    private int idEnvios;
    private String fechaEnvio;
    private String nombreReceptor;
    private int idFinca;

    public Envios() {
    }

    public Envios(int idEnvios, String fechaEnvio, String nombreReceptor, int idFinca) {
        this.idEnvios = idEnvios;
        this.fechaEnvio = fechaEnvio;
        this.nombreReceptor = nombreReceptor;
        this.idFinca = idFinca;
    }

    public int getIdEnvios() {
        return idEnvios;
    }

    public void setIdEnvios(int idEnvios) {
        this.idEnvios = idEnvios;
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

   
   
}
