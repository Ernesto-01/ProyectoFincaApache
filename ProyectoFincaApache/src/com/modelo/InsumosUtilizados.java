package modelo;

/**
 *
 * @author herrj
 */
public class InsumosUtilizados {
    
    private int idInsumoUtilizados;
    private int cantidadUtilizada;
    private int idInsumo;
    private int idTareaDiaria;

    public InsumosUtilizados() {
    }

    public InsumosUtilizados(int idInsumoUtilizados, int cantidadUtilizada, int idInsumo, int idTareaDiaria) {
        this.idInsumoUtilizados = idInsumoUtilizados;
        this.cantidadUtilizada = cantidadUtilizada;
        this.idInsumo = idInsumo;
        this.idTareaDiaria = idTareaDiaria;
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

    public int getIdTareaDiaria() {
        return idTareaDiaria;
    }

    public void setIdTareaDiaria(int idTareaDiaria) {
        this.idTareaDiaria = idTareaDiaria;
    }
    
}
