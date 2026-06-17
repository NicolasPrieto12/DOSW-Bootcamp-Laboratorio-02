package edu.dosw.bootcamp.lab.comportamiento.reto4CasaDeCambio;

public class ConversionUSD implements EstrategiaConversion {

    @Override
    public double convertir(double cantidad, String destino) {
        return switch (destino) {
            case "USD" -> cantidad;
            case "COP" -> cantidad * 4100;
            case "EUR" -> cantidad * 0.92;
            case "JPY" -> cantidad * 149;
            default -> throw new IllegalArgumentException("Moneda no soportada: " + destino);
        };
    }

    @Override public String getCodigo() { return "USD"; }
    @Override public String getSimbolo() { return "$"; }
}
