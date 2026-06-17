package edu.dosw.bootcamp.lab.comportamiento.reto4CasaDeCambio;

public class ConversionCOP implements EstrategiaConversion {
    private static final double TASA = 4100.0;

    @Override
    public double convertir(double cantidad, String destino) {
        double usd = cantidad / TASA;
        return switch (destino) {
            case "USD" -> usd;
            case "EUR" -> usd * 0.92;
            case "JPY" -> usd * 149;
            case "COP" -> cantidad;
            default -> throw new IllegalArgumentException("Moneda no soportada: " + destino);
        };
    }

    @Override public String getCodigo() { return "COP"; }
    @Override public String getSimbolo() { return "$"; }
}
