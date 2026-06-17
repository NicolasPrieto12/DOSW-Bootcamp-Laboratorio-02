# DOSW Bootcamp — Laboratorio 2
## Hackathon Express · SOLID · Patrones · UML

**Integrantes:** Sara Arteaga · Nicolás Prieto  
**Rama:** feature/ArteagaSara_PrietoNicolas_2026-INT

---

# Reto 1 — La Tienda de Don Pepe

## Descripción
Sistema de ventas que permite a un cliente elegir productos de un catálogo, agregarlos al carrito y obtener un recibo con descuento según su tipo (nuevo o frecuente).

## Principios SOLID aplicados

**S — Single Responsibility Principle**  
Cada clase tiene una sola responsabilidad:
- `Producto`: representa un producto con nombre y precio.
- `ItemCarrito`: une un producto con la cantidad comprada.
- `Carrito`: gestiona la lista de ítems y calcula el subtotal.
- `Recibo`: imprime el resumen de la compra.
- `Cliente`: guarda el tipo de cliente y su estrategia de descuento.

**O — Open/Closed Principle**  
La interfaz `EstrategiaDescuento` permite agregar nuevos tipos de descuento sin modificar clases existentes. Solo se crea una nueva clase que implemente la interfaz.

**L — Liskov Substitution Principle**  
`DescuentoNuevo` y `DescuentoFrecuente` son intercambiables en cualquier lugar donde se use `EstrategiaDescuento` sin romper el comportamiento del programa.

**I — Interface Segregation Principle**  
La interfaz `EstrategiaDescuento` es pequeña y específica: solo define `calcularDescuento()` y `getDescripcion()`.

**D — Dependency Inversion Principle**  
`Cliente` y `Recibo` dependen de la abstracción `EstrategiaDescuento`, no de `DescuentoNuevo` o `DescuentoFrecuente` directamente.

## Polimorfismo
Se aplica a través de `EstrategiaDescuento`. Según el tipo ingresado, `Cliente` asigna una implementación distinta:
```java
if (tipo.equalsIgnoreCase("frecuente")) {
    this.descuento = new DescuentoFrecuente(); // 10%
} else {
    this.descuento = new DescuentoNuevo();     // 5%
}
```
`Recibo` llama `cliente.getDescuento().calcularDescuento(subtotal)` sin saber qué implementación concreta está usando.

## Inmutabilidad
El precio unitario de `Producto` es `final` y solo se asigna en el constructor. Ninguna parte del sistema puede modificarlo después de ser creado.

## Streams usados
- `Carrito.calcularSubtotal()` → `mapToDouble + sum`

## Evidencia de ejecución

