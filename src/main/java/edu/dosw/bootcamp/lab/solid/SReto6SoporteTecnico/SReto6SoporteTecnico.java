package edu.dosw.bootcamp.lab.solid.SReto6SoporteTecnico;

// =====================================================================
// PRINCIPIOS SOLID APLICADOS EN EL RETO 6 - Soporte Tecnico
// =====================================================================

// S - Single Responsibility Principle (SRP)
// Cada clase tiene una sola responsabilidad:
//   - Ticket: solo almacena los datos del ticket y su estado
//   - Tecnico: define el contrato de la cadena de manejo
//   - TecnicoBasico/Intermedio/Avanzado: cada uno solo resuelve su nivel
//   - Reto6SoporteTecnico: solo sirve como punto de entrada

// O - Open/Closed Principle (OCP)
// Para agregar un nuevo nivel (ej: Critico) solo se crea TecnicoCritico
// que extienda Tecnico y se agrega al final de la cadena,
// sin modificar las clases existentes.

// L - Liskov Substitution Principle (LSP)
// TecnicoBasico, TecnicoIntermedio y TecnicoAvanzado pueden sustituirse
// entre si en la cadena sin alterar el comportamiento esperado,
// ya que todos extienden Tecnico y respetan su contrato.

// I - Interface Segregation Principle (ISP)
// Tecnico expone solo el metodo manejar() que es lo unico necesario
// para que cada eslabon procese o pase el ticket.

// D - Dependency Inversion Principle (DIP)
// Cada tecnico depende de la abstraccion Tecnico para encadenar
// el siguiente, no de implementaciones concretas.

public class SReto6SoporteTecnico {
    // Esta clase documenta los principios SOLID aplicados en el Reto 6
}
