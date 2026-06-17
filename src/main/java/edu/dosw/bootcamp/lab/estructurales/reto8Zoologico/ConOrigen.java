package edu.dosw.bootcamp.lab.estructurales.reto8Zoologico;

public class ConOrigen extends AnimalDecorator {
    private final String origen;

    public ConOrigen(Animal animal, String origen) {
        super(animal);
        this.origen = origen;
    }

    @Override
    public String getDescripcion() {
        return animal.getDescripcion() + " | Origen: " + origen;
    }

    public String getOrigen() { return origen; }
}
