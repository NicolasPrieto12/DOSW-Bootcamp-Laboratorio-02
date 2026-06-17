package edu.dosw.bootcamp.lab.estructurales.reto5CafePersonalizado;

public abstract class ToppingDecorador implements Cafe {
    protected Cafe cafe;
    public ToppingDecorador(Cafe cafe) {
        this.cafe = cafe;
    }
    @Override
    public String getDescripcion() {
        return cafe.getDescripcion();
    }
    @Override
    public double getPrecio() {
        return cafe.getPrecio();
    }
}