package edu.dosw.bootcamp.lab.comportamiento.reto4CasaDeCambio;

public interface EstrategiaConversion {
    double convertir(double cantidad, String monedaDestino);
    String getCodigo();
    String getSimbolo();
}
