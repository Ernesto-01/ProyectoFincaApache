
package modelo;

/**
 *
 * @author xavy
 */
public class DetalleEnvio {
    private int idDetalleEnvio;
    private int cantidadEnvios;
    private int idEnvios;
    private int idInsumo;

    public DetalleEnvio() {
    }

    public DetalleEnvio(int idDetalleEnvio, int cantidadEnvios, int idEnvios, int idInsumo) {
        this.idDetalleEnvio = idDetalleEnvio;
        this.cantidadEnvios = cantidadEnvios;
        this.idEnvios = idEnvios;
        this.idInsumo = idInsumo;
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

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    
    
    
   

   



    
}
