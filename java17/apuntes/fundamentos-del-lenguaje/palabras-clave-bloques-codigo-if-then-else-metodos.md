# 1.- Palabras Clave y Expresiones en Java

## Introducción

En Java, como en muchos lenguajes de programación, las **palabras clave** y las **expresiones** juegan roles cruciales. Las palabras clave son fundamentales en la sintaxis del lenguaje, mientras que las expresiones son construcciones que combinan variables, operadores y llamadas a métodos para producir valores.

## Palabras Clave en Java

Las palabras clave en Java son palabras reservadas por el lenguaje que tienen un significado especial para el compilador. Estas palabras no pueden ser utilizadas como identificadores (nombres de variables, métodos, clases, etc.).

### Lista de Palabras Clave Comunes

- `class`: Define una clase.
- `public`, `private`, `protected`: Define niveles de acceso.
- `static`: Indica que un miembro pertenece a la clase, no a una instancia.
- `void`: Especifica que un método no retorna un valor.
- `if`, `else`: Usadas en declaraciones condicionales.
- `for`, `while`, `do`: Controlan estructuras de bucle.
- `try`, `catch`, `finally`: Manejo de excepciones.
- `import`: Para importar paquetes o clases.
- `new`: Crea instancias de objetos.
- `return`: Retorna un valor desde un método.

### Uso de Palabras Clave

Las palabras clave son fundamentales para la estructura de un programa en Java. Por ejemplo, `if` y `else` se usan para controlar el flujo del programa con condiciones, mientras que `for` y `while` son esenciales para escribir bucles.

## Expresiones en Java

Una expresión en Java es una combinación de variables, operadores, valores literales y llamadas a métodos que se evalúan para producir un único valor. Java soporta varios tipos de expresiones, incluyendo aritméticas, lógicas, relacionales y de asignación.

### Tipos de Expresiones

1. **Aritméticas**: Involucran operadores matemáticos. Ejemplo: `a + b`.
2. **Lógicas**: Involucran booleanos y operadores lógicos. Ejemplo: `a && b`.
3. **Relacionales**: Comparan dos valores. Ejemplo: `a < b`.
4. **De asignación**: Asignan valores a variables. Ejemplo: `a = b`.

### Evaluación de Expresiones

La evaluación de expresiones sigue reglas específicas de precedencia y asociatividad. Por ejemplo, en la expresión `a + b * c`, primero se evalúa `b * c` debido a la mayor precedencia del operador `*`.

## Conclusión

El correcto uso de palabras clave y expresiones es esencial para escribir programas efectivos en Java. Entender cómo y cuándo utilizar estas herramientas es fundamental para cualquier programador que trabaja con este lenguaje.

---

# 2.- Declaraciones, Espacios en Blanco e Indentación en Java

## Introducción

En Java, la claridad y legibilidad del código son tan importantes como su funcionalidad. Las **declaraciones**, el uso de **espacios en blanco** y la **indentación** son elementos clave en la organización del código. Estos aspectos no solo afectan la apariencia del código, sino también su mantenibilidad y comprensión.

## Declaraciones en Java

Las declaraciones en Java se refieren a las instrucciones que le dicen al programa cómo actuar. Estas incluyen declaraciones de variables, métodos y clases.

### Tipos de Declaraciones

1. **Declaraciones de Variables**: Incluyen el tipo de variable y su nombre.
   - Ejemplo: `int contador;`
2. **Declaraciones de Métodos**: Definen el método, sus parámetros y su tipo de retorno.
   - Ejemplo: `public void mostrarMensaje() { ... }`
3. **Declaraciones de Clases**: Definen una nueva clase.
   - Ejemplo: `public class MiClase { ... }`

### Importancia de las Declaraciones Correctas

Las declaraciones correctas y claras son cruciales para evitar errores y entender el flujo del programa.

## Espacios en Blanco en Java

Los espacios en blanco en Java incluyen espacios, tabulaciones y saltos de línea. Aunque son ignorados por el compilador, son esenciales para la legibilidad del código.

### Uso de Espacios en Blanco

- **Entre operadores y operandos**: Mejora la legibilidad. Ejemplo: `a + b`, en lugar de `a+b`.
- **Después de comas**: En listas de parámetros o arrays.
- **Antes y después de llaves**: En la definición de clases y métodos.

## Indentación en Java

La indentación es el desplazamiento horizontal del texto con respecto a un margen. En Java, la indentación es fundamental para mostrar la estructura y jerarquía del código.

### Prácticas de Indentación

- **Bloques de Código**: Cada bloque de código (dentro de llaves `{}`) debe estar indentado un nivel más que el bloque que lo contiene.
- **Sentencias de Control**: Sentencias dentro de `if`, `for`, `while`, etc., deben estar indentadas para indicar que están dentro del bloque de control.

### Herramientas de Indentación

La mayoría de los IDEs (Entornos de Desarrollo Integrado) ofrecen herramientas para automatizar y estandarizar la indentación.

## Conclusión

