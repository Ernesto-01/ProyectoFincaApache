
package modelo;

/**
 * Clase:Pagos
 * Version:1.0
 * Fecha de creacion:20/5/2018
 * Fecha de modificación:20/5/2018
 * @author Ernesto Rosales
 */
public class Pagos {
    private int idPago;
    private double salario;

    public Pagos() {
    }

    public Pagos(int idPago, double salario) {
        this.idPago = idPago;
        this.salario = salario;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
}
