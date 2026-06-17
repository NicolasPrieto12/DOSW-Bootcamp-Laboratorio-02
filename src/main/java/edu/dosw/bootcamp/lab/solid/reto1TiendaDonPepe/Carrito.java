package edu.dosw.bootcamp.lab.solid.reto1TiendaDonPepe;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private final List<ItemCarrito> items = new ArrayList<>();
    public void agregar(Producto producto, int cantidad) {
        items.add(new ItemCarrito(producto, cantidad));
        System.out.println(producto.getNombre() + ": " + cantidad + " unidades agregadas al carrito.");
    }
    public List<ItemCarrito> getItems() {
        return items;
    }
    public double calcularSubtotal() {
        return items.stream()
                    .mapToDouble(ItemCarrito::getSubtotal)
                    .sum();
    }
}