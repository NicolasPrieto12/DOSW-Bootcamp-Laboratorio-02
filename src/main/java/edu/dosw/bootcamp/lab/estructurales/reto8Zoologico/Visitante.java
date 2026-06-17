package edu.dosw.bootcamp.lab.estructurales.reto8Zoologico;

import java.util.ArrayList;
import java.util.List;

public class Visitante {
    private String nombre;
    private int edad;
    private List<Animal> animalesFavoritos = new ArrayList<>();
    private List<String> fotografias = new ArrayList<>();

    public Visitante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void alimentar(Animal animal) {
        System.out.println(nombre + " (visitante) alimenta a " + animal.getNombre());
        animal.comer();
    }

    public void darPropina(Cuidador cuidador) {
        System.out.println(nombre + " da propina a " + cuidador.getNombre());
    }

    public void subirFoto(Animal animal) {
        String foto = "Foto de " + nombre + " con " + animal.getNombre();
        fotografias.add(foto);
        System.out.println(foto + " subida.");
    }

    public void agregarFavorito(Animal animal) {
        animalesFavoritos.add(animal);
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public List<Animal> getAnimalesFavoritos() { return animalesFavoritos; }
    public List<String> getFotografias() { return fotografias; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }
}
