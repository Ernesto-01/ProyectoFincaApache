/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Alejandro
 */
public class Jornaleros {
    private int idJornalero;
    private String nombre;
    private String apellido;
    private int edad;
    private String horario;
    private int estado;
    private String direccion;
    private int idPagos;
    private double pagos;

    public Jornaleros() {
    }

    public Jornaleros(int idJornalero, String nombre, String apellido, int edad, String horario, int estado, String direccion, int idPagos, double pagos) {
        this.idJornalero = idJornalero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.horario = horario;
        this.estado = estado;
        this.direccion = direccion;
        this.idPagos = idPagos;
        this.pagos = pagos;
    }

    public double getPagos() {
        return pagos;
    }

    public void setPagos(double pagos) {
        this.pagos = pagos;
    }

    

    public int getIdJornalero() {
        return idJornalero;
    }

    public void setIdJornalero(int idJornalero) {
        this.idJornalero = idJornalero;
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

    public int getIdPagos() {
        return idPagos;
    }

    public void setIdPagos(int idPagos) {
        this.idPagos = idPagos;
    }
    
}