Una organización adecuada del código a través de declaraciones claras, uso efectivo de espacios en blanco e indentación coherente es esencial para la calidad del código en Java. Esto no solo facilita la lectura y comprensión del código, sino que también ayuda en la detección y corrección de errores.

---

# 3.- Bloques de Código y la Estructura de Control If-Then-Else en Java

## Introducción

En Java, los **bloques de código** y las estructuras de control como **if-then-else** son fundamentales para dirigir el flujo de ejecución del programa. Estos conceptos permiten al programador controlar las condiciones bajo las cuales ciertos bloques de código se ejecutan.

## Bloques de Código en Java

Un bloque de código en Java es un grupo de cero o más sentencias entre llaves balanceadas `{}` y se puede usar en cualquier lugar donde se permita una sola sentencia.

### Características de los Bloques de Código

- **Ámbito**: Las variables declaradas dentro de un bloque están limitadas a ese bloque y no son accesibles fuera de él.
- **Ejecución**: Un bloque se ejecuta en secuencia, desde la primera hasta la última sentencia dentro de las llaves.

## Estructura de Control If-Then-Else

La estructura de control `if-then-else` es una de las formas más básicas de toma de decisiones en Java.

### Sintaxis

1. **If-Then**:
   ```java
   if (condición) {
       // bloque de código a ejecutar si la condición es verdadera
   }
   ```
2. **If-Then-Else**:
   ```java
   if (condición) {
       // bloque de código a ejecutar si la condición es verdadera
   } else {
       // bloque de código a ejecutar si la condición es falsa
   }
   ```

### Funcionamiento

- La **condición** debe ser una expresión booleana.
- Si la condición es `true`, se ejecuta el bloque de código después del `if`.
- Si la condición es `false` y existe un `else`, se ejecuta el bloque de código después del `else`.

### Ejemplo Básico

```java
int numero = 5;
if (numero > 0) {
    System.out.println("El número es positivo.");
} else {
    System.out.println("El número es negativo o cero.");
}
```

## Uso Avanzado de If-Then-Else

- **Anidación de If-Then-Else**: Se pueden anidar múltiples `if-then-else` para verificar varias condiciones.
- **Else If Ladder**: Se utiliza para probar una serie de condiciones.

### Ejemplo de Anidación

```java
if (condición1) {
    // código
} else if (condición2) {
    // código
} else {
    // código
}
```

## Conclusión

Los bloques de código y la estructura de control `if-then-else` en Java son esenciales para la programación estructurada. Permiten al programador controlar el flujo del programa de manera efectiva y flexible, facilitando la escritura de código claro y mantenible.

---

# 4.- Métodos en Java

## Introducción

Los **métodos** en Java son bloques de código que realizan una tarea específica. Son fundamentales en la programación orientada a objetos y permiten modularizar y reutilizar el código.

## Definición de un Método

Un método en Java se define con un nombre, una lista de parámetros, un tipo de retorno y un cuerpo.

### Sintaxis Básica

```java
tipoRetorno nombreMetodo(tipoParam1 param1, tipoParam2 param2, ...) {
    // Cuerpo del método
}
```

### Componentes de un Método

- **tipoRetorno**: Indica el tipo de dato que el método devuelve. Puede ser cualquier tipo de dato, incluido `void` si el método no devuelve nada.
- **nombreMetodo**: Nombre del método, siguiendo las convenciones de nomenclatura de Java.
- **Lista de Parámetros**: Cero o más parámetros que el método necesita para realizar su tarea.
- **Cuerpo del Método**: El código que define lo que hace el método.

## Tipos de Métodos

1. **Métodos Estáticos**: Pertenecen a la clase y no a una instancia específica de la clase. Se invocan directamente sobre la clase.
   - Ejemplo: `Math.sqrt(4.0)`
2. **Métodos de Instancia**: Pertenecen a un objeto y requieren una instancia de la clase para ser invocados.
   - Ejemplo: `objeto.metodoInstancia()`

## Parámetros y Argumentos

- **Parámetros**: Son variables en la definición del método que aceptan valores cuando se llama al método.
- **Argumentos**: Son los valores reales pasados a los parámetros cuando se invoca el método.

## Sobreescritura y Sobrecarga de Métodos

- **Sobrecarga (Overloading)**: Múltiples métodos en una clase tienen el mismo nombre pero diferentes listas de parámetros.
- **Sobreescritura (Overriding)**: Un método en una clase derivada tiene la misma firma que un método en la clase base.

## Ejemplo de Método en Java

```java
public int suma(int a, int b) {
    return a + b;
}
```

## Buenas Prácticas

- **Nombres Descriptivos**: Los nombres de los métodos deben ser claros y reflejar la acción que realizan.
- **Simplicidad**: Un método debe hacer una tarea específica y no ser excesivamente largo.
- **Reusabilidad**: Los métodos deben diseñarse para ser reutilizables en diferentes partes del programa.

## Conclusión

Los métodos son una parte crucial de la programación en Java, permitiendo la encapsulación, reutilización y organización del código. Entender cómo definir, utilizar y manipular métodos es fundamental para cualquier desarrollador de Java.

---
