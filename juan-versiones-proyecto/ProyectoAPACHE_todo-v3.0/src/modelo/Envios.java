
package modelo;

/**
 *
 * @author Xavy
 */
public class Envios {
    private int idEnvios;
    private String nombreEnvio;
    private String fechaEnvio;
    private int cantidadEnvios;
    private String nombreReceptor;
    private int idFinca;
    private String nombreFinca;
    
    private int idInsumo; //para detalleenvio
    private String nombreInsumo;

    public Envios() {
    }

    public Envios(int idEnvios, String nombreEnvio, String fechaEnvio, int cantidadEnvios, String nombreReceptor, int idFinca, String nombreFinca, int idInsumo, String nombreInsumo) {
        this.idEnvios = idEnvios;
        this.nombreEnvio = nombreEnvio;
        this.fechaEnvio = fechaEnvio;
        this.cantidadEnvios = cantidadEnvios;
        this.nombreReceptor = nombreReceptor;
        this.idFinca = idFinca;
        this.nombreFinca = nombreFinca;
        this.idInsumo = idInsumo;
        this.nombreInsumo = nombreInsumo;
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

    public int getCantidadEnvios() {
        return cantidadEnvios;
    }

    public void setCantidadEnvios(int cantidadEnvios) {
        this.cantidadEnvios = cantidadEnvios;
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

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }
    
    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }
    
}
