package edu.dosw.bootcamp.lab.comportamiento.reto4CasaDeCambio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reto4CasaDeCambio {

    public static void main() {
        Scanner sc = new Scanner(System.in);
        CasaDeCambio casa = new CasaDeCambio();
        List<Transaccion> transacciones = new ArrayList<>();

        System.out.println("Casa de Cambio Honesta");
        System.out.print("¿Cuantas transacciones? ");
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 1; i <= n; i++) {
            System.out.printf("Tx %d: cantidad -> ", i);
            double cantidad = Double.parseDouble(sc.nextLine().trim());
            System.out.printf("Tx %d: moneda origen (COP/EUR/JPY/USD) -> ", i);
            String origen = sc.nextLine().trim();
            System.out.printf("Tx %d: moneda destino (COP/EUR/JPY/USD) -> ", i);
            String destino = sc.nextLine().trim();
            transacciones.add(casa.convertir(cantidad, origen, destino));
        }

        System.out.println();
        for (int i = 0; i < transacciones.size(); i++) {
            Transaccion tx = transacciones.get(i);
            String simboloDestino = casa.getSimboloDestino(tx.getMonedaDestino());
            System.out.printf("Tx %d: %.0f %s = %s%.2f %s%n",
                    i + 1, tx.getCantidad(), tx.getMonedaOrigen(),
                    simboloDestino, tx.getResultado(), tx.getMonedaDestino());
        }

        double totalUSD = transacciones.stream()
                .mapToDouble(Transaccion::getEquivalenteUSD)
                .sum();

        System.out.println("\n--- Resumen ---");
        System.out.printf("Total USD equivalente: $%.2f%n", totalUSD);
        System.out.println("¡Gracias por usar la casa de cambio DOSW!");
    }
}
