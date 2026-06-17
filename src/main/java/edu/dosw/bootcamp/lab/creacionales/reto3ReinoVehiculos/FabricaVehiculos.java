package edu.dosw.bootcamp.lab.creacionales.reto3ReinoVehiculos;

public interface FabricaVehiculos {
    Vehiculo crearVehiculo(String modelo, String categoria);
}