# 1.- Variables en Java

## 1.1.- Definición y Declaración

Una variable en Java es un espacio de memoria asignado para almacenar datos que pueden modificarse durante la ejecución del programa. Se asocia con un tipo de dato específico que determina el tipo y tamaño de valor que puede contener. La declaración de una variable sigue la sintaxis:

```java
tipo nombreVariable;
```

Ejemplo:

```java
int edad;
String nombre;
```

## 1.2.- Inicialización de Variables

Una variable se inicializa asignando un valor, que se puede realizar en la declaración o posteriormente.

```java
int edad = 30; // Declaración e inicialización
String nombre; // Declaración
nombre = "Juan"; // Inicialización posterior
```

# 2.- Expresiones en Java

## 2.1.- Definición

Una expresión en Java es una combinación de variables, operadores y llamadas a métodos que se evalúa para producir un valor. Puede ser tan simple como una variable individual o más compleja, involucrando múltiples operaciones.

Ejemplo:

```java
int suma = 10 + 5; // Expresión aritmética
boolean esMayorDeEdad = edad >= 18; // Expresión booleana
```

## 2.2.- Tipos de Expresiones

Las expresiones pueden ser aritméticas, lógicas, relacionales, entre otras, y se utilizan en estructuras de control, asignaciones, etc.

# 3.- Tipos de Datos Primitivos y Clases Envolventes

## 3.1.- Tipos Primitivos

Java tiene 8 tipos de datos primitivos, que son tipos básicos y no son objetos:

- `byte`: Entero de 8 bits.
- `short`: Entero de 16 bits.
- `int`: Entero de 32 bits.
- `long`: Entero de 64 bits.
- `float`: Número de punto flotante de 32 bits.
- `double`: Número de punto flotante de 64 bits.
- `char`: Carácter Unicode de 16 bits.
- `boolean`: Valores lógicos `true` o `false`.

Ejemplo:

```java
int numero = 100;
double salario = 2500.30;
char letra = 'A';
boolean esValido = true;
```

## 3.2.- Clases Envolventes

Las clases envolventes o "Wrapper classes" permiten trabajar con tipos primitivos como si fueran objetos. Cada tipo primitivo tiene una clase envolvente correspondiente:

- `Integer` para `int`
- `Long` para `long`
- `Float` para `float`
- `Double` para `double`
- `Character` para `char`
- `Boolean` para `boolean`
- `Byte` para `byte`
- `Short` para `short`

Estas clases proporcionan métodos útiles para manipulaciones como la conversión entre tipos, comparaciones, etc.

Ejemplo:

```java
Integer numeroEntero = new Integer(10); // Forma tradicional
Integer numeroAuto = 20; // Autoboxing

int numPrimitivo = numeroEntero.intValue(); // Unboxing
```

# 4.- Tipos de Datos Primitivos: byte, short y long en Java

## 4.1 byte

### Descripción

El `byte` es un tipo de dato entero de 8 bits con signo. Se utiliza para ahorrar memoria en grandes arrays, siendo particularmente útil en contextos donde la memoria es una preocupación importante.

### Rango

El rango de un `byte` va de -128 a 127.

### Ejemplos de Uso

```java
byte edad = 30;
byte nivel = -5;
```

### Aplicaciones Prácticas

Ideal para el procesamiento de streams de datos y en situaciones donde se manejan datos a nivel de byte.

## 4.2 short

### Descripción

El tipo `short` es un entero de 16 bits con signo. Similar al `byte`, se usa para ahorrar memoria, pero ofrece un rango más amplio que el `byte`.

### Rango

El rango de un `short` es de -32,768 a 32,767.

### Ejemplos de Uso

```java
short temperatura = 120;
short capacidad = -32000;
```

### Aplicaciones Prácticas

Utilizado cuando se necesita más rango que el ofrecido por `byte`, pero menos que un `int`.

## 4.3 long

### Descripción

El `long` es un tipo de dato entero de 64 bits con signo. Se usa cuando los valores exceden el rango de un `int`.

### Rango

El rango de un `long` es de aproximadamente -9.2 quintillones a 9.2 quintillones.

### Ejemplos de Uso

```java
long poblacionMundial = 7800000000L;
long distanciaALasEstrellas = 9460730472580800L;
```

### Aplicaciones Prácticas

