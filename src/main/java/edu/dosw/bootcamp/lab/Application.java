package edu.dosw.bootcamp.lab;
import edu.dosw.bootcamp.lab.solid.reto1TiendaDonPepe.Reto1TiendaDonPepe;
import edu.dosw.bootcamp.lab.creacionales.reto2ChefEstrellas.Reto2ChefEstrellas;
import edu.dosw.bootcamp.lab.creacionales.reto3ReinoVehiculos.Reto3ReinoVehiculos;
import edu.dosw.bootcamp.lab.comportamiento.reto4CasaDeCambio.Reto4CasaDeCambio;
import edu.dosw.bootcamp.lab.estructurales.reto5CafePersonalizado.Reto5CafePersonalizado;
import edu.dosw.bootcamp.lab.comportamiento.reto6SoporteTecnico.Reto6SoporteTecnico;
import edu.dosw.bootcamp.lab.comportamiento.reto7ControlRemoto.Reto7ControlRemoto;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // Reto 1
        Reto1TiendaDonPepe.main();
        // Reto 2
        Reto2ChefEstrellas.main();
        // Reto 3
        Reto3ReinoVehiculos.main();
        // Reto 4
        Reto4CasaDeCambio.main();
        // Reto 5
        Reto5CafePersonalizado.main();
        // Reto 6
        Reto6SoporteTecnico.main();
        // Reto 7
        Reto7ControlRemoto.main();
    }
}