package edu.dosw.bootcamp.lab.comportamiento.reto7ControlRemoto;

public class ComandoPuertas implements Comando {
    private final String accion;
    public ComandoPuertas(String accion) {
        this.accion = accion;
    }
    @Override
    public void ejecutar() {
        if (accion.equalsIgnoreCase("abrir")) {
            System.out.println("Puerta abierta");
        } else {
            System.out.println("Puerta cerrada");
        }
    }
    @Override
    public void deshacer() {
        if (accion.equalsIgnoreCase("abrir")) {
            System.out.println("Acción deshecha: Puerta cerrada.");
        } else {
            System.out.println("Acción deshecha: Puerta abierta.");
        }
    }
    @Override
    public String getDescripcion() {
        return "Puertas " + accion;
    }
}