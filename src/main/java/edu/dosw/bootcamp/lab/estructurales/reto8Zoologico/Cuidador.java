package edu.dosw.bootcamp.lab.estructurales.reto8Zoologico;

import java.util.ArrayList;
import java.util.List;

public class Cuidador {
    private String nombre;
    private int edad;
    private String especialidad;
    private List<Animal> animalesAsignados = new ArrayList<>();

    public Cuidador(String nombre, int edad, String especialidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.especialidad = especialidad;
    }

    public void asignarAnimal(Animal animal) {
        animalesAsignados.add(animal);
    }

    public void alimentar(Animal animal) {
        System.out.println(nombre + " alimenta a " + animal.getNombre());
        animal.comer();
    }

    public void bañar(Animal animal) {
        System.out.println(nombre + " bana a " + animal.getNombre());
    }

    public void limpiarHabitat(Animal animal) {
        System.out.println(nombre + " limpia el habitat de " + animal.getNombre());
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getEspecialidad() { return especialidad; }
    public List<Animal> getAnimalesAsignados() { return animalesAsignados; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
}