![Reto1](https://github.com/NicolasPrieto12/DOSW-Bootcamp-Laboratorio-02/blob/main/Reto1.png)

---

# Reto 2 — El Chef de 5 Estrellas

## Descripción
Sistema para construir hamburguesas personalizadas paso a paso. El cliente elige pan, carne, queso, vegetales y salsa. El chef ensambla la hamburguesa y muestra el precio total.

## Patrón de Diseño

**Categoría:** Creacional  
**Patrón utilizado:** Builder

**Justificación:** Una hamburguesa tiene muchos componentes opcionales. Sin Builder, el constructor tendría demasiados parámetros y sería confuso. Builder permite construir el objeto paso a paso, solo con los ingredientes que el cliente elija, manteniendo el código limpio y legible.

**Cómo lo aplicamos:**

| Clase | Rol |
|-------|-----|
| `Hamburguesa` | Producto final — contiene todos los ingredientes y calcula el total |
| `HamburguesaBuilder` | Builder — acumula ingredientes con métodos encadenables y construye con `build()` |
| `Ingrediente` | Clase inmutable — nombre y precio de cada componente |
| `Chef` | Director — usa el Builder para tomar el pedido paso a paso |
| `Reto2ChefEstrellas` | Cliente — instancia el Chef y muestra el resultado |

## Evidencia de ejecución

![Reto 2](https://github.com/NicolasPrieto12/DOSW-Bootcamp-Laboratorio-02/blob/main/Reto2.png)

---

# Reto 3 — El Reino de los Vehículos

## Descripción
Concesionaria que vende vehículos de tierra, acuáticos y aéreos en categorías Económico, Lujo y Usado. El usuario elige cuántos vehículos comprar, su tipo, modelo y categoría. Al final se muestra el total con Streams.

## Patrón de Diseño

**Categoría:** Creacional  
**Patrón utilizado:** Abstract Factory

**Justificación:** El problema tiene dos dimensiones de variación: tipo de medio (tierra, acuático, aéreo) y categoría (económico, lujo, usado). Abstract Factory permite crear familias de vehículos sin que el código cliente conozca las clases concretas. Agregar un nuevo tipo de medio solo requiere una nueva fábrica sin modificar nada existente.

**Cómo lo aplicamos:**

| Clase | Rol |
|-------|-----|
| `FabricaVehiculos` | Interfaz Abstract Factory — define `crearVehiculo(modelo, categoria)` |
| `FabricaTierra` | Fábrica concreta — crea Auto, Bicicleta, Moto |
| `FabricaAcuatica` | Fábrica concreta — crea Lancha, Velero, Jet Ski |
| `FabricaAerea` | Fábrica concreta — crea Avion, Avioneta, Helicoptero |
| `Vehiculo` | Producto abstracto — atributos comunes y getters |
| `Auto`, `Moto`, `Lancha`, etc. | Productos concretos — velocidad y precio según categoría |
| `Reto3ReinoVehiculos` | Cliente — elige la fábrica y usa `crearVehiculo()` |

## Streams usados
- `compra.stream().mapToDouble(Vehiculo::getPrecio).sum()` para el total de la compra.

## Evidencia de ejecución

![Reto 3](https://github.com/NicolasPrieto12/DOSW-Bootcamp-Laboratorio-02/blob/main/Reto3.png)

---

# Reto 4 — La Estafa de la Casa de Cambio

## Descripción
Casa de cambio honesta que convierte entre COP, EUR, JPY y USD usando tasas de cambio reales. El usuario ingresa X transacciones y al final se muestra el total equivalente en USD.

## Patrón de Diseño

**Categoría:** Comportamiento  
**Patrón utilizado:** Strategy

**Justificación:** Cada moneda tiene su propia lógica de conversión. Sin Strategy, habría un bloque `if/else` gigante mezclado con la lógica del negocio. Con Strategy, cada moneda encapsula su regla de conversión en una clase separada. Agregar una nueva moneda solo requiere crear una nueva clase que implemente `EstrategiaConversion`.

**Cómo lo aplicamos:**

| Clase | Rol |
|-------|-----|
| `EstrategiaConversion` | Interfaz Strategy — define `convertir()`, `getCodigo()`, `getSimbolo()` |
| `ConversionCOP` | Estrategia concreta — lógica de conversión para COP |
| `ConversionEUR` | Estrategia concreta — lógica de conversión para EUR |
| `ConversionJPY` | Estrategia concreta — lógica de conversión para JPY |
| `ConversionUSD` | Estrategia concreta — lógica de conversión para USD |
| `CasaDeCambio` | Contexto — selecciona la estrategia y ejecuta la conversión |
| `Transaccion` | Guarda el resultado con su equivalente en USD |
| `Reto4CasaDeCambio` | Cliente — lee transacciones y muestra el resumen |

## Streams usados
- `transacciones.stream().mapToDouble(Transaccion::getEquivalenteUSD).sum()` para el total acumulado en USD.

## Evidencia de ejecución

![Reto 4](https://github.com/NicolasPrieto12/DOSW-Bootcamp-Laboratorio-02/blob/main/Reto4.png)

---

# Reto 5 — El Café Personalizado

## Descripción
Cafetería que permite personalizar un café base (Espresso) agregando toppings dinámicamente. Cada topping añade su precio y descripción. Se pueden agregar nuevos toppings sin modificar la clase base del café.

## Patrón de Diseño

**Categoría:** Estructural  
**Patrón utilizado:** Decorator

**Justificación:** El problema requiere agregar funcionalidades (toppings) a un objeto base (café) de forma dinámica, sin modificar la clase original. Cada decorador envuelve al anterior sumando su precio y descripción. Cumple el principio Abierto/Cerrado: agregar un nuevo topping solo requiere crear una nueva clase que extienda `ToppingDecorador`.

**Cómo lo aplicamos:**

| Clase | Rol |
|-------|-----|
| `Cafe` | Interfaz componente — define `getDescripcion()` y `getPrecio()` |
| `Espresso` | Componente concreto — café base con precio $3.500 |
| `ToppingDecorador` | Decorador abstracto — envuelve un `Cafe` y delega por defecto |
| `LecheAvena` | Decorador concreto — agrega +$1.200 y descripción |
| `Caramelo` | Decorador concreto — agrega +$800 y descripción |
| `Chantilly` | Decorador concreto — agrega +$1.000 y descripción |
| `Reto5CafePersonalizado` | Cliente — encadena decoradores según la elección del usuario |

## Evidencia de ejecución

![Reto 5](https://github.com/NicolasPrieto12/DOSW-Bootcamp-Laboratorio-02/blob/main/Reto5.png)

---

# Reto 6 — Soporte Técnico

## Descripción
Sistema que recibe tickets con distintos niveles de complejidad. Cada técnico intenta resolver el ticket y si no puede, lo pasa al siguiente en la cadena. Al final se muestran estadísticas con Streams.

## Patrón de Diseño

**Categoría:** Comportamiento  
**Patrón utilizado:** Chain of Responsibility

**Justificación:** Cada ticket debe ser procesado por el técnico adecuado, pero el sistema no sabe de antemano quién lo resolverá. La cadena permite que cada técnico intente resolver el ticket y, si no puede, lo pase al siguiente. Agregar un nuevo nivel solo requiere crear un nuevo `Tecnico` e insertarlo en la cadena.

**Cómo lo aplicamos:**

| Clase | Rol |
|-------|-----|
| `Tecnico` | Handler abstracto — define `manejar()` y `setSiguiente()` |
| `TecnicoBasico` | Handler concreto — resuelve nivel básico, pasa el resto |
| `TecnicoIntermedio` | Handler concreto — resuelve nivel intermedio, pasa el resto |
| `TecnicoAvanzado` | Handler concreto — resuelve nivel avanzado, marca pendiente si es crítico |
| `Ticket` | Contiene descripción, nivel, prioridad y estado de resolución |
| `Reto6SoporteTecnico` | Cliente — crea la cadena y envía los tickets |

## Streams usados
- Conteo por técnico: `tickets.stream().filter(t -> t.isResuelto() && t.getResolvedBy().equals(...)).count()`
- Pendientes: `tickets.stream().filter(t -> !t.isResuelto()).count()`
- Promedio prioridad: `tickets.stream().filter(Ticket::isResuelto).mapToInt(Ticket::getPrioridadValor).average()`

## Evidencia de ejecución

![Reto 6](https://github.com/NicolasPrieto12/DOSW-Bootcamp-Laboratorio-02/blob/main/Reto6.png)

---

# Reto 7 — El Control Remoto Mágico

## Descripción
Control remoto que permite a múltiples usuarios ejecutar acciones sobre dispositivos del hogar (luces, puertas, música, persianas). Mantiene un historial con el usuario que realizó cada acción y permite deshacer acciones individuales.

## Patrón de Diseño

**Categoría:** Comportamiento  
**Patrón utilizado:** Command

**Justificación:** El patrón Command encapsula cada acción como un objeto independiente, lo que permite guardarlas en un historial y deshacerlas individualmente sin que el control remoto sepa cómo funciona cada dispositivo internamente. Cada comando sabe cómo ejecutarse y cómo revertirse.

**Cómo lo aplicamos:**

| Clase | Rol |
|-------|-----|
| `Comando` | Interfaz — define `ejecutar()`, `deshacer()`, `getDescripcion()` |
| `ComandoLuces` | Comando concreto — encender/apagar con intensidad |
| `ComandoPuertas` | Comando concreto — abrir/cerrar puerta |
| `ComandoMusica` | Comando concreto — reproducir/parar con volumen |
| `ComandoPersianas` | Comando concreto — subir/bajar con porcentaje |
| `RegistroAccion` | Almacena el comando, el usuario y si fue deshecho |
| `ControlRemoto` | Invocador — ejecuta comandos y mantiene el historial |
| `Reto7ControlRemoto` | Cliente — crea los comandos según el input del usuario |

## Evidencia de ejecución

![Reto 7](https://github.com/NicolasPrieto12/DOSW-Bootcamp-Laboratorio-02/blob/main/Reto7.png)

---

# Reto 8 — El Zoológico de los UML

## Descripción
Sistema de gestión del zoológico ECI Zoo con animales de tres especies, cuidadores que los atienden y visitantes que interactúan con ellos. Diseñado con SOLID, patrones de diseño y documentado con diagrama UML de clases.

---

## Diagrama UML de Clases

![Reto 8](https://github.com/NicolasPrieto12/DOSW-Bootcamp-Laboratorio-02/blob/main/Reto8UML.png)

https://lucid.app/lucidchart/fae45f47-d5ff-44c1-aee9-33e7a41108f2/edit?invitationId=inv_128280fd-3b48-492f-b1ad-f47ac2d73a8c&page=0_0#
---

## Descripción del diseño

### Jerarquía de Animal
`Animal` es una clase abstracta con atributos comunes (nombre, edad, dieta, alimento preferido, peso, altura, estado de salud, hábitat) y métodos `emitirSonido()` y `comer()`. De ella heredan tres especies concretas:

- **Mamifero**: agrega atributo `sonido` e implementa `emitirSonido()` y `getDescription()`
- **Reptil**: agrega atributo `sonido` e implementa `emitirSonido()` y `getDescription()`
- **Ave**: agrega atributo `sonido` e implementa `emitirSonido()` y `getDescription()`

### Cuidador
Tiene nombre, edad, especialidad y una lista de animales asignados. Sus métodos son `asignarAnimal()`, `alimentar()`, `bañar()` y `limpiarHabitat()`. Se asocia con 1 o más animales (1..*).

### Visitante
Tiene nombre, edad, lista de animales favoritos y fotografías. Sus métodos son `alimentar()`, `darPropina()`, `subirFoto()` y `agregarFavorito()`. Se asocia con 0 o más animales (0..*).

---

## Patrón de Diseño

**Categoría:** Estructural
**Patrón utilizado:** Decorator

**Justificación:** Los animales pueden tener atributos dinámicos adicionales (color de pelaje, origen, rareza, historial médico) que no todos comparten y que pueden combinarse entre sí. El patrón Decorator permite agregar estos atributos envolviendo el animal en capas, sin modificar las clases base ni crear una explosión de subclases para cada combinación posible.

**Cómo lo aplicamos:**

| Clase | Rol |
|-------|-----|
| `Animal` | Componente abstracto — define la interfaz base |
| `Mamifero`, `Reptil`, `Ave` | Componentes concretos — implementaciones base de cada especie |
| `AnimalDecorator` | Decorador abstracto — envuelve un `Animal` y delega por defecto |
| `ConPelaje` | Decorador concreto — agrega atributo `colorPelaje` y lo incluye en `getDescription()` |
| `ConOrigen` | Decorador concreto — agrega atributo `origen` y lo incluye en `getDescription()` |
| `ConRareza` | Decorador concreto — agrega atributo `rareza` y lo incluye en `getDescription()` |
| `ConHistorialMedico` | Decorador concreto — agrega lista `historial` con método `agregarRegistro()` |

---

## Principios SOLID aplicados

**S — Single Responsibility Principle**
Cada clase tiene una sola responsabilidad: `Animal` representa un animal, `Cuidador` gestiona el cuidado, `Visitante` maneja las interacciones del visitante, y cada decorador agrega un único atributo dinámico.

**O — Open/Closed Principle**
El sistema está abierto para agregar nuevos atributos dinámicos (nuevos decoradores) sin modificar las clases `Animal`, `Mamifero`, `Reptil` o `Ave`.

**L — Liskov Substitution Principle**
`Mamifero`, `Reptil`, `Ave` y todos los decoradores pueden usarse en cualquier lugar donde se espere un `Animal` sin alterar el comportamiento del sistema.

**I — Interface Segregation Principle**
Los métodos de `Cuidador` y `Visitante` están separados según su responsabilidad. No se obliga a ninguna clase a implementar métodos que no le corresponden.

**D — Dependency Inversion Principle**
`Cuidador` y `Visitante` dependen de la abstracción `Animal`, no de `Mamifero`, `Reptil` o `Ave` directamente.
