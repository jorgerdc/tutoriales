# Tema 1: Sentencia if-then

## 1.1.- Concepto y Uso de la Sentencia if-then

La sentencia `if-then` es una estructura de control fundamental en Java, utilizada para la toma de decisiones. Permite ejecutar un bloque de código solo si una condición especificada es verdadera.

### Sintaxis

```java
if (condicion) {
    // Bloque de código que se ejecuta si la condición es verdadera
}
```

- **condicion**: Es una expresión booleana (verdadera o falsa). Si la condición es verdadera (`true`), el bloque de código dentro de las llaves `{}` se ejecuta. Si es falsa (`false`), el bloque de código se omite.

### Ejemplo Básico

```java
int numero = 5;
if (numero > 0) {
    System.out.println("El número es positivo");
}
```

En este ejemplo, si `numero` es mayor que 0, se imprime el mensaje "El número es positivo".

### Consideraciones

- La sentencia `if-then` es ideal para casos donde solo se requiere realizar una acción en respuesta a una condición verdadera.
- No se requiere un bloque `else`; es opcional y se utiliza cuando se necesita ejecutar un código alternativo en caso de que la condición sea falsa.
- La claridad y simplicidad en la expresión de la condición son clave para mantener el código legible y mantenible.

## 1.2.- Buenas Prácticas en el Uso de if-then

### Evitar Condiciones Complicadas

Es recomendable mantener las condiciones lo más simples y claras posible. Condiciones complejas pueden hacer que el código sea difícil de leer y mantener.

### Uso de Llaves

Aunque las llaves (`{}`) son opcionales para bloques de una sola línea, es una buena práctica siempre usarlas para evitar errores y mejorar la legibilidad del código.

### Comparación de Valores Booleanos

Al comparar valores booleanos, no es necesario usar `== true` o `== false`. Por ejemplo, en lugar de `if (condicion == true)`, se puede escribir simplemente `if (condicion)`.

# Tema 2: El Operador Lógico AND

## 2.1.- Concepto y Uso del Operador Lógico AND

El operador lógico AND, representado por `&&` en Java, es un operador binario que se utiliza para combinar dos expresiones booleanas. El resultado de la operación AND es `true` solo si ambas expresiones son verdaderas.

### Sintaxis

```java
expresion1 && expresion2
```

- **expresion1** y **expresion2**: Son expresiones que devuelven un valor booleano (`true` o `false`).

### Ejemplo Básico

```java
boolean esMayorDeEdad = true;
boolean tieneDocumento = true;

if (esMayorDeEdad && tieneDocumento) {
    System.out.println("Acceso permitido");
}
```

En este ejemplo, el mensaje "Acceso permitido" se imprimirá solo si `esMayorDeEdad` y `tieneDocumento` son ambos `true`.

### Evaluación de Cortocircuito

El operador `&&` realiza una evaluación de cortocircuito: si la primera expresión es `false`, la segunda expresión no se evalúa, ya que el resultado final no puede ser `true`.

## 2.2.- Buenas Prácticas en el Uso del Operador AND

### Claridad en las Expresiones

Es importante que cada expresión combinada con `&&` sea clara y legible. Evitar combinar demasiadas expresiones en una sola línea para mantener el código fácil de entender.

### Orden de Evaluación

Colocar la expresión más probable de ser `false` como la primera en la operación AND puede mejorar la eficiencia, aprovechando la evaluación de cortocircuito.

### Uso en Estructuras de Control

El operador AND es comúnmente utilizado en estructuras de control, como `if`, para combinar múltiples condiciones que deben cumplirse simultáneamente.

# Tema 3: El Operador Lógico OR

## 3.1.- Concepto y Uso del Operador Lógico OR

El operador lógico OR, representado por `||` en Java, es utilizado para combinar dos expresiones booleanas. El resultado de la operación OR es `true` si al menos una de las expresiones es verdadera.

### Sintaxis

```java
expresion1 || expresion2
```