Esencial para números extremadamente grandes, como identificadores únicos, cálculos poblacionales o medidas astronómicas.

### Nota sobre Literales

Para literales `long`, se utiliza el sufijo `L` para indicar su tipo.

```java
long ejemploLong = 123456789L;
```

# Tema 5: Casting Primitivo en Java

## 5.1 Definición de Casting Primitivo

El casting primitivo en Java se refiere a la conversión de un tipo de dato primitivo a otro. Esto es necesario cuando se quiere asignar un valor de un tipo a una variable de otro tipo. El casting puede ser implícito o explícito.

## 5.2 Tipos de Casting Primitivo

### 5.2.1 Casting Implícito (Widening Casting)

El casting implícito ocurre cuando se asigna un valor de un tipo de dato más pequeño a un tipo de dato más grande. Java realiza esta conversión automáticamente, ya que no hay riesgo de pérdida de información.

#### Ejemplo de Casting Implícito

```java
int miInt = 100;
double miDouble = miInt;  // Aquí se realiza un casting implícito de int a double
```

### 5.2.2 Casting Explícito (Narrowing Casting)

El casting explícito es necesario cuando se asigna un valor de un tipo de dato más grande a un tipo de dato más pequeño. Esto se debe hacer manualmente y con cuidado, ya que puede conllevar a la pérdida de información.

#### Ejemplo de Casting Explícito

```java
double miDouble = 9.78;
int miInt = (int) miDouble;  // Casting explícito de double a int
```

## 5.3 Precauciones en el Casting Primitivo

### 5.3.1 Pérdida de Información

Al realizar casting explícito (narrowing), es importante ser consciente de la posible pérdida de información, especialmente cuando se convierte de un tipo con mayor capacidad a uno con menor capacidad (por ejemplo, de `double` a `int`).

### 5.3.2 Precisión Numérica

En el caso de números decimales convertidos a enteros, se pierde la parte fraccionaria del número, lo que puede afectar la precisión del valor resultante.

### 5.3.3 Rango de Valores

Es crucial considerar el rango de valores que puede manejar el tipo de destino. Por ejemplo, al convertir un `long` grande a `int`, si el valor de `long` está fuera del rango del `int`, el resultado será una conversión incorrecta.

# Tema 6: Tipos Primitivos Float y Double en Java

## 6.1 Float

### Descripción

El tipo `float` es un tipo de dato primitivo en Java que se utiliza para almacenar números de punto flotante (números con decimales) con precisión simple. Utiliza 32 bits de almacenamiento.

### Rango y Precisión

- Rango aproximado: 3.4e−038 a 3.4e+038.
- Precisión: hasta 7 dígitos decimales.

### Ejemplo de Uso

```java
float tasaDeInteres = 6.75f;
float temperatura = 36.6f;
```

### Uso del Sufijo 'f'

Es necesario usar el sufijo `f` o `F` al asignar un literal de punto flotante a una variable `float`, ya que los literales decimales son tratados como `double` por defecto en Java.

```java
float pi = 3.14f; // Uso correcto del sufijo 'f'
```

### Aplicaciones

`float` es útil en contextos donde se requiere una gran cantidad de operaciones matemáticas pero no se necesita una precisión extremadamente alta, como en gráficos por computadora o ciertas aplicaciones científicas.

## 6.2 Double

### Descripción

El tipo `double` es un tipo de dato primitivo utilizado para números de punto flotante con precisión doble. Utiliza 64 bits de almacenamiento, lo que permite una mayor precisión y rango que `float`.

### Rango y Precisión

- Rango aproximado: 1.7e−308 a 1.7e+308.
- Precisión: hasta 15 dígitos decimales.

### Ejemplo de Uso

```java
double salario = 123456.789;
double distancia = 98765.4321;
```

### Aplicaciones

`double` es el tipo de punto flotante predeterminado en Java y es ampliamente utilizado en cálculos matemáticos precisos, finanzas, ciencias, y donde la precisión es crucial.

## 6.3 Consideraciones de Uso

### 6.3.1 Precisión

- `double` es más preciso que `float` y es generalmente la mejor opción si no hay restricciones de memoria o rendimiento.
- En cálculos científicos y matemáticos de alta precisión, se prefiere `double`.

### 6.3.2 Rendimiento

