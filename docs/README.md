# Laboratorio 02 — Preguntas Iniciales

> Equipo: Sara Arteaga / Nicolás Prieto

---

### 1. ¿Qué ventaja ofrece el polimorfismo en el diseño de clases frente al uso de múltiples condicionales para determinar el comportamiento de un objeto?

El polimorfismo permite que cada clase implemente su propio comportamiento mediante la sobreescritura de métodos, evitando largas cadenas de `if/else` o `switch` que verifican el tipo de objeto antes de actuar.

Esto trae varios beneficios:

- **Código más limpio y legible**, sin condicionales anidados que crecen con cada nuevo caso.
- **Extensibilidad**: para agregar un nuevo tipo basta con crear una nueva clase que implemente la interfaz o herede de la clase base, sin modificar el código existente.
- **Menor acoplamiento**: el código cliente solo conoce la interfaz común, no los detalles internos de cada implementación.


---

### 2. ¿Por qué una clase inmutable puede mejorar la seguridad en un sistema?

Una clase inmutable es aquella cuyo estado no puede modificarse una vez creado el objeto: todos sus atributos son `final` y no existen setters que permitan cambiarlos después de la construcción.

Esto mejora la seguridad de varias formas:

- **Evita modificaciones accidentales o maliciosas** del estado del objeto desde otras partes del código.
- **Es segura en entornos concurrentes (thread-safe)**: como el estado no cambia, varios hilos pueden leer el mismo objeto sin riesgo de condiciones de carrera, sin necesidad de sincronización adicional.
- **Facilita el razonamiento sobre el código**: si un objeto se crea con ciertos valores, se puede confiar en que esos valores serán los mismos durante todo su ciclo de vida, lo que reduce errores difíciles de depurar.
- **Protege la encapsulación**: al no exponer setters, se elimina por completo la posibilidad de dejar el objeto en un estado inválido después de su creación.

---

### 3. ¿Qué problema podría aparecer en un sistema si los atributos de las clases se mantienen públicos en lugar de privados con getters y setters controlados?

Si los atributos son públicos, cualquier parte del programa puede modificarlos directamente sin pasar por ninguna validación, lo que puede dejar el objeto en un **estado inconsistente o inválido** (por ejemplo, asignar un saldo negativo o una edad fuera de rango).

Principales problemas:

- **Violación del encapsulamiento**: la lógica de validación queda dispersa o ausente.
- **Difícil mantenimiento**: no hay un punto centralizado de control sobre cómo cambian los datos.
- **Mayor riesgo de errores**: el estado del objeto puede alterarse desde cualquier lugar del código, dificultando el rastreo de bugs.

Usar getters y setters permite validar, controlar y registrar los cambios, además de poder modificar la implementación interna sin afectar a quienes usan la clase.

---

### 4. Según el principio Abierto/Cerrado, ¿cómo deberíamos modificar el sistema si queremos añadir una nueva funcionalidad sin alterar el código existente?

El **Principio Abierto/Cerrado (OCP)** establece que las entidades de software (clases, módulos, funciones) deben estar **abiertas para extensión, pero cerradas para modificación**.

Esto significa que, para añadir una nueva funcionalidad, no deberíamos modificar las clases ya existentes y probadas, sino:

- **Crear nuevas clases** que implementen una interfaz o hereden de una clase abstracta ya definida, agregando el nuevo comportamiento.
- **Usar polimorfismo** para que el código cliente trabaje con la abstracción común, sin necesidad de conocer las nuevas implementaciones.
- Apoyarse en **patrones de diseño** (como Strategy, Decorator o Factory) que faciliten extender el comportamiento del sistema sin tocar el código central.

De esta manera, el código existente permanece estable (sin riesgo de introducir nuevos bugs) y el sistema crece simplemente agregando nuevas piezas que se acoplan a través de las abstracciones ya definidas.
 
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

### 6. ¿Qué es y para qué usamos el `pom.xml`?

El `pom.xml` (**Project Object Model**) es el archivo de configuración central de un proyecto Maven. Es un documento XML que describe el proyecto y administra todo su ciclo de vida.

Entre sus principales usos están:

- **Definir información del proyecto**: nombre, versión, descripción, grupo (`groupId`), artefacto (`artifactId`), etc.
- **Gestionar dependencias**: especifica las librerías externas que necesita el proyecto y sus versiones, descargándolas automáticamente desde repositorios remotos.
- **Configurar el ciclo de vida de construcción**: define cómo se compila, prueba, empaqueta y despliega el proyecto (por ejemplo, la versión de Java a usar mediante `maven-compiler-plugin`).
- **Definir plugins**: herramientas adicionales que extienden las capacidades de Maven (ejecutar pruebas, generar documentación, ejecutar la aplicación, etc.).

 
---

### 7. ¿Qué diferencia hay entre `mvn compile`, `mvn package` y `mvn install`?

| Comando | Qué hace |
|---|---|
| **`mvn compile`** | Compila el código fuente (`src/main/java`) y genera los `.class` en `target/classes`. No genera ningún artefacto empaquetado. |
| **`mvn package`** | Compila, ejecuta las pruebas unitarias y empaqueta el proyecto en el formato definido en el `pom.xml` (`.jar` o `.war`), dejándolo en `target/`. |
| **`mvn install`** | Hace todo lo anterior y además **instala** el artefacto generado en el repositorio local de Maven (`~/.m2/repository`), para que pueda usarse como dependencia en otros proyectos locales. |

Cada fase incluye a las anteriores: `install` ejecuta `package`, que a su vez ejecuta `compile`.

---

### 8. ¿Qué diferencia existe entre una interfaz y una clase abstracta?

| Aspecto | Interfaz | Clase abstracta |
|---|---|---|
| **Propósito** | Define un **contrato** de comportamiento (qué debe hacer una clase). | Define una **base común** parcialmente implementada (qué es y qué hace una clase). |
| **Métodos** | Por defecto todos son abstractos (sin cuerpo), aunque desde Java 8 puede tener métodos `default` y `static`. | Puede tener métodos abstractos **y** métodos concretos con implementación. |
| **Atributos** | Solo constantes (`public static final`), no tiene estado propio. | Puede tener atributos de instancia con estado. |
| **Herencia** | Una clase puede implementar **múltiples interfaces**. | Una clase solo puede extender **una** clase abstracta (herencia simple). |
| **Constructor** | No tiene constructor. | Puede tener constructores, usados por las subclases mediante `super()`. |

