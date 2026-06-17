package edu.dosw.bootcamp.lab.comportamiento.reto4CasaDeCambio;

public class ConversionJPY implements EstrategiaConversion {
    private static final double TASA = 149.0;

    @Override
    public double convertir(double cantidad, String destino) {
        double usd = cantidad / TASA;
        return switch (destino) {
            case "USD" -> usd;
            case "COP" -> usd * 4100;
            case "EUR" -> usd * 0.92;
            case "JPY" -> cantidad;
            default -> throw new IllegalArgumentException("Moneda no soportada: " + destino);
        };
    }

    @Override public String getCodigo() { return "JPY"; }
    @Override public String getSimbolo() { return "¥"; }
}
