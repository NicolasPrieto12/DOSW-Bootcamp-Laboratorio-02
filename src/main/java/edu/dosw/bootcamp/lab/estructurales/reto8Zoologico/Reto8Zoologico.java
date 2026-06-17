package edu.dosw.bootcamp.lab.estructurales.reto8Zoologico;

public class Reto8Zoologico {

    public static void main() {
        // Animales base
        Mamifero leon = new Mamifero("Leon", 5, "Carnivoro", "Carne", 190, 1.2, "Saludable", "Sabana", "Roar");
        Reptil cocodrilo = new Reptil("Cocodrilo", 10, "Carnivoro", "Pez", 500, 0.5, "Saludable", "Rio", "Hiss");
        Ave aguila = new Ave("Aguila", 3, "Carnivoro", "Raton", 5, 0.9, "Saludable", "Montaña", "Screech");

        // Decoradores aplicados
        Animal leonDecorado = new ConPelaje(new ConOrigen(leon, "Africa"), "Dorado");
        Animal cocodriloDecorado = new ConRareza(cocodrilo, "Muy raro");
        ConHistorialMedico aguilaConHistorial = new ConHistorialMedico(aguila);
        aguilaConHistorial.agregarRegistro("Vacuna antiparasitaria - 2024");
        aguilaConHistorial.agregarRegistro("Revision anual - 2025");

        System.out.println("=== ECI Zoo ===");
        System.out.println(leonDecorado.getDescripcion());
        leonDecorado.emitirSonido();
        System.out.println(cocodriloDecorado.getDescripcion());
        cocodriloDecorado.emitirSonido();
        System.out.println(aguilaConHistorial.getDescripcion());
        aguilaConHistorial.emitirSonido();

        // Cuidador
        Cuidador cuidador = new Cuidador("Carlos", 30, "Mamiferos");
        cuidador.asignarAnimal(leon);
        cuidador.alimentar(leon);
        cuidador.bañar(cocodrilo);
        cuidador.limpiarHabitat(aguila);

        // Visitante
        Visitante visitante = new Visitante("Maria", 25);
        visitante.agregarFavorito(leon);
        visitante.alimentar(aguila);
        visitante.darPropina(cuidador);
        visitante.subirFoto(leon);
    }
}
