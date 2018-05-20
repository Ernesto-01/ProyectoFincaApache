package com.modelo;

/**
 *
 * @author herrj
 */
public class InsumosUtilizados {
    
    private int cantidadUtilizada;
    private int idUtilizada;
    private int idTareaDiaria;

    public InsumosUtilizados() {
    }

    public InsumosUtilizados(int cantidadUtilizada, int idUtilizada, int idTareaDiaria) {
        this.cantidadUtilizada = cantidadUtilizada;
        this.idUtilizada = idUtilizada;
        this.idTareaDiaria = idTareaDiaria;
    }

    public int getCantidadUtilizada() {
        return cantidadUtilizada;
    }

    public void setCantidadUtilizada(int cantidadUtilizada) {
        this.cantidadUtilizada = cantidadUtilizada;
    }

    public int getIdUtilizada() {
        return idUtilizada;
    }

    public void setIdUtilizada(int idUtilizada) {
        this.idUtilizada = idUtilizada;
    }

    public int getIdTareaDiaria() {
        return idTareaDiaria;
    }

    public void setIdTareaDiaria(int idTareaDiaria) {
        this.idTareaDiaria = idTareaDiaria;
    }
    
}
