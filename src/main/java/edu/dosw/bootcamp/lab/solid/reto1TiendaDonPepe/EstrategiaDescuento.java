package edu.dosw.bootcamp.lab.solid.reto1TiendaDonPepe;

public interface EstrategiaDescuento {
    double calcularDescuento(double subtotal);
    String getDescripcion();
}