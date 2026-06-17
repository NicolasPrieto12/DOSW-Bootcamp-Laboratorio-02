package edu.dosw.bootcamp.lab.estructurales.reto5CafePersonalizado;
import java.util.Scanner;

public class Reto5CafePersonalizado {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cafeteria Creativa");
        System.out.println("Cafe base: Espresso ($3.500)");
        System.out.println("\nToppings disponibles:");
        System.out.println("1. Leche de avena (+$1.200)");
        System.out.println("2. Caramelo (+$800)");
        System.out.println("3. Chantilly (+$1.000)");
        Cafe cafe = new Espresso();
        double precioBase = cafe.getPrecio();
        System.out.print("\n¿Cuántos toppings deseas? ");
        int n = Integer.parseInt(sc.nextLine()
                                   .trim());
        double totalToppings = 0;
        for (int i = 1; i <= n; i++) {
            System.out.printf("Topping %d (1/2/3): ", i);
            String opcion = sc.nextLine()
                              .trim();
            switch (opcion) {
                case "1" -> {
                    cafe = new LecheAvena(cafe);
                    totalToppings += 1200;
                }
                case "2" -> {
                    cafe = new Caramelo(cafe);
                    totalToppings += 800;
                }
                case "3" -> {
                    cafe = new Chantilly(cafe);
                    totalToppings += 1000;
                }
                default -> System.out.println("Opcion no valida, se omite.");
            }
        }
        System.out.println("\nTu Café");
        System.out.println("Descripción:");
        System.out.println(cafe.getDescripcion());
        System.out.printf("Precio base: $%.0f%n", precioBase);
        System.out.printf("Toppings: $%.0f%n", totalToppings);
        System.out.printf("Total: $%.0f%n", cafe.getPrecio());
        System.out.println("¡Disfruta tu café!");
    }
}