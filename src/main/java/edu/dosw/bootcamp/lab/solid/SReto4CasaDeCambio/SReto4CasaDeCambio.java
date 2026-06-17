package edu.dosw.bootcamp.lab.solid.SReto4CasaDeCambio;

// =====================================================================
// PRINCIPIOS SOLID APLICADOS EN EL RETO 4 - La Casa de Cambio
// =====================================================================

// S - Single Responsibility Principle (SRP)
// Cada clase tiene una sola responsabilidad:
//   - EstrategiaConversion: define el contrato de conversion
//   - ConversionCOP/EUR/JPY/USD: cada una convierte solo desde su moneda
//   - Transaccion: solo almacena los datos de una conversion
//   - CasaDeCambio: solo gestiona las estrategias y delega la conversion
//   - Reto4CasaDeCambio: solo sirve como punto de entrada

// O - Open/Closed Principle (OCP)
// Para agregar una nueva moneda (ej: GBP) solo se crea una nueva clase
// ConversionGBP que implemente EstrategiaConversion y se registra en
// CasaDeCambio, sin modificar ninguna clase existente.

// L - Liskov Substitution Principle (LSP)
// Cualquier implementacion de EstrategiaConversion puede usarse
// en CasaDeCambio sin alterar el comportamiento esperado del sistema.

// I - Interface Segregation Principle (ISP)
// EstrategiaConversion expone solo los metodos necesarios:
// convertir(), getCodigo() y getSimbolo(). Ninguna clase implementa
// metodos que no necesita.

// D - Dependency Inversion Principle (DIP)
// CasaDeCambio depende de la interfaz EstrategiaConversion (abstraccion)
// y no de las implementaciones concretas ConversionCOP, ConversionEUR, etc.

public class SReto4CasaDeCambio {
    // Esta clase documenta los principios SOLID aplicados en el Reto 4
}
