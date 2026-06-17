package edu.dosw.bootcamp.lab.estructurales.reto8Zoologico;

public class ConPelaje extends AnimalDecorator {
    private final String colorPelaje;

    public ConPelaje(Animal animal, String colorPelaje) {
        super(animal);
        this.colorPelaje = colorPelaje;
    }

    @Override
    public String getDescripcion() {
        return animal.getDescripcion() + " | Pelaje: " + colorPelaje;
    }

    public String getColorPelaje() { return colorPelaje; }
}
