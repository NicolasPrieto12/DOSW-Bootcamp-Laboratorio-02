package edu.dosw.bootcamp.lab.solid.reto1TiendaDonPepe;

public class DescuentoNuevo implements EstrategiaDescuento {
    @Override
    public double calcularDescuento(double subtotal) {
        return subtotal * 0.05;
    }
    @Override
    public String getDescripcion() {
        return "Descuento (5%)";
    }
}