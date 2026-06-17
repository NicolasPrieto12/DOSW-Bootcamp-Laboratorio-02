package edu.dosw.bootcamp.lab.util;

import edu.dosw.bootcamp.lab.creacionales.reto2ChefEstrellas.Reto2ChefEstrellas;
import edu.dosw.bootcamp.lab.comportamiento.reto4CasaDeCambio.Reto4CasaDeCambio;
import edu.dosw.bootcamp.lab.comportamiento.reto6SoporteTecnico.Reto6SoporteTecnico;
import edu.dosw.bootcamp.lab.estructurales.reto8Zoologico.Reto8Zoologico;

public class AppRunner {

    public static void run() {
        // Reto 2
        Reto2ChefEstrellas.ejecutar();

        // Reto 4
        Reto4CasaDeCambio.ejecutar();

        // Reto 6
        Reto6SoporteTecnico.ejecutar();

        // Reto 8
        Reto8Zoologico.ejecutar();
    }
}
