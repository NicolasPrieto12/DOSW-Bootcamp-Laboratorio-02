package edu.dosw.bootcamp.lab.comportamiento.reto4CasaDeCambio;

import java.util.HashMap;
import java.util.Map;

public class CasaDeCambio {
    private final Map<String, EstrategiaConversion> estrategias = new HashMap<>();

    public CasaDeCambio() {
        estrategias.put("COP", new ConversionCOP());
        estrategias.put("EUR", new ConversionEUR());
        estrategias.put("JPY", new ConversionJPY());
        estrategias.put("USD", new ConversionUSD());
    }

    public Transaccion convertir(double cantidad, String origen, String destino) {
        EstrategiaConversion estrategia = estrategias.get(origen.toUpperCase());
        if (estrategia == null)
            throw new IllegalArgumentException("Moneda no soportada: " + origen);
        double resultado = estrategia.convertir(cantidad, destino.toUpperCase());
        return new Transaccion(cantidad, origen.toUpperCase(), destino.toUpperCase(), resultado);
    }

    public String getSimboloDestino(String moneda) {
        EstrategiaConversion e = estrategias.get(moneda.toUpperCase());
        return e != null ? e.getSimbolo() : "";
    }
}
