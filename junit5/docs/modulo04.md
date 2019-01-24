# JUnit 5
## 4. Tags, Ciclo de instancia, nested tests,  Inyección de parámetros.
### 4.1 Tags
* Tanto clases como métodos de prueba pueden ser asociados a un conjunto de etiquetas o *tags*  empleando `@Tag`
* Esta funcionalidad se emplea básicamente para filtrar y clasificar clases y métodos de prueba, agruparlos, crear test suites.
##### Ejemplo:
```java
@Tag("dev")
@Test
void testA() {
  log.debug("Running test on development environment");
}

@Tag("qa")
@Test
void testB() {
  log.debug("Running test on quality server");
}

@Tag("prod")
@Test
void testC() {
  log.debug("Running test on production");
}

@Tag("dev")
@Tag("qa")
@Tag("prod")
@Test
void testD() {
  log.debug("Running test on all environments");
}
  ```
* En este ejemplo, se ha decidido clasificar  a los métodos de prueba en 3 grupos:
	* Pruebas que se ejecutarán en ambientes de desarrollo `@Tag("dev")`
	* Pruebas que se ejecutarán en ambientes QA (quality assurance) `@Tag("qa")`
	* Pruebas que se ejecutarán en ambientes de producción `@Tag("prod")`
* Uno de los usos principales de `@Tag`es la creación de Test suites.
* Existen básicamente 2 estrategias para crear Test suites:
	* Programaticamente
	* Filtrado empleando Gradle.
#### 4.1.1 Test suits - modo programático. 
* JUnit ofrece varias anotaciones para crear una clase Java que represente un Test Suite. 
##### Ejemplo:
```java
@RunWith(JUnitPlatform.class)
@SuiteDisplayName("JUnit 4 Suite Demo")
@SelectPackages("com.jorgerdc.tutoriales.junit5.modulo04")
@SelectClasses(TestTagExamples.class)
@IncludeTags("prod")
public class JUnit4SuiteDemo {
}
```
* En este ejemplo,  se crea un test suite formado por todos los métodos de prueba que cumplan con los filtros anteriores:  paquete seleccionado, clases seleccionadas  y que incluyan el tag  `'prod'`.
* Esta técnica tiene el siguiente detalle:
	* Hasta el momento, el soporte para crear test suites en JUnit 5  requiere del uso de`@RunWith` .
	* `@RunWith` es una anotación de JUnit4.
	* En realidad, el ejemplo anterior es una clase de prueba de JUnit4, pero esta se ejecutará  empleando JUnit5 a través de la clase `JUnitPlatform`.
	* En caso de continuar con la implementación de esta estrategia, se deberá incluir  en el classpath la dependencia `junit-platform-suite-api` 
	* La dependencia anterior agrega JUnit4 al classpath.