- **expresion1** y **expresion2**: Son expresiones que devuelven un valor booleano (`true` o `false`).

### Ejemplo Básico

```java
boolean tienePermiso = false;
boolean esAdministrador = true;

if (tienePermiso || esAdministrador) {
    System.out.println("Acceso permitido");
}
```

En este ejemplo, el mensaje "Acceso permitido" se imprimirá si `tienePermiso` es `true` o si `esAdministrador` es `true`.

### Evaluación de Cortocircuito

Al igual que con el operador AND, el operador OR realiza una evaluación de cortocircuito: si la primera expresión es `true`, la segunda no se evalúa, ya que el resultado final será `true` de todos modos.

## 3.2.- Buenas Prácticas en el Uso del Operador OR

### Claridad en las Expresiones

Es crucial que cada expresión combinada con `||` sea clara y legible. Evitar combinar demasiadas condiciones en una sola línea para mantener el código comprensible.

### Orden de Evaluación

Para mejorar la eficiencia, se recomienda colocar la expresión más probable de ser `true` como la primera en la operación OR, aprovechando así la evaluación de cortocircuito.

### Uso en Estructuras de Control

El operador OR se utiliza frecuentemente en estructuras de control para permitir múltiples condiciones que pueden satisfacer una misma ruta de ejecución.

Si necesitas más detalles sobre este tema, deseas revisar otro tema específico o avanzar al siguiente, házmelo saber.

# Tema 4: Operador de Asignación vs Operador de Igualdad

## 4.1.- Operador de Asignación

El operador de asignación en Java es el signo `=`, utilizado para asignar un valor a una variable.

### Sintaxis

```java
tipoVariable nombreVariable = valor;
```

- **tipoVariable**: El tipo de la variable (como `int`, `String`, `boolean`, etc.).
- **nombreVariable**: El nombre de la variable.
- **valor**: El valor a asignar a la variable.

### Ejemplo

```java
int numero = 5;
```

Aquí, el valor `5` se asigna a la variable `numero`.

### Función

- El operador de asignación guarda un valor en la variable especificada.
- Se puede usar para inicializar una variable o para cambiar su valor durante la ejecución del programa.

## 4.2.- Operador de Igualdad

El operador de igualdad en Java es representado por dos signos iguales `==`, utilizado para comparar dos valores y verificar si son iguales.

### Sintaxis

```java
expresion1 == expresion2
```

- **expresion1** y **expresion2**: Son valores o variables que se comparan.

### Ejemplo

```java
if (numero == 5) {
    // Código a ejecutar si numero es igual a 5
}
```

Aquí se compara si el valor de `numero` es igual a `5`.

### Función

- El operador de igualdad compara dos valores y devuelve un valor booleano (`true` si son iguales, `false` si son diferentes).
- Se utiliza comúnmente en estructuras de control, como `if`, para tomar decisiones en función de comparaciones.

## 4.3.- Diferencias Clave y Buenas Prácticas

- **Uso**: El operador de asignación (`=`) se usa para asignar valores, mientras que el operador de igualdad (`==`) se usa para comparar valores.
- **Resultado**: El operador de asignación no devuelve un valor, solo asigna uno. El operador de igualdad devuelve un valor booleano.
- **Errores Comunes**: Una confusión común es usar un operador en lugar del otro, especialmente `=` en lugar de `==` en las condiciones `if`, lo cual puede llevar a errores lógicos en el código.
- **Buenas Prácticas**: Es crucial estar atento al contexto para elegir el operador correcto y evitar errores comunes, manteniendo siempre la claridad en la intención del código.

# Tema 5: Operador Ternario

## 5.1.- Concepto y Uso del Operador Ternario

El operador ternario en Java es una forma abreviada de la sentencia `if-else`. Este operador toma tres operandos y es muy útil para realizar asignaciones condicionales en una sola línea.

### Sintaxis

```java
condicion ? expresionSiVerdadero : expresionSiFalso;
```

