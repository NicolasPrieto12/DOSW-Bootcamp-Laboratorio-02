package edu.dosw.bootcamp.lab.estructurales.reto8Zoologico;

import java.util.ArrayList;
import java.util.List;

public class ConHistorialMedico extends AnimalDecorator {
    private final List<String> historial = new ArrayList<>();

    public ConHistorialMedico(Animal animal) {
        super(animal);
    }

    public void agregarRegistro(String registro) {
        historial.add(registro);
    }

    @Override
    public String getDescripcion() {
        return animal.getDescripcion() + " | Historial: " + historial;
    }

    public List<String> getHistorial() { return historial; }
}
