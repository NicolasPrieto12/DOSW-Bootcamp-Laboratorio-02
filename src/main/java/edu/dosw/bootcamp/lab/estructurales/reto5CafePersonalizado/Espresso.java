package edu.dosw.bootcamp.lab.estructurales.reto5CafePersonalizado;

public class Espresso implements Cafe {
    @Override
    public String getDescripcion() {
        return "Espresso";
    }
    @Override
    public double getPrecio() {
        return 3500;
    }
}