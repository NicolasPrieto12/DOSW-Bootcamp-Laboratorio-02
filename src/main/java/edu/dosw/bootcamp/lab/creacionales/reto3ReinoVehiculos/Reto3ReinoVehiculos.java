package edu.dosw.bootcamp.lab.creacionales.reto3ReinoVehiculos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reto3ReinoVehiculos {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        List<Vehiculo> compra = new ArrayList<>();
        System.out.println("Bienvenido al Reino de los Vehículos");
        System.out.println("Tierra: Auto, Bicicleta, Moto");
        System.out.println("Acuático: Lancha, Velero, Jet Ski");
        System.out.println("Aéreo: Avión, Avioneta, Helicóptero");
        System.out.println("Categorías: economico, lujo, usado");
        System.out.print("\n¿Cuántos vehículos deseas comprar? ");
        int n = Integer.parseInt(sc.nextLine()
                                   .trim());
        for (int i = 1; i <= n; i++) {
            System.out.printf("\nVehículo %d:%n", i);
            System.out.print("Ingresa el tipo de Vehículo: ");
            String tipo = sc.nextLine()
                            .trim()
                            .toLowerCase();
            System.out.print("Ingresa el modelo: ");
            String modelo = sc.nextLine()
                              .trim();
            System.out.print("Ingresa la categoría: ");
            String categoria = sc.nextLine()
                                 .trim();
            FabricaVehiculos fabrica = switch (tipo) {
                case "tierra" -> new FabricaTierra();
                case "acuático" -> new FabricaAcuatica();
                case "aéreo" -> new FabricaAerea();
                default -> throw new IllegalArgumentException("Tipo no válido: " + tipo);
            };
            Vehiculo v = fabrica.crearVehiculo(modelo, categoria);
            compra.add(v);
        }
        System.out.println();
        for (int i = 0; i < compra.size(); i++) {
            System.out.printf("Vehiculo %d: %s %s%n", i + 1, compra.get(i).getModelo(), compra.get(i).getCategoria());
            System.out.printf("  Vel. max: %.0f km/h%n", compra.get(i).getVelocidadMaxima());
            System.out.printf("  Precio: $%,.0f%n", compra.get(i).getPrecio());
        }
        double total = compra.stream().mapToDouble(Vehiculo::getPrecio).sum();
        System.out.printf("%nTotal a pagar: $%,.0f%n", total);
        System.out.println("¡Gracias por su compra!");
    }
}