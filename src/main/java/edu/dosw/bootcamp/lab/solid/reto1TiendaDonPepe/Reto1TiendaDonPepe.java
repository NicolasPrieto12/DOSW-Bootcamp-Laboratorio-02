package edu.dosw.bootcamp.lab.solid.reto1TiendaDonPepe;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reto1TiendaDonPepe {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        List<Producto> catalogo = new ArrayList<>();
        catalogo.add(new Producto("Camiseta", 20000));
        catalogo.add(new Producto("Pantalón", 50000));
        catalogo.add(new Producto("Galletas", 500));
        catalogo.add(new Producto("Jugo Natural", 3000));
        System.out.println("¡Bienvenido a la tienda Don Pepe!");
        System.out.println("\nProductos disponibles:");
        for (Producto p : catalogo) {
            System.out.printf("  %-15s $%.0f%n", p.getNombre(), p.getPrecioUnitario());
        }
        System.out.print("\n¿Eres cliente nuevo o frecuente?: ");
        String tipo = sc.nextLine();
        Cliente cliente = new Cliente(tipo);
        Carrito carrito = new Carrito();
        System.out.print("¿Cuántos productos deseas agregar? ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("\nIngresa tu compra:");
        for (int i = 0; i < n; i++) {
            System.out.print("Nombre del producto: ");
            String nombre = sc.nextLine();
            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(sc.nextLine());
            Producto encontrado = null;
            for (Producto p : catalogo) {
                if (p.getNombre()
                     .equalsIgnoreCase(nombre)) {
                    encontrado = p;
                    break;
                }
            }
            if (encontrado != null) {
                carrito.agregar(encontrado, cantidad);
            } else {
                System.out.println("Producto no encontrado.");
            }
        }
        Recibo recibo = new Recibo();
        recibo.mostrar(cliente, carrito);
    }
}