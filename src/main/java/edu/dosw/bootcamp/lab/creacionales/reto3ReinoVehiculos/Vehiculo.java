package edu.dosw.bootcamp.lab.creacionales.reto3ReinoVehiculos;

public abstract class Vehiculo {
    protected String modelo;
    protected String categoria;
    protected double velocidadMaxima;
    protected double precio;
    public String getModelo() {
        return modelo;
    }
    public String getCategoria() {
        return categoria;
    }
    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }
    public double getPrecio() {
        return precio;
    }
    public void mostrar() {
        System.out.printf("  Modelo: %s - %s%n", modelo, categoria);
        System.out.printf("  Vel. max: %.0f km/h%n", velocidadMaxima);
        System.out.printf("  Precio: $%,.0f%n", precio);
    }
}