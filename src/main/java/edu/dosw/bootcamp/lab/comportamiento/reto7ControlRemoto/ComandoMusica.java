package edu.dosw.bootcamp.lab.comportamiento.reto7ControlRemoto;

public class ComandoMusica implements Comando {
    private final String accion;
    private final int volumen;
    public ComandoMusica(String accion, int volumen) {
        this.accion = accion;
        this.volumen = volumen;
    }
    @Override
    public void ejecutar() {
        if (accion.equalsIgnoreCase("reproducir")) {
            System.out.println("Música reproduciéndose con volumen: " + volumen);
        } else {
            System.out.println("Música pausada");
        }
    }
    @Override
    public void deshacer() {
        if (accion.equalsIgnoreCase("reproducir")) {
            System.out.println("Acción deshecha: Música pausada.");
        } else {
            System.out.println("Acción deshecha: Música reproduciéndose.");
        }
    }
    @Override
    public String getDescripcion() {
        if (accion.equalsIgnoreCase("reproducir")) {
            return "Música reproduciéndose(" + volumen + ")";
        } else {
            return "Música detenida";
        }
    }
}