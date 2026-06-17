package edu.dosw.bootcamp.lab.solid.reto1TiendaDonPepe;

public class Producto {
    private final String nombre;
    private final double precioUnitario;
    public Producto(String nombre, double precioUnitario) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }
}