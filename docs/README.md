# Laboratorio 02 — Preguntas Iniciales

> Equipo: Sara Arteaga / Nicolás Prieto

---

### 1. ¿Qué ventaja ofrece el polimorfismo en el diseño de clases frente al uso de múltiples condicionales para determinar el comportamiento de un objeto?

El polimorfismo permite que cada clase implemente su propio comportamiento mediante la sobreescritura de métodos, evitando largas cadenas de `if/else` o `switch` que verifican el tipo de objeto antes de actuar.

Esto trae varios beneficios:

- **Código más limpio y legible**, sin condicionales anidados que crecen con cada nuevo caso.
- **Extensibilidad**: para agregar un nuevo tipo basta con crear una nueva clase que implemente la interfaz o herede de la clase base, sin modificar el código existente.
- **Menor acoplamiento**: el código cliente solo conoce la interfaz común, no los detalles internos de cada implementación.

En resumen, el polimorfismo delega la decisión de "qué hacer" a cada objeto, en lugar de centralizarla en condicionales dispersos por el sistema.

---

### 3. ¿Qué problema podría aparecer en un sistema si los atributos de las clases se mantienen públicos en lugar de privados con getters y setters controlados?

Si los atributos son públicos, cualquier parte del programa puede modificarlos directamente sin pasar por ninguna validación, lo que puede dejar el objeto en un **estado inconsistente o inválido** (por ejemplo, asignar un saldo negativo o una edad fuera de rango).

Principales problemas:

- **Violación del encapsulamiento**: la lógica de validación queda dispersa o ausente.
- **Difícil mantenimiento**: no hay un punto centralizado de control sobre cómo cambian los datos.
- **Mayor riesgo de errores**: el estado del objeto puede alterarse desde cualquier lugar del código, dificultando el rastreo de bugs.

Usar getters y setters permite validar, controlar y registrar los cambios, además de poder modificar la implementación interna sin afectar a quienes usan la clase.

---

### 5. ¿Por qué es importante que una clase cumpla con el Principio de Única Responsabilidad? Da un ejemplo donde se vulnere.

El **Principio de Única Responsabilidad (SRP)** establece que una clase debe tener una sola razón para cambiar, es decir, debe encargarse de una sola tarea o responsabilidad bien definida.

Es importante porque:

- Facilita el **mantenimiento** y las **pruebas unitarias**.
- Favorece la **reutilización** del código.
- Evita que un cambio en una responsabilidad rompa funcionalidades no relacionadas.

**Ejemplo donde se vulnera:**
Una clase `Empleado` que, además de almacenar los datos del empleado (nombre, salario, cargo), también calcula el pago de nómina, genera reportes en PDF y guarda los datos en la base de datos. Si cambia la forma de generar el reporte o la lógica de la base de datos, hay que modificar la clase `Empleado`, aunque su responsabilidad principal debería ser solo representar los datos del empleado.

La solución sería separar esas responsabilidades en clases independientes, como `CalculadoraNomina`, `GeneradorReporte` y `RepositorioEmpleado`.

---

### 7. ¿Qué diferencia hay entre `mvn compile`, `mvn package` y `mvn install`?

| Comando | Qué hace |
|---|---|
| **`mvn compile`** | Compila el código fuente (`src/main/java`) y genera los `.class` en `target/classes`. No genera ningún artefacto empaquetado. |
| **`mvn package`** | Compila, ejecuta las pruebas unitarias y empaqueta el proyecto en el formato definido en el `pom.xml` (`.jar` o `.war`), dejándolo en `target/`. |
| **`mvn install`** | Hace todo lo anterior y además **instala** el artefacto generado en el repositorio local de Maven (`~/.m2/repository`), para que pueda usarse como dependencia en otros proyectos locales. |

Cada fase incluye a las anteriores: `install` ejecuta `package`, que a su vez ejecuta `compile`.

---
