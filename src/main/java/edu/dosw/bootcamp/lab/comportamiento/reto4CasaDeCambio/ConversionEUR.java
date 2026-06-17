package edu.dosw.bootcamp.lab.comportamiento.reto4CasaDeCambio;

public class ConversionEUR implements EstrategiaConversion {
    private static final double TASA = 0.92;

    @Override
    public double convertir(double cantidad, String destino) {
        double usd = cantidad / TASA;
        return switch (destino) {
            case "USD" -> usd;
            case "COP" -> usd * 4100;
            case "JPY" -> usd * 149;
            case "EUR" -> cantidad;
            default -> throw new IllegalArgumentException("Moneda no soportada: " + destino);
        };
    }

    @Override public String getCodigo() { return "EUR"; }
    @Override public String getSimbolo() { return "€"; }
}
