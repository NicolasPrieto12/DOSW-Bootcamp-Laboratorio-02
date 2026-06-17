package edu.dosw.bootcamp.lab.estructurales.reto8Zoologico;

public class ConRareza extends AnimalDecorator {
    private final String rareza;

    public ConRareza(Animal animal, String rareza) {
        super(animal);
        this.rareza = rareza;
    }

    @Override
    public String getDescripcion() {
        return animal.getDescripcion() + " | Rareza: " + rareza;
    }

    public String getRareza() { return rareza; }
}
