package edu.dosw.bootcamp.lab.estructurales.reto5CafePersonalizado;

public class LecheAvena extends ToppingDecorador {
    public LecheAvena(Cafe cafe) {
        super(cafe);
    }
    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " con leche de avena";
    }
    @Override
    public double getPrecio() {
        return cafe.getPrecio() + 1200;
    }
}