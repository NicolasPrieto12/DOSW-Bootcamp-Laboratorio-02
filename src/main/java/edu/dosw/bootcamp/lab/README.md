# Documentación Hackathon - Retos 2, 4, 6 y 8

**Integrantes:** Sara Arteaga - Nicolas Prieto

---

## Reto 2 - El Chef de 5 Estrellas

### Patrón de Diseño
- **Categoría:** Creacional
- **Patrón utilizado:** Builder

### Justificación
Se eligió Builder porque una hamburguesa se construye paso a paso con ingredientes opcionales. Usar un constructor con múltiples parámetros sería confuso y difícil de mantener. El Builder permite construir el objeto de forma clara y flexible.

### Cómo lo apliqué
| Clase | Rol |
|---|---|
| `Ingrediente` | Clase inmutable que representa cada ingrediente con nombre y precio |
| `HamburguesaBuilder` | Construye la hamburguesa paso a paso con métodos encadenados |
| `Hamburguesa` | Producto final, usa Streams para calcular el precio total |
| `Chef` | Director que interactúa con el usuario y usa el Builder |
| `Reto2ChefEstrellas` | Punto de entrada con el método `ejecutar()` |

### Principios SOLID aplicados
- **S:** Cada clase tiene una sola responsabilidad
- **O:** Se pueden agregar nuevos ingredientes sin modificar clases existentes
- **I:** Cada clase expone solo los métodos que necesita
- **D:** Chef depende del Builder (abstracción), no construye la Hamburguesa directamente

---

## Reto 4 - La Estafa de la Casa de Cambio

### Patrón de Diseño
- **Categoría:** Comportamiento
- **Patrón utilizado:** Strategy

### Justificación
Se eligió Strategy porque cada moneda tiene su propio algoritmo de conversión. El patrón permite intercambiar el algoritmo según la moneda origen sin modificar el contexto, cumpliendo con OCP.

### Cómo lo apliqué
| Clase | Rol |
|---|---|
| `EstrategiaConversion` | Interfaz que define el contrato de conversión |
| `ConversionCOP` | Estrategia concreta para convertir desde Peso Colombiano |
| `ConversionEUR` | Estrategia concreta para convertir desde Euro |
| `ConversionJPY` | Estrategia concreta para convertir desde Yen Japonés |
| `ConversionUSD` | Estrategia concreta para convertir desde Dólar |
| `Transaccion` | Almacena los datos de cada conversión |
| `CasaDeCambio` | Contexto que selecciona y ejecuta la estrategia según la moneda origen |
| `Reto4CasaDeCambio` | Punto de entrada con el método `ejecutar()` |

### Principios SOLID aplicados
- **S:** Cada clase tiene una sola responsabilidad
- **O:** Para agregar una nueva moneda solo se crea una nueva clase sin modificar las existentes
- **L:** Cualquier estrategia puede sustituirse sin alterar el comportamiento del sistema
- **I:** `EstrategiaConversion` expone solo los métodos necesarios
- **D:** `CasaDeCambio` depende de la interfaz `EstrategiaConversion`, no de implementaciones concretas

---

## Reto 6 - Soporte Técnico

### Patrón de Diseño
- **Categoría:** Comportamiento
- **Patrón utilizado:** Chain of Responsibility

### Justificación
Se eligió Chain of Responsibility porque cada técnico intenta resolver el ticket según su nivel y si no puede lo pasa al siguiente, sin que el cliente sepa quién lo resuelve. Permite agregar nuevos niveles sin modificar los existentes.

### Cómo lo apliqué
| Clase | Rol |
|---|---|
| `Ticket` | Almacena descripción, nivel, prioridad y estado del ticket |
| `Tecnico` | Clase abstracta base con `manejar()` y `setSiguiente()` |
| `TecnicoBasico` | Resuelve tickets de nivel básico o pasa al siguiente |
| `TecnicoIntermedio` | Resuelve tickets de nivel intermedio o pasa al siguiente |
| `TecnicoAvanzado` | Resuelve tickets de nivel avanzado o marca como pendiente |
| `Reto6SoporteTecnico` | Punto de entrada, usa Streams para estadísticas finales |

### Principios SOLID aplicados
- **S:** Cada clase tiene una sola responsabilidad
- **O:** Para agregar un nuevo nivel solo se crea una nueva clase que extienda `Tecnico`
- **L:** Todos los técnicos pueden sustituirse entre sí en la cadena sin alterar el comportamiento
- **I:** `Tecnico` expone solo el método `manejar()` necesario para procesar tickets
- **D:** Cada técnico depende de la abstracción `Tecnico` para encadenar el siguiente

---

## Reto 8 - El Zoológico de los UML

### Patrón de Diseño
- **Categoría:** Estructural
- **Patrón utilizado:** Decorator

### Justificación
Se eligió Decorator para agregar atributos dinámicos a los animales (color de pelaje, origen, rareza, historial médico) sin modificar las clases base. Permite combinar múltiples atributos en tiempo de ejecución de forma flexible.

### Cómo lo apliqué
| Clase | Rol |
|---|---|
| `Animal` | Clase abstracta base con atributos encapsulados y métodos de interacción |
| `Mamifero` | Subclase de Animal que representa mamíferos |
| `Reptil` | Subclase de Animal que representa reptiles |
| `Ave` | Subclase de Animal que representa aves |
| `AnimalDecorator` | Clase abstracta base del patrón Decorator |
| `ConPelaje` | Decorador que agrega color de pelaje |
| `ConOrigen` | Decorador que agrega origen geográfico |
| `ConRareza` | Decorador que agrega nivel de rareza |
| `ConHistorialMedico` | Decorador que agrega historial médico dinámico |
| `Cuidador` | Gestiona la atención de los animales (1 cuidador ↔ N animales) |
| `Visitante` | Interactúa con animales y cuidadores |
| `Reto8Zoologico` | Punto de entrada con el método `ejecutar()` |

### Principios SOLID aplicados
- **S:** Cada clase tiene una sola responsabilidad
- **O:** Para agregar un nuevo atributo dinámico solo se crea un nuevo decorador
- **L:** `Mamifero`, `Reptil` y `Ave` pueden usarse donde se espera un `Animal`
- **I:** `Animal` expone solo los métodos necesarios para todos los animales
- **D:** `Cuidador` y `Visitante` dependen de la abstracción `Animal`, no de subclases concretas

### Diagrama UML
[Ver diagrama UML en Lucidchart](https://lucid.app/lucidchart/fae45f47-d5ff-44c1-aee9-33e7a41108f2/edit?view_items=A.l7Z~GMbYBm&page=0_0&invitationId=inv_128280fd-3b48-492f-b1ad-f47ac2d73a8c)
