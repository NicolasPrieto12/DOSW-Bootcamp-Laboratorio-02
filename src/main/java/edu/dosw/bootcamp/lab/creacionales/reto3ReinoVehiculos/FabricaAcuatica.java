package edu.dosw.bootcamp.lab.creacionales.reto3ReinoVehiculos;

public class FabricaAcuatica implements FabricaVehiculos {
    @Override
    public Vehiculo crearVehiculo(String modelo, String categoria) {
        return switch (modelo.toLowerCase()) {
            case "lancha" -> new Lancha(categoria);
            case "velero" -> new Velero(categoria);
            case "jet ski" -> new JetSki(categoria);
            default -> throw new IllegalArgumentException("Modelo acuático no válido: " + modelo);
        };
    }
}