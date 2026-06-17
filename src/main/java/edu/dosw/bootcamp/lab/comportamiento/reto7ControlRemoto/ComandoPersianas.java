package edu.dosw.bootcamp.lab.comportamiento.reto7ControlRemoto;

public class ComandoPersianas implements Comando {
    private final String accion;
    private final int porcentaje;
    public ComandoPersianas(String accion, int porcentaje) {
        this.accion = accion;
        this.porcentaje = porcentaje;
    }
    @Override
    public void ejecutar() {
        if (accion.equalsIgnoreCase("subir")) {
            System.out.println("Persianas subidas al " + porcentaje + "%");
        } else {
            System.out.println("Persianas bajadas al " + porcentaje + "%");
        }
    }
    @Override
    public void deshacer() {
        if (accion.equalsIgnoreCase("subir")) {
            System.out.println("Acción deshecha: Persianas vuelven a bajar.");
        } else {
            System.out.println("Acción deshecha: Persianas vuelven a subir.");
        }
    }
    @Override
    public String getDescripcion() {
        return "Persianas " + accion + "(" + porcentaje + "%)";
    }
}