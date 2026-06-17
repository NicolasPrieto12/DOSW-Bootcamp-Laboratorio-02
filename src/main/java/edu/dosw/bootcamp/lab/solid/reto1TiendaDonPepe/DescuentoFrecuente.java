package edu.dosw.bootcamp.lab.solid.reto1TiendaDonPepe;

public class DescuentoFrecuente implements EstrategiaDescuento {
    @Override
    public double calcularDescuento(double subtotal) {
        return subtotal * 0.10;
    }
    @Override
    public String getDescripcion() {
        return "Descuento (10%)";
    }
}