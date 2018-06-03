/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Alejandro
 */
public class TareaDiaria {
    private int idTareaDiaria;
    private String fecha;
    private int estado;
    private String jornada;
    private String porcentajeRealizado;
    private int idTarea;
    private String nombreTarea;
    private int idTablones;
    private String nombreTablon;
    private int idJornalero;
    private String nombreJornalero;

    public TareaDiaria() {
    }

    public TareaDiaria(int idTareaDiaria, String fecha, int estado, String jornada, String porcentajeRealizado, int idTarea, String nombreTarea, int idTablones, String nombreTablon, int idJornalero, String nombreJornalero) {
        this.idTareaDiaria = idTareaDiaria;
        this.fecha = fecha;
        this.estado = estado;
        this.jornada = jornada;
        this.porcentajeRealizado = porcentajeRealizado;
        this.idTarea = idTarea;
        this.nombreTarea = nombreTarea;
        this.idTablones = idTablones;
        this.nombreTablon = nombreTablon;
        this.idJornalero = idJornalero;
        this.nombreJornalero = nombreJornalero;
    }

    public int getIdTareaDiaria() {
        return idTareaDiaria;
    }

    public void setIdTareaDiaria(int idTareaDiaria) {
        this.idTareaDiaria = idTareaDiaria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getPorcentajeRealizado() {
        return porcentajeRealizado;
    }

    public void setPorcentajeRealizado(String porcentajeRealizado) {
        this.porcentajeRealizado = porcentajeRealizado;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public int getIdTablones() {
        return idTablones;
    }

    public void setIdTablones(int idTablones) {
        this.idTablones = idTablones;
    }

    public String getNombreTablon() {
        return nombreTablon;
    }

    public void setNombreTablon(String nombreTablon) {
        this.nombreTablon = nombreTablon;
    }

    public int getIdJornalero() {
        return idJornalero;
    }

    public void setIdJornalero(int idJornalero) {
        this.idJornalero = idJornalero;
    }

    public String getNombreJornalero() {
        return nombreJornalero;
    }

    public void setNombreJornalero(String nombreJornalero) {
        this.nombreJornalero = nombreJornalero;
    }
    
    
    
}
