package edu.dosw.bootcamp.lab.estructurales.reto5CafePersonalizado;

public class Chantilly extends ToppingDecorador {
    public Chantilly(Cafe cafe) {
        super(cafe);
    }
    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " y chantilly";
    }
    @Override
    public double getPrecio() {
        return cafe.getPrecio() + 1000;
    }
}