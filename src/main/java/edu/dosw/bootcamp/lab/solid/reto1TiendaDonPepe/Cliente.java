package edu.dosw.bootcamp.lab.solid.reto1TiendaDonPepe;

public class Cliente {
    private final String tipo;
    private final EstrategiaDescuento descuento;

    public Cliente(String tipo) {
        this.tipo = tipo;
        if (tipo.equalsIgnoreCase("frecuente")) {
            this.descuento = new DescuentoFrecuente();
        } else {
            this.descuento = new DescuentoNuevo();
        }
    }

    public String getTipo() { return tipo; }
    public EstrategiaDescuento getDescuento() { return descuento; }
}