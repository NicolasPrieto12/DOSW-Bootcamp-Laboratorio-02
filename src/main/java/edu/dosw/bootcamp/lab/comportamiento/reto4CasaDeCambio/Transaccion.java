package edu.dosw.bootcamp.lab.comportamiento.reto4CasaDeCambio;

public class Transaccion {
    private final double cantidad;
    private final String monedaOrigen;
    private final String monedaDestino;
    private final double resultado;

    public Transaccion(double cantidad, String monedaOrigen, String monedaDestino, double resultado) {
        this.cantidad = cantidad;
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.resultado = resultado;
    }

    public double getCantidad() { return cantidad; }
    public String getMonedaOrigen() { return monedaOrigen; }
    public String getMonedaDestino() { return monedaDestino; }
    public double getResultado() { return resultado; }

    public double getEquivalenteUSD() {
        return switch (monedaOrigen) {
            case "USD" -> cantidad;
            case "COP" -> cantidad / 4100;
            case "EUR" -> cantidad / 0.92;
            case "JPY" -> cantidad / 149;
            default -> 0;
        };
    }
}
