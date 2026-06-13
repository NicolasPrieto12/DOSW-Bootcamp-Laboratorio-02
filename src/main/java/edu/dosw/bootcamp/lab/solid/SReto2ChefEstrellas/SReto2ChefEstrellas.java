package edu.dosw.bootcamp.lab.solid.SReto2ChefEstrellas;

// =====================================================================
// PRINCIPIOS SOLID APLICADOS EN EL RETO 2 - Chef de 5 Estrellas
// =====================================================================

// S - Single Responsibility Principle (SRP)
// Cada clase tiene una sola responsabilidad:
//   - Ingrediente: solo representa un ingrediente con nombre y precio
//   - HamburguesaBuilder: solo construye la hamburguesa paso a paso
//   - Hamburguesa: solo almacena ingredientes y muestra el resultado
//   - Chef: solo interactua con el usuario para tomar el pedido
//   - Reto2ChefEstrellas: solo sirve como punto de entrada (ejecutar)

// O - Open/Closed Principle (OCP)
// HamburguesaBuilder esta abierto para extension (se pueden agregar
// nuevos ingredientes con nuevos metodos) pero cerrado para modificacion.
// Agregar un nuevo tipo de ingrediente no requiere cambiar las clases existentes.

// L - Liskov Substitution Principle (LSP)
// No aplica directamente en este reto ya que no hay herencia,
// pero Ingrediente es inmutable y consistente en todos sus usos.

// I - Interface Segregation Principle (ISP)
// Cada clase expone solo los metodos que necesita:
//   - Ingrediente expone solo getNombre() y getPrecio()
//   - HamburguesaBuilder expone solo los setters y build()
//   - Chef expone solo tomarPedido()

// D - Dependency Inversion Principle (DIP)
// Chef depende de HamburguesaBuilder (abstraccion del proceso de construccion)
// y no construye la Hamburguesa directamente, delegando esa responsabilidad
// al Builder.

public class SReto2ChefEstrellas {
    // Esta clase documenta los principios SOLID aplicados en el Reto 2
}
