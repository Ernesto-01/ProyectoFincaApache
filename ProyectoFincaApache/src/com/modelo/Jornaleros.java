
package com.modelo;

/**
 * Clase:Jornaleros
 * Version:1.1
 * Fecha de creacion:20/5/2018
 * Fecha de modificación:20/5/2018
 * @author Ernesto Rosales
 */
public class Jornaleros {
    private int idJornaleros;
    private String nombre;
    private String apellido;
    private int edad;
    private String horario;
    private int estado;
    private String direccion;
    private Pagos pagos;

    public Jornaleros() {
    }
    public Jornaleros(int idJornaleros, String nombre, String apellido, int edad, String horario, int estado, String direccion, Pagos pagos) {
        this.idJornaleros = idJornaleros;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.horario = horario;
        this.estado = estado;
        this.direccion = direccion;
        this.pagos = pagos;
    }

    public int getIdJornaleros() {
        return idJornaleros;
    }

    public void setIdJornaleros(int idJornaleros) {
        this.idJornaleros = idJornaleros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Pagos getPagos() {
        return pagos;
    }

    public void setPagos(Pagos pagos) {
        this.pagos = pagos;
    }   
    
}