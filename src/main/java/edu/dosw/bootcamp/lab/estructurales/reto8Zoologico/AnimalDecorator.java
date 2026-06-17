package edu.dosw.bootcamp.lab.estructurales.reto8Zoologico;

public abstract class AnimalDecorator extends Animal {
    protected Animal animal;

    public AnimalDecorator(Animal animal) {
        super(animal.getNombre(), animal.getEdad(), animal.getDieta(),
              animal.getAlimentoPreferido(), animal.getPeso(),
              animal.getAltura(), animal.getEstadoSalud(), animal.getHabitat());
        this.animal = animal;
    }

    @Override
    public void emitirSonido() {
        animal.emitirSonido();
    }

    @Override
    public void comer() {
        animal.comer();
    }
}
