package edu.dosw.bootcamp.lab.creacionales.reto2ChefEstrellas;

import java.util.Scanner;

public class Chef {

    public Hamburguesa tomarPedido() {
        Scanner sc = new Scanner(System.in);
        HamburguesaBuilder builder = new HamburguesaBuilder();

        System.out.println("Bienvenido al Chef de 5 Estrellas");
        System.out.println("\nElige tu hamburguesa:");

        System.out.print("¿Pan? -> ");
        builder.setPan(sc.nextLine(), 2000);

        System.out.print("¿Carne? -> ");
        builder.setCarne(sc.nextLine(), 8000);

        System.out.print("¿Queso? -> ");
        builder.setQueso(sc.nextLine(), 1500);

        System.out.print("¿Vegetales? (separados por coma) -> ");
        String[] vegetales = sc.nextLine().split(",");
        for (String v : vegetales)
            builder.agregarVegetal(v.trim(), 500);

        System.out.print("¿Salsa? -> ");
        builder.setSalsa(sc.nextLine(), 800);

        return builder.build();
    }
}
