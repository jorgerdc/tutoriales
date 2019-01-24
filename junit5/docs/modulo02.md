# JUnit 5
## 2. Creando pruebas unitarias.
* El código de este módulo se encuentra en Github correspondiente al paquete `com.jorgerdc.tutoriales.junit5.modulo02`
### 2.1  Clases y métodos de prueba
* Un método de prueba es aquel anotado directamente o meta-anotado  con alguna de las siguientes anotaciones: `@Test`, `@RepeatedTest`, `@ParameterizedTest`, `@TestFactory`, o `@TestTemplate`
* Una clase de prueba es aquella que contiene al menos un método de prueba.
* Los métodos no necesariamente deben ser `public`.
##### Ejemplo:
* Ciclo de vida de una clase de prueba.
```java
public class TestMethods {
  private static int beforeAllCounter;
  private static int beforeEachCounter;
  private static int testCounter;
  private static int afterEachCounter;
  private static int afterAllCounter;
  private static final Logger log = LoggerFactory.getLogger(TestMethods.class);

  @BeforeAll
  private static void initAll() {
    log.debug("before all");
    beforeAllCounter++;
  }

  @BeforeEach
  private void init() {
    log.debug("before each");
    beforeEachCounter++;
  }

  @Test
  void testOne() {
    log.debug("test one");
    assertEquals(1, beforeAllCounter, "Invalid value for beforeAllCounter");
    assertEquals(1, beforeEachCounter, "Invalid value for beforeEachCounter");
    testCounter++;
  }

  @Test
  void testTwo() {
    log.debug("test two");
    assertEquals(1, beforeAllCounter, "Invalid value for beforeAllCounter");
    assertEquals(2, beforeEachCounter, "Invalid value for beforeEachCounter");
    testCounter++;
  }

  @Test
  void testThree() {
    log.debug("test three");
    assertEquals(1, beforeAllCounter, "Invalid value for beforeAllCounter");
    assertEquals(3, beforeEachCounter, "Invalid value for beforeEachCounter");
    testCounter++;
  }

  @Disabled
  private void disabled() {
    throw new RuntimeException(
      "This method should not be executed. Annotated with @Disabled");
  }

  @AfterEach
  private void tearDown() {
    log.debug("after each");
    afterEachCounter++;
  }

  @AfterAll
  private static void tearDownAll() {
    log.debug("after all");
    afterAllCounter++;
    assertEquals(3, beforeEachCounter, "Invalid value for testCounter");
    assertEquals(3, testCounter, "Invalid value for testCounter");
    assertEquals(3, afterEachCounter, "Invalid value for testCounter");
    assertEquals(1, beforeAllCounter, "Invalid value for beforeAllCounter");
    assertEquals(1, afterAllCounter, "Invalid value for afterAllCounter");
  }
}
```
##### Salida:
```
23:52:55,510 DEBUG main junit5.modulo02.TestMethods:49 - before all
23:52:55,527 DEBUG main junit5.modulo02.TestMethods:55 - before each
23:52:55,531 DEBUG main junit5.modulo02.TestMethods:61 - test one
23:52:55,543 DEBUG main junit5.modulo02.TestMethods:91 - after each
23:52:55,553 DEBUG main junit5.modulo02.TestMethods:55 - before each
23:52:55,554 DEBUG main junit5.modulo02.TestMethods:69 - test two
23:52:55,554 DEBUG main junit5.modulo02.TestMethods:91 - after each
23:52:55,556 DEBUG main junit5.modulo02.TestMethods:55 - before each
23:52:55,557 DEBUG main junit5.modulo02.TestMethods:77 - test three
23:52:55,558 DEBUG main junit5.modulo02.TestMethods:91 - after each
23:52:55,560 DEBUG main junit5.modulo02.TestMethods:97 - after all
```
* Observar que los métodos anotados con `@beforeAll`, `@afterAll` deben ser métodos de clase (static), esto para hacer énfasis que se tratan de métodos ejecutados a nivel de clase.  Pueden ser marcados como `private`
* Por cada método de prueba se crea una instancia de la clase. `@beforeAll`, `@afterAll` no se asocian a ninguna instancia en partícular debido a que se ejecutan una sola vez, por lo tanto, deben ser métodos marcados con `static` 
* Los métodos de prueba no pueden ser `private`, pueden tener el atributo de acceso por default (package).
### 2.2 @DisplayName
* Esta anotación se emplea para nombrar a los métodos de prueba y dar un mejor significado. Este nombre es empleado por herramientas y en la generación de reportes de resultados. 
##### Ejemplo:
```java
@DisplayName("Arithmetic tests")
public class NamedTests {
  @Test
  @DisplayName(" 1 + 1 test")
  void sum() {
    assertEquals(2, 1 + 1, "Invalid result for 1 +1 ");
  }
}
```
* Observar en la siguiente imagen el uso de estos nombres en  Eclipse:
![eclipse-junit](https://lh3.googleusercontent.com/im-jaFX3PFYgzNTAX7G-U0Wxzt5LAaR13YEOFeA9CURJC-BKkNx0FUdxO91IZPTA15grlhajcb-9 )
### 2.3 Aserciones. 
* La  mayoría de los métodos de clase (static) `assert*`  corresponden con los de JUnit 4.  Todos definidos en la clase `org.junit.jupiter.api.Assertions`
* Existen 2 tipos de aserciones:
	* Clásicos
	* Extendidos.
#### 2.3.1 Aserciones clásicas
* Verifican alguna condición o valor de una propiedad o atributo de un objeto o variable. 
* A nivel general  estos métodos reciben los siguientes parámetros en el siguiente orden:
1. Valor esperado
2. Valor obtenido o valor actual que se desea verficar
3. Descripción o mensaje que se muestra cuando la verificación falla.
##### Ejemplo:
```java
assertEquals(2, 1 + 1, "Invalid result for 1 +1 ");
```
* En JUnit  5 es posible emplear una expresión lambda  que contiene el código a ejecutar para construir el mensaje. 
* Esta técnica puede mejorar el desempeño ya que dicho código se ejecuta únicamente si la prueba falla.
* En general la firma del tercer parámetro es `Supplier<String> message`
##### Ejemplo:
```java
assertEquals(2,  1  +  1, 
  () ->  "Invalid result for  "  + (1  +  1) +  "Expensive message");
```
#### 2.3.1 Aserciones extendidas
##### 2.3.1.1 fail
* ```Assertions.fail("mensaje")```.  No es propiamente una aserción,  provoca que una prueba falle deliberadamente.
##### 2.3.1.2 assertAll
* `Assertions.assertAll` . Acepta una lista de aserciones. Ejecuta toda la lista de aserciones y hasta el final reporta aquellas que fallaron.
* Util cuando se desea ejecutar una lista de aserciones sin importar si algunas fallan o no.
* En realidad el método acepta una lista de objetos `org.junit.jupiter.api.function.Executable` 
##### Ejemplo:
```java
@Test
  void multipleAssertions() {

    int[] values = { 1, 2, 3, 4, 5 };

    assertAll("Multiple validations", () -> assertEquals(values[0], 1, "Invalid result for values[0]"),
      () -> assertEquals(values[1], 8, "Invalid result for values[1]"),
      () -> assertEquals(values[2], 3, "Invalid result for values[2]"),
      () -> assertEquals(values[3], 2, "Invalid result for values[3]"),
      () -> assertEquals(values[4], 5, "Invalid result for values[4]"));

  }
```
 * Cada elemento de la colección es una expresión lambda definida por la interface funcional `org.junit.jupiter.api.function.Executable`
 ```java
 @FunctionalInterface
@API(status = STABLE, since = "5.0")
public interface Executable {
  void execute() throws Throwable;
}
```
 * La salida al ejecutar la prueba anterior es:
 ```
 org.opentest4j.MultipleFailuresError: Multiple validations (2 failures)
	Invalid result for values[1] ==> expected: <2> but was: <8>
	Invalid result for values[3] ==> expected: <4> but was: <2>
``` 
* Observar que se muestra la lista de  aserciones fallidas.
* Observar la cadena **Multiple validations** que se emplea como   "header" o "mensaje" para incluirse en la salida o resultado.
* ```assertAll```  puede emplearse también para realizar *agrupamientos de aserciones* .  En este caso cada grupo es ejecutado de forma independiente. La ejecución de cada grupo se detiene al fallar alguna de las aserciones del grupo.
##### Ejemplo:
```java
@Test
  void groupAssertions() {
    String[] persons = { "John", "Mike", "Peter" };
    String[] fruits = { "Apple", "Banana", "Coconut" };

    String[] colors = { "Red", "Blue", "Pink" };

    // the following assertAll has 3 groups: persons, fruits and colors. All the three groups will
    // be processed independently

    assertAll("Words", () -> {
      // if the first assertion fails, the following will not be executed.
      log.debug("Processing name group");
      assertEquals("John", persons[0]);
      assertEquals("Mike", persons[1]);
      assertEquals("Peter", persons[2]);
    }, () -> {
      log.debug("Processing fruit group");
      assertEquals("Apple", fruits[0]);
      assertEquals("Banana", fruits[1]);
      // uncomment the following assertion to produce an error. In the output you will see
      // that all groups are still executed, but the Coconut validation won't be
      // processed.

      // assertEquals("Grapes", fruits[2]);
      log.debug("Processing Coconut group");
      assertEquals("Coconut", fruits[2]);
    }, () -> {
      log.debug("Testing  color group");
      //here we have a nested assertAll. In this case, all the assertion of this group
      //will be processed independently, it does not matter if some of them fails.
      assertAll("Colors", () -> assertEquals("Red", colors[0]),
        () -> assertEquals("Blue", colors[1]), () -> assertEquals("Pink", colors[2]));
    },
      // the last group is using method references. the checkAnimals method match the
      // Executable functional interface, so we can use as a method reference.
      this::checkAnimals);
  }

  private void checkAnimals() {
    String[] animals = { "Cat", "Dog", "Bird" };
    log.debug("Processing Animal group");
    assertAll("Animals", () -> assertEquals("Cat", animals[0]),
      () -> assertEquals("Dog", animals[1]), () -> assertEquals("Bird", animals[2]));
  } 
``` 
* Cada grupo es representado por una expresión lambda `()->{}` o  por  alguna referencia a métodos como en el caso del grupo 3.
* Dentro de cada grupo se pueden  agregar las N aserciones que integran al grupo. 
* Notar que si una de estas aserciones falla, las restantes ya no se ejecutarán.  Este comportamiento se puede comprobar al quitar el comentario que se indica en el ejemplo.
* Observar que  es posible anidar ```assertAll```dentro de un grupo.   La idea de hacer esto es que todas las aserciones del grupo serán ejecutadas de forma independiente  (independencia dentro de un grupo).
##### 2.3.1.3 assertThrows
* La prueba falla en caso de no lanzar alguna de las excepciones esperadas.
*  ` assertThrows` regresa la excepción generada para posible reuso.
##### Ejemplo:
```java
/**
 * The test expects an {@link SQLException}. If it is not thrown, the test fails.
 */
@Test
  void expectedException() {
    assertThrows(SQLException.class, () -> {
      log.debug("Throwing an expected exception");
      throw new SQLException("DB error");
    });
  }
  
  /**
   * Similar to the previous tests, but now showing how to reuse the exception.
   */
  @Test
  void reuseException() {
    Exception e;
    e = assertThrows(SQLException.class, () -> {
      log.debug("Throwing an expected exception");
      throw new SQLException("DB error");
    });
    log.debug("the following expected exception was thrown, Type: {}, message: {} ",
      e.getClass(), e.getMessage());
  }
  ```
  ##### fin de módulo.
