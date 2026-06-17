package edu.dosw.bootcamp.lab.solid.reto1TiendaDonPepe;

public class Recibo {
    public void mostrar(Cliente cliente, Carrito carrito) {
        double subtotal = carrito.calcularSubtotal();
        double descuento = cliente.getDescuento().calcularDescuento(subtotal);
        double total = subtotal - descuento;
        System.out.println("\nRecibo de la compra");
        System.out.println("Cliente: " + cliente.getTipo());
        System.out.println("Productos:");
        for (ItemCarrito item : carrito.getItems()) {
            System.out.printf("  %-15s - $%.0f%n",
                    item.getProducto()
                        .getNombre(), item.getSubtotal());
        }
        System.out.printf("Subtotal: $%.0f%n", subtotal);
        System.out.printf("%s: $%.0f%n", cliente.getDescuento().getDescripcion(), descuento);
        System.out.printf("Total a pagar: $%.0f%n", total);
        System.out.println("¡Gracias por su compra!");
    }
}