- El uso de `float` puede ser más eficiente en términos de memoria cuando se manejan grandes arrays de números.
- Sin embargo, en la mayoría de los procesadores modernos, los cálculos con `double` pueden ser tan rápidos como con `float`.

### 6.3.3 Elección entre Float y Double

- Prefiera `double` para la mayoría de los cálculos para evitar problemas de precisión.
- Utilice `float` cuando necesite ahorrar memoria y la precisión no sea la principal preocupación.

# Tema 7: Precisión del Punto Flotante en Java

## 7.1 Concepto de Punto Flotante

El punto flotante es un método para representar números reales en programación que soporta un rango mucho más amplio que el de los números enteros. En Java, los tipos `float` (32 bits) y `double` (64 bits) se utilizan para representar estos números.

## 7.2 Precisión en Punto Flotante

La precisión se refiere a cuán exacta es la representación de un número. En Java, `float` proporciona una precisión de hasta 7 dígitos decimales, mientras que `double` ofrece precisión hasta 15 dígitos decimales.

### 7.2.1 Precisión de `float`

- 32 bits de almacenamiento.
- Aproximadamente 7 dígitos decimales de precisión.
- Ejemplo: `3.1415927f`.

### 7.2.2 Precisión de `double`

- 64 bits de almacenamiento.
- Aproximadamente 15 dígitos decimales de precisión.
- Ejemplo: `3.141592653589793`.

## 7.3 Problemas de Precisión

Debido a la manera en que los números de punto flotante se almacenan y calculan, pueden surgir problemas de precisión, especialmente en cálculos matemáticos complejos o acumulativos.

### 7.3.1 Redondeo

- Los números de punto flotante no pueden representar exactamente todos los números reales, y algunos números pueden ser redondeados a su representación más cercana.
- Ejemplo: `0.1 + 0.2` puede no resultar exactamente en `0.3` debido a la representación interna de estos números.

### 7.3.2 Acumulación de Errores

- En cálculos con muchos pasos, los pequeños errores de redondeo pueden acumularse, llevando a resultados inesperados o imprecisos.

## 7.4 Buenas Prácticas

Para manejar la precisión en Java:

### 7.4.1 Uso de `BigDecimal`

- Para cálculos financieros o cuando se requiere alta precisión, se recomienda usar `BigDecimal`.
- `BigDecimal` permite controlar la precisión y el redondeo, aunque a costa de una mayor complejidad y menor rendimiento en comparación con `float` y `double`.

### 7.4.2 Evitar Comparaciones Directas

- Evitar comparar números de punto flotante para igualdad directa (`==`).
- En su lugar, considerar si la diferencia entre ellos está dentro de un rango aceptable.

### 7.4.3 Consciencia de Rango y Precisión

- Ser consciente de los límites de rango y precisión de `float` y `double`, y elegir el tipo adecuado según las necesidades del programa.

## 7.5 Ejemplo Ilustrativo

Un ejemplo clásico de problemas de precisión es el siguiente:

```java
double a = 0.1;
double b = 0.2;
double c = a + b; // Puede no ser exactamente 0.3
```

En este caso, `c` puede no ser exactamente `0.3` debido a cómo los números de punto flotante son representados en la memoria.

# Tema 8: Los Tipos de Dato Primitivos Char y Boolean en Java

## 8.1 Char

### Descripción

`char` es un tipo de dato primitivo en Java que se utiliza para almacenar un único carácter. Internamente, los caracteres en Java se representan utilizando el estándar Unicode, que permite una amplia variedad de caracteres de diferentes idiomas y símbolos especiales.

### Características

- Tamaño: 16 bits (2 bytes).
- Rango: De 0 a 65,535, ya que representa caracteres Unicode sin signo.
- Uso: Principalmente para almacenar caracteres individuales.

### Ejemplo de Uso

```java
char letra = 'A';
char numero = '1';
char simbolo = '$';
```

### Literales Char

Los literales `char` se especifican entre comillas simples. También pueden representar caracteres especiales y de escape, como '\n' (nueva línea) o '\u0041' (representación Unicode para 'A').

## 8.2 Boolean

### Descripción

El tipo `boolean` se utiliza para almacenar valores lógicos, que pueden ser `true` o `false`. Es uno de los tipos más básicos en Java y es fundamental en el control de flujo y la lógica condicional.

