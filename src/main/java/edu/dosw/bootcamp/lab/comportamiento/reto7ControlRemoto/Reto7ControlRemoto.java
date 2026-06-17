package edu.dosw.bootcamp.lab.comportamiento.reto7ControlRemoto;
import java.util.Scanner;

public class Reto7ControlRemoto {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        ControlRemoto control = new ControlRemoto();
        System.out.println("Control Remoto Magico");
        System.out.println("Dispositivos: luces, puertas, música, persianas");
        System.out.print("¿Cuántos usuarios van a usar el control?: ");
        int numUsuarios = Integer.parseInt(sc.nextLine()
                                             .trim());
        for (int u = 1; u <= numUsuarios; u++) {
            System.out.print("\nNombre de usuario " + u + ": ");
            String usuario = sc.nextLine()
                               .trim();
            System.out.print("¿Cuántas acciones realizará " + usuario + "? ");
            int numAcciones = Integer.parseInt(sc.nextLine()
                                                 .trim());
            for (int i = 1; i <= numAcciones; i++) {
                System.out.printf("Acción %d - Dispositivo: ", i);
                String dispositivo = sc.nextLine()
                                       .trim()
                                       .toLowerCase();
                Comando comando = null;
                switch (dispositivo) {
                    case "luces" -> {
                        System.out.print("¿Encender o Apagar?: ");
                        String accion = sc.nextLine()
                                          .trim();
                        int intensidad = 0;
                        if (accion.equalsIgnoreCase("encender")) {
                            System.out.print("¿Qué intensidad?: % ");
                            intensidad = Integer.parseInt(sc.nextLine()
                                                            .trim());
                        }
                        comando = new ComandoLuces(accion, intensidad);
                    }
                    case "puertas" -> {
                        System.out.print("¿Abrir o cerrar?: ");
                        String accion = sc.nextLine()
                                          .trim();
                        comando = new ComandoPuertas(accion);
                    }
                    case "musica" -> {
                        System.out.print("¿Reproducir o parar?: ");
                        String accion = sc.nextLine()
                                          .trim();
                        int volumen = 0;
                        if (accion.equalsIgnoreCase("reproducir")) {
                            System.out.print("¿Con cuánto volumen?: % ");
                            volumen = Integer.parseInt(sc.nextLine().trim());
                        }
                        comando = new ComandoMusica(accion, volumen);
                    }
                    case "persianas" -> {
                        System.out.print("¿Subir o bajar?: ");
                        String accion = sc.nextLine()
                                          .trim();
                        System.out.print("¿Qué tanto?: % ");
                        int porcentaje = Integer.parseInt(sc.nextLine()
                                                            .trim());
                        comando = new ComandoPersianas(accion, porcentaje);
                    }
                    default -> System.out.println("Dispositivo no reconocido.");
                }
                if (comando != null) {
                    control.ejecutar(comando, usuario);
                }
            }
        }
        System.out.print("\n¿Deseas deshacer alguna acción?: ");
        String resp = sc.nextLine()
                        .trim()
                        .toLowerCase();
        while (resp.equals("si")) {
            System.out.print("Ingresa el número de acción que quieres deshacer: ");
            int num = Integer.parseInt(sc.nextLine()
                                         .trim());
            control.deshacer(num);
            System.out.print("¿Quieres deshacer alguna otra?: ");
            resp = sc.nextLine()
                     .trim()
                     .toLowerCase();
        }
    }
}