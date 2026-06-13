package edu.dosw.bootcamp.lab.creacionales.reto2ChefEstrellas;

import java.util.List;

public class Hamburguesa {
    private final Ingrediente pan;
    private final Ingrediente carne;
    private final Ingrediente queso;
    private final List<Ingrediente> vegetales;
    private final Ingrediente salsa;

    public Hamburguesa(Ingrediente pan, Ingrediente carne, Ingrediente queso,
                       List<Ingrediente> vegetales, Ingrediente salsa) {
        this.pan = pan;
        this.carne = carne;
        this.queso = queso;
        this.vegetales = vegetales;
        this.salsa = salsa;
    }

    public double calcularTotal() {
        double total = 0;
        if (pan != null) total += pan.getPrecio();
        if (carne != null) total += carne.getPrecio();
        if (queso != null) total += queso.getPrecio();
        if (salsa != null) total += salsa.getPrecio();
        if (vegetales != null)
            total += vegetales.stream().mapToDouble(Ingrediente::getPrecio).sum();
        return total;
    }

    public void mostrar() {
        System.out.println("------- Tu Hamburguesa -------");
        if (pan != null)
            System.out.printf("Pan:       %-15s $%.0f%n", pan.getNombre(), pan.getPrecio());
        if (carne != null)
            System.out.printf("Carne:     %-15s $%.0f%n", carne.getNombre(), carne.getPrecio());
        if (queso != null)
            System.out.printf("Queso:     %-15s $%.0f%n", queso.getNombre(), queso.getPrecio());
        if (vegetales != null && !vegetales.isEmpty()) {
            System.out.printf("Vegetales: %-15s $%.0f%n", vegetales.get(0).getNombre(), vegetales.get(0).getPrecio());
            for (int i = 1; i < vegetales.size(); i++)
                System.out.printf("           %-15s $%.0f%n", vegetales.get(i).getNombre(), vegetales.get(i).getPrecio());
        }
        if (salsa != null)
            System.out.printf("Salsa:     %-15s $%.0f%n", salsa.getNombre(), salsa.getPrecio());
        System.out.printf("%nTotal:     $%.0f%n", calcularTotal());
        System.out.println("¡Buen provecho!");
    }
}
