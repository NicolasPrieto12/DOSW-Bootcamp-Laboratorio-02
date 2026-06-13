package edu.dosw.bootcamp.lab.creacionales.reto2ChefEstrellas;

import java.util.ArrayList;
import java.util.List;

public class HamburguesaBuilder {
    private Ingrediente pan;
    private Ingrediente carne;
    private Ingrediente queso;
    private List<Ingrediente> vegetales = new ArrayList<>();
    private Ingrediente salsa;

    public HamburguesaBuilder setPan(String nombre, double precio) {
        this.pan = new Ingrediente(nombre, precio);
        return this;
    }

    public HamburguesaBuilder setCarne(String nombre, double precio) {
        this.carne = new Ingrediente(nombre, precio);
        return this;
    }

    public HamburguesaBuilder setQueso(String nombre, double precio) {
        this.queso = new Ingrediente(nombre, precio);
        return this;
    }

    public HamburguesaBuilder agregarVegetal(String nombre, double precio) {
        this.vegetales.add(new Ingrediente(nombre, precio));
        return this;
    }

    public HamburguesaBuilder setSalsa(String nombre, double precio) {
        this.salsa = new Ingrediente(nombre, precio);
        return this;
    }

    public Hamburguesa build() {
        return new Hamburguesa(pan, carne, queso, vegetales, salsa);
    }
}
