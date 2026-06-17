package edu.dosw.bootcamp.lab.solid.SReto8Zoologico;

// =====================================================================
// PRINCIPIOS SOLID APLICADOS EN EL RETO 8 - El Zoologico de los UML
// =====================================================================

// S - Single Responsibility Principle (SRP)
// Cada clase tiene una sola responsabilidad:
//   - Animal: define atributos y comportamientos base de un animal
//   - Mamifero/Reptil/Ave: cada una representa su especie especifica
//   - AnimalDecorator: base para agregar atributos dinamicos
//   - ConPelaje/ConOrigen/ConRareza/ConHistorialMedico: cada uno agrega un atributo dinamico
//   - Cuidador: gestiona la atencion de los animales
//   - Visitante: gestiona la interaccion del visitante con el zoo

// O - Open/Closed Principle (OCP)
// Para agregar un nuevo atributo dinamico (ej: ConVacunas) solo se crea
// un nuevo decorador que extienda AnimalDecorator, sin modificar Animal
// ni sus subclases existentes.

// L - Liskov Substitution Principle (LSP)
// Mamifero, Reptil y Ave pueden usarse donde se espera un Animal
// sin alterar el comportamiento del sistema.
// Los decoradores tambien pueden sustituirse entre si ya que todos
// extienden AnimalDecorator.

// I - Interface Segregation Principle (ISP)
// Animal expone solo los metodos necesarios para todos los animales:
// emitirSonido(), comer() y getDescripcion().
// Cuidador y Visitante exponen solo sus metodos de interaccion propios.

// D - Dependency Inversion Principle (DIP)
// Cuidador y Visitante dependen de la abstraccion Animal, no de
// Mamifero, Reptil o Ave directamente. Esto permite trabajar con
// cualquier tipo de animal sin cambiar Cuidador ni Visitante.

public class SReto8Zoologico {
    // Esta clase documenta los principios SOLID aplicados en el Reto 8
}