### Características

- Tamaño: No especificado por la especificación de Java, pero generalmente representa 1 bit de información (aunque su tamaño en memoria puede ser mayor debido a cuestiones de alineación y eficiencia).
- Valores: Solo puede tomar uno de dos valores, `true` o `false`.

### Ejemplo de Uso

```java
boolean esMayorDeEdad = true;
boolean resultado = false;
```

### Uso en Estructuras de Control

`boolean` es ampliamente utilizado en estructuras de control como `if`, `while`, y `for`, así como en expresiones condicionales y operadores lógicos.

```java
if (esMayorDeEdad) {
    // Código a ejecutar si esMayorDeEdad es true
}
```

## 8.3 Aplicaciones y Consideraciones

### Para `char`

- Adecuado para trabajar con caracteres individuales.
- Utilizado en arrays para formar cadenas (aunque en la práctica, la clase `String` se usa con más frecuencia para cadenas de texto).

### Para `boolean`

- Esencial en la toma de decisiones y la lógica condicional en programas.
- No debe confundirse con los valores numéricos 0 y 1, ya que `boolean` no es numérico en Java.

# Tema 9: Recapitulación de Tipos Primitivos y el Tipo de Dato String en Java

## 9.1 Tipos Primitivos en Java

Java ofrece varios tipos de datos primitivos, que son los bloques de construcción básicos para la manipulación de datos. Cada tipo primitivo tiene un tamaño y un rango definidos, y sirve para un propósito específico.

### 9.1.1 byte

- **Tamaño**: 8 bits.
- **Rango**: -128 a 127.
- **Uso**: Manejo eficiente de la memoria en grandes arrays de datos.

### 9.1.2 short

- **Tamaño**: 16 bits.
- **Rango**: -32,768 a 32,767.
- **Uso**: Ahorro de memoria en grandes arrays cuando `byte` es muy pequeño y `int` es más de lo necesario.

### 9.1.3 int

- **Tamaño**: 32 bits.
- **Rango**: -2,147,483,648 a 2,147,483,647.
- **Uso**: Tipo más común para números enteros.

### 9.1.4 long

- **Tamaño**: 64 bits.
- **Rango**: -9,223,372,036,854,775,808 a 9,223,372,036,854,775,807.
- **Uso**: Cuando `int` no es suficiente para manejar números grandes.

### 9.1.5 float

- **Tamaño**: 32 bits.
- **Precisión**: 7 dígitos decimales.
- **Uso**: Números de punto flotante cuando se necesitan menos decimales y menos memoria.

### 9.1.6 double

- **Tamaño**: 64 bits.
- **Precisión**: 15 dígitos decimales.
- **Uso**: Tipo predeterminado para números de punto flotante, usado en cálculos matemáticos.

### 9.1.7 char

- **Tamaño**: 16 bits (caracteres Unicode).
- **Rango**: 0 a 65,535.
- **Uso**: Almacenamiento de caracteres individuales.

### 9.1.8 boolean

- **Tamaño**: No definido específicamente, representa 1 bit de información.
- **Valores**: `true` o `false`.
- **Uso**: Control de flujo y operaciones lógicas.

## 9.2 El Tipo de Dato String

Aunque `String` no es un tipo primitivo, es una de las clases más utilizadas en Java y merece una mención especial.

### Características

- `String` representa una secuencia de caracteres y es una clase, no un tipo primitivo.
- Las cadenas de texto se manejan como instancias de la clase `String`.
- Los objetos `String` son inmutables, lo que significa que una vez creados, su contenido no puede cambiar.

### Ejemplo de Uso

```java
String nombre = "Ana";
String saludo = "Hola, " + nombre;
```

### Operaciones Comunes

- Concatenación (`+`).
- Comparación (`equals`, `compareTo`).
- Búsqueda y manipulación (como `substring`, `length`, `replace`).

### Importancia en Java

- `String` se utiliza en casi todos los programas de Java para manejar datos de texto.
- A menudo se utiliza en interfaces de usuario, manejo de archivos, comunicaciones en red, y para procesamiento general de texto.

# Tema 10: Operadores, Operandos y Expresiones en Java

## 10.1 Operadores

Los operadores en Java son símbolos especiales que se utilizan para realizar operaciones sobre uno o más operandos. Java ofrece varios tipos de operadores:

