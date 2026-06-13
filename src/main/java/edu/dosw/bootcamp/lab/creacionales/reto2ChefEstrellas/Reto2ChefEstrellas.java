package edu.dosw.bootcamp.lab.creacionales.reto2ChefEstrellas;

public class Reto2ChefEstrellas {

    public static void ejecutar() {
        Chef chef = new Chef();
        Hamburguesa hamburguesa = chef.tomarPedido();
        hamburguesa.mostrar();
    }
}