* Debido a este detalle, este tutorial no incluye ejemplos de este tema, básicamente para enfocarse al uso exclusivo de las características de JUnit 5.
#### 4.1.2 Test suites con Gradle
* Otra técnica para crear un test suite sin involucrar JUnit 4 es el uso de la integración de JUnit 5 en gradle a partir de su versión 4.6.
* El primer paso es habilitar el uso de JUnit 5 en gradle:
```groovy
test {
  useJUnitPlatform()
}
```
* La configuración para crear un test suite similar al ejemplo con Java es:
```groovy
test {
  useJUnitPlatform {
    excludeTags 'qa', 'prod'
  }
  testLogging {
    events "passed", "skipped", "failed"
  }
}
```
* En este ejemplo,  al ejecutar `gradlew test`sobre el  proyecto gradle,  se habilita el uso de JUnit 5 mostrando las pruebas exitosas, fallidas, las pruebas no ejecutadas (deshabilitadas).
* Adicionalmente, se excluirán todas las pruebas marcadas con los tags `'qa'`y `'prod'`
* Con base al ejemplo, solo el método `testA` deberá ejecutarse.
* Un extracto de la salida al ejecutar el comando `gradlew test` es:
```bash
com.jorgerdc.tutoriales.junit5.modulo03.ConditionalAnnotationsTests > disabledOnSeveralOs() PASSED
com.jorgerdc.tutoriales.junit5.modulo03.ConditionalAnnotationsTests > disableIfUserJorge() SKIPPED
com.jorgerdc.tutoriales.junit5.modulo03.ConditionalAnnotationsTests > disableOnSomeOs() PASSED
com.jorgerdc.tutoriales.junit5.modulo03.ConditionalAnnotationsTests > disabledOnWeekend() SKIPPED
com.jorgerdc.tutoriales.junit5.modulo03.ConditionalAnnotationsTests > disabledIfMac() SKIPPED
com.jorgerdc.tutoriales.junit5.modulo03.ConditionalAnnotationsTests > disabledRandomly() PASSED
com.jorgerdc.tutoriales.junit5.modulo03.ConditionalAnnotationsTests > disabledForJRE9() PASSED
com.jorgerdc.tutoriales.junit5.modulo04.TestTagExamples > testA() PASSED
```
* Notar que efectivamente solo se ejecutó el método `testA`
* [En este enlace](https://docs.gradle.org/current/userguide/java_testing.html#using_junit5) se puede revisar toda la funcionalidad que ofrece Gradle para JUnit 5.
### 4.2 Ciclo de vida de una Instancia de de prueba.
* Con la finalidad de ejecutar cada método de prueba de forma aislada,  JUnit5 crea una nueva instancia de la clase por cada método  (similar a JUnit 4).
* A este concepto se le conoce como *"per-method" test instance lifecycle*.
* Notar que a pesar de que el método de prueba sea deshabilitado empleado `@Disabled`o alguna variante, ¡la  instancia de la clase se crea!
* Para cambiar este comportamiento por default se pueden emplear 2 técnicas:
	* Empleando `@TestInstance` , recibe  un Enum como valor: `LifeCycle.PER_CLASS` o `LifeCycle.PER_METHOD`
	* Empleando un parámetro de configuración.  JUnit  5 permite especificar parámetros de configuración como System properties o en un script llamado `junit-platform.properties`  ubicado a nivel raíz del classpath.
```properties
junit.jupiter.testinstance.lifecycle.default = per_class
```
##### Ejemplo:
```java
@TestInstance(Lifecycle.PER_CLASS)
class ClassInstanceLifeCycleTest {

  private static int instanceCount;

  /**
   * This property is used to simulate a shared property used by method tests. Suppose
   * that the value of this property must be 10 before running. If a test method change
   * it`s value, it must be reseted to 10 since only one instance is created. This
   * behavior can be implemented using @BeforeEach and @AfterEach
   */
  private int sharedProperty;

  private static final Logger log =
    LoggerFactory.getLogger(ClassInstanceLifeCycleTest.class);

  /**
   * Constructor used to validate the number of instances created to executed all
   * test methods.
   */
  ClassInstanceLifeCycleTest() {
    log.debug("Creating a new instance of ClassInstanceLifeCycleTest ");
    instanceCount++;
  }

  /**
   * If a test class is using PER_INSTANCE value as instance class life cycle, make sure
   * to reset possible instance attributes which share common data. In this example,
   * the <code>sharedProperty</code> instance attribute must be reseted to 10.
   */
  @BeforeEach
  void init() {
    log.debug("reset sharedProperty to 10 before running");
    this.sharedProperty = 10;
  }

  @Test
  void testOne() {
    log.debug("test one");
    assertEquals(1, instanceCount, "Only one instance should be created");
    assertEquals(10, sharedProperty, "initial value of sharedProperty must be 10");
    // change a shared instance property
    sharedProperty = 1;
  }

  @Test
  void testTwo() {
    log.debug("test two");
    assertEquals(1, instanceCount, "Only one instance should be created");
    assertEquals(10, sharedProperty, "initial value of sharedProperty must be 10");
    // change a shared instance property
    sharedProperty = 2;
  }

  @Test
  void testThree() {
    log.debug("test three");
    assertEquals(1, instanceCount, "Only one instance should be created");
    assertEquals(10, sharedProperty, "initial value of sharedProperty must be 10");
    // change a shared instance property
    sharedProperty = 2;
  }
  ``` 
  * En este ejemplo se realizan 2 validaciones principales para ilustrar este concepto.
	  * Se verifica que solo una instancia de la clase sea creada empleando `instanceCount`.
	  * Se verifica que los objetos o en general atributos de instancia de la clase sean 'reseteados' antes de ejecutar cada método de clase empleando `sharedProperty`. Este punto es muy importante en caso de que los métodos de prueba modifiquen atributos de instancia, solo se tiene una copia debido a  que se crea una sola instancia. 
  * Finalmente, un beneficio de esta técnica es la reutilización  de objetos como conexiones, etc.
  ### 4.3 Nested Tests
  * JUnit 5 permite crear métodos de prueba anidados. 
  * Un método de prueba anidado se encuentra dentro de una Inner class.
  * La inner class a su vez puede ser Inner class de la clase principal o a su vez ser inner class de otra inner class  (no hay límite de Jerarquía).
  * Cada Inner class puede definir sus métodos de prueba así como `@BeforeEach`y `@AfterEach`.  `@BeforeAll`y `@AfterAll` no pueden aparecer en un Inner class ya que Java no permite métodos `static`en  Inner classes.
  * Para indicar a JUnit que un método de prueba se encuentra dentro de una Inner class,  dicha clase debe estar anotada con `@Nested`
  ##### Ejemplo:
  ```java
public class NestedTest {
   private static final Logger log = LoggerFactory.getLogger(NestedTest.class);

   @BeforeAll
   static void beforeAll() {
     log.debug("before all Test methods");
   }

   @BeforeEach
   void beforeEach() {
     log.debug("before each test - Main class");
   }

  @Nested
  class TestA {

    @BeforeEach
    void beforeEach() {
      log.debug("before each test - Test A class");
    }

    @Nested
    class TestAA {

      @BeforeEach
      void beforeEach() {
        log.debug("before each test - Test AA class");
      }

      @Test
      void testA() {
        log.debug("running testAA - Test AA class");
      }

      @AfterEach
      void afterEach() {
        log.debug("after each test - Test AA class");
      }
    }

    @AfterEach
    void afterEach() {
      log.debug("after each test - Test A class");
    }
  }

   @AfterEach
   void afterEach() {
     log.debug("after each test - Main class");
   }

   @AfterAll
   static void afterAll() {
     log.debug("after all Test methods");
   }
}
 ```
 * Observar la salida del código anterior.
 ```
 junit5.modulo04.NestedTest:38 - before all Test methods
junit5.modulo04.NestedTest:43 - before each test - Main class
junit5.modulo04.NestedTest:51 - before each test - Test A class
junit5.modulo04.NestedTest:59 - before each test - Test AA class
junit5.modulo04.NestedTest:64 - running testAA - Test AA class
junit5.modulo04.NestedTest:69 - after each test - Test AA class
junit5.modulo04.NestedTest:75 - after each test - Test A class
junit5.modulo04.NestedTest:82 - after each test - Main class
junit5.modulo04.NestedTest:87 - after all Test methods
 ```
 * Notar la secuencia de ejecución de los métodos `beforeEach`  en orden Jerárquico Iniciando en la clase padre:  NestedTest -> Clase A -> Clase AA.
 * Para el caso de los métodos  `afterEach` ocurre algo similar solo que en orden inverso:   Clase AA -> Clase A -> NestedTest.
 * Algunos beneficios de esta característica son:
	 * Evitar código duplicado en los métodos `beforeEach` , `afterEach`.   Al contar con esta Jerarquía de ejecución, el código se puede dividir por niveles, de lo más general a lo más particular.
	 * Agrupar métodos de prueba con propósitos similares.  Para cada grupo de pruebas se puede crear una Inner class.
##### Ejemplo:
* El siguiente ejemplo simula las pruebas unitarias de un servicio de Login.
* La prueba se divide en 2 grupos:
	* Pruebas del las funcionalidades para hacer login
	* Pruebas de las funcionalidades para cambiar password.
* Para cada grupo se crea una Inner class
* En la clase principal se inicializa el servicio a probar empleando `@BeforeEach`.  Este código se reutiliza en las clases Inner evitando la duplicidad de código al evitar esta inicialización  en cada inner class.
* En cada Inner class, se inicializan algunos objetos particulares a cada funcionalidad empleando `@BeforeEach`  La división de funcionalidades relacionadas en cada Inner class facilita la comprensión, lectura y mantenimiento del código.
* Finalmente, observar el uso de `@DisplayName`en cada  inner class para hacer énfasis en el propósito de cada grupo de pruebas.
```java

public class UserServiceTest {

  private UserService userService;

  @BeforeEach
  void beforeEach() {
    log.debug("Init UserService");
    userService = new UserService();
  }

  @Nested
  @DisplayName("Testing Login feature")
  class LoginTests {

    private Map<String, String> testingUsers;

    @BeforeEach
    void beforeEach() {
      log.debug("Init login data for Login tests");
      testingUsers = new HashMap<>();
      testingUsers.put("u1", "pwd1");
      testingUsers.put("u2", "pwd-wrong");
    }

    @Test
    void usernameAndPasswordAreValid() {
      assertTrue(userService.loginUser("u1", testingUsers.get("u1")));
    }

    @Test
    void passwordIsInvalid() {
      assertFalse(userService.loginUser("u2", testingUsers.get("u2")));
    }

    @Test
    void emptyLoginAndNullPassword() {
      assertFalse(userService.loginUser("", null));
    }
  }

  @Nested
  @DisplayName("Testing password feature")
  class PasswordTests {

    private Map<String, String> testingUsers;

    @BeforeEach
    void beforeEach() {
      log.debug("Init login data for password tests");
      testingUsers = new HashMap<>();
      testingUsers.put("u1", "pwd1");
      testingUsers.put("u2", "pwd2");
    }

    @Test
    void newPasswordIsValid() {
      assertTrue(
        userService.changePassword("u1", testingUsers.get("u1"), "new-password"));
    }

    @Test
    void newPasswordIsTheSame() {
      assertFalse(
        userService.changePassword("u2", testingUsers.get("u2"), testingUsers.get("u2")));
    }

    @Test
    void newPasswordIsEmpty() {
      assertFalse(userService.changePassword("u2", testingUsers.get("u2"), ""));
    }
  }
}
```
### 4.4 Inyección de dependencias en constructores y métodos.
* En versiones anteriores de JUnit,  los constructores y métodos de prueba no permitían el uso de parámetros.
* En JUnit 5 es posible que los constructores y los métodos anotados con `@Test`, `@TestFactory`, `@BeforeEach`, `@AfterEach`, `@BeforeAll`, `@AfterAll` tengan parámetros.
* Las instancias y valores de los parámetros que definan estos métodos ***deberán***   ser inicializados  a través de *inyección de dependencias*.
* `org.junit.jupiter.api.extension.ParameterResolver`es la interface que declara los métodos encargados de resolver estas dependencias de forma dinámica en tiempo de ejecución.
* Implementaciones de `ParameterResolcer` deben ser registradas (asociadas a las clases de prueba) para poder resolver dependencias. 
* En JUnit existen 3 implementaciones que se registran de manera automática:
	* `TestInfoParameterResolver`
	* `RepetitionInfoParameterResolver`
	* `TestReporterParameterResolver`
#### 4.4.1 TestInfoParameterResolver
* Si el parámetro del método es de tipo `TestInfo`, `TestInfoParameterResolver` proporcionará una instancia de este objeto con información de la prueba en ejecución.	
##### Ejemplo:
```java
@DisplayName("TestInfo class test")
public class TestInfoParameterResolverExample {

  private static final Logger log =
    LoggerFactory.getLogger(TestInfoParameterResolverExample.class);

  TestInfoParameterResolverExample(TestInfo testInfo) {
    log.debug("in constructor of test class {}", testInfo.getDisplayName());
    // note this string must be equals to the value of the @DisplayName of the test class
    assertEquals("TestInfo class test", testInfo.getDisplayName());
  }

  @Test
  @DisplayName("This is test 1")
  @Tag("dev")
  @Tag("qa")
  void test1(TestInfo testInfo) {
    log.debug("Running test with name {}", testInfo.getDisplayName());
    assertEquals("This is test 1", testInfo.getDisplayName());
    testInfo.getTags().forEach(tag -> assertTrue("dev".equals(tag) || "qa".equals(tag)));
  }

  @Test
  void test2(TestInfo testInfo) {
    log.debug("Running test with name {}", testInfo.getDisplayName());
    // in this case, tne name of the test is the method name: test2(TestInfo)
    assertEquals("test2(TestInfo)", testInfo.getDisplayName());
  }

  @BeforeEach
  void beforeEach(TestInfo testInfo) {
    log.debug("Before running test with name {}", testInfo.getDisplayName());
    assertTrue(testInfo.getDisplayName().equals("This is test 1")
      || testInfo.getDisplayName().equals("test2(TestInfo)"));
  }
}
```
* Notar que en los métodos `beforeEach`, etc.,  el método `TestInfo` contiene los datos de la prueba que se va a ejecutar.
#### 4.4.2 RepetitionInfoParameterResolver
* Contiene información acerca de las pruebas que se ejecutan repetidamente. Por ejemplo: datos de la actual repetición, número de repetición, total de repeticiones.
* Los métodos que pueden ejecutarse repetidamente son aquellos anotados con `@RepeatedTest`, `@BeforeEach`, or `@AfterEach`.
* El parámetro que aceptan estos métodos es del tipo `RepetitionInfo`.
* En secciones posteriores se revisa a detalle el tema de repetición de pruebas.
####  4.4.3 TestReporterParameterResolver.
* En este caso, el parámetro es del tipo `TestReporter`.
* Este objeto puede ser empleado para publicar información adicional de una prueba con propósitos de reportes.
#### 4.4.4 Resolvers personalizados.
* Requieren ser registrados explícitamente empleando `@ExtendWith`
##### Ejemplo.
* En el siguiente ejemplo se ilustra la forma en la que se pueden inyectar nombres de personas aleatorios a métodos de prueba a través del uso de una implementación de `ParameterResolver`.
```java
public class RandomNamesParameterResolver implements ParameterResolver {
  /**
   * Custom annotation used to identify parameters that can be injected using this
   * parameter resolver implementation
   */
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.PARAMETER)
  public @interface RandomName {
    // no code needed
  }
  
  @Override
  public boolean supportsParameter(ParameterContext parameterContext,
    ExtensionContext extensionContext) throws ParameterResolutionException {
    return parameterContext.isAnnotated(RandomName.class);
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext,
    ExtensionContext extensionContext) throws ParameterResolutionException {

    return getRandomValue(parameterContext.getParameter(), extensionContext);
  }

  private Object getRandomValue(Parameter parameter, ExtensionContext extensionContext) {
    Class<?> type = parameter.getType();
    String[] array = extensionContext.getRoot().getStore(Namespace.GLOBAL)
      .getOrComputeIfAbsent("names", key -> {
        log.debug("creating name array");
        return new String[] { "Mike", "Melli", "Paty" };
      }, String[].class);
    int random = (int) (Math.random() * array.length);
    if (String.class.equals(type)) {
      return new String(array[random]);
    }
    if (StringBuilder.class.equals(type)) {
      return new StringBuilder(array[random]);
    }
    throw new ParameterResolutionException("No Name generator implemented for " + type);
  }
}
```
*  Observar que la interface `ParameterResolver` declara 2 métodos:
* `supportsParameter`  se emplea para determinar si el parámetro puede ser resuelto por esta clase.  En este caso, se emplea`@RandomName`. Esta anotación se define en esta clase y su único propósito es  identificar a los parámetros que pueden ser resueltos por esta clase.  No es obligatorio que todos los parámetros sean identificados a través de una anotación. Para este caso es requerido, pero para otras implementaciones, se pueden emplear otras técnicas, por ejemplo, a través del tipo de dato.
* `resolveParameter` Se emplea para crear/obtener la instancia a inyectar.  Los objetos `ParameterContext` y `ExtensionContext` contienen métodos que facilitan la creación u obtención de esta instancia. 
* Una instancia de `ExtensionContext` representan al contexto en el que se ejecuta una clase o un conjunto de clases de prueba. En esta instancia se almacenan o se asocian los objetos empleados para realizar la inyección de los parámetros.  
	* Observar el uso del método `extensionContext.getRoot().getStore(Namespace.GLOBAL)
      .getOrComputeIfAbsent(...)`
	* Básicamente existe  se cuenta con un *almacén*  asociado a un contexto donde se pueden guardar objetos (object store). 
	* El método `getOrComputeIfAbstent` permite construir este objeto en caso de no existir o simplemente obtenerlo en caso de existir.
	* Notar que el primer parámetro de este método es la cadena `names`. En realidad este primer parámetro corresponde a un objeto que representa una *key* . Es decir,  los objetos que se almacenan en este almacén pueden ser referenciados empleando una llave.  Este arreglo de nombres se crea una sola vez durante la ejecución de la clase de prueba.
	* El segundo parámetro de este método corresponde a un objeto tipo `function<K,V>` . Este parámetro se representa por la expresión lambda que recibe una llave y regresa un valor (el arreglo de Strings).
	* El tercer parámetro es un objeto `Class`empleado para indicar el tipo de dato que se obtendrá y evitar castings.  En este caso `String[].class`.
* Una vez que se recupera el arreglo de nombres,  se  realizan 2 validaciones adicionales antes de regresar  el objeto a inyectar.  Si el tipo de dato del parámetro  es `String` o `StringBuilder`, este ejemplo los considera como parámetros compatibles y genera el objeto correspondiente. De lo contrario, se genera excepción.
* La parte más complicada es la implementación de esta clase.  Una vez  terminada, la creación de la prueba se vuelve muy sencilla:
```java
@ExtendWith(RandomNamesParameterResolver.class)
public class TestRandomNameExample {
  
  @Test
  void randomNumber(@RandomName String n1, @RandomName StringBuilder n2) {
    log.debug("Generated random names: {},{}", n1, n2);
    assertTrue(() -> checkRandomName(n1), "Invalid random name");
    assertTrue(() -> checkRandomName(n2.toString()), "Invalid random name");
  }

  @Test
  void moreRandomNames(@RandomName String n1) {
    log.debug("More generated random name: {}", n1);
    assertTrue(() -> checkRandomName(n1), "Invalid random name");

  }
  boolean checkRandomName(String name) {
    return name.equals("Mike") || name.equals("Melli") || name.equals("Paty");
  }
}
```
* Notar el uso de `@ExtendWith`   empleada para registrar  al parameter resolver `RandomNamesParameterResolver` 
* Observar la sintaxis empleada en los métodos de prueba: `@RandomName String n1`.   Esta expresión permite que JUnit resuelva este parámetro  resultando en la inyección de un nombre aleatorio seleccionado del arreglo de nombres.
##### fin de módulo.
 
 