### 10.1.1 Operadores Aritméticos

- **Uso**: Para realizar cálculos matemáticos.
- **Ejemplos**: `+` (suma), `-` (resta), `*` (multiplicación), `/` (división), `%` (módulo).

### 10.1.2 Operadores de Comparación

- **Uso**: Para comparar dos valores.
- **Ejemplos**: `==` (igual a), `!=` (diferente de), `>` (mayor que), `<` (menor que), `>=` (mayor o igual que), `<=` (menor o igual que).

### 10.1.3 Operadores Lógicos

- **Uso**: Para realizar operaciones lógicas (principalmente con booleanos).
- **Ejemplos**: `&&` (AND lógico), `||` (OR lógico), `!` (NOT lógico).

### 10.1.4 Operadores de Asignación

- **Uso**: Para asignar valores a variables.
- **Ejemplos**: `=` (asignación simple), `+=` (suma y asigna), `-=` (resta y asigna).

### 10.1.5 Operadores Unarios

- **Uso**: Operan sobre un solo operando.
- **Ejemplos**: `++` (incremento), `--` (decremento), `-` (negación unaria).

### 10.1.6 Operadores Bit a Bit

- **Uso**: Operaciones a nivel de bits.
- **Ejemplos**: `&` (AND bit a bit), `|` (OR bit a bit), `^` (XOR bit a bit), `~` (NOT bit a bit).

## 10.2 Operandos

Los operandos son los valores o variables sobre los que actúan los operadores. En una expresión como `a + b`, `a` y `b` son operandos.

## 10.3 Expresiones

Una expresión es una combinación de operadores y operandos que se evalúa para producir un resultado. Las expresiones pueden ser tan simples como un valor literal o tan complejas como una combinación de múltiples operadores y operandos.

### 10.3.1 Tipos de Expresiones

- **Aritméticas**: Involucran operadores aritméticos y producen un resultado numérico.
- **Lógicas**: Utilizan operadores lógicos y producen un resultado booleano.
- **Relacionales**: Comparan operandos y producen un resultado booleano.

### 10.3.2 Ejemplos de Expresiones

```java
int resultado = a * b; // Expresión aritmética
boolean esMayor = edad > 18; // Expresión relacional
boolean esAdulto = esMayor && tieneDocumento; // Expresión lógica
```

### 10.3.3 Evaluación de Expresiones

- La evaluación de expresiones sigue las reglas de precedencia de operadores en Java.
- La asociatividad de operadores determina cómo se agrupan los operadores y operandos en ausencia de paréntesis.

# Tema 11: Operadores de Abreviación en Java

## 11.1 Definición de Operadores de Abreviación

Los operadores de abreviación, también conocidos como operadores de asignación compuesta, son una forma corta de aplicar una operación a una variable y luego asignar el resultado a esa misma variable. Simplifican la escritura y la lectura del código.

## 11.2 Tipos de Operadores de Abreviación

### 11.2.1 Operadores Aritméticos de Abreviación

- **Suma y Asignación (`+=`)**:
  - Ejemplo: `a += b;` es equivalente a `a = a + b;`.
- **Resta y Asignación (`-=`)**:
  - Ejemplo: `a -= b;` es equivalente a `a = a - b;`.
- **Multiplicación y Asignación (`*=`)**:
  - Ejemplo: `a *= b;` es equivalente a `a = a * b;`.
- **División y Asignación (`/=`)**:
  - Ejemplo: `a /= b;` es equivalente a `a = a / b;`.
- **Módulo y Asignación (`%=`)**:
  - Ejemplo: `a %= b;` es equivalente a `a = a % b;`.

## 11.3 Uso y Aplicaciones

Los operadores de abreviación son muy útiles para simplificar operaciones que actualizan el valor de una variable basándose en su valor actual. Se usan frecuentemente en bucles y en operaciones matemáticas o lógicas repetitivas.

## 11.4 Ejemplos Prácticos

```java
int contador = 0;
contador += 1; // Incrementa contador en 1
```

## 11.5 Buenas Prácticas

- Utilizar operadores de abreviación para mejorar la legibilidad del código y reducir la posibilidad de errores, especialmente en cálculos complejos o repetitivos.
- Ser consciente de la precedencia de operadores al usar operadores de abreviación en expresiones complejas.
