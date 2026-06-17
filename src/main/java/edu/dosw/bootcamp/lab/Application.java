package edu.dosw.bootcamp.lab;
import edu.dosw.bootcamp.lab.creacionales.reto2ChefEstrellas.Reto2ChefEstrellas;
import edu.dosw.bootcamp.lab.comportamiento.reto4CasaDeCambio.Reto4CasaDeCambio;
import edu.dosw.bootcamp.lab.comportamiento.reto6SoporteTecnico.Reto6SoporteTecnico;
import edu.dosw.bootcamp.lab.solid.reto1TiendaDonPepe.Reto1TiendaDonPepe;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // Reto 1
        Reto1TiendaDonPepe.main();
        // Reto 2
        Reto2ChefEstrellas.main();
        // Reto 4
        Reto4CasaDeCambio.main();
        // Reto 6
        Reto6SoporteTecnico.main();
    }
}