- **condicion**: Una expresión booleana que se evalúa a `true` o `false`.
- **expresionSiVerdadero**: El valor o acción a tomar si la condición es `true`.
- **expresionSiFalso**: El valor o acción a tomar si la condición es `false`.

### Ejemplo

```java
int a = 5;
int b = 10;
int max = (a > b) ? a : b;
```

Aquí, `max` será igual a `a` si `a` es mayor que `b`, y será igual a `b` en caso contrario.

### Función

- El operador ternario es útil para asignaciones condicionales simples y para reemplazar estructuras `if-else` cortas.
- Contribuye a la concisión del código, permitiendo la reducción de múltiples líneas de una estructura `if-else` a una sola línea.

## 5.2.- Buenas Prácticas y Limitaciones

### Claridad y Legibilidad

Aunque el operador ternario puede hacer el código más conciso, es importante no sacrificar la legibilidad. En casos de condiciones o expresiones complejas, es preferible usar una estructura `if-else` tradicional.

### Uso Moderado

Debido a su naturaleza concisa, puede ser tentador abusar del operador ternario. Se recomienda su uso moderado, especialmente en situaciones donde la condición y las expresiones son simples y claras.

### Evitar Anidaciones

Evitar anidar operadores ternarios, ya que esto puede hacer el código difícil de leer y entender. En casos de múltiples condiciones, es mejor utilizar estructuras `if-else` o `switch`.

# Tema 6: Precedencia de Operadores

## 6.1.- Concepto de Precedencia de Operadores

La precedencia de operadores en Java determina el orden en que se evalúan las operaciones en una expresión. Cuando una expresión contiene múltiples operadores, la precedencia define cuáles operaciones se realizan primero antes de otras.

### Importancia de la Precedencia

- **Evitar Ambigüedades**: La precedencia ayuda a evitar ambigüedades en expresiones complejas.
- **Resultados Correctos**: Una comprensión adecuada de la precedencia asegura que se obtengan los resultados esperados de las operaciones.

### Ejemplo

```java
int resultado = 10 + 5 * 2;
```

Aquí, `5 * 2` se evalúa antes que `10 +`, debido a la mayor precedencia del operador de multiplicación.

## 6.2.- Reglas de Precedencia en Java

En Java, la precedencia de operadores sigue un orden específico. Algunos de los operadores con mayor precedencia incluyen:

1. **Operadores de Postfijo**: `exp++`, `exp--`
2. **Operadores de Unario**: `++exp`, `--exp`, `+exp`, `-exp`, `~`, `!`
3. **Operadores de Multiplicación/División**: `*`, `/`, `%`
4. **Operadores de Suma/Resta**: `+`, `-`
5. **Operadores de Desplazamiento**: `<<`, `>>`, `>>>`
6. **Operadores Relacionales**: `<`, `>`, `<=`, `>=`, `instanceof`
7. **Operadores de Igualdad**: `==`, `!=`
8. **Operadores Bit a Bit**: `&`, `^`, `|`
9. **Operadores Lógicos**: `&&`, `||`
10. **Operadores Ternarios**: `? :`
11. **Operadores de Asignación**: `=`, `+=`, `-=`, `*=`, `/=`, etc.

## 6.3.- Uso de Paréntesis para Modificar la Precedencia

Los paréntesis `()` se pueden utilizar para cambiar el orden de evaluación predeterminado en una expresión. La expresión dentro de los paréntesis tiene la mayor precedencia y se evalúa primero.

### Ejemplo

```java
int resultado = (10 + 5) * 2;
```

En este caso, la suma `(10 + 5)` se evalúa primero debido a los paréntesis, alterando el orden de precedencia natural.

### Buenas Prácticas

- **Uso de Paréntesis para Claridad**: Aunque no siempre sean necesarios, los paréntesis pueden usarse para hacer el código más legible y claro, especialmente en expresiones complejas.
- **Evitar Suposiciones**: No asumir la precedencia de operadores; en caso de duda, usar paréntesis para asegurar la evaluación deseada.
