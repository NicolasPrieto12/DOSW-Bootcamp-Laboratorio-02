package edu.dosw.bootcamp.lab.estructurales.reto5CafePersonalizado;

public class Caramelo extends ToppingDecorador {
    public Caramelo(Cafe cafe) {
        super(cafe);
    }
    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " con caramelo";
    }
    @Override
    public double getPrecio() {
        return cafe.getPrecio() + 800;
    }
}