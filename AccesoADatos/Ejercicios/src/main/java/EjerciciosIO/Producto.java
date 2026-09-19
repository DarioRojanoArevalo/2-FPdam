package EjerciciosIO;

import java.io.Serializable;

public class Producto implements Serializable {
    int codigo;
    double precio;
    String nombre;

    public Producto() {
    }

    public Producto(int codigo, double precio, String nombre) {
        this.codigo=codigo;
        this.precio = precio;
        this.nombre= nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", precio=" + precio +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
