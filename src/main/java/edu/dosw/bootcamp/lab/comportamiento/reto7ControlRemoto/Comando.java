package edu.dosw.bootcamp.lab.comportamiento.reto7ControlRemoto;

public interface Comando {
    void ejecutar();
    void deshacer();
    String getDescripcion();
}