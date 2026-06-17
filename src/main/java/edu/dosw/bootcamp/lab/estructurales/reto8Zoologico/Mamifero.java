package edu.dosw.bootcamp.lab.estructurales.reto8Zoologico;

public class Mamifero extends Animal {
    private String sonido;

    public Mamifero(String nombre, int edad, String dieta, String alimentoPreferido,
                    double peso, double altura, String estadoSalud, String habitat, String sonido) {
        super(nombre, edad, dieta, alimentoPreferido, peso, altura, estadoSalud, habitat);
        this.sonido = sonido;
    }

    @Override
    public void emitirSonido() {
        System.out.println(getNombre() + " dice: " + sonido);
    }

    @Override
    public String getDescripcion() {
        return "Mamifero: " + getNombre();
    }

    public String getSonido() { return sonido; }
    public void setSonido(String sonido) { this.sonido = sonido; }
}
