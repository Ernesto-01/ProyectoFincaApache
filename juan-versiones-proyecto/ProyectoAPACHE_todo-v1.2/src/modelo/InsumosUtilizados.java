package modelo;

/**
 *
 * @author herrj
 */
public class InsumosUtilizados {
    
    private int idInsumoUtilizados;
    private int cantidadUtilizada;
    private int idInsumo;
    private String nombreInsumo;
    private int idTareaDiaria;
    private String nombreTarea;

    public InsumosUtilizados() {
    }

    public InsumosUtilizados(int idInsumoUtilizados, int cantidadUtilizada, int idInsumo, String nombreInsumo, int idTareaDiaria, String nombreTarea) {
        this.idInsumoUtilizados = idInsumoUtilizados;
        this.cantidadUtilizada = cantidadUtilizada;
        this.idInsumo = idInsumo;
        this.nombreInsumo = nombreInsumo;
        this.idTareaDiaria = idTareaDiaria;
        this.nombreTarea = nombreTarea;
    }

    public int getIdInsumoUtilizados() {
        return idInsumoUtilizados;
    }

    public void setIdInsumoUtilizados(int idInsumoUtilizados) {
        this.idInsumoUtilizados = idInsumoUtilizados;
    }

    public int getCantidadUtilizada() {
        return cantidadUtilizada;
    }

    public void setCantidadUtilizada(int cantidadUtilizada) {
        this.cantidadUtilizada = cantidadUtilizada;
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

    public int getIdTareaDiaria() {
        return idTareaDiaria;
    }

    public void setIdTareaDiaria(int idTareaDiaria) {
        this.idTareaDiaria = idTareaDiaria;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }
    
}
