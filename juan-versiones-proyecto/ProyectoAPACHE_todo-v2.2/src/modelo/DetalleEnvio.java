
package modelo;

/**
 *
 * @author xavy
 */
public class DetalleEnvio {
    private int idDetalleEnvio;
    private int cantidadEnvios;
    private int idEnvios;
    private String nombreEnvios;
    private int idInsumo;
    private String nombreInsumo;

    public DetalleEnvio() {
    }

    public DetalleEnvio(int idDetalleEnvio, int cantidadEnvios, int idEnvios, String nombreEnvio, int idInsumo, String nombreInsumo) {
        this.idDetalleEnvio = idDetalleEnvio;
        this.cantidadEnvios = cantidadEnvios;
        this.idEnvios = idEnvios;
        this.nombreEnvios = nombreEnvio;
        this.idInsumo = idInsumo;
        this.nombreInsumo = nombreInsumo;
    }

    public int getIdDetalleEnvio() {
        return idDetalleEnvio;
    }

    public void setIdDetalleEnvio(int idDetalleEnvio) {
        this.idDetalleEnvio = idDetalleEnvio;
    }

    public int getCantidadEnvios() {
        return cantidadEnvios;
    }

    public void setCantidadEnvios(int cantidadEnvios) {
        this.cantidadEnvios = cantidadEnvios;
    }

    public int getIdEnvios() {
        return idEnvios;
    }

    public void setIdEnvios(int idEnvios) {
        this.idEnvios = idEnvios;
    }
    
    public String getNombreEnvios() {
        return nombreEnvios;
    }

    public void setNombreEnvios(String nombreEnvios) {
        this.nombreEnvios = nombreEnvios;
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
